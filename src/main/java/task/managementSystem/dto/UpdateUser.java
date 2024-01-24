package task.managementSystem.dto;

import lombok.Data;

/**
 * DTO обновления пользователя
 */

@Data
public class UpdateUser {
    private String firstName;
    private String lastName;
    private String phone;
}
