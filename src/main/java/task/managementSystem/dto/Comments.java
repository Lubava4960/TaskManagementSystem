package task.managementSystem.dto;

import lombok.Data;

import java.util.List;
 /**
 * DTO списка комментариев.
 */
@Data

public class Comments {

    private int count; // общее количество комментариев
    private List<Comment> results; // все комментарии
}