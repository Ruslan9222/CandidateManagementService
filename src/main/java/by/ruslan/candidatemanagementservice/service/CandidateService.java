package by.ruslan.candidatemanagementservice.service;

import by.ruslan.candidatemanagementservice.dto.UpdateCandidateDto;
import by.ruslan.candidatemanagementservice.model.Candidate;
import by.ruslan.candidatemanagementservice.repository.CandidateRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.Optional;

@Service
public class CandidateService {


    @Autowired
    CandidateRepository candidateRepository;

    ModelMapper mapper;


    public Candidate create(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public String convertPhoto(Part photo) throws IOException {
        InputStream fileContent = photo.getInputStream();
        return Base64.getEncoder().encodeToString(fileContent.readAllBytes());
    }

    public void updateCustomer(UpdateCandidateDto dto) {
//        Optional<Candidate> candidate = candidateRepository.findById(dto.getId());
//        mapper.updateCustomerFromDto(dto, candidate);
//        candidateRepository.save(candidate);
    }


}
