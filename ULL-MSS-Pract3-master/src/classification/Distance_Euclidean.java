package classification;

import java.util.ArrayList;

public class Distance_Euclidean extends Distance{
	@Override
	public double calculateDistance(ArrayList<Double> p1, ArrayList<Double> p2) {
		double output = 0.0;
		for(int i = 0; i < p1.size(); i++) {
			output += Math.pow(p1.get(i) - p2.get(i), 2);
		}
		output = Math.sqrt(output);
		return output;
	}

}
