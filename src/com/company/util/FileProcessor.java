package com.company.util;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;

public class FileProcessor {
    public JsonReader readDataFromFile(String path) throws IOException {
        JsonReader reader = new JsonReader(new FileReader(path));

        return reader;
    }

    public void writeDataToFile(String data, String path) throws IOException {
        try {
            FileWriter fileWriter = new FileWriter(path);
            fileWriter.write(data);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
