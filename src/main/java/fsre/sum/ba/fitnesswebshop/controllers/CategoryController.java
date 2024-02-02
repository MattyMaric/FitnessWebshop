package fsre.sum.ba.fitnesswebshop.controllers;

import fsre.sum.ba.fitnesswebshop.models.Kategorija;
import fsre.sum.ba.fitnesswebshop.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/kategorije")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String showKategorije(Model model){
        List<Kategorija> kategorije = categoryRepository.findAll();
        model.addAttribute("kategorije", kategorije);
        return "stranice/kategorija";
    }
}
