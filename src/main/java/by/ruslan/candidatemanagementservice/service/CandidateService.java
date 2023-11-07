package by.ruslan.candidatemanagementservice.service;

import by.ruslan.candidatemanagementservice.model.Candidate;
import by.ruslan.candidatemanagementservice.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

@Service
public class CandidateService {
    @Autowired
    CandidateRepository candidateRepository;
    public Candidate create(Candidate candidate){
        return candidateRepository.save(candidate);
    }
    public String convertPhoto(Part photo) throws IOException {
        InputStream fileContent = photo.getInputStream();
        return Base64.getEncoder().encodeToString(fileContent.readAllBytes());
    }
}
