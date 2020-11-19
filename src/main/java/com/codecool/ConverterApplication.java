package com.codecool;


import com.codecool.config.AppConfig;
import com.codecool.converter.SimpleCsvConverter;
import com.codecool.fileReader.ReadFile;
import com.codecool.formats.FormatType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.File;


@Configuration
@ComponentScan
public class ConverterApplication {

    public static void main(String[] args) {

        String filePath = "";
        FormatType formatType = null;

        if (args.length < 1) {
            System.out.println("No input file defined");
            return;
        }
        if (args.length == 1){
            filePath = args[0];
        }
        else if(args.length == 2) {
            filePath = args[1];
            formatType = FormatType.valueOf(args[0].toUpperCase());
        }

        AppConfig.path = filePath;
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        File file = applicationContext.getBean(File.class);
        SimpleCsvConverter simpleCsvConverter = applicationContext.getBean(SimpleCsvConverter.class);
        simpleCsvConverter.convert(file, formatType);

    }
}
