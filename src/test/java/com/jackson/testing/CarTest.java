package com.jackson.testing;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


class CarTest {
    ObjectMapper objectMapper = new ObjectMapper();


    @Test
    @DisplayName("Class To JSON")
    void classToJSON() throws IOException {
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        Car car = new Car("yellow", "renault");
        objectMapper.writeValue(new File("car.json"), car);
    }

    @Test
    void jsonToObject() throws IOException {
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Car car = objectMapper.readValue(json, Car.class);
        assertThat(car.getColor()).isEqualTo("Black");
    }

    @Test
    void jsonToJsonNode() throws IOException {
        String json = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
        JsonNode jsonNode = objectMapper.readTree(json);
        assertThat(jsonNode.get("color").asText()).isEqualTo("Black");
    }
}
