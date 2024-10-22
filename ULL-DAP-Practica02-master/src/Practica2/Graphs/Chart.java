package Practica2.Graphs;

import org.jfree.ui.ApplicationFrame;

public abstract class Chart extends ApplicationFrame {
    iCreateDataBase createDataBase;
    int xAxis, yAxis;
    public Chart(String applicationTitle, int xAxis, int yAxis) {
        super(applicationTitle);
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }
    public abstract void display();
}
