package numeros;

public class Fibonacci extends Secuencias {
	
	public Fibonacci(int n) {
		super(n);
		doFibonacci();
	}
	
	public Fibonacci() {
		this(10);
	}
	
	private void doFibonacci() {
		if(rango >= 2) listaNumeros.add(1);
		int nextNumber;
		for(int i = 2; i < rango; i++) {
			nextNumber = listaNumeros.get(i-1) + listaNumeros.get(i-2);
			listaNumeros.add(nextNumber);
		}
	}
}
