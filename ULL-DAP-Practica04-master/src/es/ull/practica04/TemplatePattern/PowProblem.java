package es.ull.practica04.TemplatePattern;

import java.util.ArrayList;

public class PowProblem implements IProblem {
    private final int base_;
    private final int exponente_;

    public PowProblem(ArrayList<Integer> arrayFromUser) {
        base_ = arrayFromUser.get(0);
        exponente_ = arrayFromUser.get(1);
    }

    public int getBase() {
        return base_;
    }

    public int getExponente() {
        return exponente_;
    }

}
