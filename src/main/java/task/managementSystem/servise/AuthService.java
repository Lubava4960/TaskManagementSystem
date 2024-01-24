package task.managementSystem.servise;

import task.managementSystem.dto.Register;

public interface AuthService {
    boolean login(String userName, String password);

    boolean register(Register register);
}
