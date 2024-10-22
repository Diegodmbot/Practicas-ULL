/*
 * Se implementa toda la prática 1
 * De la práctica 2 no se implementa el pesado de atributos (punto 4), pesado de casos y reglas de clasificación(punto 5) y el punto 6 y 7
 */

package main;

import java.util.ArrayList;
import java.util.Scanner;

import classification.*;
import data.*;

public class main {
    //  Valores por defecto
    public static int k_ = 5;
    public static int distance_ = 1;
    public static int preprocceisng = 2;

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            // fichero csv
            System.out.print("Introduce el nombre del fichero csv: ");
            String fileName = sc.nextLine();
            Dataset iris = new Dataset(fileName);
            while (true) {
                menu(iris);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Menu
    public static void menu(Dataset iris) {
        System.out.println();
        System.out.println("/********************MENU******************/");
        System.out.println("1.- Mostrar datos");
        System.out.println("2.- Mostrar informacion sobre los atributos");
        System.out.println("3.- Mostrar valores de evaluacion");
        System.out.println("4.- Analizar");
        System.out.println("5.- Modificar valores de evaluacion");
        System.out.println("6.- Salir");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        switch (option) {
            case 1 -> iris.write();
            case 2 -> writeInfo(iris);
            case 3 -> writeEvaluation();
            case 4 -> analyzeData(iris);
            case 5 -> modifyEvaluation(iris);
            case 6 -> System.exit(0);
        }
    }

    private static void modifyEvaluation(Dataset iris) {
    }

    private static void writeEvaluation() {
        System.out.println("Valores de evaluacion: ");
        System.out.print("Distancia: ");
        switch(distance_) {
            case 1 -> System.out.println("Euclidea");
            case 2 -> System.out.println("Manhattan");
            case 3 -> System.out.println("Chebycheff");
        }
        System.out.print("Preprocesado: ");
        switch(preprocceisng) {
            case 1 -> System.out.println("Sin preprocesamiento");
            case 2 -> System.out.println("Normalizacion");
            case 3 -> System.out.println("Estandarizacion");
        }
        System.out.println("K: " + k_);

    }

    // Mostrar información sobre los atributos
    private static void writeInfo(Dataset iris) {
        System.out.println("Atributos: " + iris.getTitulo());
        System.out.println("Numero de atributos numericos: " + iris.getNumAttributes());
        System.out.println("Numero de instancias: " + iris.getNumInstances());
        System.out.println("Numero de clases: " + iris.getTypes().size());
        // Mostrar información relevante de los atributos
        String[] atributos = iris.getTitulo().split(",");
        for (int i = 0; i < iris.getNumAttributes() - 1; i++) {
            System.out.println("Atributo " + atributos[i] + ":");
            iris.writeAtribInfo(i);
        }
        System.out.println("Numero de atributos cualitativos: " + iris.getNumQualitativeAttributes());
        for (int i = 0; i < iris.getTypes().size(); i++) {
            iris.writeQualitativeInfo(i);
        }
    }

    // Analizar
    public static void analyzeData(Dataset iris) {
        System.out.println("Introduzca el tipo de preprocesado: ");
        System.out.println("1.- Sin procesar");
        System.out.println("2.- Normalizar");
        System.out.println("3.- Estadarizar");
        int option = new Scanner(System.in).nextInt();
        switch (option) {
            case 1:
                break;
            case 3:
                iris.standardize();
                break;
            default:
                iris.normalize();
                break;
        }
        System.out.println("Introduce los datos para analizar: ");
        Scanner sc = new Scanner(System.in);
        String[] tempArr = iris.getTitulo().split(",");
        ArrayList<Double> values = new ArrayList<>();
        double tempDouble;
        for (int i = 0; i < iris.getNumAttributes() - 1; i++) {
            System.out.print(tempArr[i] + ":");
            tempDouble = sc.nextDouble();
            values.add(tempDouble);
        }
        Instance ins1 = switch (option) {
            case 1 -> new Instance(values);
            case 3 -> new Instance(iris.standardizeIns(values));
            default -> new Instance(iris.normalizeIns(values));
        };
        // buscar los k vecinos
        System.out.print("Introduzca los k vecinos para analizar: ");
        int k = sc.nextInt();
        // calcular el tipo
        System.out.println("Tipo de distancia:");
        System.out.println("1.- Euclidea");
        System.out.println("2.- Manhattan");
        System.out.println("3.- Chebychef");
        int dist = sc.nextInt();
        KNN knn_ = new KNN(dist);
        String output = knn_.predictType(iris, k, ins1);
        System.out.println("La clase sera: " + output);
    }
}


