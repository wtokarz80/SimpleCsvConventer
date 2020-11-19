package com.codecool.formats;

public class OutputFormatterFactory {

    public OutputFormatter createByFormat(FormatType outputFormatType){

        if (outputFormatType == FormatType.JSON){
            return new JsonOutputFormatter();
        }
        else if (outputFormatType == FormatType.XML){
            return new XmlOutputFormatter();
        }
        return new TableOutputFormatter();

    }
}
