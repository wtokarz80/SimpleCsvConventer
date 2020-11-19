package com.codecool.config;


import com.codecool.converter.SimpleCsvConverter;
import com.codecool.fileReader.ReadFile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class AppConfig {


    public static String path;

    @Bean
    public SimpleCsvConverter getConverter(){
        ReadFile readFile = new ReadFile();
        return new SimpleCsvConverter(readFile);
    }

    @Bean
    public File getFile(){
        return new File(path);
    }

}
