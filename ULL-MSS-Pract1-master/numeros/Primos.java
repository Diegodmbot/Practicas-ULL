package numeros;

import java.lang.Math;
import java.util.Iterator;

public class Primos extends Secuencias{
	
	public Primos(int n) {
		super(n);
		doPrime();
	}
	
	public Primos() {
		this(100);
	}
	
	private void doPrime() {
		// si flag es mayor que 0 el numero no es primo
		int flag;
		for(int i = 2; i < rango; i++) {
			flag = 0;
			// limite por arriba
			int top = (int)Math.sqrt(i);
			// Dividir por todos los primos desde 2 hasta max 
			for(int j = 1; j < top; j++) {
				if(i%listaNumeros.get(j) == 0) flag++;
			}
			if (flag == 0) listaNumeros.add(i);
		}
	}
}

