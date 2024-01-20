package fsre.sum.ba.fitnesswebshop.models;

import jakarta.persistence.*;

@Entity
public class Korpa {

    @Id
    @GeneratedValue
    long idKorpe;

    int kolicina;


    public Korpa(){

    }
    public Korpa(long idKorpe, int kolicina) {
        this.idKorpe = idKorpe;
        this.kolicina = kolicina;
    }

    @OneToOne
    @JoinColumn(name = "idKorisnika")
    private Korisnik korisnik;

    public long getIdKorpe() {
        return idKorpe;
    }

    public void setIdKorpe(long idKorpe) {
        this.idKorpe = idKorpe;
    }


    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }
}
