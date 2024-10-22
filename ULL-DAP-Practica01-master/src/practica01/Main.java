package practica01;

import practica01.Shapes.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class ShapesPanel extends JPanel {
    Figura[] shapes;
    Color background;

    // Creates every Shape we want to draw
    public ShapesPanel() {
        shapes = new Figura[3];
        shapes[0] = new Triangulo(100, 100, 100);
        shapes[1] = new Circulo(5);
        shapes[2] = new Rectangulo(3, 4);
        this.background = Color.RED;
    }

    // How the Panel is painted
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Figura s: shapes) {
            s.draw(g);
        }
    }
}

class MyFrame extends JFrame {

    public MyFrame() {
        // adding components to JFrame
        add(new ShapesPanel());

        // Frame Configuration
        setSize(600, 500);//600 x 500
        setVisible(true); // Visible
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Close on Exit
    }

}

public class Main {
    public static void main(String[] args) {
        new MyFrame();
    }
}
