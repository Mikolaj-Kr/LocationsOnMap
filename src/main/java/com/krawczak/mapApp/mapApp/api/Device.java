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

    @JsonProperty("ups_adres")
    String address;

    @JsonProperty("ups_ip")
    String ip;

    @JsonProperty("ups_gps")
    String coordinate;

    @JsonProperty("dbo.OID")
    List<DeviceDetails> deviceDetails;
}
