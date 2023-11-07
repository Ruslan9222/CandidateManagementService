package by.ruslan.candidatemanagementservice.service;

import by.ruslan.candidatemanagementservice.model.Direction;
import by.ruslan.candidatemanagementservice.repository.DirectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectionService {
    @Autowired
    DirectionRepository directionRepository;

    public Direction create(Direction direction) {
        return directionRepository.save(direction);
    }
    public Direction updateDirectionById(Long id, Direction direction) {
        directionRepository.updateDirectionById(id, direction);
        return direction;
    }

}
