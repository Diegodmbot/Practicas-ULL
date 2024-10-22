package paquete1;

import Fracciones.*;

public class main {

	public static void main(String[] args) {
		Fraction a = new Fraction(5,4);
		System.out.print("a = ");
		a.print();
		Fraction b = new Fraction(1,3);
		System.out.print("b = ");
		b.print();
		Fraction c = a.multiply(b);
		System.out.print("c = ");
		c.print();
		Fraction d = a.divide(b);
		System.out.print("d = ");
		d.print();
//		Fraction g = new Fraction(3.7);
//		System.out.println("g = " + g.toString());
//		Fraction h = new Fraction("4,1");
//		System.out.println("h = " + h.toString());
		
	}
}
