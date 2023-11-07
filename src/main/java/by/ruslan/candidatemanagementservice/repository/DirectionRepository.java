package by.ruslan.candidatemanagementservice.repository;

import by.ruslan.candidatemanagementservice.model.Direction;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface DirectionRepository extends JpaRepository<Direction, Long> {
    @Modifying
    @Query("update Direction u set u.description = :description where u.id = :id")
    void updateDirectionByID(@Param(value = "id") long id, @Param(value = "description") String description);


    List<Direction> findAllByDirectionName(String directionName, PageRequest pageable);


}


