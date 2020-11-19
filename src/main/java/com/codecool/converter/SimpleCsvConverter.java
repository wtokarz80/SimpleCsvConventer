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
    private OutputFormatter outputFormatter;

    @Autowired
    public SimpleCsvConverter(ReadFile readFile, OutputFormatter outputFormatter){
        this.outputFormatter = outputFormatter;
        this.readFile = readFile;
    }


    public void convert(File file){
        outputFormatter.prepareData(readFile.readData(file));
        outputFormatter.printToConsole();
    }

}
