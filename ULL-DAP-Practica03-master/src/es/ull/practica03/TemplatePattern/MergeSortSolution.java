package es.ull.practica03.TemplatePattern;

import java.util.ArrayList;

public class MergeSortSolution implements ISolution {
    private final ArrayList<Integer> orderedArray;
    public MergeSortSolution(ArrayList<Integer> orderedArray) {
        this.orderedArray = orderedArray;
    }
    public ArrayList<Integer> getOrderedArray() {
        return orderedArray;
    }
    @Override
    public String toString() {
        return "Array ordenado con MergeSort: " + orderedArray;
    }
}

