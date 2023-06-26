package pl.coderslab.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
                    "Użytkownik z takim adresem email już istnieje");
        }
        if(bindingResult.hasErrors()){
            return "register";
        }
        if(user.getPassword().equals(user.getPassword2())){
            userService.saveUser(user);
        }else{
            return "register";
        }
        return "login";
    }


}
