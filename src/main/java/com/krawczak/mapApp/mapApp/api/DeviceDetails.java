package com.krawczak.mapApp.mapApp.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceDetails {

    @JsonProperty("oid_id")
    private String oidId;

    @JsonProperty("status")
    private String status;

    @JsonProperty("nazwa")
    String name;

    @JsonProperty("gps")
    String gps;

    @JsonProperty("ip")
    String ip;

    @JsonProperty("typ")
    String type;

    @JsonProperty("wartosc")
    String value;
}
