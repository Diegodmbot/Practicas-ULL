package es.ull.practica03;

import es.ull.practica03.TemplatePattern.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static final String DELIMITER = ",";
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DivConqTemplate divConq = null;
        IProblem problem = null;
        int inputNumber;
        do{
            System.out.println("""
                    Introduzca el algoritmo de ordenación que desee usar:
                    1. Mergesort\s
                    2. Potencia\s
                    """);
            String input = reader.readLine();
            inputNumber = Integer.parseInt(input);
            System.out.println("Introuzca los números a ordenar separados por ','");
            if (inputNumber == 1){
                ArrayList<Integer> arrayFromUser = getArrayFromUser(reader);
                divConq = new MergeSortDivConq();
                problem = new MergeSortProblem(arrayFromUser);
            }
            else if (inputNumber == 2){
                System.out.println("Introduzca la base");
                int base = Integer.parseInt(reader.readLine());
                System.out.println("Introduzca el exponente");
                int exponente = Integer.parseInt(reader.readLine());
                divConq = new PowDivConq();
                problem = new PowProblem(base, exponente);
            }
            else {
                inputNumber = 0;
                System.out.println("Elija una opción de las indicadas");
            }
        }while(inputNumber == 0);
        ISolution solution = divConq.solve(problem);
        System.out.println(solution);
    }

    public static ArrayList<Integer> getArrayFromUser(BufferedReader reader) throws IOException {
        String input = reader.readLine();
        String[] inputStringArray  = input.split(DELIMITER);
        ArrayList<Integer> inputNumberArray = new ArrayList<>();
        for (String number : inputStringArray) {
            inputNumberArray.add(Integer.parseInt(number));
        }
        return inputNumberArray;
    }
}