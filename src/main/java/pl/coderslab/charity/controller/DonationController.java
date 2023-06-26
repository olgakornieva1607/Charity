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
import pl.coderslab.charity.model.CurrentUser;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.service.CategoryService;
import pl.coderslab.charity.service.DonationService;
import pl.coderslab.charity.service.InstitutionService;


@Controller
@RequiredArgsConstructor
public class DonationController {

    private final CategoryService categoryService;
    private final InstitutionService institutionService;
    private final DonationService donationService;


    @GetMapping("/donation")
    public String showDonationForm(Model model){
        model.addAttribute("donation", new Donation());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("institutions", institutionService.getAllInstitutions());
        return "form";
    }

    @PostMapping("donation")
    public String handleDonationForm(@ModelAttribute("donation") @Valid Donation donation, @AuthenticationPrincipal CurrentUser currentUser,
                                     BindingResult result){
        if(result.hasErrors()){
            return "form";
        }
        donation.setUser(currentUser.getUser());
        donationService.add(donation);
        return "form-confirmation";
    }

}
