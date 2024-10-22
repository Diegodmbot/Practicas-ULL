package data;

import java.util.ArrayList;
import information.*;

public class Attribute_Qualitative implements Attribute,Qualitative_Information {
	ArrayList<String> value_;
	// Constructor
	Attribute_Qualitative(){
		value_ = new ArrayList<>();
	}

	/*
	Metodos
	 */
	@Override
	public double getFrequency(String str){
		double frecuence = 0;
		for (String s : value_) {
			if (s.equals(str)) {
				frecuence++;
			}
		}
		frecuence /= value_.size();
		return frecuence;
	}

	/*
	Metodos de la interfaz Attribute
	 */
	@Override
	public Object getValue_(int i) {
		return value_.get(i);
	}

	@Override
	public void setValue_(int i, Object value) {
		value_.set(i, (String) value);
	}

	@Override
	public int sizeVal() {
		return value_.size();
	}

	@Override
	public void writeAttrib(int i) {
		System.out.print(value_.get(i) + " ");
	}

	@Override
	public void addAttrib(String str) {
		value_.add(str);
	}
}
