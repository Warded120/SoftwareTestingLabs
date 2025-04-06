package com.ivan.lab2_3;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntegerRomanConverterTest {

    IntegerRomanConverter converter = new IntegerRomanConverter();

    @Nested
    class IntToRomanTests {
        //considered as 17 tests, this method is not that big to have so many unique case branches to test
        @ParameterizedTest
        @CsvSource({
                "1, I",
                "2, II",
                "3, III",
                "4, IV",
                "5, V",
                "9, IX",
                "10, X",
                "27, XXVII",
                "40, XL",
                "50, L",
                "58, LVIII",
                "90, XC",
                "100, C",
                "400, CD",
                "500, D",
                "900, CM",
                "1000, M",
                "4000, MMMM",
                "4999, MMMMCMXCIX"
        })
        void should_ReturnRoman_when_InputIsValid(int input, String expectedResult) {
            // when
            String result = converter.intToRoman(input);
            // then
            assertEquals(expectedResult, result);
        }

        @Test
        void should_ReturnRoman_when_InputIsParsed() {
            //given
            String inputTobeParsed = "19";
            String expected = "XIX";

            //when
            //then
            assertEquals(expected, converter.intToRoman(Integer.valueOf(inputTobeParsed)));
        }

        @Test
        void should_ThrowNumberFormatException_when_InputCouldNotBeParsed() {
            //given
            String inputTobeParsed = "notANumber";

            //when
            //then
            assertThrows(NumberFormatException.class, () -> converter.intToRoman(Integer.valueOf(inputTobeParsed)));
        }
        
        @Test
        void should_ThrowNullPointerException_when_InputIsNull() {
            //when
            //then
            assertThrows(NullPointerException.class, () -> converter.intToRoman(null));
        }

        @Test
        void should_ThrowException_when_InputIsZero() {
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> converter.intToRoman(0));
        }

        @Test
        void should_ThrowException_when_InputIsNegative() {
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> converter.intToRoman(-1));
        }

        @Test
        void should_ThrowException_when_InputIsNegativeLarge() {
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> converter.intToRoman(-999));
        }
    }

    @Nested
    class RomanToIntTests {
        //considered as 20 tests
        @ParameterizedTest
        @CsvSource({
                "I, 1",
                "II, 2",
                "III, 3",
                "IV, 4",
                "V, 5",
                "IX, 9",
                "X, 10",
                "XXVII, 27",
                "XL, 40",
                "L, 50",
                "LVIII, 58",
                "XC, 90",
                "C, 100",
                "CD, 400",
                "D, 500",
                "CM, 900",
                "M, 1000",
                "MCMXCIV, 1994",
                "MMMM, 4000",
                "MMMMCMXCIX, 4999"
        })
        void should_ReturnRoman_when_InputIsValid(String input, Integer expected) {
            //when
            int actual = converter.romanToInt(input);

            //then
            assertEquals(expected, actual);
        }
        
        @Test
        void should_ThrowNullPointerException_when_InputIsNull() {
            //when
            //then
            assertThrows(NullPointerException.class, () -> converter.romanToInt(null));
        }

        @Test
        void should_ThrowIllegalArgumentException_when_InputIsBlank() {
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> converter.romanToInt(""));
        }

        @ParameterizedTest
        @CsvSource({
                //considered as 10 tests
                "IIII",
                "VV",
                "IC",
                "LL",
                "CC",
                "XD",
                "MIIII",
                "MMVV",
                "IIIIII",
                "IXD",
        })
        void should_ThrowIllegalArgumentException_when_InputIsInvalid(String input) {
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> converter.romanToInt(input));
        }
    }
}