package fsre.sum.ba.fitnesswebshop.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Korisnik {

    @Id
    @GeneratedValue
    long idKorisnika;

    @NotBlank(message = "Polje je obavezno")
    String ime;
    @NotBlank(message = "Polje je obavezno")
    String prezime;
    @NotBlank(message = "Polje je obavezno")
    String email;
    @NotBlank(message = "Polje je obavezno")
    String lozinka;
    @NotBlank(message = "Polje je obavezno")
    String adresa;
    @NotBlank(message = "Polje je obavezno")
    String mobitel;

    @NotBlank(message = "Molimo ponovo unesite lozinku!")
    @Transient
    String potvrdaLozinke;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    Set<Role> roles = new HashSet<>();


    public Korisnik(){

    }

    public Korisnik(long idKorisnika, String ime, String prezime, String email, String lozinka, String adresa, String mobitel) {
        this.idKorisnika = idKorisnika;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.lozinka = lozinka;
        this.adresa = adresa;
        this.mobitel = mobitel;
        roles.add(Role.KUPAC);

    }

    @OneToMany(mappedBy = "korisnik", cascade = CascadeType.ALL)
    private Set<Narudzba> narudzbe;

    @OneToOne
    @JoinColumn(name = "detaljiKorisnikaId")
    private DetaljiKorisnika detaljiKorisnika;

    @OneToOne(mappedBy = "korisnik", cascade = CascadeType.ALL)
    private Korpa korpa;

    public String getPotvrdaLozinke() {
        return potvrdaLozinke;
    }

    public void setPotvrdaLozinke(String potvrdaLozinke) {
        this.potvrdaLozinke = potvrdaLozinke;
    }

    public long getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(long idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getMobitel() {
        return mobitel;
    }

    public void setMobitel(String mobitel) {
        this.mobitel = mobitel;
    }

    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }


    @AssertTrue(message = "Lozinke se moraju podudarati")
    public boolean isPasswordsEqual() {
        try {
            return this.lozinka.equals(this.potvrdaLozinke);
        } catch (Exception e) {
            return false;
        }
    }
}
