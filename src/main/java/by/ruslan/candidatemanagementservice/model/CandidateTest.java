package by.ruslan.candidatemanagementservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "db_candidateTest")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CandidateTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinTable(name = "db_candidateTest",
            joinColumns = @JoinColumn(name = "db_candidate_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "db_candidateTest_id", referencedColumnName = "id"))
    private Candidate candidates;
    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinTable(name = "db_candidateTest",
            joinColumns = @JoinColumn(name = "db_test_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "db_candidateTest_id", referencedColumnName = "id"))
    private Tests tests;




}
