

        package fsre.sum.ba.fitnesswebshop.services;

import fsre.sum.ba.fitnesswebshop.models.Produkt;
import fsre.sum.ba.fitnesswebshop.models.StavkaKorpe;

import java.util.List;

public interface KorpaService {
    void dodajUKorpu(Produkt produkt);
    void ukloniIzKorpe(Long stavkaKorpeId);

    List<StavkaKorpe> getStavkeKorpe();
    void ocistiKorpu();
    double getUkupnaCijena();

}
