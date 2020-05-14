package com.krawczak.mapApp.mapApp.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.StringReader;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValueFromDevice {

    @JsonProperty("wartosc")
    private String value;

    @JsonProperty("status")
    private String status;
}
