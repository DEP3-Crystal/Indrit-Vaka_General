package com.crystal.tests.ex9;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Folders {
    public static Collection<String> folderNames(String xml, char startingLetter) throws Exception {
        return Arrays.stream(xml.split(">"))
                .filter(s -> s.contains("folder name"))
                .map(s -> {
                            String substring = s.split("=")[1].substring(1);
                            return substring.substring(0, substring.indexOf("\""));
                        }
                )
                .filter(s -> s.startsWith(startingLetter+""))
                .collect(Collectors.toList());
    }
    public static void main(String[] args) throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                        "<folder name=\"c\">" +
                        "<folder name=\"program files\">" +
                        "<folder name=\"uninstall information\" />" +
                        "</folder>" +
                        "<folder name=\"users\" />" +
                        "</folder>";


        Collection<String> names = folderNames(xml, 'u');

        for (String name : names)
            System.out.println(name);
    }
}