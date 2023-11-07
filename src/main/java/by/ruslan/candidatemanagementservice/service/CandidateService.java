package by.ruslan.candidatemanagementservice.service;

import by.ruslan.candidatemanagementservice.model.Candidate;
import by.ruslan.candidatemanagementservice.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CandidateService {
    @Autowired
    CandidateRepository candidateRepository;
    public Candidate create(Candidate candidate){
        return candidateRepository.save(candidate);
    }
//    public void saveProfilePhoto(MultipartFile photo){
//    }
}
