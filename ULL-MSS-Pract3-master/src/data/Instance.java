package data;

import java.util.ArrayList;

public class Instance {
	// Atributos
    private ArrayList<Double> flowerParams;

    // Constructor
    public Instance() {
    }    
    public Instance(ArrayList<Double> flowerParams) {
        this.flowerParams = flowerParams;
    }
    // Metodos
    public ArrayList<Double> GetParams(){
    	return flowerParams;
    }
}
