package com.company.util;

import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class FileProcessor {
    public Map<?, ?> readDataFromFile(String path) throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get(path));
        Map<?, ?> map = gson.fromJson(reader, Map.class);
        reader.close();

        return map;
    }

    public void writeDataToFile(String data, String path) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        fileWriter.write(data);
        fileWriter.close();
    }
}
