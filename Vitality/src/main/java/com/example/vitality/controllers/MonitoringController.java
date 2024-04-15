package com.example.vitality.controllers;

import com.example.vitality.dtos.MonitoringDTO;
import com.example.vitality.entities.Monitoring;
import com.example.vitality.servicesinterfaces.IMonitoringService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/seguimiento")
public class MonitoringController {
    @Autowired
    private IMonitoringService mR;

    @PostMapping
    public void insertar(@RequestBody MonitoringDTO monitoringDTO) {
        ModelMapper d = new ModelMapper();
        Monitoring monitoring = d.map(monitoringDTO, Monitoring.class);
        mS.insert(monitoring);
    }

    @GetMapping
    public List<MonitoringDTO> listar() {
        return mR.list().stream().map(y-> {
            ModelMapper m=new ModelMapper();
            return  m.map(y,MonitoringDTO.class);
        }).collect(Collectors.toList());
    }
}