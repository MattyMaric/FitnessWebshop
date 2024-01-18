package fsre.sum.ba.fitnesswebshop.controllers;

import fsre.sum.ba.fitnesswebshop.models.korisnik;
import fsre.sum.ba.fitnesswebshop.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/korisnici")
    public String listUsers(Model model) {
        List<korisnik> korisnici = userRepository.findAll();
        model.addAttribute("korisnici", korisnici);
        return "index"; // Check if "index.html" exists in templates directory
    }


    // U klasi UserController

    @GetMapping("/korisnici/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("korisnik", new korisnik());
        return "korisnici/add";
    }

    @PostMapping("/korisnici/add")
    public String addUser(@Valid korisnik Korisnik, BindingResult result, Model model) {
        if (result.hasErrors()){
            model.addAttribute("korisnik", Korisnik);
            return "korisnici/add";
        } else {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String passwordEncoded = encoder.encode(Korisnik.getLozinka());
            Korisnik.setLozinka(passwordEncoded);
            Korisnik.setPotvrdaLozinke(passwordEncoded);
            userRepository.save(Korisnik);
            return "redirect:/korisnici";
        }
    }

    @PostMapping("/korisnici/delete/{idKorisnika}")
    public String deleteUser(@PathVariable Long idKorisnika) {
        userRepository.deleteById(idKorisnika);
        return "redirect:/korisnici";
    }

    // U klasi UserController

    @GetMapping("/korisnici/edit/{idKorisnika}")
    public String showEditUserForm(@PathVariable Long idKorisnika, Model model) {
        korisnik Korisnik = userRepository.findById(idKorisnika)
                .orElseThrow(() -> new IllegalArgumentException("Neispravan ID korisnika: " + idKorisnika));
        model.addAttribute("korisnik", Korisnik);
        return "korisnici/edit";
    }

    @PostMapping("/korisnici/edit/{idKorisnika}")
    public String updateUser(@PathVariable Long idKorisnika, @ModelAttribute korisnik Korisnik, Model model) {
        // Provjerite postoji li korisnik s tim ID-om
        korisnik postojeciKorisnik = userRepository.findById(idKorisnika)
                .orElseThrow(() -> new IllegalArgumentException("Neispravan ID korisnika: " + idKorisnika));
        postojeciKorisnik.setIme(Korisnik.getIme());
        postojeciKorisnik.setPrezime(Korisnik.getPrezime());
        postojeciKorisnik.setEmail(Korisnik.getEmail());
        // Lozinka
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String lozinka = encoder.encode(Korisnik.getLozinka());
        postojeciKorisnik.setLozinka(lozinka);
        postojeciKorisnik.setPotvrdaLozinke(lozinka);

        // Postavite ostala polja po potrebi
        userRepository.save(postojeciKorisnik);
        return "redirect:/korisnici";
    }
}