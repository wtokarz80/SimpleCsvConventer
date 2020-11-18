package com.codecool.fileReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;

public class ReadFile {

    private File file;
    private BufferedReader br;

    ReadFile(){}

    public ReadFile(File file){
        this.file = file;

    }

    public void readCSVFile() {
        try {
            br = new BufferedReader(new java.io.FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
