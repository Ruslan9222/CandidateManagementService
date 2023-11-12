package by.ruslan.candidatemanagementservice.dto;

import by.ruslan.candidatemanagementservice.model.Tests;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@Setter
@Getter
@ToString
public class CreateCandidateTestDto {
    private Tests tests;
    private LocalDate localDate;
    private String result;
}
