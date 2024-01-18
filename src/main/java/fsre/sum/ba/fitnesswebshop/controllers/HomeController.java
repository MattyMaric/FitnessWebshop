package fsre.sum.ba.fitnesswebshop.controllers;
import org.springframework.ui.Model;
import fsre.sum.ba.fitnesswebshop.models.produkt;
import fsre.sum.ba.fitnesswebshop.repositories.ProduktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProduktRepository produktRepository;

    @GetMapping("/")
    public String home(Model model){
        List<produkt> proizvodi = produktRepository.findAll();

        model.addAttribute("proizvodi", proizvodi);
        return "storefront";
    }
}