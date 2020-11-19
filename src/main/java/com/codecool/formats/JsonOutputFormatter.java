package com.codecool.formats;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class JsonOutputFormatter extends OutputFormatter{

    @Override
    public void printToConsole() {
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
