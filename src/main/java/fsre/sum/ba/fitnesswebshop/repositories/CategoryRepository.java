package fsre.sum.ba.fitnesswebshop.repositories;

import fsre.sum.ba.fitnesswebshop.models.Kategorija;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Kategorija, Long> {
}
