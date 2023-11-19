package by.ruslan.candidatemanagementservice.controller;

import by.ruslan.candidatemanagementservice.dto.CreateCandidateDto;
import by.ruslan.candidatemanagementservice.mapper.CandidateMapper;
import by.ruslan.candidatemanagementservice.model.Candidate;
import by.ruslan.candidatemanagementservice.repository.CandidateRepository;
import by.ruslan.candidatemanagementservice.service.CandidateService;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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

    @SneakyThrows
    @PostMapping("/new")
    public ResponseEntity<Candidate> create(@RequestPart("candidate") CreateCandidateDto dto,
                                            @RequestPart("cv") MultipartFile cv,
                                            @RequestPart("photo") MultipartFile photo) {
        Candidate candidate = new Candidate();
        candidate.setName(dto.getName());
        candidate.setSurname(dto.getSurname());
        candidate.setPatronymic(dto.getPatronymic());
        candidate.setDescription(dto.getDescription());
        candidate.setCv(cv.getBytes());
        candidate.setPhoto(photo.getBytes());
        candidateRepository.save(candidate);
//        Candidate candidateToCandidate = candidateMapper.createCandidateToCandidate(dto);
//        candidateRepository.save(candidateToCandidate);
        return ResponseEntity.ok(candidate);
    }

    @SneakyThrows
    @PutMapping("/{id}/cv")
    public ResponseEntity<Candidate> updateCv(@PathVariable Long id,
                                              @RequestPart("cv") MultipartFile cv) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow();
        candidate.setCv(cv.getBytes());
        Candidate save = candidateRepository.save(candidate);
        return ResponseEntity.ok(save);
    }
    @SneakyThrows
    @PutMapping("/{id}/photo")
    public ResponseEntity<Candidate> updatePhoto(@PathVariable Long id,
                                              @RequestPart("photo") MultipartFile photo) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow();
        candidate.setPhoto(photo.getBytes());
        Candidate save = candidateRepository.save(candidate);
        return ResponseEntity.ok(save);
    }

    @GetMapping(value = "/{id}/cv", produces = "application/pdf")
    public ResponseEntity<byte[]> downloadCV(@PathVariable Long id) {
        Candidate user = candidateRepository.findById(id).orElseThrow();
        byte[] cv = user.getCv();
        return ResponseEntity.ok(cv);
    }

    @GetMapping(value = "/{id}/photo", produces = "image/png")
    public ResponseEntity<byte[]> downloadPhoto(@PathVariable Long id) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow();
        byte[] photo = candidate.getPhoto();
        return ResponseEntity.ok(photo);
    }


    @GetMapping("{name}/all/{pages}")
    public ResponseEntity<List<Candidate>> findAllByDirectionName(
            @PathVariable String name,
            @PathVariable String pages) {
        List<Candidate> allByCandidateName = candidateRepository.findAllByName(name,
                PageRequest.of(Integer.parseInt(pages), 20, Sort.Direction.ASC, "name"));
        return ResponseEntity.ok(allByCandidateName);
    }
}