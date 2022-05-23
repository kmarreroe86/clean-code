package com.d.tdd;

public class StringHelperTdd {
    public String truncateAInFirstTwoPositions(String str) {

        if (str.length() < 2) return str.replaceAll("A", "");
        String firstTwoChars = str.substring(0, 2);
        String firstTwoCharsTruncated = firstTwoChars.replaceAll("A", "");

        return  firstTwoCharsTruncated + str.substring(2);
    }

    public boolean checkFirstAndLastTwoCharacters(String s) {
        int length = s.length();
        if (length < 2) return false;

        String firstTwoChars = s.substring(0, 2);
        String lastTwoChars = s.substring(length - 2);
        return firstTwoChars.equals(lastTwoChars);
    }
}
