package preprocessed;

import data.Attribute_Numeric;

public class Standardization {
    public void standardize(Attribute_Numeric attr) {
        double avg = attr.getAvg();
        double std = attr.getTypicalDesviation();
        for (int i = 0; i < attr.sizeVal(); i++) {
            double val = ((double)attr.getValue_(i) - avg) / std;
            attr.setValue_(i, val);;
        }
    }
    public double standardizeVal(Attribute_Numeric attr, double value) {
        return (value - attr.getAvg()) / attr.getTypicalDesviation();
    }
}
