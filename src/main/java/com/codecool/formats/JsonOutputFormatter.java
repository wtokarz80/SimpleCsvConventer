package com.codecool.formats;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonOutputFormatter implements OutputFormatter{

    @Override
    public void printToConsole(BufferedReader data) {
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
        String[] headers = rows.get(0);
        String[][] content = new String[rows.size()-1][rows.get(0).length];
        for (int i = 0; i < rows.size()-1; i++){
            System.arraycopy(rows.get(i + 1), 0, content[i], 0, rows.get(0).length);
        }

        JsonFactory jsonFactory = new JsonFactory();
        try (JsonGenerator jsonGenerator = jsonFactory.createGenerator(System.out)) {

            jsonGenerator.writeStartArray();

            for(int j = 0; j < content.length; j++) {
                jsonGenerator.writeStartObject();
                String[] values = content[j];
                int nbCells = headers.length;
                for(int i = 0; i < nbCells; i++) {
                    jsonGenerator.writeFieldName(headers[i]);
                    jsonGenerator.writeString(values[i]);
                }
                jsonGenerator.writeEndObject();
            }
            jsonGenerator.writeEndArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
