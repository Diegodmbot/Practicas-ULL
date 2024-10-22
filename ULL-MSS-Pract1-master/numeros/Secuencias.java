package numeros;

import java.util.*;

public class Secuencias {
	// Constante del entero mas grande que se puede almacenar
	static final int MAXINT = 2147483647;
	ArrayList<Integer> listaNumeros;
	int rango; 
	
	public Secuencias(int n) {
		if (n < 1) n = 10;
		rango = n;
		listaNumeros = new ArrayList<Integer>();
		listaNumeros.add(1);
	}
	
	public Secuencias() {
		this(100);
	}
	
	public void write() {
		write(0,MAXINT);
	}
	
	public void write(int min, int max) {
		Iterator<Integer> itr=listaNumeros.iterator();
		int itr_;
		while(itr.hasNext()) {
			itr_ = (int)itr.next();
			if (itr_ > min && itr_ < max) System.out.print(itr_ + " ");
		}
		System.out.println();
	}
	
	public boolean itBelongs(int numero) {
		Iterator itr=listaNumeros.iterator();
		int itr_;
		boolean output = false;
		while(itr.hasNext()) {
			itr_ = (int)itr.next();
			if (numero == itr_) output = true;
		}
		return output;
	}

	public int add() {
		Iterator<Integer> itr=listaNumeros.iterator();
		int itr_;
		int output = 0;
		while(itr.hasNext()) {
			itr_ = (int)itr.next();
			output += itr_;
		}
		return output;
	}}