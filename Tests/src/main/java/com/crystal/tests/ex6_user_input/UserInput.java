package com.crystal.tests.ex6_user_input;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class UserInput {

    public static class TextInput  {
        protected List<Character> characters = new ArrayList<>();
        void add(char c){
            characters.add(c);
        }

        public String getValue() {
            return characters.toString().replaceAll("\\W","");
        }
    }

    public static class NumericInput extends TextInput {
        public void add(char c) {
            if(Pattern.compile("\\d").matcher(c+"").find()){
                characters.add(c);
            }
        }
    }

    public static void main(String[] args) {
        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('0');
        System.out.println(input.getValue());
    }
}