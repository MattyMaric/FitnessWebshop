package fsre.sum.ba.fitnesswebshop.controllers;

import fsre.sum.ba.fitnesswebshop.models.Produkt;
import fsre.sum.ba.fitnesswebshop.models.StavkaKorpe;
import fsre.sum.ba.fitnesswebshop.services.KorpaService;
import fsre.sum.ba.fitnesswebshop.services.ProduktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class KorpaController {

    @Autowired
    private ProduktService produktService;

    @Autowired
    private KorpaService korpaService;

    @GetMapping("/korpa")
    public String vidiKorpu(Model model) {
        List<StavkaKorpe> stavkeKorpe = korpaService.getStavkeKorpe();
        double ukupnaCijena = korpaService.getUkupnaCijena();

        model.addAttribute("stavkeKorpe", stavkeKorpe);
        model.addAttribute("ukupnaCijena", ukupnaCijena);

        List<Produkt> proizvodiUKorpi = produktService.getProizvodiUKorpi(stavkeKorpe);
        model.addAttribute("proizvodiUKorpi", proizvodiUKorpi);

        return "/korpa/korpa";
    }

    @PostMapping("/dodajUKorpu")
    public String dodajUKorpu(@RequestParam Long idProdukta) {
        Produkt produkt = produktService.getProductById(idProdukta);
        if(produkt != null) {
            korpaService.dodajUKorpu(produkt);
        }
        return "redirect:/";
    }

    @PostMapping("/ocistiKorpu")
    public String ocistiKorpu() {
        korpaService.ocistiKorpu();
        return "redirect:/korpa";
    }

    @GetMapping("/korpa/ukloniIzKorpe/{stavkaKorpeId}")
    public String ukloniIzKorpe(@PathVariable Long stavkaKorpeId) {
        korpaService.ukloniIzKorpe(stavkaKorpeId);
        return "redirect:/korpa";
    }
}