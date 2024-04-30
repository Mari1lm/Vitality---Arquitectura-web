package com.example.vitality.controllers;

import com.example.vitality.dtos.MonitoringDTO;
import com.example.vitality.entities.Monitoring;
import com.example.vitality.servicesinterfaces.IMonitoringService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/seguimiento")
public class MonitoringController {
    @Autowired
    private IMonitoringService mR;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN') OR hasAuthority('PROFESIONAL')")
    public void insertar(@RequestBody MonitoringDTO monitoringDTO) {
        ModelMapper d = new ModelMapper();
        Monitoring monitoring = d.map(monitoringDTO, Monitoring.class);
        mR.insert(monitoring);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<MonitoringDTO> listar(){
        return mR.list().stream().map(y->{
            ModelMapper m=new ModelMapper();
            return m.map(y,MonitoringDTO.class);
        }).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void eliminar(@PathVariable("id") Integer id){

        mR.delete(id);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public MonitoringDTO listarId(@PathVariable("id") Integer id){

        ModelMapper m= new ModelMapper();
        MonitoringDTO dto=m.map(mR.listId(id),MonitoringDTO.class);
        return dto;

    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public void modificar(@RequestBody MonitoringDTO monitoringDTO){
        ModelMapper d= new ModelMapper();
        Monitoring monitoring=d.map(monitoringDTO,Monitoring.class);
        mR.insert(monitoring);
    }


}