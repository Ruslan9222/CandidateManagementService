package by.ruslan.candidatemanagementservice.controller;

import by.ruslan.candidatemanagementservice.dto.CreateCandidateDto;
import by.ruslan.candidatemanagementservice.dto.UpdateCandidateDto;
import by.ruslan.candidatemanagementservice.mapper.CandidateMapper;
import by.ruslan.candidatemanagementservice.model.Candidate;
import by.ruslan.candidatemanagementservice.repository.CandidateRepository;
import by.ruslan.candidatemanagementservice.service.CandidateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Objects;


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
                                            @RequestPart("cv") MultipartFile cv) throws IOException {
        Candidate candidateToCandidate = candidateMapper.createCandidateToCandidate(dto);
        Candidate candidate = candidateService.create(candidateToCandidate);
        candidate.setPhoto(candidateService.convertPhoto((Part) photo));
        candidate.setCv(String.valueOf(cv));
        return ResponseEntity.ok(candidate);

    }
    @PutMapping(value = "/candidate/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updatePost(@PathVariable("id") Long id, @RequestBody UpdateCandidateDto updateCandidateDto) {

    }



}