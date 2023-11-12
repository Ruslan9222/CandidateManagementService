package by.ruslan.candidatemanagementservice.controller;

import by.ruslan.candidatemanagementservice.mapper.CandidateTestMapper;
import by.ruslan.candidatemanagementservice.repository.CandidateTestRepository;
import by.ruslan.candidatemanagementservice.service.CandidateTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidatetest")
public class CandidateTestController {
    @Autowired
    CandidateTestRepository candidateTestRepository;
    @Autowired
    CandidateTestService candidateTestService;
    @Autowired
    CandidateTestMapper candidateTestMapper;

}
