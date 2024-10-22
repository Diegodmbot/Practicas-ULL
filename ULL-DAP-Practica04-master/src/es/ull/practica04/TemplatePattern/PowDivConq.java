package es.ull.practica04.TemplatePattern;

import java.util.ArrayList;

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
        ArrayList<Integer> problemArray = new ArrayList<>();
        problemArray.add(base);
        problemArray.add(exponente/2);
        return new IProblem[]{ new PowProblem(problemArray), new PowProblem(problemArray)};
    }

    @Override
    protected ISolution combine(IProblem p, ISolution[] ss) {
        int result;
        if(((PowProblem)p).getExponente()%2 == 0){
            result = (int) (((PowSolution)ss[0]).getResult() * ((PowSolution)ss[1]).getResult());

        }else{
            result = (int) (((PowProblem)p).getBase() * ((PowSolution)ss[0]).getResult() * ((PowSolution)ss[1]).getResult());
        }
        return new PowSolution(result);
    }
}
