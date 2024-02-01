package fsre.sum.ba.fitnesswebshop.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/support")
@PreAuthorize("hasAuthority('KUPAC')")
public class SupportController {

   @GetMapping
    public String supportStranica(Model model){
       return "stranice/contactpage";
   }


}
