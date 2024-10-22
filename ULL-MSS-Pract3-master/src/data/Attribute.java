package data;

public interface Attribute {
    /*
     Metodos
     */
    Object getValue_(int i);

    void setValue_(int i, Object value);

    int sizeVal();

    void writeAttrib(int i);

    void addAttrib(String str);
}
