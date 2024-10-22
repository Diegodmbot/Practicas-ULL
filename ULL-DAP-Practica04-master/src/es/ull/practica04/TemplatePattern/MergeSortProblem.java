package es.ull.practica04.TemplatePattern;

import java.util.ArrayList;

public class MergeSortProblem implements IProblem {
    private final ArrayList<Integer> disorderedArray;
    public MergeSortProblem(ArrayList<Integer> disorderedArray) {
        this.disorderedArray = disorderedArray;
    }
    public ArrayList<Integer> getDisorderedArray() {
        return disorderedArray;
    }
}
