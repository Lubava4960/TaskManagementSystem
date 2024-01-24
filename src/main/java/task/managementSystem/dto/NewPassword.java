package task.managementSystem.dto;

import lombok.Data;
/**
        * DTO нового пароля.
        */
@Data

public class NewPassword {

    private String currentPassword; // текущий пароль
    private String newPassword; // новый пароль
}
