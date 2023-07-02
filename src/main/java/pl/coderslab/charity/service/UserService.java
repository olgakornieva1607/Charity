package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;

import java.util.List;


public interface UserService {

    User findUserByEmail(String email);

    void createUser(User user);

    void createAdmin(User user);

    List<User> findAlLByRole(Role role);

    void saveUser(User user);

    void deleteUser(Long id);

    User getUserById(Long id);


}
