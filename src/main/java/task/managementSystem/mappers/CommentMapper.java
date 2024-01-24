package task.managementSystem.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import task.managementSystem.entity.Comment;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(source = "id",target="pk")
    @Mapping(source = "user.id",target="author")
    @Mapping(source = "user.firstName",target="authorFirstName")
    task.managementSystem.dto.Comment toDto(Comment comment);



}
