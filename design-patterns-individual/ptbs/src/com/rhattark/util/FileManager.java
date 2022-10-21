package com.rhattark.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a generic class used for file parsing and appending to it
 * @Pattern Singleton - only single instance of file manager will be created
 */
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

    /**
     * Read and parse given file
     * @param filePath
     * @return list of keyValue array read from file
     * @throws IOException
     */
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

    /**
     * Append string at the end of a given file
     * @param givenString
     * @param filePath
     * @throws IOException
     */
    public void appendStringToFile(String givenString, String filePath) throws IOException {
        filePath = BASE_PATH + filePath;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));) {
            bw.write(givenString);
            bw.newLine();
        }
    }
}
