package fsre.sum.ba.fitnesswebshop.repositories;

import fsre.sum.ba.fitnesswebshop.models.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Korisnik, Long> {

    @Query("SELECT DISTINCT k FROM Korisnik k WHERE k.email=?1")
    public Korisnik findByEmail(String email);
}
