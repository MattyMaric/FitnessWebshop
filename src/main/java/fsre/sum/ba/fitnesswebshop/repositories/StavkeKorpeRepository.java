package fsre.sum.ba.fitnesswebshop.repositories;

import fsre.sum.ba.fitnesswebshop.models.Produkt;
import fsre.sum.ba.fitnesswebshop.models.StavkaKorpe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StavkeKorpeRepository extends JpaRepository<StavkaKorpe, Long> {
    StavkaKorpe findByProdukt(Produkt produkt);
}
