package task.managementSystem.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class Task extends task.managementSystem.entity.Task {
    private String title;
    private int author;//id автора
    private int pk; // id задачи
    private String description;

    @Getter
    private List<Task> results;
    private int count;



}
