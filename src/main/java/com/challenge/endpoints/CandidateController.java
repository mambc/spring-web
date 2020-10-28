package com.challenge.endpoints;

import com.challenge.dto.CandidateDTO;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import com.challenge.service.interfaces.CandidateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateServiceInterface candidateServiceInterface;

    @Autowired
    private CandidateMapper candidateMapper;

    @GetMapping("/{userId}/{accelerationId}/{companyId}")
    public CandidateDTO findById(@PathVariable Long userId, @PathVariable Long accelerationId, @PathVariable Long companyId){
        return candidateMapper.map(candidateServiceInterface.findById(userId, companyId, accelerationId).orElse(null));
    }

    @GetMapping
    public List<CandidateDTO> findByAll(@RequestParam(name = "companyId") Optional<Long> companyId,
                                        @RequestParam(name = "accelerationId") Optional<Long> accelerationId){
        return candidateMapper.map(companyId.map(aLong -> ResponseEntity.ok(candidateServiceInterface.findByCompanyId(aLong)))
                              .orElseGet(() -> ResponseEntity.ok(candidateServiceInterface.findByAccelerationId(accelerationId.get()))).getBody());
    }
}
