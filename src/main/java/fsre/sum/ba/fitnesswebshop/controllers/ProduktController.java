package fsre.sum.ba.fitnesswebshop.controllers;

import fsre.sum.ba.fitnesswebshop.models.Produkt;
import fsre.sum.ba.fitnesswebshop.repositories.ProduktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/produkt")
public class ProduktController {

    @Autowired
    private ProduktRepository produktRepository;

    @GetMapping
    public List<Produkt> getAllProducts() {
        return produktRepository.findAll();
    }
}
