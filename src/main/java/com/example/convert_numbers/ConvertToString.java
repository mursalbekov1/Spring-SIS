package com.example.convert_numbers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConvertToString {
    BigInteger number;

    static String convert_to_words(char[] num)
    {
        StringBuilder words = new StringBuilder();

        int len = num.length;

        // Base cases
        if (len == 0) {
            return "empty string";
        }
        if (len > 4) {
            return "Length more than 4 is not supported";
        }

        String[] single_digits = new String[] {
                "zero", "one", "two",   "three", "four",
                "five", "six", "seven", "eight", "nine"
        };

        String[] two_digits = new String[] {
                "",          "ten",      "eleven",  "twelve",
                "thirteen",  "fourteen", "fifteen", "sixteen",
                "seventeen", "eighteen", "nineteen"
        };

        String[] tens_multiple = new String[] {
                "",      "",      "twenty",  "thirty", "forty",
                "fifty", "sixty", "seventy", "eighty", "ninety"
        };

        String[] tens_power = new String[] { "hundred", "thousand" };

        words.append(String.valueOf(num)).append(": ");

        if (len == 1) {
            words.append(single_digits[num[0] - '0']);
            return words.toString();
        }

        int x = 0;
        while (x < num.length) {
            if (len >= 3) {
                if (num[x] - '0' != 0) {
                    words.append(single_digits[num[x] - '0']).append(" ");
                    words.append(tens_power[len - 3]).append(" ");

                }
                --len;
            }
            else {
                if (num[x] - '0' == 1) {
                    int sum = num[x] - '0' + num[x + 1] - '0';
                    words.append(two_digits[sum]);
                    return words.toString();
                }
                else if (num[x] - '0' == 2 && num[x + 1] - '0' == 0) {
                    words.append("twenty");
                    return words.toString();
                }
                else {
                    int i = (num[x] - '0');
                    if (i > 0)
                        words.append(tens_multiple[i]).append(" ");
                    else
                        words.append("");
                    ++x;
                    if (num[x] - '0' != 0)
                        words.append(single_digits[num[x] - '0']);
                }
            }
            ++x;
        }

        return words.toString();
    }

    public String convertToString(BigInteger value) {
        String number = String.valueOf(value);
        return convert_to_words(number.toCharArray());
    }
}
