package com.krawczak.mapApp.mapApp.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceDetails {

    @JsonProperty("OID_typ")
    private String type;

    @JsonProperty("dbo.aktualny_odczyt")
    private List<ValueFromDevice> valueFromDeviceList;
}
