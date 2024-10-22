package preprocessed;

import data.Attribute_Numeric;

public class Normalization {

    /*
    Metodos
     */
    public void normalize(Attribute_Numeric attr) {
        double min = attr.getMin_();
        double denominator = attr.getMax_() - min;
        for (int i = 0; i < attr.sizeVal(); i++) {
            double val = ((double)attr.getValue_(i) - min) / denominator;
            attr.setValue_(i, val);
        }
    }

    public double normalizeVal(Attribute_Numeric attr, double val) {
        return (val - attr.getMin_()) / attr.getMax_() - attr.getMin_();
    }

}
