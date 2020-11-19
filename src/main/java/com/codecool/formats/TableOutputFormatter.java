package com.codecool.formats;

import com.jakewharton.fliptables.FlipTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TableOutputFormatter extends OutputFormatter{

    @Override
    public void printToConsole() {
        System.out.println(FlipTable.of(headers, content));

    }
}
