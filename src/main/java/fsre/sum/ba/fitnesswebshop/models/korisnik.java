package fsre.sum.ba.fitnesswebshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class korisnik {

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

    public korisnik(){

    }

    public korisnik(long idKorisnika, String ime, String prezime, String email, String lozinka, String adresa, String mobitel) {
        this.idKorisnika = idKorisnika;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.lozinka = lozinka;
        this.adresa = adresa;
        this.mobitel = mobitel;
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
}
