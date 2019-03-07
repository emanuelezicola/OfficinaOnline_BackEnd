package it.project.alpha.service.auto;

import it.project.alpha.model.Auto;
import it.project.alpha.repository.auto.AutoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AutoServiceImpl implements AutoService {

    @Autowired
    private AutoRepository repository;

    @Override
    public List<Auto> listAllAuto() {
        return (List<Auto>) repository.findAll();
    }

    @Override
    public Auto caricaSingolaAuto(long id) {
        return repository.findOne(id);
    }

    @Override
    public void aggiorna(Auto autoInstance) {
        repository.save(autoInstance);
    }

    @Override
    public void inserisciNuova(Auto autoInstance) {
        repository.save(autoInstance);
    }

    @Override
    public void rimuovi(Auto autoInstance) {
        repository.delete(autoInstance);
    }

    @Override
    public List<Auto> findByExample(Auto example) {
        //TODO findByExampleAuto
        return null;
    }
}
