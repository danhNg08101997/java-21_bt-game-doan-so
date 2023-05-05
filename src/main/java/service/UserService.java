package service;

import model.UserModel;
import repository.UserRepository;

import java.util.List;

public class UserService {
    UserRepository userRepository = new UserRepository();

    public boolean checkLogin (String email, String password) {
        boolean isValid = false;
        List<UserModel> list = userRepository.findByEmailAndPassword(email, password);
        isValid = list.size() > 0;
        return isValid;
    }
}
