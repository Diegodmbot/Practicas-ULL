package Practica2.Graphs;

import Practica2.CSVManager.CSVFile;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.ui.RefineryUtilities;

public class LineChart extends Chart {
    public LineChart(String applicationTitle, String chartTitle, CSVFile file, int xAxis, int yAxis) {
        super(applicationTitle, xAxis, yAxis);
        createDataBase  = new LineChartDataBase();
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                // X axis
                file.getHeaders().get(xAxis),
                // Y axis
                file.getHeaders().get(yAxis),
                createDataBase.createDataBase(file, xAxis, yAxis),
                PlotOrientation.VERTICAL,
                true,true,false);
        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }

    public void display() {
        this.pack();
        RefineryUtilities.centerFrameOnScreen(this);
        this.setVisible(true);
    }
}
