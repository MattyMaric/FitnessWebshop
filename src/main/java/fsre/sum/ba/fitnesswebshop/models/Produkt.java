package fsre.sum.ba.fitnesswebshop.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Produkt {

    @Id
    @GeneratedValue
    long idProdukta;

    String imeProdukta;
    String opisProdukta;
    long cijena;
    int kolicinaNaSkladistu;
    String urlSlike;

    public Produkt(){

    }

    public Produkt(long idProdukta, String imeProdukta, String opisProdukta, long cijena, int kolicinaNaSkladistu, String kategorija, String urlSlike) {
        this.idProdukta = idProdukta;
        this.imeProdukta = imeProdukta;
        this.opisProdukta = opisProdukta;
        this.cijena = cijena;
        this.kolicinaNaSkladistu = kolicinaNaSkladistu;
        this.urlSlike = urlSlike;
    }

    @OneToMany(mappedBy = "produkt", cascade = CascadeType.ALL)
    private Set<NarudzbaProdukti> narudzbaProdukti;

    @ManyToOne
    @JoinColumn(name = "idKategorije")
    private Kategorija kategorija;

    public long getIdProdukta() {
        return idProdukta;
    }

    public void setIdProdukta(long idProdukta) {
        this.idProdukta = idProdukta;
    }

    public String getImeProdukta() {
        return imeProdukta;
    }

    public void setImeProdukta(String imeProdukta) {
        this.imeProdukta = imeProdukta;
    }

    public String getOpisProdukta() {
        return opisProdukta;
    }

    public void setOpisProdukta(String opisProdukta) {
        this.opisProdukta = opisProdukta;
    }

    public long getCijena() {
        return cijena;
    }

    public void setCijena(long cijena) {
        this.cijena = cijena;
    }

    public int getKolicinaNaSkladistu() {
        return kolicinaNaSkladistu;
    }

    public void setKolicinaNaSkladistu(int kolicinaNaSkladistu) {
        this.kolicinaNaSkladistu = kolicinaNaSkladistu;
    }

    public String getUrlSlike() {
        return urlSlike;
    }

    public void setUrlSlike(String urlSlike) {
        this.urlSlike = urlSlike;
    }
}
