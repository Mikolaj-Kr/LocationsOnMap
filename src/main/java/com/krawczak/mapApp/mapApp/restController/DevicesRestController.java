package com.krawczak.mapApp.mapApp.restController;

import com.krawczak.mapApp.mapApp.dto.DeviceDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DevicesRestController {

    @GetMapping("/rest/api/devices")
    public List<DeviceDto> getDevicesList(){
        List<DeviceDto> devicesList = new ArrayList<>();
        DeviceDto deviceDto = new DeviceDto();
        DeviceDto deviceDto1 = new DeviceDto();
        deviceDto.setId("1");
        deviceDto.setLat("53.501757");
        deviceDto.setLng("18.778621");
        deviceDto.setStatus("jestem na Paderewskiego");
        deviceDto1.setId("2");
        deviceDto1.setLat("53.454509");
        deviceDto1.setLng("18.719909");
        deviceDto1.setStatus("jestem na rządzu");
        devicesList.add(deviceDto);
        devicesList.add(deviceDto1);
        return devicesList;
    }

}
