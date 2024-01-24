package task.managementSystem.dto;

import lombok.Data;

/**
 *DTO юзера
 */
@Data

public class User {
    private int id; // id пользователя
    private String email; // логин пользователя
    private String firstName; // имя пользователя
    private String lastName; // фамилия пользователя
    private String phone; // телефон пользователя
    private Role role;//права начальника и исполнителя
}
