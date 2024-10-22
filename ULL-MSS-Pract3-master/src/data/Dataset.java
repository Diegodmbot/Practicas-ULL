package data;

import java.io.*;
import java.util.*;

public class Dataset {
    /*
     * Atributos
     */
    public static final String DELIMETER = ",";
    // cada espacio del array es una columna del fichero csv
    ArrayList<Attribute_Numeric> attributes;
    // atributos normalizados
    ArrayList<Attribute_Numeric> preprocessedAttributes;
    // atributos cualitativos
    ArrayList<Attribute_Qualitative> qualitativeAttributes;
    // guarda los distintos tipos de flores
    ArrayList<String> types;
    //
    String titulo;
    int numAttributes;
    int numQualitativeAttributes;
    int numInstances;

    /*
     * Constructor
     */
    public Dataset() {
        attributes = new ArrayList<>();
        preprocessedAttributes = new ArrayList<>();
        types = new ArrayList<>();
        titulo = "";
        numAttributes = 0;
        numQualitativeAttributes = 0;
        numInstances = 0;
    }

    public Dataset(String filename) throws IOException {
        read(filename);
    }

    /*
     * Metodos
     */
    public String getTitulo() {
        return titulo;
    }

    public int getNumQualitativeAttributes() {
        return numQualitativeAttributes;
    }

    public int getNumAttributes() {
        return numAttributes;
    }

    public int getNumInstances() {
        return numInstances;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public String getType(int i) {
        return (String) qualitativeAttributes.get(numQualitativeAttributes - 1).getValue_(i);
    }

    public ArrayList<Double> getInstance(int ins) {
        ArrayList<Double> output = new ArrayList<>();
        for (int i = 0; i < numAttributes - 1; i++) {
            output.add(preprocessedAttributes.get(i).value_.get(ins));
        }
        return output;
    }

    public void normalize() {
        for (int i = 0; i < numAttributes - 1; i++) {
            preprocessedAttributes.get(i).normalize();
        }
    }

    public void standardize() {
        for (int i = 0; i < numAttributes - 1; i++) {
            preprocessedAttributes.get(i).standarize();
        }
    }

    public ArrayList<Double> normalizeIns(ArrayList<Double> ins) {
        double tempDouble;
        for (int i = 0; i < numAttributes - 1; i++) {
            tempDouble = ins.get(i);
            ins.set(i, preprocessedAttributes.get(i).normalizeVal(tempDouble));
        }
        return ins;
    }

    public ArrayList<Double> standardizeIns(ArrayList<Double> ins) {
        double tempDouble;
        for (int i = 0; i < numAttributes - 1; i++) {
            tempDouble = ins.get(i);
            ins.set(i, preprocessedAttributes.get(i).standarizeVal(tempDouble));
        }
        return ins;
    }

    void read(String fileName) throws IOException {
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();
        this.titulo = line;
        // Guarda cada valor de la linea en string separados
        String[] tempArr;
        tempArr = line.split(DELIMETER);
        numAttributes = tempArr.length;
        // Crea los ArrayList según los elementos que haya
        attributes = new ArrayList<>(numAttributes - 1);
        preprocessedAttributes = new ArrayList<>(numAttributes - 1);
        qualitativeAttributes = new ArrayList<>();
        qualitativeAttributes.add(new Attribute_Qualitative());
        types = new ArrayList<>();
        for (int i = 0; i < numAttributes - 1; i++) {
            attributes.add(new Attribute_Numeric());
            preprocessedAttributes.add(new Attribute_Numeric());
        }
        // Lee cada linea y almacena cada valor en su respectivo atributo
        while ((line = br.readLine()) != null) {
            tempArr = line.split(DELIMETER);
            for (int i = 0; i < numAttributes; i++) {
                if (i == numAttributes -1) {
                    qualitativeAttributes.get(0).addAttrib(tempArr[i]);
                    addType(tempArr[i]);
                } else {
                    attributes.get(i).addAttrib(tempArr[i]);
                    preprocessedAttributes.get(i).addAttrib(tempArr[i]);
                }
            }
        }
        numQualitativeAttributes = qualitativeAttributes.size();
        numInstances = attributes.get(0).sizeVal();
        br.close();
        fr.close();
    }

    public void write() {
        System.out.println(titulo);
        for (int i = 0; i < numInstances; i++) {
            for (int j = 0; j < numAttributes - 1; j++) {
                attributes.get(j).writeAttrib(i);
            }
            qualitativeAttributes.get(0).writeAttrib(i);
            System.out.println();
        }
    }

    private void addType(String s) {
        int count = 0;
        for (String str : types) {
            if (str.equals(s))
                count++;
        }
        if (count == 0)
            types.add(s);
    }

    public void writeAtribInfo(int i) {
        attributes.get(i).calculateMaxMin();
        System.out.println("\tValores: " + attributes.get(i).sizeVal());
        System.out.println("\tMin: " + attributes.get(i).getMin_());
        System.out.println("\tMax: " + attributes.get(i).getMax_());
        System.out.println("\tMedia: " + attributes.get(i).getAvg());
        System.out.println("\tDesviacion Tipica: " + attributes.get(i).getTypicalDesviation());
    }

    public void writeQualitativeInfo(int i) {
        System.out.println("Nombre: " + types.get(i));
        System.out.println("Frecuencia Relativa: " + qualitativeAttributes.get(0).getFrequency(types.get(i)));

    }
}
