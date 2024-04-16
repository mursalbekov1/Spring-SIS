package com.example.convert_numbers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ConvertToDollar {
    BigDecimal number;

    public String convertToDollar() {
        return number.toString() + " $";
    }
}
