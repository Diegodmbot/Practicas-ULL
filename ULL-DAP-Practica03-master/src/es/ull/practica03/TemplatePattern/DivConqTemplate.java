package es.ull.practica03.TemplatePattern;

public abstract class DivConqTemplate {

        final public ISolution solve(IProblem p) {
            IProblem[] pp;
            if (isSimple(p)) {
                return simplySolve(p);
            } else {
                pp = decompose(p);
            }

            ISolution[] ss = new ISolution[pp.length];

            for(int i = 0; i < pp.length; i++) {
                ss[i] = solve(pp[i]);
            }

            return combine(p, ss);
        }

        abstract protected boolean isSimple (IProblem p);
        abstract protected ISolution simplySolve (IProblem p);
        abstract protected IProblem[] decompose (IProblem p);
        abstract protected ISolution combine(IProblem p, ISolution[] ss);
}
