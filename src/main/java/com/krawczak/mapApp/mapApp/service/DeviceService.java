package com.krawczak.mapApp.mapApp.service;

import com.krawczak.mapApp.mapApp.api.Device;
import com.krawczak.mapApp.mapApp.dto.DeviceDetailsDto;
import com.krawczak.mapApp.mapApp.dto.DeviceDto;
import com.krawczak.mapApp.mapApp.mapper.DeviceMapper;
import com.krawczak.mapApp.mapApp.parser.ApiParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceService {

    private final DeviceMapper deviceMapper;
    private final ApiParser apiParser;

    @Autowired
    public DeviceService(DeviceMapper deviceMapper, ApiParser apiParser) {
        this.deviceMapper = deviceMapper;
        this.apiParser = apiParser;
    }

    public List<DeviceDto> getDevicesList() throws IOException, InterruptedException {
        List<DeviceDto> devicesList = new ArrayList<>();
        int x = 0;
        while (devicesList.isEmpty() && x<10 ) {
            apiParser.devicesParser().forEach(device -> devicesList.add(deviceMapper.mapDeviceToDto(device)));
            if (x>0){
                Thread.sleep(5000);
            }
            x++;
        }
        return devicesList;
    }
}
