package com.krawczak.mapApp.mapApp.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Device {

    @JsonProperty("ups_id")
    Long id;

    @JsonProperty("aktualny_odczyt")
    List <DeviceDetails> deviceDetailsList;

}
