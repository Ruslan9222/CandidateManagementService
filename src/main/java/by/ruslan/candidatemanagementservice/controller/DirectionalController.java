package by.ruslan.candidatemanagementservice.controller;

import by.ruslan.candidatemanagementservice.dto.CreateDirectionDto;
import by.ruslan.candidatemanagementservice.dto.UpdateDirectionDto;
import by.ruslan.candidatemanagementservice.mapper.DirectionMapper;
import by.ruslan.candidatemanagementservice.model.Direction;
import by.ruslan.candidatemanagementservice.repository.DirectionRepository;
import by.ruslan.candidatemanagementservice.service.DirectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/direction")
public class DirectionalController {
    @Autowired
    DirectionService directionService;
    @Autowired
    DirectionMapper directionMapper;
    @Autowired
    DirectionRepository directionRepository;

    @PostMapping
    ResponseEntity<Direction> create(@RequestBody CreateDirectionDto createDirectionDto) {
        Direction directionToDirection = directionMapper.createDirectionToDirection(createDirectionDto);
        Direction direction = directionService.create(directionToDirection);
        return ResponseEntity.ok(direction);

    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Direction> updateDirectionById(
            @RequestBody UpdateDirectionDto updateDirectionDto,
            @PathVariable("id") long id) {
        Direction updateDirection = directionMapper.updateDescriptionDtoToDirection(updateDirectionDto);
        Direction direction = directionService.updateDirectionById(id, updateDirection);
        return ResponseEntity.ok(direction);
    }

    @GetMapping("{directionName}/all/{pages}")
    public ResponseEntity <List<Direction>> findAllByDirectionName(
            @PathVariable String directionName,
            @PathVariable String pages){
        List<Direction> allByDirectionName = directionRepository.findAllByDirectionName(directionName,
                PageRequest.of(Integer.parseInt(pages), 5, Sort.Direction.ASC, "directionName"));
        return ResponseEntity.ok(allByDirectionName);
    }

}