package com.codecool.formats;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;


public class XmlOutputFormatter implements OutputFormatter{

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

        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sb.append("<root>\n");
        sb.append("    <elements>\n");
        for (int i = 0; i < content.length; i++){
            sb.append(String.format("        <element %d>" + "\n", i+1));
            for (int j = 0; j < headers.length; j++){
                sb.append(String.format("            <%s>%s</%s>\n",headers[j], content[i][j], headers[j]));
            }
            sb.append("        <element>\n");
        }
        sb.append("    </elements>\n");
        sb.append("</root>\n");

        System.out.println(sb.toString());


    }
}
