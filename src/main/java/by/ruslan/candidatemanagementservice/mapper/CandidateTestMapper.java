package by.ruslan.candidatemanagementservice.mapper;

import by.ruslan.candidatemanagementservice.dto.CreateCandidateTestDto;
import by.ruslan.candidatemanagementservice.dto.UpdateCandidateTestDto;
import by.ruslan.candidatemanagementservice.dto.UpdateTestsDto;
import by.ruslan.candidatemanagementservice.model.CandidateTest;
import org.springframework.stereotype.Component;

@Component
public class CandidateTestMapper {
    public CandidateTest createCandidateTestToCandidateTest (CreateCandidateTestDto createCandidateTestDto){
        CandidateTest candidateTest = new CandidateTest();
        candidateTest.setTests(createCandidateTestDto.getTests());
        candidateTest.setResult(createCandidateTestDto.getResult());
        candidateTest.setLocalDate(createCandidateTestDto.getLocalDate());
        return candidateTest;
    }
    public CandidateTest updateResultDtoToResult(UpdateCandidateTestDto updateCandidateTestDto){
        CandidateTest candidateTest = new CandidateTest();
        candidateTest.setResult(updateCandidateTestDto.getResult());
        return candidateTest;
    }
}
