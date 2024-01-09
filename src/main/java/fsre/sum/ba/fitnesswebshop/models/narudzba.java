package fsre.sum.ba.fitnesswebshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class narudzba {

    @Id
    @GeneratedValue
    long idNarudzbe;

    long idKorisnika;

    String datumNarudzbe;

    int kolicina;

    public narudzba(){

    }

    public narudzba(long idNarudzbe, long idKorisnika, String datumNarudzbe, int kolicina) {
        this.idNarudzbe = idNarudzbe;
        this.idKorisnika = idKorisnika;
        this.datumNarudzbe = datumNarudzbe;
        this.kolicina = kolicina;
    }

    public long getIdNarudzbe() {
        return idNarudzbe;
    }

    public void setIdNarudzbe(long idNarudzbe) {
        this.idNarudzbe = idNarudzbe;
    }

    public long getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(long idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public String getDatumNarudzbe() {
        return datumNarudzbe;
    }

    public void setDatumNarudzbe(String datumNarudzbe) {
        this.datumNarudzbe = datumNarudzbe;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }
}
