package task.managementSystem.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.security.core.userdetails.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "username", target = "email")
    default User userToUserDto(task.managementSystem.entity.User user) {
        return null;
    }


}