package by.ruslan.candidatemanagementservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/calculator")
public class CalculatorController {

    Logger logger = LoggerFactory.getLogger(CalculatorController.class);

//    @PostMapping(consumes = "multipart/form-data")
//    public String create(@RequestPart("candidate") CreateCandidateDto dto,
//                         @RequestPart("photo") MultipartFile photo,
//                         @RequestPart("cv") MultipartFile cv) {

//    }

    @PostMapping
    public Integer calculate(@AuthenticationPrincipal UserDetails userDetails, Integer num1, Integer num2) {
//    System.out.println(userDetails);
        logger.info("Calculate");
        return num1 + num2;
    }
}
