package by.ruslan.candidatemanagementservice.repository;


import by.ruslan.candidatemanagementservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
