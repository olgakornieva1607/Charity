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

    private final UserService userService;


    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user){

        return "register";
    }


    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") @Valid  User user,
                                      BindingResult bindingResult){

        if(userService.findUserByEmail(user.getEmail()) != null){
            bindingResult.rejectValue("email","registration.username.exist",
                    "Użytkownik o podanym adresie e-mail już istnieje");
        }
        if(bindingResult.hasErrors()){
            return "register";
        }
        if(user.getPassword().equals(user.getPassword2())){
            userService.createUser(user);
        }else{
            return "register";
        }
        return "login";
    }


    @GetMapping("/user/profile")
    public String showUserProfile(){
        return "user/user";
    }

    @GetMapping("/user/edit")
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
        userService.updateUser(existingUser, updatedUser);
        return "redirect:/user/profile";
    }

    @GetMapping("/user/change-password")
    public String changePassword(){
        return "user/change-password";
    }


    @PostMapping("/user/change-password")
    public String performChangePassword(@RequestParam("currentPassword") String currentPassword,
                                        @RequestParam("newPassword") String newPassword,
                                        @AuthenticationPrincipal CurrentUser currentUser,
                                        Model model){
        User user = currentUser.getUser();
        if (!userService.isValidPassword(user, currentPassword)) {
            model.addAttribute("error", "Nieprawidłowe hasło");
            return "user/change-password";
        }
        userService.changePassword(user, newPassword);
        model.addAttribute("success", "Hasło zostało zmienione");
        return "user/change-password";
    }


}
