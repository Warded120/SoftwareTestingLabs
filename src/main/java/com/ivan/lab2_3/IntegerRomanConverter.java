package com.ivan.lab2_3;

public class IntegerRomanConverter {
    private final int[] values =     {1000, 900,  500, 400,  100, 90,   50,  40,   10,   9,    5,   4,    1};
    private final String[] symbols = {"M",  "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(Integer num) {
        if (num < 0) {
            throw new IllegalArgumentException("number is less that 0");
        }
        else if (num == 0) {
            throw new IllegalArgumentException("number is zero");
        }

        StringBuilder roman = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }

    public int romanToInt(String roman) {
        if (roman == null) {
            throw new NullPointerException("roman is null");
        } else if (roman.isEmpty()) {
            throw new IllegalArgumentException("Invalid Roman numeral");
        }

        checkInputForInvalidRepetitions(roman);

        int result = 0;
        int prevValue = 0;

        for (int i = roman.length() - 1; i >= 0; i--) {
            int currentValue = getValue(roman.charAt(i));

            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }

    private void checkInputForInvalidRepetitions(String roman) {
        boolean contains = roman.contains("IIII")
                        || roman.contains("VV")
                        || roman.contains("IC")
                        || roman.contains("LL")
                        || roman.contains("CC")
                        || roman.contains("XD")
                        || roman.contains("DD");

        if(contains) {
            throw new IllegalArgumentException("Invalid repetitions in roman");
        }
    }

    private int getValue(char romanChar) {
        return switch (romanChar) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> throw new IllegalArgumentException("Invalid Roman numeral");
        };
    }
}