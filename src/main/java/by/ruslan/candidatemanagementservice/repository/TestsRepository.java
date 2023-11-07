package by.ruslan.candidatemanagementservice.repository;

import by.ruslan.candidatemanagementservice.model.Tests;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestsRepository extends JpaRepository<Tests,Long> {
    Tests updateTestById(Long id, Tests tests);
    List<Tests> findAllByTestName(String testName, PageRequest pageable);
}
