package by.ruslan.candidatemanagementservice.service;

import by.ruslan.candidatemanagementservice.model.Tests;
import by.ruslan.candidatemanagementservice.repository.TestsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestsService {
    @Autowired
    TestsRepository testsRepository;
    public Tests create(Tests tests){
        return testsRepository.save(tests);
    }
    public Tests updateTestsById(Long id,Tests tests){
        return testsRepository.updateTestById(id,tests);
    }
}
