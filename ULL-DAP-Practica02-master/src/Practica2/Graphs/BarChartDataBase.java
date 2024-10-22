package Practica2.Graphs;

import Practica2.CSVManager.CSVFile;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChartDataBase implements iCreateDataBase {
    @Override
    public CategoryDataset createDataBase(CSVFile file, int xAxis, int yAxis) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        String[] xAxisValues = file.getValuesNonRepeated(xAxis);
        for (int i = 0; i < xAxisValues.length; i++) {
            int sum = 0;
            for (int j = 0; j < file.getSize(); j++) {
                if (file.getValue(j, xAxis).equals(xAxisValues[i])) {
                    sum += Integer.parseInt(file.getValue(j, yAxis));
                }
            }
            dataset.addValue(sum, file.getValue(i, xAxis), file.getValue(i, yAxis));
        }
        return dataset;
    }
}
