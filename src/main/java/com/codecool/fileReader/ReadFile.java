package com.codecool.fileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;

@Component
public class ReadFile {

    private File file;

    public ReadFile(){}


    public BufferedReader readData(File file) {
        BufferedReader br = null;
        try {
           br = new BufferedReader(new java.io.FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return br;
    }

}
