package com.codecool.formats;

public enum FormatType {

    TABLE("table"), JSON("json"), XML("xml");

    String type;

    FormatType(String type){
        this.type = type;
    }
}
