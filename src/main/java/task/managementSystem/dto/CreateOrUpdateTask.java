package task.managementSystem.dto;

import lombok.Data;
@Data
public class CreateOrUpdateTask {

    private String title;
    private String description;
    private Status status;
    private Priority priority;
    private String author;
    private String executor;

    }


