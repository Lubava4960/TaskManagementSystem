package task.managementSystem.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO Полного формата задачи
 */

@Data
@Getter
@Setter
public class ExtendedTask {

    private int pk; // id задачи
    private String authorFirstName;//имя
    private String authorLastName; //фамилия
    private String description;//описание
    private String email;//эл.почта
    private String phone; //телефон
    private String title; // заголовок задачи

}
