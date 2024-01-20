package fsre.sum.ba.fitnesswebshop.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Kategorija {

    @Id
    @GeneratedValue
    long idKategorije;

    String ime;

    public Kategorija(){

    }
    public Kategorija(long idKategorije, String ime) {
        this.idKategorije = idKategorije;
        this.ime = ime;
    }

    @OneToMany(mappedBy = "kategorija", cascade = CascadeType.ALL)
    private Set<Produkt> produkti;

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
