package pl.coderslab.charity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.InstitutionService;


@Controller
@RequiredArgsConstructor
public class DonationController {

    private final CategoryService categoryService;
    private final InstitutionService institutionService;


    @GetMapping("/donation")
    public String showDonationForm(Model model){
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("institutions", institutionService.getAllInstitutions());
        return "form";
    }


}
