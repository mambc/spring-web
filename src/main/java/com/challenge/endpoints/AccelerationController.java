package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import com.challenge.service.interfaces.AccelerationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationServiceInterface accelerationServiceInterface;


    @GetMapping("/{id}")
    public Acceleration findById(@PathVariable Long id){
        return accelerationServiceInterface.findById(id).orElse(null);
    }

    @GetMapping
    public List<Acceleration> findByAll(@RequestParam(name = "companyId") Long id){
        return accelerationServiceInterface.findByCompanyId(id);
    }
}
