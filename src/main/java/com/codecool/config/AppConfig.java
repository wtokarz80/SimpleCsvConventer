package com.codecool.config;


import com.codecool.converter.SimpleCsvConverter;
import com.codecool.fileReader.ReadFile;
import com.codecool.formats.FormatType;
import com.codecool.formats.OutputFormatter;
import com.codecool.formats.OutputFormatterFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class AppConfig {


    public static String path;
    public static FormatType formatType;

    @Bean
    public SimpleCsvConverter getConverter(){
        ReadFile readFile = new ReadFile();
        OutputFormatter outputFormatter = new OutputFormatterFactory().createByFormat(formatType);
        return new SimpleCsvConverter(readFile, outputFormatter);
    }

    @Bean
    public File getFile(){
        return new File(path);
    }

}
