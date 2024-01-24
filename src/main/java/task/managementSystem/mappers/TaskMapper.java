package task.managementSystem.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import task.managementSystem.dto.ExtendedTask;
import task.managementSystem.dto.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    @Mapping(source="id",target="pk")
    @Mapping(source="user.firstName",target="authorFirstName")
    @Mapping(source="user.lastName",target="authorLastName")
    @Mapping(source="user.username",target="email")
    @Mapping(source="user.phone",target="phone")
    ExtendedTask toExtendedTask(Task task);

    @Mapping(source="id", target = "pk")
    @Mapping(source="user.id",target="author")
    Task toTask(Task task);



}
