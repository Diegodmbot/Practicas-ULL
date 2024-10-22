package es.ull.practica03;

import es.ull.practica03.TemplatePattern.PowDivConq;
import es.ull.practica03.TemplatePattern.PowProblem;
import es.ull.practica03.TemplatePattern.PowSolution;

public class MainTest02 {
    // Test es.ull.practica03.TemplatePattern.PowDivConq
    public static void main(String[] args) {
        PowProblem problem = new PowProblem(2, 10);
        PowDivConq divConq = new PowDivConq();
        PowSolution solution = (PowSolution) divConq.solve(problem);
        System.out.println(solution.toString());
    }
}
