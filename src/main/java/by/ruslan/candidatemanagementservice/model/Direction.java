package by.ruslan.candidatemanagementservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "db_directionNames")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Direction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String directionName;
    private String description;
}
