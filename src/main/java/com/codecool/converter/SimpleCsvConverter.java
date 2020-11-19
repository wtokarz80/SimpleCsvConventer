package com.codecool.converter;

import com.codecool.fileReader.ReadFile;
import com.codecool.formats.FormatType;
import com.codecool.formats.OutputFormatter;
import com.codecool.formats.OutputFormatterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class SimpleCsvConverter {

    private ReadFile readFile;

    @Autowired
    public SimpleCsvConverter(ReadFile readFile){
        this.readFile = readFile;
    }


    public void convert(File file, FormatType formatType){

        OutputFormatter outputFormatter = new OutputFormatterFactory().createByFormat(formatType);
        outputFormatter.prepareData(readFile.readData(file));
        outputFormatter.printToConsole();


    }

}
