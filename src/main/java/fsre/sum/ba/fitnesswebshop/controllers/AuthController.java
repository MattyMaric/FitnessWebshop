package fsre.sum.ba.fitnesswebshop.controllers;

import fsre.sum.ba.fitnesswebshop.models.Role;
import fsre.sum.ba.fitnesswebshop.repositories.UserRepository;
import fsre.sum.ba.fitnesswebshop.models.Korisnik;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Controller
public class AuthController {



    @Autowired
    UserRepository userRepo;

    @GetMapping("auth/register")
    public String add(Model model) {
        Korisnik Korisnik = new Korisnik();
        model.addAttribute("korisnik", Korisnik);
        return "korisnici/register";
    }

    @PostMapping("auth/register")
    public String newUser (@Valid Korisnik Korisnik, BindingResult bindingresult, Model model){
        boolean errors = bindingresult.hasErrors();

        if(errors){
            model.addAttribute("korisnik", Korisnik);
            return "korisnici/register";
        }else{

            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String lozinkaEncoded = encoder.encode(Korisnik.getLozinka());
            Korisnik.setLozinka(lozinkaEncoded);
            Korisnik.setPotvrdaLozinke(lozinkaEncoded);
            Korisnik.setRoles(new HashSet<>(Collections.singletonList(Role.KUPAC)));
            userRepo.save(Korisnik);
            return "redirect:/auth/login";}
    }


    @GetMapping("/auth/login")
    public String login (Model model){
        model.addAttribute("korisnik", new Korisnik());
        return "korisnici/login";
    }

}
