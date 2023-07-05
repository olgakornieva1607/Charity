package pl.coderslab.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {

    private static final String REGISTRATION_PAGE = "register";

    private final UserService userService;


    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user){

        return REGISTRATION_PAGE;
    }


    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") @Valid  User user,
                                      BindingResult bindingResult){

        if(userService.findUserByEmail(user.getEmail()) != null){
            bindingResult.rejectValue("email","registration.username.exist",
                    "Użytkownik o podanym adresie e-mail już istnieje");
        }
        if(bindingResult.hasErrors()){
            return REGISTRATION_PAGE;
        }
        if(user.getPassword().equals(user.getPassword2())){
            userService.createUser(user);
        }else{
            return REGISTRATION_PAGE;
        }
        return "login";
    }


    @GetMapping("user/profile")
    public String showUserProfile(){
        return "user/user";
    }

    @GetMapping("user/edit")
    public String editUser(Model model, @AuthenticationPrincipal CurrentUser currentUser){
        model.addAttribute("user", currentUser.getUser());
        return "user/user-edit";
    }

    @PostMapping("/user/edit")
    public String updateUser(@ModelAttribute("user") @Valid User updatedUser,
                             BindingResult result, @AuthenticationPrincipal CurrentUser currentUser){
        if(result.hasErrors()){
            return "user/user-edit";
        }
        User existingUser = currentUser.getUser();
        existingUser.setName(updatedUser.getName());
        existingUser.setSurname(updatedUser.getSurname());
        existingUser.setEmail(updatedUser.getEmail());
        userService.saveUser(existingUser);
        return "redirect:/user/profile";
    }

    @GetMapping("user/change-password")
    public String changePassword(){
        return "user/change-password";
    }





}
