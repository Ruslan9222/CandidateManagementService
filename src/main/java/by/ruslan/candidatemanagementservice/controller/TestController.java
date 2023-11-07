package by.ruslan.candidatemanagementservice.controller;

import by.ruslan.candidatemanagementservice.mapper.TestsMapper;
import by.ruslan.candidatemanagementservice.repository.TestsRepository;
import by.ruslan.candidatemanagementservice.service.TestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/tests")
public class TestController {

    @Autowired
    TestsRepository testsRepository;
    @Autowired
    TestsService testsService;
    @Autowired
    TestsMapper testsMapper;
}
