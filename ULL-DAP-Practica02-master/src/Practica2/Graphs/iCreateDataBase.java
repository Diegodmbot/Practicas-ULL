package Practica2.Graphs;

import Practica2.CSVManager.CSVFile;
import org.jfree.data.category.CategoryDataset;

public interface iCreateDataBase {
    CategoryDataset createDataBase(CSVFile file, int xAxis, int yAxis);
}
