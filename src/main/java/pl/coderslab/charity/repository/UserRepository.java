package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmail(String email);

    @Query("SELECT DISTINCT u FROM User u JOIN u.roles r WHERE r = :role")
    List<User> findAllByRole(Role role);
}

