package pl.coderslab.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.InstitutionService;

@Controller
@RequiredArgsConstructor
@RequestMapping("admin")
public class AdminController {

    private static final String INSTITUTION_ADD = "admin/institution-add";
    private static final String INSTITUTION_EDIT = "admin/institution-edit";
    private static final String INSTITUTION_ALL = "redirect:/admin/institution/all";

    private final InstitutionService institutionService;

    @GetMapping("")
    public String showAdminDashboard() {
        return "admin/admin";
    }


    @GetMapping("/institution/all")
    public String showAllInstitutions(Model model){
        model.addAttribute("institutions", institutionService.getAllInstitutions());
        return "admin/institutions";
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

}
