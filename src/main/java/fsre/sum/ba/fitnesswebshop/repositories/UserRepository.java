package fsre.sum.ba.fitnesswebshop.repositories;

import fsre.sum.ba.fitnesswebshop.models.korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<korisnik, Long> {

    @Query("SELECT DISTINCT k FROM korisnik k  WHERE k.email=?1")
    public korisnik findByEmail(String email);
}
