package home.application.teai_pracadomowatydzien7_2.dao;

import home.application.teai_pracadomowatydzien7_2.model.AnimalFactDB;
import home.application.teai_pracadomowatydzien7_2.model.AnimalFactFromApi;

import java.util.List;

public interface FactDao {
    void createNewFactInDatabase(AnimalFactFromApi fact);

    void updateFact(AnimalFactDB animalFactDB);

    List<AnimalFactDB> getAllFacts();

    AnimalFactDB findFact(long id);

    void delete(long id);

    Integer counter();

}
