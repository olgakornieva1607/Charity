package pl.coderslab.charity.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class DonationController {

    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;


    @ModelAttribute("categories")
    public List<Category> categories(){
        return categoryService.getAllCategories();
    }

    @ModelAttribute("institutions")
    public List<Institution> institutions(){
        return institutionService.getAllInstitutions();
    }

    @GetMapping("/donation")
    public String showDonationForm(Model model){
        model.addAttribute("donation", new Donation());
        return "form";
    }

    @PostMapping("/donation")
    public String handleDonationForm(@ModelAttribute("donation") @Valid Donation donation, BindingResult result,
                                     @AuthenticationPrincipal CurrentUser currentUser){
        if(result.hasErrors()){
            return "form";
        }
        donation.setUser(currentUser.getUser());
        donationService.add(donation);
        return "form-confirmation";
    }

}
