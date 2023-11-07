package by.ruslan.candidatemanagementservice.mapper;

import by.ruslan.candidatemanagementservice.dto.CreateDirectionDto;
import by.ruslan.candidatemanagementservice.dto.UpdateDirectionDto;
import by.ruslan.candidatemanagementservice.model.Direction;
import org.springframework.stereotype.Component;

@Component
public class DirectionMapper {
    public Direction updateDescriptionDtoToDirection(UpdateDirectionDto dto) {
        Direction direction = new Direction();
        direction.setDescription(dto.getDescription());
        return direction;

    }
    public Direction createDirectionToDirection(CreateDirectionDto createDirectionDto){
        Direction newDirection = new Direction();
        newDirection.setDirectionName(createDirectionDto.getDirectionName());
        newDirection.setDescription(createDirectionDto.getDescription());
        return newDirection;
    }
}