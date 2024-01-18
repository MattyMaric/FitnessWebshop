package fsre.sum.ba.fitnesswebshop.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class produkt {

    @Id
    @GeneratedValue
    long idProduka;

    String imeProduka;
    String opisProdukta;
    long cijena;
    int kolicinaNaSkladistu;
    String kategorija;
    String urlSlike;

    public produkt(){

    }

    public produkt(long idProduka, String imeProduka, String opisProdukta, long cijena, int kolicinaNaSkladistu, String kategorija, String urlSlike) {
        this.idProduka = idProduka;
        this.imeProduka = imeProduka;
        this.opisProdukta = opisProdukta;
        this.cijena = cijena;
        this.kolicinaNaSkladistu = kolicinaNaSkladistu;
        this.kategorija = kategorija;
        this.urlSlike = urlSlike;
    }

    public long getIdProduka() {
        return idProduka;
    }

    public void setIdProduka(long idProduka) {
        this.idProduka = idProduka;
    }

    public String getImeProduka() {
        return imeProduka;
    }

    public void setImeProduka(String imeProduka) {
        this.imeProduka = imeProduka;
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

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getUrlSlike() {
        return urlSlike;
    }

    public void setUrlSlike(String urlSlike) {
        this.urlSlike = urlSlike;
    }
}
