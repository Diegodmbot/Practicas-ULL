package paquete1;

import numeros.*;
import estructuras.*;

import java.io.IOException;
import java.util.*;

public class Ejercicio1 {
	
	private static Secuencias num;
	private static Scanner sc = new Scanner(System.in); 
	
	public static void main(String[] args) {
		Ejercicio1.apartado1();
		Ejercicio1.apartado2();
		Ejercicio1.apartado3();
		Ejercicio1.apartado4();
		Ejercicio1.apartado5();
		Ejercicio1.apartado6();
		Ejercicio1.apartado7();
		Ejercicio1.apartado9();
		Ejercicio1.apartado8();
	}
	
	public static void apartado1() {
		System.out.println("Primos:");
		System.out.println("Introduce valor: ");
		int n1 = sc.nextInt();
		num = new Primos(n1);
		num.write();
		System.out.println("Suma: ");
		int sum = num.add();
		System.out.println(sum);
	}
	
	public static void apartado2() {
		System.out.println("Introduce valor: ");
		int n1 = sc.nextInt();
		num = new Fibonacci(n1);
		num.write();	
		System.out.println("Pertenece1:");
		n1 = sc.nextInt();
		boolean pertenece1 = num.itBelongs(n1);
		System.out.println(pertenece1);
		System.out.println("Pertenece2:");
		n1 = sc.nextInt();
		boolean pertence2 = num.itBelongs(n1);
		System.out.println(pertence2);
	}
	
	public static void apartado3() {
		System.out.println("Subintervalo:");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		num.write(n1,n2);
	}
	
	public static void apartado4() {
		System.out.println("Vectores:");
		System.out.println("Introduce tamaño de v1:");
		int n1 = sc.nextInt();
		Vector_ v1 = new Vector_(n1);
		v1.setAllVals();
		System.out.println("Introduce tamaño de v2:");
		n1 = sc.nextInt();
		Vector_ v2 = new Vector_(n1);
		v2.setAllVals();
		System.out.println("v1: ");
		v1.write();
		System.out.println("v2: ");
		v2.write();		
		try {			
			System.out.print("Producto Escalar: ");
			double prod_esc = v1.scalarProd(v2);
			System.out.println(prod_esc);
		}
		catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: No se puede hacer el producto escalar de dos vectores de diferentes tamaños");
		}
	}
	
	public static void apartado5() {
		System.out.println("Introduce tamaño de v3:");
		int n1 = sc.nextInt();
		Vector_ v3 = new Vector_(n1);
		v3.write();
		v3.setAllVals();
		System.out.println("Introduce nombre del fichero:");
		String name = sc.next();
		try {
			v3.writeFile(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void apartado6() {
		System.out.println("Matriz:");
		Matrix_ m1 = new Matrix_();
		System.out.println("m1:");
		m1.print();
		System.out.println("Introduce las filas y columnas de m2:");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		Matrix_ m2 = new Matrix_(n1,n2);
		System.out.println("m2:");
		m2.print();
		double[][] coef = new double[2][2];
		coef[0][0] = 1;
		coef[0][1] = 1.5;
		coef[1][0] = 2;
		coef[1][1] = 2.5;
		System.out.println("Introduce las filas y columnas de m3:");
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		Matrix_ m3 = new Matrix_(n1,n2,coef);
		System.out.println("m3:");
		m3.print();
	}
	
	public static void apartado7() {
		System.out.println("Introduce las filas y columnas de m4:");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		Matrix_ m4 = new Matrix_(n1,n2);
		m4.setAllVals();
		System.out.println("m4:");
		m4.print();
		System.out.println("Introduce las filas y columnas de m5:");
		n1 = sc.nextInt();
		n2 = sc.nextInt();
		Matrix_ m5 = new Matrix_(n1,n2);
		m5.setAllVals();
		System.out.println("m5:");
		m5.print();
		try {			
			Matrix_ m6 = new Matrix_(m4.getNumRow(),m5.getNumCol(),m4.matrixProd(m5));
			System.out.println("m6:");
			m6.print();
		}
		catch (IndexOutOfBoundsException e) {
			System.err.println("IndexOutOfBoundsException: El número de columnas de la primera matriz debe coincidir con el número de filas de la segunda matriz. ");
		}
	}
	
	public static void apartado8() {
		System.out.println("Introduce nombre del fichero:");
		String name = sc.next();
		try {
			Matrix_ m7 = new Matrix_(name);
			m7.print();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void apartado9() {
		System.out.println("Introduce las filas y columnas de m4:");
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		Matrix_ m8 = new Matrix_(n1,n2);
		m8.setAllVals();
		System.out.println("Introduce nombre del fichero:");
		String name = sc.next();
		try {
			m8.writeFile(name);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
