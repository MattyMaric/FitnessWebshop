package fsre.sum.ba.fitnesswebshop.controllers;
import fsre.sum.ba.fitnesswebshop.models.Korisnik;
import fsre.sum.ba.fitnesswebshop.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import fsre.sum.ba.fitnesswebshop.models.Produkt;
import fsre.sum.ba.fitnesswebshop.repositories.ProduktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProduktRepository produktRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String home(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        Korisnik prijavljeniKorisnik = userRepository.findByEmail(userEmail);

        List<Produkt> proizvodi = produktRepository.findAll();

        model.addAttribute("korisnik", prijavljeniKorisnik);
        model.addAttribute("proizvodi", proizvodi);
        return "storefront";
    }

}