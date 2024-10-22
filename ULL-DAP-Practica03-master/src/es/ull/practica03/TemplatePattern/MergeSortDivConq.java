package es.ull.practica03.TemplatePattern;

import java.util.ArrayList;

public class MergeSortDivConq extends DivConqTemplate {
    @Override
    protected boolean isSimple(IProblem p) {
        MergeSortProblem problem = (MergeSortProblem) p;
        return problem.getDisorderedArray().size() <= 1;
    }

    @Override
    protected ISolution simplySolve(IProblem p) {
        MergeSortProblem problem = (MergeSortProblem) p;
        return new MergeSortSolution(problem.getDisorderedArray());
    }

    @Override
    protected IProblem[] decompose(IProblem p) {
        MergeSortProblem problem = (MergeSortProblem) p;
        ArrayList<Integer> disorderedArray = problem.getDisorderedArray();
        ArrayList<Integer> leftArray = new ArrayList<>();
        ArrayList<Integer> rightArray = new ArrayList<>();
        int middle = disorderedArray.size() / 2;
        for (int i = 0; i < middle; i++) {
            leftArray.add(disorderedArray.get(i));
        }
        for (int i = middle; i < disorderedArray.size(); i++) {
            rightArray.add(disorderedArray.get(i));
        }
        MergeSortProblem leftProblem = new MergeSortProblem(leftArray);
        MergeSortProblem rightProblem = new MergeSortProblem(rightArray);
        return new IProblem[]{leftProblem, rightProblem};
    }

    @Override
    protected ISolution combine(IProblem p, ISolution[] ss) {
        MergeSortSolution leftSolution = (MergeSortSolution) ss[0];
        MergeSortSolution rightSolution = (MergeSortSolution) ss[1];
        ArrayList<Integer> leftArray = leftSolution.getOrderedArray();
        ArrayList<Integer> rightArray = rightSolution.getOrderedArray();
        ArrayList<Integer> orderedArray = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < leftArray.size() && rightIndex < rightArray.size()){
            if (leftArray.get(leftIndex) < rightArray.get(rightIndex)){
                orderedArray.add(leftArray.get(leftIndex));
                leftIndex++;
            }else{
                orderedArray.add(rightArray.get(rightIndex));
                rightIndex++;
            }
        }
        while (leftIndex < leftArray.size()){
            orderedArray.add(leftArray.get(leftIndex));
            leftIndex++;
        }
        while (rightIndex < rightArray.size()){
            orderedArray.add(rightArray.get(rightIndex));
            rightIndex++;
        }
        return new MergeSortSolution(orderedArray);
    }
}
