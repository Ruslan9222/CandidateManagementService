package by.ruslan.candidatemanagementservice.repository;

import by.ruslan.candidatemanagementservice.model.Candidate;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    List<Candidate> findAllByName(String name, PageRequest pageable);
}

