package com.rhattark.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static FileManager fileManager;
    private final String BASE_PATH = "src/com/rhattark/resources/";

    private FileManager() {}

    public static FileManager getInstance() {
        if (fileManager == null) {
            fileManager = new FileManager();
        }
        return fileManager;
    }

    public List<String[]> readKeyValuesFrom(String filePath) throws IOException {
        filePath = BASE_PATH + filePath;
        List<String[]> keyValues = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();

            while (line != null) {
                String[] lineSplit = line.split(":");

                if (lineSplit.length == 2) {
                    keyValues.add(new String[]{lineSplit[0], lineSplit[1]});
                }

                line = br.readLine();
            }
        }

        return keyValues;
    }
}
