package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;

import java.util.List;


public interface UserService {

    User findUserByEmail(String email);

    void saveUser(User user);

    List<User> findAlLByRole(Role role);
}
