package fsre.sum.ba.fitnesswebshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kupac")
@PreAuthorize("hasAuthority('KUPAC')")
public class KupacController {

    @GetMapping
    public String studentDashboard(Model model) {
        // Dodajte potrebne atribute u model
        return "kupac/dashboard";
    }
}

//TODO: Update return function to appropriate link