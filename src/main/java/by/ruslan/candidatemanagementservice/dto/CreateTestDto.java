package by.ruslan.candidatemanagementservice.dto;

import by.ruslan.candidatemanagementservice.model.Direction;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@Setter
@Getter
@ToString
public class CreateTestDto {
    private String testName;
    private String description;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ownerDirection")
    private List<Direction> directions;
}
