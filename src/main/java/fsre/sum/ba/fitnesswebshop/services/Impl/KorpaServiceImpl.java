package fsre.sum.ba.fitnesswebshop.services.Impl;

import fsre.sum.ba.fitnesswebshop.models.Produkt;
import fsre.sum.ba.fitnesswebshop.models.StavkaKorpe;
import fsre.sum.ba.fitnesswebshop.services.KorpaService;
import fsre.sum.ba.fitnesswebshop.repositories.StavkeKorpeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorpaServiceImpl implements KorpaService {

    @Autowired
    private StavkeKorpeRepository stavkeKorpeRepository;

    @Override
    public void dodajUKorpu(Produkt produkt) {
        StavkaKorpe postojiStavkaKorpe = stavkeKorpeRepository.findByProdukt(produkt);

        if(postojiStavkaKorpe != null){
            postojiStavkaKorpe.setKolicina(postojiStavkaKorpe.getKolicina() + 1);
            stavkeKorpeRepository.save(postojiStavkaKorpe);


        } else {
            StavkaKorpe stavkaKorpe = new StavkaKorpe();
            stavkaKorpe.setProdukt(produkt);
            stavkaKorpe.setKolicina(1);

            stavkeKorpeRepository.save(stavkaKorpe);
        }
    }

    @Override
    public List<StavkaKorpe> getStavkeKorpe() {
        return stavkeKorpeRepository.findAll();
    }

    @Override
    public void ocistiKorpu() {
        stavkeKorpeRepository.deleteAll();
    }

    @Override
    public double getUkupnaCijena() {
        List<StavkaKorpe> stavkeKorpe = getStavkeKorpe();

        double ukupnaCijena = 0;

        for(StavkaKorpe stavkaKorpe : stavkeKorpe){
            ukupnaCijena += stavkaKorpe.getProdukt().getCijena() * stavkaKorpe.getKolicina();
        }

        return ukupnaCijena;
    }

    @Override
    public void ukloniIzKorpe(Long stavkaKorpeId) {
        stavkeKorpeRepository.deleteById(stavkaKorpeId);
    }
}