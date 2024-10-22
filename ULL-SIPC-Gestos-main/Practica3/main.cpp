#include <iostream>
#include <opencv2/highgui.hpp>
#include <opencv2/imgcodecs.hpp>
#include <opencv2/imgproc.hpp>
#include <opencv2/video.hpp>
#include <opencv2/videoio.hpp>

using namespace cv;
using namespace std;

double angle(Point s, Point e, Point f) {
  double v1[2], v2[2];
  v1[0] = s.x - f.x;
  v1[1] = s.y - f.y;
  v2[0] = e.x - f.x;
  v2[1] = e.y - f.y;
  double ang1 = atan2(v1[1], v1[0]);
  double ang2 = atan2(v2[1], v2[0]);

  double ang = ang1 - ang2;
  if (ang > CV_PI) ang -= 2 * CV_PI;
  if (ang < -CV_PI) ang += 2 * CV_PI;

  return ang * 180 / CV_PI;
}

int main(int argc, char* argv[]) {
  Mat frame, roi, fgMask;
  vector<vector<Point> > contours;
  vector<int> hull;
  vector<Vec4i> defects;

  // Abrimos la camara
  VideoCapture cap;  // permite capturar imagen de la webcam
  cap.open("out.avi");
  if (!cap.isOpened()) {
    printf("No se puedo abrir la camara\n");
    return -1;
  }
  int cont = 0;
  while (frame.empty() && cont < 2000) {
    cap >> frame;
    ++cont;
  }
  if (cont >= 2000) {
    printf("No se ha podido leer un frame valido\n");
    exit(-1);
  }
  // Puntero para subtraer el fondo
  Ptr<BackgroundSubtractor> pBackSub = createBackgroundSubtractorMOG2();

  // Creamos las ventanas que vamos a usar
  namedWindow("Frame: RECONOCIMEINTO");
  namedWindow("ROI");
  namedWindow("Foreground Mask: FONDO");

  Rect rect(400, 100, 200, 200);

  // int frame_width = cap.get(CAP_PROP_FRAME_WIDTH);
  // int frame_height = cap.get(CAP_PROP_FRAME_HEIGHT);

  // int codec = VideoWriter::fourcc('M','J','P','G');
  //  VideoWriter video("out.avi",codec,20, Size(frame_width,frame_height));

  while (true) {
    cap >> frame;
    // varieble para apply
    int aprender{-1};
    // simetria de espejo
    flip(frame, frame, 1);
    if (frame.empty()) break;

    // se dibuja el rectangulo azul en frame
    rectangle(frame, rect, Scalar(255, 0, 0));

    // variable que toma valor de la pulsacion de una tecla
    int c = waitKey(40);
    // si pulsamos la tecla w, indicamos que pBackSub tiene que dejar de
    // aprender
    if ((char)c == 'w') aprender = 0;

    // seleccionar la region de interes
    frame(rect).copyTo(roi);
    // en fgmask se aplicara el fondo negro/blanco de lo que se ve en roi
    pBackSub->apply(roi, fgMask, aprender);

    // Se muestra el resultado del reconocimiento
    imshow("Foreground Mask: FONDO", fgMask);
    // encuentra el controno en la fgmask
    findContours(fgMask, contours, RETR_EXTERNAL, CHAIN_APPROX_SIMPLE);
    // dibujarmos el contorno en roi
    drawContours(roi, contours, -1, Scalar(0, 255, 0), 3);
    // un bucle porque se procesa muchos pixseles
    for (size_t i = 0; i < contours.size(); i++) {
      convexHull(contours[i], hull, false, false);
      sort(hull.begin(), hull.end(), greater<int>());
      convexityDefects(contours[i], hull, defects);

      for (int i = 0; i < defects.size(); i++) {
        Point s = contours[0][defects[i][0]];
        Point e = contours[0][defects[i][1]];
        Point f = contours[0][defects[i][2]];
        float depth = (float)defects[i][3] / 256.0;
        double ang = angle(s, e, f);

        Rect boundRect = boundingRect(contours[i]);
        rectangle(roi, boundRect, Scalar(0, 0, 255), 3);
        // hacer la relacion para que se pinte los puntos
        // importantes y no todos
        circle(roi, f, 5, Scalar(0, 0, 255), -1);
        // line(roi,s,e,Scalar(255,0,0),2);
      }
    }

    // Se muestra el resultado del reconocimiento
    imshow("Frame: RECONOCIMEINTO", frame);
    imshow("ROI", roi);

    // para salir del programa
    if ((char)c == 'q') break;
  }

  cap.release();
  destroyAllWindows();
  // destroyWindow("Frame: RECONOCIMEINTO");
  // destroyWindow("ROI");
  // destroyWindow("Foreground Mask: FONDO");
  return 0;
}