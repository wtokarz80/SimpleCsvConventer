package com.codecool;


import com.codecool.converter.SimpleCsvConverter;
import com.codecool.fileReader.ReadFile;
import com.codecool.formats.FormatType;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.File;


@Configuration
@ComponentScan
public class ConverterApplication {

    public static void main(String[] args) {

        //        String path = "/home/dell/my-projects/advance/simpleCsvConventer/test.csv";

        String path = "";
        FormatType formatType = null;

        if (args.length < 1) {
            System.out.println("No input file defined");
            return;
        }

        if (args.length == 1){
            path = args[0];
        }
        else if(args.length == 2) {
            path = args[1];
            formatType = FormatType.valueOf(args[0].toUpperCase());
        }

        File file = new File(path);

        ReadFile readFile = new ReadFile();


        SimpleCsvConverter simpleCsvConverter = new SimpleCsvConverter(readFile);
        simpleCsvConverter.convert(file, formatType);



    }
}
