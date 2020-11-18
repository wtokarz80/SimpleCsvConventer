package com.codecool;


import com.codecool.converter.SimpleCsvConverter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.File;


@Configuration
@ComponentScan
public class ConverterApplication {

    public static void main(String[] array) {

        //        String path = "/home/dell/my-projects/advance/simpleCsvConventer/test.csv";

        String[] args = {"test.csv"};
        String path = "";
        String formatType = "";

        if (args.length < 1) {
            System.out.println("No input file defined");
            return;
        }

        if (args.length == 1){
            path = args[0];
        }
        else if(args.length == 2) {
            path = args[1];
            formatType = args[0];
        }

        File file = new File(args[0]);

        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(ConverterApplication.class);
        SimpleCsvConverter converter = ctx.getBean(SimpleCsvConverter.class);



//        File file = new File(args[0]);
//        ReadFile fileReader = new ReadFile(file);



    }
}
