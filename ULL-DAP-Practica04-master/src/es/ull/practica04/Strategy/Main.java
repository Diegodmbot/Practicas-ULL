package es.ull.practica04.Strategy;

import java.util.Scanner;

/*
 * https://cnecovid.isciii.es/covid19/resources/hosp_uci_def_sexo_edad_provres_todas_edades.csv
 */
public class Main {
    public static void main(String[] args) {
        // Introducir archivo para descargar
        Scanner sc = new Scanner(System.in);
        String url;
        if (args.length == 0) {
            System.out.println("Introduce la URL del archivo CSV:");
            url = sc.nextLine();
        } else {
            url = args[0];
        }
        // Descargar archivo
        System.out.println("Downloading from: " + url);
        String[] contents = HTTPFileDownloader.downloadFromURL(url).split("\n");
        CSVFile data = new CSVFile(contents);
        // Crear gráfica
        System.out.println("""
                Introduzca el tipo de diagrama que desea crear:
                1. Line\s
                2. Bar\s
                """);
        int option = sc.nextInt();
        System.out.println("Introduce el indice del eje X:");
        int xAxis = sc.nextInt();
        System.out.println("Introduce el indice del eje Y:");
        int yAxis = sc.nextInt();
        Chart chart = null;
        if (option == 1) chart = new BarChart("Practica02", "Practica02", data, xAxis, yAxis);
        else if(option == 2) chart = new LineChart("Practica02", "Practica02", data, xAxis, yAxis);
        // Mostrar gráfica
        chart.display();
    }
}
