package by.ruslan.candidatemanagementservice.controller;

import by.ruslan.candidatemanagementservice.dto.CreateCandidateDto;
import by.ruslan.candidatemanagementservice.dto.UpdateCandidateDto;
import by.ruslan.candidatemanagementservice.mapper.CandidateMapper;
import by.ruslan.candidatemanagementservice.model.Candidate;
import by.ruslan.candidatemanagementservice.model.Direction;
import by.ruslan.candidatemanagementservice.repository.CandidateRepository;
import by.ruslan.candidatemanagementservice.service.CandidateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;


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

    @PostMapping("/new")
    public ResponseEntity<Candidate> create(@RequestPart("candidate") CreateCandidateDto dto,
                                         @RequestPart("cv") MultipartFile cv,
                                         @RequestPart("photo") MultipartFile photo) throws IOException, InstantiationException, IllegalAccessException {
        if (dto.getPhoto() != null){
            Candidate createCandidateToCandidate = candidateMapper.createCandidateToCandidate(dto);
            Candidate candidate = candidateService.updateCandidate(createCandidateToCandidate);
            return ResponseEntity.ok(candidate);
        } else  {
            return ResponseEntity.badRequest().build();
        }
    }

//    @PutMapping("/updateCandidate")
//    public ResponseEntity<Candidate> updateCandidate(@RequestPart("updateCandidate") UpdateCandidateDto dto,
//                                                     @RequestPart("updatePhoto") MultipartFile updatePhoto,
//                                                     @RequestPart("updateCV") MultipartFile updateCV) throws IOException {
//
//
//        Candidate updateCandidateToCandidate = candidateMapper.updateCandidateToCandidate(dto);
//        Candidate candidate = candidateService.updateCandidate(updateCandidateToCandidate);
//        return ResponseEntity.ok(candidate);
//
//    }

    @GetMapping("{name}/all/{pages}")
    public ResponseEntity<List<Candidate>> findAllByDirectionName(
            @PathVariable String name,
            @PathVariable String pages) {
        List<Candidate> allByCandidateName = candidateRepository.findAllByName(name,
                PageRequest.of(Integer.parseInt(pages), 20, Sort.Direction.ASC, "name"));
        return ResponseEntity.ok(allByCandidateName);
    }
}