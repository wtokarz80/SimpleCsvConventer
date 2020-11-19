package com.codecool.formats;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

@Component
public class XmlOutputFormatter extends OutputFormatter{

    @Override
    public void printToConsole() {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sb.append("<root>\n");
        sb.append("    <elements>\n");
        for (int i = 0; i < content.length; i++){
            sb.append("        <element>\n");
            for (int j = 0; j < headers.length; j++){
                sb.append(String.format("            <%s>%s</%s>\n",headers[j], content[i][j], headers[j]));
            }
            sb.append("        </element>\n");
        }
        sb.append("    </elements>\n");
        sb.append("</root>\n");

        System.out.println(sb.toString());

    }
}
