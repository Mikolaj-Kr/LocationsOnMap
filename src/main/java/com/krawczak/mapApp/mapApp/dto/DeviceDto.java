package com.krawczak.mapApp.mapApp.dto;

import com.krawczak.mapApp.mapApp.api.DeviceDetails;
import lombok.Data;

import java.util.List;

@Data
public class DeviceDto {

    private Long id;
    private String address;
    private String status;
    private String ip;
    private String lat;
    private String lng;
    private List<DeviceDetailsDto> deviceDetails;

}
