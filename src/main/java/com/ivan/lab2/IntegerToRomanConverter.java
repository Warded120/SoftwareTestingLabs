package com.ivan.lab2;

public class IntegerToRomanConverter {
    private final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

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
}