
package fsre.sum.ba.fitnesswebshop.services;

import fsre.sum.ba.fitnesswebshop.models.Produkt;
import fsre.sum.ba.fitnesswebshop.models.StavkaKorpe;

import java.util.List;

public interface ProduktService {
    List<Produkt> getAllProducts();
    List<Produkt> getProizvodiUKorpi(List<StavkaKorpe> stavkeKorpe);
    Produkt getProductById(Long id);
    void saveProduct(Produkt product);
    void updateProduct(Produkt product);
    void deleteProduct(Long id);
}