package by.ruslan.candidatemanagementservice.controller;

import by.ruslan.candidatemanagementservice.dto.CreateCandidateDto;
import by.ruslan.candidatemanagementservice.mapper.CandidateMapper;
import by.ruslan.candidatemanagementservice.model.Candidate;
import by.ruslan.candidatemanagementservice.repository.CandidateRepository;
import by.ruslan.candidatemanagementservice.service.CandidateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
    CandidateService candidateService;
    @Autowired
    CandidateMapper candidateMapper;

    Logger logger = LoggerFactory.getLogger(CandidateController.class);

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<Candidate> create(@RequestPart("candidate") CreateCandidateDto dto,
                                            @RequestPart("photo") MultipartFile photo,
                                            @RequestPart("cv") MultipartFile cv) {
        Candidate candidateToCandidate = candidateMapper.CreateCandidateToCAndidate(dto);
        Candidate candidate = candidateService.create(candidateToCandidate);
        candidate.setPhoto(String.valueOf(photo));
        candidate.setCv(String.valueOf(cv));
        return ResponseEntity.ok(candidate);


    }



}