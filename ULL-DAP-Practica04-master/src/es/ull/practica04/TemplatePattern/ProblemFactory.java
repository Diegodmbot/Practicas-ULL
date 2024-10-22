package es.ull.practica04.TemplatePattern;

import java.util.ArrayList;

public class ProblemFactory {
    public IProblem getProblem(int inputNumber, ArrayList<Integer> arrayFromUser){
        IProblem problem = null;
        if (inputNumber == 1){
            problem = new MergeSortProblem(arrayFromUser);
        }
        else if (inputNumber == 2){
            problem = new PowProblem(arrayFromUser);
        }
        return problem;
    }
}
