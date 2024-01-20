package fsre.sum.ba.fitnesswebshop.services;

import fsre.sum.ba.fitnesswebshop.models.DetaljiKorisnika;
import fsre.sum.ba.fitnesswebshop.models.Korisnik;
import fsre.sum.ba.fitnesswebshop.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
public class DetaljiKorisnikaService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    UserRepository repository;

    @Override
    public DetaljiKorisnika loadUserByUsername(String username) throws UsernameNotFoundException {
        Korisnik k = repository.findByEmail(username);
        return new DetaljiKorisnika(k);
    }
}