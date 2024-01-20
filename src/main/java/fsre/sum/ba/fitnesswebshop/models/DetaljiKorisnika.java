package fsre.sum.ba.fitnesswebshop.models;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Entity
public class DetaljiKorisnika implements org.springframework.security.core.userdetails.UserDetails {

    @Id
    @GeneratedValue
    long detaljiKorisnikaId;

    @OneToOne(mappedBy = "detaljiKorisnika", cascade = CascadeType.ALL)
    private Korisnik korisnik;

    public DetaljiKorisnika() {
    }

    public DetaljiKorisnika(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return korisnik.getLozinka();
    }

    @Override
    public String getUsername() {
        return korisnik.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName() {
        return korisnik.getIme() + " " + korisnik.getPrezime();
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }
}
