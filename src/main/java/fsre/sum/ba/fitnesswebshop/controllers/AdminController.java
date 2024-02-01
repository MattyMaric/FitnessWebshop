package fsre.sum.ba.fitnesswebshop.controllers;

import fsre.sum.ba.fitnesswebshop.models.Produkt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import fsre.sum.ba.fitnesswebshop.repositories.ProduktRepository;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProduktRepository produktRepository;

    @GetMapping("/noviProizvodi")
    @PreAuthorize("hasRole('ADMIN')")
    public String prikaziFormuZaNoviProizvod(Model model, HttpServletRequest request) {
        Map<String, ?> inputFlashMap = RequestContextUtils.getInputFlashMap(request);
        if (inputFlashMap != null) {
            model.addAttribute("uspjeh", inputFlashMap.get("uspjeh"));
        }
        model.addAttribute("proizvod", new Produkt());
        return "admin/novi-proizvodi";
    }

    @PostMapping("/noviProizvodi")
    @PreAuthorize("hasRole('ADMIN')")
    public String dodajNoviProizvod(@ModelAttribute Produkt produkt, RedirectAttributes redirectAttributes) {

        produktRepository.save(produkt);
        redirectAttributes.addFlashAttribute("uspjeh", "Uspješno ste dodali proizvod!");
        return "redirect:/admin/noviProizvodi";
    }
}
