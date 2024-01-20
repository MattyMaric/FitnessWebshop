package fsre.sum.ba.fitnesswebshop.models;

import jakarta.persistence.*;

@Entity
public class NarudzbaProdukti {
    @Id
    @GeneratedValue
    long idProduktaNarudzbe;

    int kolicina;
    long cijena;

    public NarudzbaProdukti(){

    }

    public NarudzbaProdukti(long idProduktaNarudzbe, int kolicina, long cijena) {
        this.idProduktaNarudzbe = idProduktaNarudzbe;
        this.kolicina = kolicina;
        this.cijena = cijena;
    }


    @ManyToOne
    @JoinColumn(name = "idNarudzbe")
    private Narudzba narudzba;

    @ManyToOne
    @JoinColumn(name = "idProdukta")
    private Produkt produkt;

    public long getIdProduktaNarudzbe() {
        return idProduktaNarudzbe;
    }

    public void setIdProduktaNarudzbe(long idProduktaNarudzbe) {
        this.idProduktaNarudzbe = idProduktaNarudzbe;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public long getCijena() {
        return cijena;
    }

    public void setCijena(long cijena) {
        this.cijena = cijena;
    }
}
