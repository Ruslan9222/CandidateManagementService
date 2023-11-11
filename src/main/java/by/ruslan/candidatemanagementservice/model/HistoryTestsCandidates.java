package by.ruslan.candidatemanagementservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "db_history")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistoryTestsCandidates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)

    private CandidateTest candidateTest;

}
