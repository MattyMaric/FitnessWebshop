package fsre.sum.ba.fitnesswebshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class kategorija {

    @Id
    @GeneratedValue
    long idKategorije;

    String ime;

    public kategorija(){

    }
    public kategorija(long idKategorije, String ime) {
        this.idKategorije = idKategorije;
        this.ime = ime;
    }

    public long getIdKategorije() {
        return idKategorije;
    }

    public void setIdKategorije(long idKategorije) {
        this.idKategorije = idKategorije;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }
}
