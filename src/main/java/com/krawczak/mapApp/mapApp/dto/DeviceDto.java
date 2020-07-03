package com.krawczak.mapApp.mapApp.dto;

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
