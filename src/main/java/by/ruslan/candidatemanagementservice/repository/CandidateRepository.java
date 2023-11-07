package by.ruslan.candidatemanagementservice.repository;

import by.ruslan.candidatemanagementservice.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {
//     void createProfilePhoto(MultipartFile photo);
}
