package by.ruslan.candidatemanagementservice.service;

import by.ruslan.candidatemanagementservice.model.CandidateTest;
import by.ruslan.candidatemanagementservice.repository.CandidateTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateTestService {
    @Autowired
    CandidateTestRepository candidateTestRepository;

    public CandidateTest create(CandidateTest candidateTest) {
        return candidateTestRepository.save(candidateTest);
    }

    public void updateResultTestWithCustomQuery(Long id, String result) {
        candidateTestRepository.updateResultTestByID(id, result);
    }
}
