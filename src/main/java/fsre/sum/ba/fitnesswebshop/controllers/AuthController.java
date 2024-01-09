package fsre.sum.ba.fitnesswebshop.controllers;

import fsre.sum.ba.fitnesswebshop.repositories.UserRepository;
import fsre.sum.ba.fitnesswebshop.models.korisnik;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    UserRepository userRepo;

    @GetMapping("auth/register")
    public String add(Model model) {
        korisnik Korisnik = new korisnik();
        model.addAttribute("korisnik", Korisnik);
        return "users/register";
    }

    @PostMapping("auth/register")
    public String newKorisnik(@Valid korisnik Korisnik, BindingResult bindingresult, Model model) {
        if (bindingresult.hasErrors()) {
            model.addAttribute("korisnik", Korisnik);
            return "users/register";
        }



        return "redirect:/";
    }
}
