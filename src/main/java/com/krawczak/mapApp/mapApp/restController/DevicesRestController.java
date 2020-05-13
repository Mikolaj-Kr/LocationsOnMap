package com.krawczak.mapApp.mapApp.restController;

import com.krawczak.mapApp.mapApp.dto.DeviceDto;
import com.krawczak.mapApp.mapApp.service.DeviceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class DevicesRestController {

    private final DeviceService deviceService;

    public DevicesRestController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @GetMapping("/rest/api/devices")
    public List<DeviceDto> getDevicesList(HttpServletResponse response) throws IOException, InterruptedException {
        return deviceService.getDevicesList();
    }

}
