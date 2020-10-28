package com.challenge.endpoints;

import com.challenge.dto.SubmissionDTO;
import com.challenge.mappers.SubmissionMapper;
import com.challenge.service.interfaces.SubmissionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

    @Autowired
    private SubmissionServiceInterface submissionServiceInterface;

    @Autowired
    private SubmissionMapper submissionMapper;

    @GetMapping
    public List<SubmissionDTO> findByChallengeIdAndAccelerationId(@RequestParam(name = "challengeId") Long challengeId,
                                                                  @RequestParam(name = "accelerationId") Long accelerationId){
        return submissionMapper.map(submissionServiceInterface.findByChallengeIdAndAccelerationId(challengeId, accelerationId));
    }

}
