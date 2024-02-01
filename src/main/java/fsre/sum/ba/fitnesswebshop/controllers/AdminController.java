package fsre.sum.ba.fitnesswebshop.controllers;

import fsre.sum.ba.fitnesswebshop.models.Produkt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import fsre.sum.ba.fitnesswebshop.repositories.ProduktRepository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private ProduktRepository produktRepository;

    @GetMapping("/noviProizvodi")
    @PreAuthorize("hasRole('ADMIN')")
    public String prikaziFormuZaNoviProizvod(Model model) {
        model.addAttribute("proizvod", new Produkt());
        return "admin/novi-proizvodi";
    }

    @PostMapping("/noviProizvodi")
    @PreAuthorize("hasRole('ADMIN')")
    public String dodajNoviProizvod(@ModelAttribute Produkt produkt, @RequestParam("image") MultipartFile file, RedirectAttributes redirectAttributes) {
       try {
           String originalFilename = file.getOriginalFilename();
           Path imagePath = Paths.get("src/main/resources/static/slikeProizvoda/" + originalFilename);
           Files.write(imagePath, file.getBytes());

           produkt.setUrlSlike("slikeProizvoda/" + originalFilename);
       } catch (IOException e) {
           e.printStackTrace();
           redirectAttributes.addFlashAttribute("error", "Greška pri uploadu slike");
              return "redirect:/admin/noviProizvodi";
       }

       produktRepository.save(produkt);
       redirectAttributes.addFlashAttribute("success", true);
       return "redirect:/admin/noviProizvodi";
    }
}
