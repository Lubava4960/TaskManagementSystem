package task.managementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.managementSystem.entity.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    public static void deleteAllById_Id(int id) {

    }

    List<Comment> findAllById_Id(int id);

}
