package estructuras;

import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;  

public class Vector_ {
	double[] doubleArray;
	int size;
	public Vector_(int size) {
		this.size = size;
		doubleArray = new double[size];
		for(int i=0;i<size;i++) this.setVal(0, i);
	}
	
	public Vector_() {
		this(3);
	}
	// Devuelve las dimensiones del vector
	public int getSize() {
		return size;
	}
	
	public double[] getVec() {
		return doubleArray;
	}
	
	public double getVal(int pos) {
		return doubleArray[pos];
	}
	
	public void setVal (double valor, int pos) {
		doubleArray[pos] = valor;			
	}
	
	public void setVec(double[] vec) {
		doubleArray = vec;
	}
	// Establece todos los valores del vector por pantalla
	public void setAllVals() {
		double d1;
		Scanner sc = new Scanner(System.in); 
		for(int i=0;i<size;i++) {				
			System.out.print("Posición " + i + ": ");
			d1 = sc.nextDouble(); 
			this.setVal(d1, i);
		}
	}
	//  Escribe por pantalla los coeficientes del vector
	public void write() {
		for(int i=0;i<size;i++) System.out.print(doubleArray[i] + " ");
		System.out.println();
	}
	// Pasa al string el vector
	public String toString() {
		String output = "";
		for(int i=0;i<size;i++) {
			output += doubleArray[i] + ",";
		}
		return output;
	}
	// Producto escalar
	public double scalarProd(Vector_ v2) {
		double output = 0;
		for(int i=0;i<size;i++) output += doubleArray[i] * v2.doubleArray[i];
		return output;
	}
	// Escribir en fichero
	public void writeFile(String name) throws IOException {
		FileWriter fw=new FileWriter(name);
		fw.write(this.toString());    
		fw.close(); 
	}
}
