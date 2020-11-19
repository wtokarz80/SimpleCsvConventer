package com.codecool.formats;

import com.jakewharton.fliptables.FlipTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TableOutputFormatter implements OutputFormatter{

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

        System.out.println(FlipTable.of(headers, content));
    }
}
