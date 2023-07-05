package pl.coderslab.charity.service;

import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;

import java.util.List;


public interface UserService {

    User findUserByEmail(String email);

    void createUser(User user);

    void createAdmin(User user);

    List<User> findAlLByRole(Role role);

    void updateUser(User existingUser, User updatedUser);

    void deleteUser(Long id);

    User findUserById(Long id);

    void disableUser(Long id);


    void changePassword(User user, String password);

    boolean isValidPassword(User user, String password);



}
