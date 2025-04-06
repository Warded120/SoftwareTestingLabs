package com.ivan.lab2;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntegerToRomanConverterTest {

    IntegerToRomanConverter converter = new IntegerToRomanConverter();

    @Nested
    class intToRomanTests {
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
                "58, LVIII",
                "40, XL",
                "50, L",
                "90, XC",
                "100, C",
                "400, CD",
                "500, D",
                "900, CM",
                "1000, M",
                "4000, MMMM",
                "4999, MMMMCMXCIX"
        })
        void should_ReturnRoman_whenInputIsValid(int input, String expectedResult) {
            // when
            String result = converter.intToRoman(input);
            // then
            assertEquals(expectedResult, result);
        }

        @Test
        void should_ReturnRoman_whenInputIsParsed() {
            //given
            String inputTobeParsed = "19";
            String expected = "XIX";

            //when
            //then
            assertEquals(expected, converter.intToRoman(Integer.valueOf(inputTobeParsed)));
        }

        @Test
        void should_ThrowNumberFormatException_whenInputCouldNotBeParsed() {
            //given
            String inputTobeParsed = "notANumber";

            //when
            //then
            assertThrows(NumberFormatException.class, () -> converter.intToRoman(Integer.valueOf(inputTobeParsed)));
        }
        
        @Test
        void should_ThrowNullPointerException_whenInputIsNull() {
            //when
            //then
            assertThrows(NullPointerException.class, () -> converter.intToRoman(null));
        }

        @Test
        void should_ThrowException_whenInputIsZero() {
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> converter.intToRoman(0));
        }

        @Test
        void should_ThrowException_whenInputIsNegative() {
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> converter.intToRoman(-1));
        }

        @Test
        void should_ThrowException_whenInputIsNegativeLarge() {
            //when
            //then
            assertThrows(IllegalArgumentException.class, () -> converter.intToRoman(-999));
        }
    }
}