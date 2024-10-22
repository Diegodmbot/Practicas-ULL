package data;

import java.util.ArrayList;

import information.*;
import preprocessed.*;

public class Attribute_Numeric implements Attribute, Numeric_Information {
    /*
     Atributos
     */
    Normalization normalization;
    Standardization standardization;
    ArrayList<Double> value_;
    double max_;
    double min_;

    /*
    Constructor
     */
    Attribute_Numeric() {
        value_ = new ArrayList<>();
        normalization = new Normalization();
        standardization = new Standardization();
    }

    /*
    Metodos
     */
    public void calculateMaxMin() {
        this.max_ =  value_.get(0);
        this.min_ = value_.get(0);
        double tempDouble;
        for (int i = 1; i < value_.size(); i++) {
            tempDouble = value_.get(i);
            if (tempDouble > max_) max_ = tempDouble;
            if (tempDouble < min_) min_ = tempDouble;
        }
    }
    /*
    Normalizacion
     */
    public void normalize(){
        calculateMaxMin();
        normalization.normalize(this);
    }

    public Double normalizeVal(double tempDouble) {
        return normalization.normalizeVal(this, tempDouble);
    }
    /*
    Estandarizacion
     */
    public void standarize(){
        calculateMaxMin();
        standardization.standardize(this);
    }

    public Double standarizeVal(double tempDouble) {
        return standardization.standardizeVal(this, tempDouble);
    }

    /*
    Metodos de la clase Attribute
     */
    @Override
    public Object getValue_(int i) {
        return value_.get(i);
    }

    @Override
    public void setValue_(int i, Object value) {
        value_.set(i, (double) value);
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
        value_.add(Double.parseDouble(str));
    }

    /*
    Métodos de la clase NumericInformation
     */
    @Override
    public double getMax_() {
        return max_;
    }

    @Override
    public double getMin_() {
        return min_;
    }

    @Override
    public double getAvg() {
        double media = 0;
        for (Double aDouble : value_) {
            media += aDouble;
        }
        return media / value_.size();
    }

    @Override
    public double getTypicalDesviation() {
        double media = getAvg();
        double suma = 0;
        for (Double aDouble : value_) {
            suma += Math.pow(aDouble - media, 2);
        }
        return Math.sqrt(suma / value_.size());
    }

}
