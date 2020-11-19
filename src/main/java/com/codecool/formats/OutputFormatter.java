package com.codecool.formats;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;


public abstract class OutputFormatter {

    protected String[] headers;
    protected String[][] content;

    public void prepareData(BufferedReader data){
            List<String[]> rows = new ArrayList<>();
            try {
                String line = "";
                while ((line = data.readLine()) != null) {
                    String[] values = line.split(",");
                    rows.add(values);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            headers = rows.get(0);
            content = new String[rows.size()-1][rows.get(0).length];
            for (int i = 0; i < rows.size()-1; i++){
                System.arraycopy(rows.get(i + 1), 0, content[i], 0, rows.get(0).length);
            }
    }

    public abstract void printToConsole();

}
