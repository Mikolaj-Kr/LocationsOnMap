package com.krawczak.mapApp.mapApp.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Device {

    @JsonProperty("id")
    String id;

    @JsonProperty("status")
    String status;

    @JsonProperty("adres")
    String address;

    @JsonProperty("gps")
    String gps;

    @JsonProperty("ip")
    String ip;

    @JsonProperty("typ")
    String type;

    @JsonProperty("wartosc")
    String value;

}
