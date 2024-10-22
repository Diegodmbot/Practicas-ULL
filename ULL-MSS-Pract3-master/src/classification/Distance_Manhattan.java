package classification;

import java.util.ArrayList;

public class Distance_Manhattan extends Distance {

    @Override
    public double calculateDistance(ArrayList<Double> p1, ArrayList<Double> p2) {
        double distance = 0;
        for (int i = 0; i < p1.size(); i++) {
            distance += Math.abs(p1.get(i) - p2.get(i));
        }
        return distance;
    }
}
