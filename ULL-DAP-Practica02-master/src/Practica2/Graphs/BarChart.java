package Practica2.Graphs;

import Practica2.CSVManager.CSVFile;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.ui.RefineryUtilities;

import java.awt.*;

public class BarChart extends Chart {
    public BarChart(String applicationTitle, String chartTitle, CSVFile file, int xAxis, int yAxis) {
        super(applicationTitle, xAxis, yAxis);
        createDataBase = new BarChartDataBase();
        JFreeChart barChart = ChartFactory.createBarChart(
                chartTitle,
                // X axis
                file.getHeaders().get(xAxis),
                // Y axis
                file.getHeaders().get(yAxis),
                createDataBase.createDataBase(file, xAxis, yAxis),
                PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension( 560 , 367 ) );
        setContentPane(chartPanel);
    }

    public void display() {
        this.pack();
        RefineryUtilities.centerFrameOnScreen(this);
        this.setVisible(true);
    }
}
