package practica01.Shapes;

import java.awt.*;

public class Rectangulo extends Figura {
    private int width;
    private int height;
    public Rectangulo(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public double getArea() {
        return width * height;
    }
    public double getPerimeter() {
        return 2 * (width + height);
    }
    // Draw a rectangle with awt
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(0, 0, width, height);
    }
}

