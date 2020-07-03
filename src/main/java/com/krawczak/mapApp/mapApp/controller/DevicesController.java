package com.krawczak.mapApp.mapApp.controller;

import com.krawczak.mapApp.mapApp.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class DevicesController {

    private final DeviceService deviceService;

    @Autowired
    public DevicesController(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    @RequestMapping("/devices")
    public ModelAndView getDevicesTable() throws IOException, InterruptedException {
        Map<String, Object> params = new HashMap<>();
        params.put("devicesList", deviceService.getDevicesList());
        return new ModelAndView("devices-site" ,params);
    }
}
