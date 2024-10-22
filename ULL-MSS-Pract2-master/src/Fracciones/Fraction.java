package Fracciones;

public class Fraction {
	// Atributos
	long numerator, denominator;

	// Constructores
	public Fraction() {
		this(0, 1);
	}

	public Fraction(final long n) {
		this(n, 1);
	}

	public Fraction(long n, long d) {
		// si d = 0 -> lanzar IllegalArgumentException
		if (d == 0)
			throw new IllegalArgumentException("not valid value = 0 in denominator");
		// hay que hacerlo irreducible en un metodo privado aparte
		// establecer el valor negativo en el numerador
		numerator = n;
		denominator = d;
		simplize();
		normalize();
	}

	public Fraction(double f) {
		System.out.println("Falta");
	}

	public Fraction(String s) {
		// Mirar apartado 3
		// s = "#" o "#/#"
		// si s no es una fraccion -> lanzar NumberFormatException
		System.out.println("Falta");
		parseFraction(s);
	}

	// Métodos Públicos
	long getNumerator() {
		return numerator;
	}

	long getDenominator() {
		return denominator;
	}

	// Comprobar que son irreducible
	void setNumerator(long n) {
		numerator = n;
		simplize();
		normalize();
	}

	void setDenominator(long d) {
		denominator = d;
		simplize();
		normalize();
	}

	void setFraction(Fraction f) {
		numerator = f.getNumerator();
		denominator = f.getDenominator();
		simplize();
		normalize();
	}

	public void changeSign() {
		numerator *= -1;
	}

	public String toString() {
		String output = "" + numerator;
		if (denominator != 1)
			output += "/" + denominator;
		return output;
	}

	public void print() {
		System.out.println(this.toString());
	}

	public long gcd(long n, long d) {
		if (d == 0)
			return n;
		else
			return gcd(d, n % d);
	}

	public long lcm(long n, long d) {
		return (n * d) / gcd(n, d);
	}

	public double ratio() {
		return (double) numerator / denominator;
	}

	public Fraction clone() {
		return this;
	}
	
	public void reciprocal() {
		long aux = numerator;
		numerator = denominator;
		denominator = aux;
	}

	// Operaciones
	public Fraction add(Fraction fr) {
		long d = lcm(this.denominator, fr.denominator);
		long n = (this.numerator * d / this.denominator) + (fr.numerator * d / fr.denominator);
		Fraction output = new Fraction(n, d);
		return output;
	}
	
	public Fraction minus(Fraction fr) {
		fr.changeSign();
		return this.add(fr);
	}
	
	public Fraction multiply(Fraction fr) {
		long d = this.denominator * fr.denominator;
		long n = this.numerator * fr.numerator;
		Fraction output = new Fraction(n, d);
		return output;
	}
	
	public Fraction divide(Fraction fr) {
		fr.reciprocal();
		return this.multiply(fr);
	}

	// Métodos Privados
	private Fraction parseFraction(String s) {
		System.out.println("Falta");
		return null;
	}

	// Hace la fraccion irreducible
	private void simplize() {
		// dividir ambos entre el maximo comun dividor
		long a = gcd(numerator, denominator);
		numerator /= a;
		denominator /= a;
	}

	// Deja el valor negativo (si lo hay) en el numerador
	private void normalize() {
		if (denominator < 0) {
			denominator *= -1;
			if (numerator > 0)
				numerator *= -1;
		}
	}
}
