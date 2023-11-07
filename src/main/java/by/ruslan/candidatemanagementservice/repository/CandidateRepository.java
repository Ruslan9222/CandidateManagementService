package by.ruslan.candidatemanagementservice.repository;

import by.ruslan.candidatemanagementservice.mapper.CandidateMapper;
import by.ruslan.candidatemanagementservice.model.Candidate;
import org.hibernate.SessionFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
