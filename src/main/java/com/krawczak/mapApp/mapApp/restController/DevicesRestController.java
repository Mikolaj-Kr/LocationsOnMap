package com.krawczak.mapApp.mapApp.restController;

import com.krawczak.mapApp.mapApp.dto.DeviceDto;
import com.krawczak.mapApp.mapApp.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class DevicesRestController {

    private final DeviceService deviceService;

    @Autowired
    public DevicesRestController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/rest/api/devices")
    public List<DeviceDto> getDevicesList() throws IOException, InterruptedException {
        List<DeviceDto> devicesList = deviceService.getDevicesList();
        return devicesList;
    }

}
