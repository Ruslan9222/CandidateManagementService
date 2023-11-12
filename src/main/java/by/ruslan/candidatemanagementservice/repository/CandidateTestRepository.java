package by.ruslan.candidatemanagementservice.repository;

import by.ruslan.candidatemanagementservice.model.CandidateTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CandidateTestRepository extends JpaRepository<CandidateTest, Long> {
    @Modifying
    @Query("update CandidateTest u set u.result = :result where u.id = :id")
    void updateResultTestByID(@Param(value = "id") long id, @Param(value = "result") String result);
}
