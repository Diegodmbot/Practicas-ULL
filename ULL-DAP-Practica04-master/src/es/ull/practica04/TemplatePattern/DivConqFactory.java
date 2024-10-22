package es.ull.practica04.TemplatePattern;

public class DivConqFactory {
    public DivConqTemplate getDivConqTemplate(int inputNumber){
        DivConqTemplate divConq = null;
        if (inputNumber == 1){
            divConq = new MergeSortDivConq();
        }
        else if (inputNumber == 2){
            divConq = new PowDivConq();
        }
        return divConq;
    }
}
