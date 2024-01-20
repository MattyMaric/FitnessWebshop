package fsre.sum.ba.fitnesswebshop.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Narudzba {

    @Id
    @GeneratedValue
    long idNarudzbe;

    String datumNarudzbe;

    int kolicina;

    public Narudzba(){

    }

    public Narudzba(long idNarudzbe, String datumNarudzbe, int kolicina) {
        this.idNarudzbe = idNarudzbe;
        this.datumNarudzbe = datumNarudzbe;
        this.kolicina = kolicina;
    }

    @ManyToOne
    @JoinColumn(name = "idKorisnika")
    private Korisnik korisnik;

    @OneToMany(mappedBy = "narudzba", cascade = CascadeType.ALL)
    private Set<NarudzbaProdukti> narudzbaProdukti;

    public long getIdNarudzbe() {
        return idNarudzbe;
    }

    public void setIdNarudzbe(long idNarudzbe) {
        this.idNarudzbe = idNarudzbe;
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
