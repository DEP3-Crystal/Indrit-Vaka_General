package com.crystal;

import org.junit.jupiter.api.Test;

public class OSTest {
    @Test
    public void checkOperationSystem(){
        String os = System.getProperty("os.name");
        System.out.println(os);
    }
}
