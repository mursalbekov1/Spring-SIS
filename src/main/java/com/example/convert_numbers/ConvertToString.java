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

    public String convertToString() {
        return String.valueOf(number);
    }
}
