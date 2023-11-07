package by.ruslan.candidatemanagementservice.controller;

import by.ruslan.candidatemanagementservice.dto.CreateDirectionDto;
import by.ruslan.candidatemanagementservice.dto.CreateTestDto;
import by.ruslan.candidatemanagementservice.dto.UpdateDirectionDto;
import by.ruslan.candidatemanagementservice.mapper.TestsMapper;
import by.ruslan.candidatemanagementservice.model.Direction;
import by.ruslan.candidatemanagementservice.model.Tests;
import by.ruslan.candidatemanagementservice.repository.TestsRepository;
import by.ruslan.candidatemanagementservice.service.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tests")
public class TestController {

    @Autowired
    TestsRepository testsRepository;
    @Autowired
    TestsService testsService;
    @Autowired
    TestsMapper testsMapper;

    @PostMapping
    ResponseEntity<Tests> create(@RequestBody CreateTestDto createTestDto) {
        Tests testsToTests = testsMapper.createTestDtoToTests(createTestDto);
        Tests tests = testsService.create(testsToTests);
        return ResponseEntity.ok(tests);

    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Tests> updateTestById(
            @RequestBody UpdateDirectionDto updateTestDto,
            @PathVariable("id") long id) {
        testsService.updateTestWithCustomQuery(id, String.valueOf(updateTestDto));
        return (ResponseEntity<Tests>) ResponseEntity.ok();
    }

    @GetMapping("{testName}/all/{pages}")
    public ResponseEntity<List<Tests>> findAllByTestsName(
            @PathVariable String testName,
            @PathVariable String pages) {
        List<Tests> allByTestName = testsRepository.findAllByTestName(testName,
                PageRequest.of(Integer.parseInt(pages), 5, Sort.Direction.ASC, "testName"));
        return ResponseEntity.ok(allByTestName);
    }

}
