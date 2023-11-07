package by.ruslan.candidatemanagementservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "db_test")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String testName;
    private String testDescription;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Direction> directions;
}
