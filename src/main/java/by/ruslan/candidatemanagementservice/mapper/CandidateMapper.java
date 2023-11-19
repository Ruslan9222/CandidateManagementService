package by.ruslan.candidatemanagementservice.mapper;

import by.ruslan.candidatemanagementservice.dto.CreateCandidateDto;
import by.ruslan.candidatemanagementservice.dto.UpdateCandidateDto;
import by.ruslan.candidatemanagementservice.model.Candidate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CandidateMapper {
    public Candidate createCandidateToCandidate(CreateCandidateDto createCandidateDto) throws IOException, InstantiationException, IllegalAccessException {
        Candidate candidate = new Candidate();
        candidate.setName(createCandidateDto.getName());
        candidate.setSurname(createCandidateDto.getSurname());
        candidate.setPatronymic(createCandidateDto.getPatronymic());
        candidate.setDescription(createCandidateDto.getDescription());
        candidate.setCv(createCandidateDto.getCv().getBytes());
        candidate.setPhoto(createCandidateDto.getPhoto().getBytes());
        return candidate;

    }
    public Candidate updateCandidateToCandidate(UpdateCandidateDto updateCandidateDto) throws IOException {
        Candidate candidate = new Candidate();
        candidate.setName(updateCandidateDto.getName());
        candidate.setSurname(updateCandidateDto.getSurname());
        candidate.setPatronymic(updateCandidateDto.getPatronymic());
        candidate.setDescription(updateCandidateDto.getDescription());
        return candidate;

    }
}
