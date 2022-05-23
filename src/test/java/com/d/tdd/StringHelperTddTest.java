package com.d.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

/*
Truncate A in first 2 positions of a String:
* "ABCD" => "BCD", "AACD"=> "CD", "BACD"=>"BCD", "AAAA" => "AA", "MNAA"=>"MNAA"
* */
public class StringHelperTddTest {

    StringHelperTdd stringHelperTdd = new StringHelperTdd();

    @ParameterizedTest
    @CsvSource({
            "ABCD, BCD",
            "AACD, CD",
            "BACD, BCD",
            "AAAA, AA",
            "MNAA, MNAA",
            "AE, E",
            "AA, ''",
            "'', ''",
            "B, B",
            "BC, BC"
    })
    void givenAString_TruncateAInFirstTwoPosition_ShouldReturnStringWithoutCharacterA(String input, String expected) {


        String actualStr = stringHelperTdd.truncateAInFirstTwoPositions(input);

        assertEquals(expected,actualStr);
//        fail();
    }

   // ""=>false, "A"=>false, "AB"=>true, "ABC"=>false, "AAA"=>true, "ABCAB"=>true, "ABCDEBA"=>false
    @ParameterizedTest
    @CsvSource({
            "'', false",
            "A, false",
            "AB, true",
            "ABC, false",
            "AAA, true",
            "ABCAB, true",
            "ABCDEBA, false"
    })
    void givenAString_checkIfFirstAndLastTwoCharactersAreEquals_ShouldReturnTrueIfTheyAreTheSame(String input, boolean expected) {
        boolean actual = stringHelperTdd.checkFirstAndLastTwoCharacters(input);
        assertEquals(expected, actual);
    }
}
