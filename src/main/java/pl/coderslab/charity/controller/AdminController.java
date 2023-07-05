package pl.coderslab.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.model.Role;
import pl.coderslab.charity.model.User;
import pl.coderslab.charity.service.InstitutionService;
import pl.coderslab.charity.service.RoleService;
import pl.coderslab.charity.service.UserService;

import java.util.List;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("admin")
public class AdminController {

    private final InstitutionService institutionService;
    private final UserService userService;
    private final RoleService roleService;

    @ModelAttribute("roles")
    public List<Role> roles(){
        return roleService.findAll();
    }

    @GetMapping("")
    public String showAdminDashboard() {
        return "admin/admin";
    }


    @GetMapping("/institution/all")
    public String showAllInstitutions(Model model){
        model.addAttribute("institutions", institutionService.getAllInstitutions());
        return "admin/institutions-all";
    }

    @GetMapping("/institution/new")
    public String addInstitution(Model model){
        model.addAttribute(new Institution());
        return "admin/institution-add";
    }

    @PostMapping("/institution/new")
    public String performAddInstitution(@ModelAttribute("institution") @Valid Institution institution,
                                        BindingResult result){
        if(result.hasErrors()){
            return "admin/institution-add";
        }
        institutionService.add(institution);
        return "redirect:/admin/institution/all";
    }


    @GetMapping("/institution/delete/{id}")
    public String deleteInstitution(@PathVariable Long id){
        institutionService.delete(id);
        return "redirect:/admin/institution/all";
    }


    @GetMapping("/institution/edit/{id}")
    public String editInstitution(@PathVariable Long id, Model model) {
        model.addAttribute("institutionToEdit", institutionService.get(id));
        return "admin/institution-edit";
    }

    @PostMapping("/institution/edit")
    public String performInstitutionEdit(@ModelAttribute("institutionToEdit") @Valid Institution institution,
                                         BindingResult result){
        if(result.hasErrors()){
            return "admin/institution-edit";
        }
        institutionService.add(institution);
        return "redirect:/admin/institution/all";
    }

    @GetMapping("/all")
    public String showAllAdmins(Model model){
        Role roleAdmin = roleService.findByName("ROLE_ADMIN");
        model.addAttribute("admins", userService.findAlLByRole(roleAdmin));
        return "admin/admins-all";
    }


    @GetMapping("/new")
    public String addNewAdmin(@ModelAttribute("user") User user){
        return "admin/admin-add";

    }

    @PostMapping("/new")
    public String performRegistration(@ModelAttribute("user") @Valid  User user,
                                      BindingResult result){

        if(userService.findUserByEmail(user.getEmail()) != null){
            result.rejectValue("email","registration.username.exist",
                    "Użytkownik o podanym adresie e-mail już istnieje");
        }
        if(result.hasErrors()){
            return "admin/admin-add";
        }
        if(user.getPassword().equals(user.getPassword2())){
            userService.createAdmin(user);
        }else{
            return "admin/admin-add";
        }
        return "redirect:/admin/all";
    }

    @GetMapping({"/delete/{id}", "/user/delete/{id}"})
    public String deleteUser(@PathVariable Long id){
        Set<Role> roles = userService.findUserById(id).getRoles();
        userService.deleteUser(id);
        if(roles.contains(roleService.findByName("ROLE_ADMIN"))) {
            return "redirect:/admin/all";
        }
        return "redirect:/admin/user/all";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable Long id, Model model){
        model.addAttribute("user", userService.findUserById(id));
        return "admin/user-edit";
    }


    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") @Valid User updatedUser,
                              BindingResult result){
        if(result.hasErrors()){
            return "admin/user-edit";
        }
        User existingUser = userService.findUserById(id);
        userService.updateUser(existingUser, updatedUser);
        Set<Role> roles = userService.findUserById(id).getRoles();
        if (roles.contains(roleService.findByName("ROLE_ADMIN"))){
            return "redirect:/admin/all";
        }
        return "redirect:/admin/user/all";

    }

    @GetMapping("/user/disable/{id}")
    public String disableUser(@PathVariable Long id){
        userService.disableUser(id);
        return "redirect:/admin/user/all";
    }

    @GetMapping("/user/all")
    public String showAllUsers(Model model){
        Role roleUser = roleService.findByName("ROLE_USER");
        model.addAttribute("users", userService.findAlLByRole(roleUser));
        return "admin/users-all";
    }

}
