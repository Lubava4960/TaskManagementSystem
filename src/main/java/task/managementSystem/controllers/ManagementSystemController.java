package task.managementSystem.controllers;

import io.swagger.v3.oas.annotations.Operation;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import task.managementSystem.dto.CreateOrUpdateTask;
import task.managementSystem.dto.ExtendedTask;
import task.managementSystem.dto.Task;
import task.managementSystem.dto.Tasks;

import task.managementSystem.servise.impl.TaskServiceImpl;

import java.io.IOException;


@RestController
@RequiredArgsConstructor
@RequestMapping("/tasks")
public class ManagementSystemController {

  private final TaskServiceImpl managementSystemImpl;



    @Operation(
            summary = "получение всех задач",
           tags= "задачи"
   )
    @GetMapping
    public Task getAllTasks(){

        return managementSystemImpl.getAllTask();
    }

    @Operation(
            summary = "добавление задач",
            tags= "задачи"
    )
    @PostMapping

    public void taskTasks(@RequestPart("properties")CreateOrUpdateTask task, Authentication authentication) throws IOException {
        managementSystemImpl.createTask(task, authentication);

    }
    @Operation(
            summary = "получение информации о задаче",
            tags= "задачи"
    )
    @GetMapping("/{id}")
    public ExtendedTask getTasks(@PathVariable("id") int id){

        return managementSystemImpl.getTasks(id);
    }
    @Operation(
            summary = "удаление задачи",
            tags= "задачи"
    )
    @DeleteMapping("/{id}")
    @PreAuthorize("@managementSystemImpl.hasRight(#id,authentication)")
    public void deleteByIdDto(@PathVariable("id") int id){

      managementSystemImpl.delete(id);
    }

    @Operation(
            summary = "обновление информации о задаче",
            tags= "задачи"
    )
    @PatchMapping("/{id}")
    @PreAuthorize("@managementSystemImpl.hasRight(#id,authentication)")
    public void updateCreateTaskDto(@PathVariable int id, @RequestBody CreateOrUpdateTask task) {
        managementSystemImpl.updateTask(id,task);
    }
  @Operation(
            summary = "Получение информации авторизованного пользователя",
            tags= "задачи"
    )

    @GetMapping("/me")

    public Tasks getLoginUserTask(Authentication authentication){
        return managementSystemImpl.getMyTasks(authentication);
    }



}
