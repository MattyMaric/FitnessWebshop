package fsre.sum.ba.fitnesswebshop.services;

import fsre.sum.ba.fitnesswebshop.models.Kategorija;
import fsre.sum.ba.fitnesswebshop.models.Produkt;
import fsre.sum.ba.fitnesswebshop.models.StavkaKorpe;

import java.util.List;

public interface CategoryService {
    List<Kategorija> getAllCategories();

}