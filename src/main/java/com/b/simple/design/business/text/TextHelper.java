package com.b.simple.design.business.text;

public class TextHelper {

    public String swapLastTwoCharacters(String str) {
        int length = str.length();
        if (length <= 1) return str;

        char lastChar = str.charAt(length - 1);
        char secondLastChar = str.charAt(length - 2);
        String remainingStr = str.substring(0, length - 2);

        return remainingStr + lastChar + secondLastChar;
    }

    public String truncateAInFirst2Positions(String str) {
        if (str.length() == 0) return "";
        String first2Characters = str.substring(0, 2);
        String remainingStr = str.substring(2);

        String stringTruncated = first2Characters.replaceAll("A", "");

        return stringTruncated + remainingStr;
    }
}
