package fsre.sum.ba.fitnesswebshop.models;

import jakarta.persistence.*;

@Entity
public class StavkaKorpe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idProdukta")
    private Produkt produkt;

    @ManyToOne
    @JoinColumn(name = "idKorpe")
    private Korpa korpa;

    private int kolicina;

    public StavkaKorpe() {
    }

    public StavkaKorpe(Produkt produkt, Korpa korpa, int kolicina) {
        this.produkt = produkt;
        this.korpa = korpa;
        this.kolicina = kolicina;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produkt getProdukt() {
        return produkt;
    }

    public void setProdukt(Produkt produkt) {
        this.produkt = produkt;
    }

    public Korpa getKorpa() {
        return korpa;
    }

    public void setKorpa(Korpa korpa) {
        this.korpa = korpa;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }




}