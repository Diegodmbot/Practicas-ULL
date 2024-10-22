package classification;

import java.util.ArrayList;
import data.*;

public class Environment {
	/*
	 Atributos
	 */
	ArrayList<Instance> instances;
	int numInstances;
	//Constructor
	Environment(){
		instances = new ArrayList<>();
		numInstances = 0;
	}
}
