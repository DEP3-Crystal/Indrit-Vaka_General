package com.crystal.os;

public class OperationSystem {
    public static String getOperatingSystem() {
        // System.out.println("Using System Property: " + os);
        return System.getProperty("os.name");
    }
}
