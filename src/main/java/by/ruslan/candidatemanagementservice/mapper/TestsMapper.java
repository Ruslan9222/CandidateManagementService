package by.ruslan.candidatemanagementservice.mapper;

import by.ruslan.candidatemanagementservice.dto.CreateTestDto;
import by.ruslan.candidatemanagementservice.dto.UpdateTestsDto;
import by.ruslan.candidatemanagementservice.model.Tests;
import org.springframework.stereotype.Component;

@Component
public class TestsMapper {
    public Tests createTestDtoToTests(CreateTestDto createTestDto) {
        Tests createTests = new Tests();
        createTests.setTestName(createTestDto.getTestName());
        createTests.setTestDescription(createTestDto.getDescription());
        createTests.setDirections(createTestDto.getDirections());
        return createTests;
    }
    public Tests updateTestDtoToTests(UpdateTestsDto updateTestsDto){
        Tests updateTests = new Tests();
        updateTests.setTestDescription(updateTestsDto.getNameDescription());
        return updateTests;
    }
}