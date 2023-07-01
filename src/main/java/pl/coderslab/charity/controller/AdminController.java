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

@Controller
@RequiredArgsConstructor
@RequestMapping("admin")
public class AdminController {

    private static final String INSTITUTION_ADD = "admin/institution-add";
    private static final String INSTITUTION_EDIT = "admin/institution-edit";
    private static final String INSTITUTION_ALL = "redirect:/admin/institution/all";
    private static final String ADMIN_ADD_FORM = "admin/admin-add";


    private final InstitutionService institutionService;
    private final UserService userService;
    private final RoleService roleService;

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
        return INSTITUTION_ADD;
    }

    @PostMapping("/institution/new")
    public String performAddInstitution(@ModelAttribute("institution") @Valid Institution institution,
                                        BindingResult result){
        if(result.hasErrors()){
            return INSTITUTION_ADD;
        }
        institutionService.add(institution);
        return INSTITUTION_ALL;
    }


    @GetMapping("/institution/delete/{id}")
    public String deleteInstitution(@PathVariable Long id){
        institutionService.delete(id);
        return INSTITUTION_ALL;
    }


    @GetMapping("/institution/edit/{id}")
    public String editInstitution(@PathVariable Long id, Model model) {
        model.addAttribute("institutionToEdit", institutionService.get(id));
        return INSTITUTION_EDIT;
    }

    @PostMapping("/institution/edit")
    public String performInstitutionEdit(@ModelAttribute("institutionToEdit") @Valid Institution institution,
                                         BindingResult result){
        if(result.hasErrors()){
            return INSTITUTION_EDIT;
        }
        institutionService.add(institution);
        return INSTITUTION_ALL;
    }

    @GetMapping("/all")
    public String showAllAdmins(Model model){
        Role roleAdmin = roleService.findByName("ROLE_ADMIN");
        model.addAttribute("admins", userService.findAlLByRole(roleAdmin));
        return "admin/admins-all";
    }


    @GetMapping("/new")
    public String addNewAdmin(@ModelAttribute("user") User user){
        return ADMIN_ADD_FORM;

    }

    @PostMapping("/new")
    public String performRegistration(@ModelAttribute("user") @Valid  User user,
                                      BindingResult bindingResult){

        if(userService.findUserByEmail(user.getEmail()) != null){
            bindingResult.rejectValue("email","registration.username.exist",
                    "Użytkownik o podanym adresie e-mail już istnieje");
        }
        if(bindingResult.hasErrors()){
            return ADMIN_ADD_FORM;
        }
        if(user.getPassword().equals(user.getPassword2())){
            userService.createAdmin(user);
        }else{
            return ADMIN_ADD_FORM;
        }
        return "redirect:/admin/all";
    }

    @GetMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable Long id){
        userService.deleteUser(id);
        return "redirect:/admin/all";
    }

    @GetMapping("/edit/{id}")
    public String editAdmin(@PathVariable Long id, Model model){
        model.addAttribute(userService.get(id));
        return "admin/admin-edit";
    }


}
