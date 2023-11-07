package by.ruslan.candidatemanagementservice.mapper;

import by.ruslan.candidatemanagementservice.dto.CreateCandidateDto;
import by.ruslan.candidatemanagementservice.model.Candidate;
import org.springframework.stereotype.Component;

@Component
public class CandidateMapper {
    public Candidate CreateCandidateToCAndidate(CreateCandidateDto createCandidateDto) {
        Candidate candidate = new Candidate();
        candidate.setName(createCandidateDto.getName());
        candidate.setSurname(createCandidateDto.getSurname());
        candidate.setPatronymic(candidate.getPatronymic());
        candidate.setDescription(createCandidateDto.getDescription());
        return candidate;

    }
}
