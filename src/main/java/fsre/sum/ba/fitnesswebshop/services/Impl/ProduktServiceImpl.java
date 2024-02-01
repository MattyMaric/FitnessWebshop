package fsre.sum.ba.fitnesswebshop.services.Impl;

import fsre.sum.ba.fitnesswebshop.models.Produkt;
import fsre.sum.ba.fitnesswebshop.models.StavkaKorpe;
import fsre.sum.ba.fitnesswebshop.repositories.ProduktRepository;
import fsre.sum.ba.fitnesswebshop.repositories.StavkeKorpeRepository;
import fsre.sum.ba.fitnesswebshop.services.ProduktService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduktServiceImpl implements ProduktService{
    @Autowired
    private ProduktRepository produktRepository;

    @Autowired
    private StavkeKorpeRepository stavkeKorpeRepository;

    @Override
    public List<Produkt> getAllProducts() {
        return produktRepository.findAll();
    }

    @Override
    public Produkt getProductById(Long id) {
        return produktRepository.findById(id).orElse(null);
    }

    @Override
    public void saveProduct(Produkt product) {
        this.produktRepository.save(product);
    }

    @Override
    public void updateProduct(Produkt product) {
        this.produktRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        this.produktRepository.deleteById(id);
    }

    public List<Produkt> getProizvodiUKorpi(List<StavkaKorpe> stavkeKorpe) {
        List<Long> idProizvodaUKorpi = stavkeKorpe.stream()
                .map(stavkaKorpe -> stavkaKorpe.getProdukt().getIdProdukta())
                .collect(Collectors.toList());

        return produktRepository.findAllById(idProizvodaUKorpi);
    }
}