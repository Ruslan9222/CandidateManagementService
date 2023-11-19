package by.ruslan.candidatemanagementservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Lob;

@Setter
@Getter
@ToString
public class CreateCandidateDto {
    private String name;
    private String surname;
    private String patronymic;
    private String description;

    private MultipartFile photo;

    private MultipartFile cv;

}
