package es.ull.practica03.TemplatePattern;

public class PowProblem implements IProblem {
    private final int base_;
    private final int exponente_;

    public PowProblem(int base, int exponente){
        exponente_ = exponente;
        base_ = base;
    }

    public int getBase() {
        return base_;
    }

    public int getExponente() {
        return exponente_;
    }

}
