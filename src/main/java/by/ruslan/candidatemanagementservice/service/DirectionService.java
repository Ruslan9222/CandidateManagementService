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

    public void updateDirectionWithCustomQuery(long id, String description) {
        directionRepository.updateDirectionByID(id, description);
    }


}
