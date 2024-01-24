package task.managementSystem.servise.impl;

import lombok.AllArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import task.managementSystem.dto.NewPassword;
import task.managementSystem.dto.UpdateUser;
import task.managementSystem.mappers.UserMapper;
import task.managementSystem.repository.UserRepository;


@AllArgsConstructor
@Service
public class UserServiceImpl {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    public User getUser(Authentication authentication) {
        return userMapper.userToUserDto(
                userRepository.findByUsername(authentication.getName()).orElseThrow()
        );
    }

    public void updateUser(UpdateUser updateUser, Authentication authentication) {
        task.managementSystem.entity.User user = userRepository.findByUsername(authentication.getName()).orElseThrow();
        user.setFirstName(updateUser.getFirstName());
        user.setLastName(updateUser.getLastName());
        user.setPhone(user.getPhone());
        userRepository.save(user);
    }



    public void changePassword(NewPassword newPassword, Authentication authentication){
        task.managementSystem.entity.User user = userRepository.findByUsername(authentication.getName()).orElseThrow();
        if(passwordEncoder.matches(newPassword.getCurrentPassword(), user.getPassword())){
            user.setPassword(passwordEncoder.encode(newPassword.getNewPassword()));
        }
    }
}
