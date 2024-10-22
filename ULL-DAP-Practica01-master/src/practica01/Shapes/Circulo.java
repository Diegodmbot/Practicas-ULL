package practica01.Shapes;

import java.awt.*;

public class Circulo extends Figura {
    private int radius;
    public Circulo(int radius) {
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawOval(0, 0, radius, radius);
    }
}
