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
                    "Użytkownik z takim adresem email już istnieje");
        }
        if(bindingResult.hasErrors()){
            return REGISTRATION_PAGE;
        }
        if(user.getPassword().equals(user.getPassword2())){
            userService.saveUser(user);
        }else{
            return REGISTRATION_PAGE;
        }
        return "login";
    }


    @GetMapping("/admin")
    public String showAdminDashboard() {
        return "admin/admin";
    }

}
