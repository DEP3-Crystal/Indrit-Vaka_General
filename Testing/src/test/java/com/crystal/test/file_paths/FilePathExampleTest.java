package com.crystal.test.file_paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FilePathExampleTest {

    @Test
    void testGetFile() {

        //This will throw file not found when we run it from ide,
        // no exception are thrown through terminal -> mvn clean install
        FilePathExample.getFile();

    }
}