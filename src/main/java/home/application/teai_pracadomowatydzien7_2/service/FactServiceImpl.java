package home.application.teai_pracadomowatydzien7_2.service;

import home.application.teai_pracadomowatydzien7_2.model.AnimalFactFromApi;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FactServiceImpl implements FactService {

    private List<AnimalFactFromApi> animalFactsFromApi;

    public FactServiceImpl() {
        this.animalFactsFromApi = new ArrayList<>();
    }

    @Override
    public AnimalFactFromApi getFact() {

        AnimalFactFromApi animalFactFromApi = new AnimalFactFromApi();
        HttpEntity httpEntity = new HttpEntity(animalFactFromApi);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<AnimalFactFromApi> factResponseEntity = restTemplate.exchange("https://cat-fact.herokuapp.com/facts/random",
                HttpMethod.GET,
                httpEntity,
                AnimalFactFromApi.class);
        animalFactsFromApi.add(factResponseEntity.getBody());
        return factResponseEntity.getBody();
    }

    public List<AnimalFactFromApi> getAnimalFactsFromApi() {
        return animalFactsFromApi;
    }

    public void setAnimalFactsFromApi(List<AnimalFactFromApi> animalFactsFromApi) {
        this.animalFactsFromApi = animalFactsFromApi;
    }
}
