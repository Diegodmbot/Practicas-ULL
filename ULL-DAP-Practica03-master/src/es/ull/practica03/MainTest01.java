package es.ull.practica03;

import es.ull.practica03.TemplatePattern.MergeSortDivConq;
import es.ull.practica03.TemplatePattern.MergeSortProblem;
import es.ull.practica03.TemplatePattern.MergeSortSolution;

import java.util.ArrayList;

public class MainTest01 {
    // Test es.ull.practica03.TemplatePattern.MergeSortDivConq
    public static void main(String[] args) {
        ArrayList<Integer> disorderedArray = new ArrayList<>();
        disorderedArray.add(3);
        disorderedArray.add(4);
        disorderedArray.add(1);
        disorderedArray.add(5);
        disorderedArray.add(2);
        MergeSortProblem problem = new MergeSortProblem(disorderedArray);
        MergeSortDivConq divConq = new MergeSortDivConq();
        MergeSortSolution solution = (MergeSortSolution) divConq.solve(problem);
        System.out.println(solution.toString());
    }
}
