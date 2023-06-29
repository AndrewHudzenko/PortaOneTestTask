package com.portatest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(getUniqueChar("C makes it easy for you" +
                " to shoot yourself in the foot. " +
                "C++ makes that harder, but when you do, " +
                "it blows away your whole leg. " +
                "(с) Bjarne Stroustrup"));
    }

    public static String getUniqueChar(String inputText) {
        StringBuilder builder = new StringBuilder();

        for (String word : inputText.split("\\s+")) {
            String[] symbols = word.split("");
            leaveUnrepeatedChars(builder, symbols);
        }

        StringBuilder resBuilder = new StringBuilder();

        String[] symbols = builder.toString().split("");
        leaveUnrepeatedChars(resBuilder, symbols);
        return resBuilder.toString();
    }

    private static void leaveUnrepeatedChars(StringBuilder builder, String[] symbols) {
        List<String> list = new ArrayList<>(Arrays.asList(symbols));
        for (int i = 0; i < symbols.length; i++) {
            for (int j = i + 1; j < symbols.length; j++) {
                if (symbols[i].equals(symbols[j])) {
                    list.remove(symbols[i]);
                    list.remove(symbols[j]);
                }
            }
        }
        if (!list.isEmpty()) {
            builder.append(list.get(0));
        }
    }
}
