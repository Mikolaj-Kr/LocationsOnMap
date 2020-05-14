package com.krawczak.mapApp.mapApp.mapper;

import com.krawczak.mapApp.mapApp.api.Device;
import com.krawczak.mapApp.mapApp.dto.DeviceDetailsDto;
import com.krawczak.mapApp.mapApp.dto.DeviceDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class DeviceMapper {

    public DeviceDto mapDeviceToDto(Device device) {
        DeviceDto deviceDto = new DeviceDto();
        String[] coordinatesTable = device.getCoordinate().replaceAll(" ", "").split(",");
        String status = "ok";
        List<DeviceDetailsDto> deviceDetailsDtoList = new ArrayList<>();
        deviceDto.setId(device.getId());
        deviceDto.setAddress(device.getAddress());
        deviceDto.setLat(coordinatesTable[0]);
        deviceDto.setLng(coordinatesTable[1]);
        deviceDto.setIp(device.getIp());
        device.getDeviceDetails().forEach(deviceDetails -> {
            DeviceDetailsDto deviceDetailsDto = new DeviceDetailsDto();
            deviceDetailsDto.setType(deviceDetails.getType());
            deviceDetailsDto.setValue(deviceDetails.getValueFromDeviceList().get(0).getValue());
            deviceDetailsDto.setStatus(deviceDetails.getValueFromDeviceList().get(0).getStatus());
            deviceDetailsDtoList.add(deviceDetailsDto);
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

