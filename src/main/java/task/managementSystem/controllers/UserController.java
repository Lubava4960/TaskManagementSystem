package task.managementSystem.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import task.managementSystem.dto.NewPassword;
import task.managementSystem.dto.UpdateUser;
import task.managementSystem.servise.impl.UserServiceImpl;



@RestController
@RequiredArgsConstructor
@RequestMapping("/users")


public class UserController {

    private final UserServiceImpl userService;



    @Operation(
            summary = "Обновление пароля",
            tags = "Пользователи")

    @PostMapping("/set_password")
    public void updateNewPassword(@RequestBody NewPassword newPassword, Authentication authentication) {
        userService.changePassword(newPassword, authentication);
    }

    @Operation(
            summary = "Получение информации об авторизованном пользователе",
            tags = "Пользователи"
    )
    @GetMapping("/me")
    public User getUser(Authentication authentication) {
        return userService.getUser(authentication);

    }

    @Operation(
            summary = "Обновление информации об авторизованном пользователе",
            tags = "Пользователи"
    )

    @PatchMapping("/me")
    public void updateUser(@RequestBody UpdateUser updateUser, Authentication authentication) {

        userService.updateUser(updateUser, authentication);

    }





}

