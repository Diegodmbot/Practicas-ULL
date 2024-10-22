package practica01.Shapes;

import java.awt.*;

public class Triangulo extends Figura {
    private int side1;
    private int side2;
    private int side3;
    public Triangulo(int side1, int side2, int side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    // Heron's formula
    public double getArea() {
        double s = getPerimeter()/2;
        return  Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    public double getPerimeter() {
        return side1 + side2 + side3;
    }
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int[] xPoints = {0, side1, side2};
        int[] yPoints = {0, 0, side3};
        g2d.drawPolygon(xPoints, yPoints, 3);
    }
}
