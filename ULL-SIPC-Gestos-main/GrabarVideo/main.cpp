#include <iostream>
#include <opencv2/highgui.hpp>
#include <opencv2/imgcodecs.hpp>
#include <opencv2/imgproc.hpp>
#include <opencv2/video.hpp>
#include <opencv2/videoio.hpp>

using namespace cv;
using namespace std;

int main(int argc, char* argv[]) {
  Mat frame, roi;
  VideoCapture cap;
  cap.open(0);
  if (!cap.isOpened()) {
    printf("Error opening cam\n");
    return -1;
  }
  namedWindow("Frame");
  namedWindow("ROI");
  Rect rect(400, 100, 200, 200);

  int frame_width = cap.get(CAP_PROP_FRAME_WIDTH);
  int frame_height = cap.get(CAP_PROP_FRAME_HEIGHT);

  int codec = VideoWriter::fourcc('M', 'J', 'P', 'G');
  VideoWriter video("out.avi", codec, 20, Size(frame_width, frame_height));

  while (true) {
    cap >> frame;
    flip(frame, frame, 1);
    imshow("Frame", frame);

    frame(rect).copyTo(roi);
    rectangle(frame, rect, Scalar(255, 0, 0));

    imshow("ROI", roi);
    video.write(frame);
    int c = waitKey(40);
    if ((char)c == 'q') break;
  }
  video.release();
  cap.release();
  destroyAllWindows();
  system("echo Grabado");
  system("cp out.avi ../Practica3/");
}
