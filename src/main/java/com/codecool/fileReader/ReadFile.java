package com.codecool.fileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadFile {

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
