package fsre.sum.ba.fitnesswebshop.controllers;

import fsre.sum.ba.fitnesswebshop.models.Korisnik;
import fsre.sum.ba.fitnesswebshop.models.Role;
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
    @PreAuthorize("hasAuthority('ADMIN')")
    public String listUsers(Model model) {
        List<Korisnik> korisnici = userRepository.findAll();
        model.addAttribute("korisnici", korisnici);
        return "index"; // Check if "index.html" exists in templates directory
    }


    // U klasi UserController

    @GetMapping("/korisnici/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String showAddUserForm(Model model) {
        model.addAttribute("korisnik", new Korisnik());
        return "korisnici/add";
    }

    @PostMapping("/korisnici/add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addUser(@Valid Korisnik Korisnik, BindingResult result, Model model) {
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
    @PreAuthorize("hasAuthority('ADMIN')")
    public String deleteUser(@PathVariable Long idKorisnika) {
        userRepository.deleteById(idKorisnika);
        return "redirect:/korisnici";
    }

    // U klasi UserController

    @GetMapping("/korisnici/edit/{idKorisnika}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String showEditUserForm(@PathVariable Long idKorisnika, Model model) {
        Korisnik Korisnik = userRepository.findById(idKorisnika)
                .orElseThrow(() -> new IllegalArgumentException("Neispravan ID korisnika: " + idKorisnika));
        model.addAttribute("korisnik", Korisnik);
        return "korisnici/edit";
    }

    @PostMapping("/korisnici/edit/{idKorisnika}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String updateUser(@PathVariable Long idKorisnika, @ModelAttribute Korisnik Korisnik, Model model) {
        // Provjerite postoji li korisnik s tim ID-om
        fsre.sum.ba.fitnesswebshop.models.Korisnik postojeciKorisnik = userRepository.findById(idKorisnika)
                .orElseThrow(() -> new IllegalArgumentException("Neispravan ID korisnika: " + idKorisnika));
        postojeciKorisnik.setIme(Korisnik.getIme());
        postojeciKorisnik.setPrezime(Korisnik.getPrezime());
        postojeciKorisnik.setEmail(Korisnik.getEmail());
        // Lozinka
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String lozinka = encoder.encode(Korisnik.getLozinka());
        postojeciKorisnik.setRoles(Korisnik.getRoles());
        postojeciKorisnik.setLozinka(lozinka);
        postojeciKorisnik.setPotvrdaLozinke(lozinka);

        // Postavite ostala polja po potrebi
        userRepository.save(postojeciKorisnik);
        return "redirect:/storefront";
}
}
