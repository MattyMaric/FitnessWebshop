package fsre.sum.ba.fitnesswebshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class korpa {

    @Id
    @GeneratedValue
    long idKorpe;

    long idKorisnika;
    long idProdukta;
    int kolicina;


    public korpa(){

    }
    public korpa(long idKorpe, long idKorisnika, long idProdukta, int kolicina) {
        this.idKorpe = idKorpe;
        this.idKorisnika = idKorisnika;
        this.idProdukta = idProdukta;
        this.kolicina = kolicina;
    }

    public long getIdKorpe() {
        return idKorpe;
    }

    public void setIdKorpe(long idKorpe) {
        this.idKorpe = idKorpe;
    }

    public long getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(long idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public long getIdProdukta() {
        return idProdukta;
    }

    public void setIdProdukta(long idProdukta) {
        this.idProdukta = idProdukta;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }
}
