package task.managementSystem.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Data
@Getter
@Setter
public class Tasks {

    private List<Task> results;
    private int count;

}
