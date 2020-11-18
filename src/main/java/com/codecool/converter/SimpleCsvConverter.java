package com.codecool.converter;

import com.codecool.formats.OutputFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class SimpleCsvConverter {

    private File file;
    private OutputFormat outputFormat;

    @Autowired
    public SimpleCsvConverter(File file){
        this.file = file;
    }

    public OutputFormat getOutputFormat() {
        return outputFormat;
    }

    @Autowired(required = false)
    public void setOutputFormat(OutputFormat outputFormat) {
        this.outputFormat = outputFormat;
    }

    public void convert(){
//        example:
//        String message = producer.getMessage();
//        message = decorator != null? decorator.decorate(message) : message;
//        System.out.println(message);

        System.out.println("I convert CSV output format");
    }

}
