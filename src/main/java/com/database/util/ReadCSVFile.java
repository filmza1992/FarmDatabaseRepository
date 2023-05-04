package com.database.util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.apache.commons.lang3.CharSet;

public class ReadCSVFile {

    ArrayList<String[]> data = new ArrayList<>();
    CSVReader reader = null;
    String csvFile = "src/main/java/com/database/resources/data/";

    public ReadCSVFile(String fileName){
        csvFile += fileName +".csv";
        try {
            reader = new CSVReader(new InputStreamReader(new FileInputStream(csvFile), StandardCharsets.UTF_8));
            String[] line;
            while ((line = reader.readNext()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<String[]> getData() {
        return data;
    }
}

