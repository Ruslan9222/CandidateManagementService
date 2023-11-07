package by.ruslan.candidatemanagementservice.repository;

import by.ruslan.candidatemanagementservice.model.Tests;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;

import java.util.List;

@EnableJpaRepositories
public interface TestsRepository extends JpaRepository<Tests, Long> {
    @Modifying
    @Query("update Tests u set u.testDescription = :testDescription where u.id = :id")
    void updateTestByID(@Param(value = "id") long id, @Param(value = "testDescription") String testDescription);

    List<Tests> findAllByTestName(String testName, PageRequest pageable);
}
