package task.managementSystem.servise.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import task.managementSystem.dto.Comments;
import task.managementSystem.dto.CreateOrUpdateComment;
import task.managementSystem.dto.Role;
import task.managementSystem.entity.Comment;
import task.managementSystem.entity.Task;
import task.managementSystem.entity.User;
import task.managementSystem.mappers.CommentMapper;
import task.managementSystem.repository.CommentRepository;
import task.managementSystem.repository.TaskRepository;
import task.managementSystem.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class CommentServiceImpl {

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final CommentMapper commentMapper;



    public void create(int id, CreateOrUpdateComment comments, Authentication authentication) {
        Comment comment=new Comment();
        User user = userRepository.findByUsername(authentication.getName()).orElseThrow(() -> new UsernameNotFoundException("Юзер не найден"));
        Task task=taskRepository.findById(id).orElseThrow();
        comment.setUser(user);
        comment.setTask(task);
        comment.setText(comments.getText());
        comment.setCreatedAt(System.currentTimeMillis());
        commentRepository.save(comment);
    }


    public Comments getComments(int id) {
        Comments comments=new Comments();
        List<task.managementSystem.dto.Comment> commentList=commentRepository.findAllById_Id(id).stream()
                .map(commentMapper::toDto)
                .collect(Collectors.toList());
        comments.setCount(commentList.size());
        comments.setResults(commentList);
        return comments;
    }

    public void delete(Integer id, Integer commentId) {
        commentRepository.deleteById(commentId);

    }

    public void update(Integer id, Integer commentId, CreateOrUpdateComment createOrUpdateComment) {
        Comment comment =commentRepository.findById(commentId).orElseThrow();
        comment.setText(createOrUpdateComment.getText());
        commentRepository.save(comment);
    }
    public boolean hasRight(int id, Authentication authentication){
        User user = userRepository.findByUsername(authentication.getName()).orElseThrow(() -> new UsernameNotFoundException("Юзер не найден"));
        Comment comment=commentRepository.findById(id).orElseThrow();
        return user.getRole()== Role.ADMIN || user.getUsername().equals(comment.getUser().getUsername());
    }



}
