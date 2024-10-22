package es.ull.practica04.TemplatePattern;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static final String DELIMITER = ",";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DivConqFactory divConqFactory = new DivConqFactory();
        DivConqTemplate divConq;
        ProblemFactory problemFactory = new ProblemFactory();
        IProblem problem = null;
        int inputNumber;
        ArrayList<Integer> arrayFromUser = new ArrayList<>();
        // Menu
        System.out.println("""
                Introduzca el algoritmo de ordenación que desee usar:
                1. Mergesort\s
                2. Potencia\s
                """);
        String input = reader.readLine();
        inputNumber = Integer.parseInt(input);
        if (inputNumber == 1) {
            System.out.println("Introuzca los números a ordenar separados por ','");
            arrayFromUser = getArrayFromUser(reader);
        } else if (inputNumber == 2) {
            System.out.println("Introduzca la base");
            arrayFromUser.add(Integer.parseInt(reader.readLine()));
            System.out.println("Introduzca el exponente");
            arrayFromUser.add(Integer.parseInt(reader.readLine()));
        }
        divConq = divConqFactory.getDivConqTemplate(inputNumber);
        problem = problemFactory.getProblem(inputNumber, arrayFromUser);
        // Ejecutamos el algoritmo
        ISolution solution = divConq.solve(problem);
        System.out.println(solution);
    }

    public static ArrayList<Integer> getArrayFromUser(BufferedReader reader) throws IOException {
        String input = reader.readLine();
        String[] inputStringArray = input.split(DELIMITER);
        ArrayList<Integer> inputNumberArray = new ArrayList<>();
        for (String number : inputStringArray) {
            inputNumberArray.add(Integer.parseInt(number));
        }
        return inputNumberArray;
    }
}