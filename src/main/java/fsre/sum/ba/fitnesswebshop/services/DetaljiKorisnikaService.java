package fsre.sum.ba.fitnesswebshop.services;

import fsre.sum.ba.fitnesswebshop.models.korisnik;
import fsre.sum.ba.fitnesswebshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
public class DetaljiKorisnikaService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public fsre.sum.ba.fitnesswebshop.models.detaljiKorisnika loadUserByUsername(String username) throws UsernameNotFoundException {
        korisnik k = repository.findByEmail(username);
        return new fsre.sum.ba.fitnesswebshop.models.detaljiKorisnika(k);
    }
}