package fsre.sum.ba.fitnesswebshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class narudzbaProdukti {
    @Id
    @GeneratedValue
    long idProduktaNarudzbe;

    long idNarudzbe;
    long idProdukta;
    int kolicina;
    long cijena;

    public narudzbaProdukti(){

    }

    public narudzbaProdukti(long idProduktaNarudzbe, long idNarudzbe, long idProdukta, int kolicina, long cijena) {
        this.idProduktaNarudzbe = idProduktaNarudzbe;
        this.idNarudzbe = idNarudzbe;
        this.idProdukta = idProdukta;
        this.kolicina = kolicina;
        this.cijena = cijena;
    }

    public long getIdProduktaNarudzbe() {
        return idProduktaNarudzbe;
    }

    public void setIdProduktaNarudzbe(long idProduktaNarudzbe) {
        this.idProduktaNarudzbe = idProduktaNarudzbe;
    }

    public long getIdNarudzbe() {
        return idNarudzbe;
    }

    public void setIdNarudzbe(long idNarudzbe) {
        this.idNarudzbe = idNarudzbe;
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

    public long getCijena() {
        return cijena;
    }

    public void setCijena(long cijena) {
        this.cijena = cijena;
    }
}
