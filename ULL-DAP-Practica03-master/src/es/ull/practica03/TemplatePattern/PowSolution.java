package es.ull.practica03.TemplatePattern;

public class PowSolution implements ISolution {
    private final int result;

    public PowSolution(int result){
        this.result = result;
    }
    public double getResult() {
        return result;
    }
    @Override
    public String toString() {
        return "Resultado = " + result;
    }
}
