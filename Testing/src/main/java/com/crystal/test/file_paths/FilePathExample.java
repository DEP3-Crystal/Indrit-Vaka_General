package com.crystal.test.file_paths;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FilePathExample {

    public static void main(String[] args) {
        getFile();
    }

    public static FileWriter getFile() {
        try {
            return new FileWriter("Testing/src/main/resources/test.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
