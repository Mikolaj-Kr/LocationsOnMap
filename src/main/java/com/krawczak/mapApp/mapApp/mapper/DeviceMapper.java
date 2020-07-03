package com.krawczak.mapApp.mapApp.mapper;

import com.krawczak.mapApp.mapApp.api.Device;
import com.krawczak.mapApp.mapApp.dto.DeviceDetailsDto;
import com.krawczak.mapApp.mapApp.dto.DeviceDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DeviceMapper {

    public DeviceDto mapDeviceToDto(Device device) {
        DeviceDto deviceDto = new DeviceDto();
        String[] coordinatesTable = device.getDeviceDetailsList().get(0).getGps().replaceAll(" ", "").split(",");
        String status = "ok";
        List<DeviceDetailsDto> deviceDetailsDtoList = new ArrayList<>();
        deviceDto.setId(device.getId());
        deviceDto.setAddress(device.getDeviceDetailsList().get(0).getName());
        deviceDto.setLat(coordinatesTable[0]);
        deviceDto.setLng(coordinatesTable[1]);
        deviceDto.setIp(device.getDeviceDetailsList().get(0).getIp());
        device.getDeviceDetailsList().forEach(details -> {
            DeviceDetailsDto deviceDetailsDto = new DeviceDetailsDto();
            deviceDetailsDto.setStatus(details.getStatus());
            deviceDetailsDto.setValue(details.getValue());
            deviceDetailsDto.setType(details.getType());
            if (!deviceDetailsDto.getValue().equals("SNMP No-Such-Object")) {
                deviceDetailsDtoList.add(deviceDetailsDto);
            }
        });
        deviceDto.setDeviceDetails(deviceDetailsDtoList);

        for (DeviceDetailsDto detailsDto : deviceDetailsDtoList) {
            if (!detailsDto.getStatus().equals("ok")) {
                status = detailsDto.getType();
                break;
            }
        }
        deviceDto.setStatus(status);
        return deviceDto;
    }
}

