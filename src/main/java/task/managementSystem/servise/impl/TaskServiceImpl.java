package task.managementSystem.servise.impl;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import task.managementSystem.dto.*;
import task.managementSystem.entity.User;
import task.managementSystem.mappers.TaskMapper;
import task.managementSystem.repository.CommentRepository;
import task.managementSystem.repository.TaskRepository;
import task.managementSystem.repository.UserRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TaskServiceImpl {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;


    public Task getAllTask() {
        Task task = new Task();
        List<Task> taskList = taskRepository.findAll();
        List<Task> list = new ArrayList<>();
        for (Task e : taskList) {
            Task taskMapperTask = taskMapper.toTask(e);
            list.add(taskMapperTask);
        }
        task.setResults(
                list);
                 return task;
    }

    public void createTask(CreateOrUpdateTask tasks,  Authentication authentication) throws IOException {
        User user = userRepository.findByUsername(authentication.getName()).orElseThrow(() -> new UsernameNotFoundException("Юзер не найден"));
        Task task = new Task();
        task.setUser(task.getUser());
        task.setTitle(task.getTitle());
        task.setDescription(task.getDescription());
        task.setAuthor(task.getAuthor());
        taskRepository.save(task);
    }
    public ExtendedTask getTasks(int id) {

        return taskRepository.findById(id).map(taskMapper::toExtendedTask)
                .orElseThrow();
    }
    public void delete(int id) {
        CommentRepository.deleteAllById_Id(id);
        taskRepository.deleteById(id);

    }
    public void updateTask(int id, CreateOrUpdateTask tasks) {
        Task task=taskRepository.findById(id).orElseThrow();
        task.setTitle(task.getTitle());
        task.setDescription(task.getDescription());
        taskRepository.save(task);
    }
    public Tasks getMyTasks(Authentication authentication) {
        List<Task> taskDto = new ArrayList<>();
        for (Task task : taskRepository.findAllByUser_Username(authentication.getName())) {
            Task taskMapperTask = taskMapper.toTask(task);
            taskDto.add(taskMapperTask);
        }
        Tasks tasks = new Tasks();
        tasks.setCount(taskDto.size());
        tasks.setResults(taskDto);
        return tasks;
    }
    public boolean hasRight(int id, Authentication authentication){
        User user = userRepository.findByUsername(authentication.getName()).orElseThrow(() -> new UsernameNotFoundException("Юзер не найден"));
        Task task =taskRepository.findById(id).orElseThrow();
        return user.getRole()== Role.ADMIN|| user.getUsername().equals(task.getUser().getUsername());
    }


}










