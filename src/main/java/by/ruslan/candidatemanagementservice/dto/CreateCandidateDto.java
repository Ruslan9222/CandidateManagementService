package by.ruslan.candidatemanagementservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CreateCandidateDto {
    private String name;
    private String surname;
    private String patronymic;
    private String description;

}
