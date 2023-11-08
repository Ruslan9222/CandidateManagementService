package by.ruslan.candidatemanagementservice.mapper;

import by.ruslan.candidatemanagementservice.dto.CreateCandidateDto;
import by.ruslan.candidatemanagementservice.dto.UpdateCandidateDto;
import by.ruslan.candidatemanagementservice.model.Candidate;
import org.springframework.stereotype.Component;

@Component
public class CandidateMapper {
    public Candidate createCandidateToCandidate(CreateCandidateDto createCandidateDto) {
        Candidate candidate = new Candidate();
        candidate.setName(createCandidateDto.getName());
        candidate.setSurname(createCandidateDto.getSurname());
        candidate.setPatronymic(createCandidateDto.getPatronymic());
        candidate.setDescription(createCandidateDto.getDescription());
        return candidate;

    }
//    public Candidate updateCandidateToCandidate(UpdateCandidateDto updateCandidateDto){
//        Candidate candidate = new Candidate();
//        candidate.setName(updateCandidateDto.getName());
//        candidate.setSurname(updateCandidateDto.getSurname());
//        candidate.setPatronymic(updateCandidateDto.getPatronymic());
//        candidate.setDescription(updateCandidateDto.getDescription());
//        return candidate;
//
//    }
}
