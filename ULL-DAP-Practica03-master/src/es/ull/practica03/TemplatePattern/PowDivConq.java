package es.ull.practica03.TemplatePattern;

public class PowDivConq extends DivConqTemplate {
    @Override
    protected boolean isSimple(IProblem p) {
        return ((PowProblem) p).getExponente() == 0;
    }

    @Override
    protected ISolution simplySolve(IProblem p) {
        return new PowSolution(1);
    }

    @Override
    protected IProblem[] decompose(IProblem p) {
        int base = ((PowProblem)p).getBase();
        int exponente = ((PowProblem)p).getExponente();
        return new IProblem[]{ new PowProblem(base, exponente/2), new PowProblem(base, exponente/2)};
    }

    @Override
    protected ISolution combine(IProblem p, ISolution[] ss) {
        int result;
        if(isEven(p)){
            result = (int) (((PowSolution)ss[0]).getResult() * ((PowSolution)ss[1]).getResult());

        }else{
            result = (int) (((PowProblem)p).getBase() * ((PowSolution)ss[0]).getResult() * ((PowSolution)ss[1]).getResult());
        }
        return new PowSolution(result);
    }

    private boolean isEven(IProblem p){
        return ((PowProblem)p).getExponente()%2 == 0;
    }
}
