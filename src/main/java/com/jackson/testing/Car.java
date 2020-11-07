package com.jackson.testing;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Car {

    private String color;
    private String type;

    public Car(String color, String type) {
        this.color = color;
        this.type = type;
    }

    // standard getters setters
}

