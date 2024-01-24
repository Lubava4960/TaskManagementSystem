package task.managementSystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import task.managementSystem.dto.Task;
import java.util.List;


public interface TaskRepository extends JpaRepository<Task, Integer> {
    List<Task> findAllByUser_Username(String username);



}
