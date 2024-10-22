package Practica2.CSVManager;

import java.util.ArrayList;
import java.util.Arrays;

public class CSVFile {
    public static final String SEPARATOR = ",";
    private final ArrayList<String> headers;
    private final ArrayList<ArrayList<String>> records;

    public CSVFile(String[] rawContent) {
        headers = new ArrayList<>(Arrays.asList(rawContent[0].split(SEPARATOR)));
        records = new ArrayList<>();
        for (int i = 1; i < rawContent.length; i++) {
            records.add(new ArrayList<>(Arrays.asList(rawContent[i].split(SEPARATOR))));
        }
    }
    public ArrayList<String> getHeaders() {
        return headers;
    }
    public String getValue(int i, int j) {
        return records.get(i).get(j);
    }
    public int getSize() {
        return records.size();
    }
    public String[] getValuesNonRepeated(int xAxis) {
        ArrayList<String> values = new ArrayList<>();
        for (ArrayList<String> record : records) {
            if (!values.contains(record.get(xAxis))) {
                values.add(record.get(xAxis));
            }
        }
        return values.toArray(new String[0]);
    }
}
