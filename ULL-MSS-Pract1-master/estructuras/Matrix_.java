package estructuras;

import java.io.*;
import java.util.Scanner;  

public class Matrix_ {
	Vector_[] doubleMatrix;
	int rows;
	int cols;
	
	public Matrix_(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
		doubleMatrix = new Vector_[rows];
		for(int i = 0; i < rows; i++) {
			doubleMatrix[i] = new Vector_(cols);
		}
	}
	
	public Matrix_(){
		this(1,1);
	}
	
	public Matrix_(int rows, int cols, double[][] coef) {
		this(rows,cols);
		for(int i = 0; i < coef.length; i++) {
			for(int j = 0; j < coef[i].length; j ++) doubleMatrix[i].setVal(coef[i][j], j);
		}
	}
	
	public Matrix_(String name) throws IOException {
		readFile(name);
	}
	
	public int getNumRow() {
		return rows;
	}
	
	public int getNumCol() {
		return cols;
	}
	
	public Vector_ getRow(int pos){
		return doubleMatrix[pos];
	}
	
	public Vector_ getCol(int pos) {
		Vector_ output = new Vector_(this.cols);
		for(int i = 0; i < this.cols; i++) output.setVal(this.doubleMatrix[i].getVal(pos), i); 
		return output;
	}
	
	public void setAllVals() {
		for(int i = 0; i < cols; i++) {
			System.out.println("Fila " + i);
			doubleMatrix[i].setAllVals();
		}
	}
	public void print() { 
		for(int i = 0; i < cols;i++) doubleMatrix[i].write();
	}
	
	public double[][] matrixProd(Matrix_ m2) {
		double[][] output = new double[this.rows][m2.cols];
		Vector_ v1 = new Vector_(m2.cols);			
		for(int i = 0; i < this.rows; i++) {
			for (int j = 0; j < m2.cols; j++) {
				v1 = m2.getCol(j);
				output[i][j] = this.getRow(i).scalarProd(v1);
			}
		}
		return output;
	}
	
	public void readFile(String name) throws IOException {
		FileInputStream fis = new FileInputStream(name);       
		Scanner sc = new Scanner(fis);
	    this.rows = sc.nextInt();
	    this.cols = sc.nextInt();
	    doubleMatrix = new Vector_[rows];
		for(int i = 0; i < rows; i++) doubleMatrix[i] = new Vector_(cols);
	    String str;
	    String[] strArray;
	    sc.nextLine();
	    for(int i = 0; i < this.rows; i++) {
	    	str = sc.nextLine();
	    	strArray = str.split(",");
	    	for (int j = 0; j < cols; j++) doubleMatrix[i].setVal(Double.parseDouble(strArray[j]), j);	    	
	    } 
	}
	
	public void writeFile(String name) throws IOException {
		FileWriter fw=new FileWriter(name);
		fw.write(this.rows + "\n");
		fw.write(this.cols + "\n");
		for(int i = 0; i < this.rows; i++) {
			fw.write(this.doubleMatrix[i].toString());
			fw.write("\n");
		}
		fw.close();
	}
}
