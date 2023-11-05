package by.ruslan.candidatemanagementservice.mapper;

import by.ruslan.candidatemanagementservice.dto.CreateUserDto;
import by.ruslan.candidatemanagementservice.model.User;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {
    public User createUserDtoToUser(CreateUserDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        return user;
    }
}
