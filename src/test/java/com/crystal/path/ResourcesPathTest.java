package com.crystal.path;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ResourcesPathTest {

    @Test
    public void testClassResourcePath(){
        String rootPath = Objects.requireNonNull(this.getClass().getResource("")).getPath().split("target")[0];

    }
}