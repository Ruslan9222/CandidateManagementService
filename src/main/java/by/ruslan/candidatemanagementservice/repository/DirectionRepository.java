package by.ruslan.candidatemanagementservice.repository;

import by.ruslan.candidatemanagementservice.model.Direction;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DirectionRepository extends JpaRepository<Direction, Long> {

    List<Direction> findAllByDirectionName(String directionName, PageRequest pageable);

    Direction updateDirectionById(Long id, Direction direction);


}
