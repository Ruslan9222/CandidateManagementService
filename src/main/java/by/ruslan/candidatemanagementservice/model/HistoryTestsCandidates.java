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
    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinTable(name = "db_history",
            joinColumns = @JoinColumn(name = "db_candidateTest_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "db_history_id", referencedColumnName = "id"))
    private CandidateTest candidateTest;
    private LocalDate localDate;
    private String result;
}
