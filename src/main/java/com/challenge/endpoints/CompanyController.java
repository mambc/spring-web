package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.interfaces.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyServiceInterface companyServiceInterface;

    @GetMapping("/{id}")
    public Company findById(@PathVariable Long id){
        return companyServiceInterface.findById(id).orElse(null);
    }

    @GetMapping
    public List<Company> findByAll(@RequestParam(name = "accelerationId", required = false) Optional<Long> accelerationId,
                                   @RequestParam(name = "userId", required = false) Optional<Long> userId){
        return accelerationId.map(id -> ResponseEntity.ok(companyServiceInterface.findByAccelerationId(id))).orElseGet(() -> ResponseEntity.ok(companyServiceInterface.findByUserId(userId.get()))).getBody();
    }
}
