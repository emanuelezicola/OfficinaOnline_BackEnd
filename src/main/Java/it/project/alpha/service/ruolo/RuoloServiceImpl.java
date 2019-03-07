package it.project.alpha.service.ruolo;

import it.project.alpha.model.Ruolo;
import it.project.alpha.repository.ruolo.RuoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuoloServiceImpl implements RuoloService {

    @Autowired
    private RuoloRepository repository;

    @Override
    public List<Ruolo> listAllRuoli() {
        return (List<Ruolo>) repository.findAll();
    }

    @Override
    public Ruolo findByCodice(String codice) {
        return repository.findByCodice(codice);
    }

    @Override
    public Ruolo caricaSingoloRuolo(long id) {
        return repository.findOne(id);
    }

    @Override
    public void aggiorna(Ruolo ruoloInstance) {
        repository.save(ruoloInstance);
    }

    @Override
    public void inserisciNuovo(Ruolo ruoloInstance) {
        repository.save(ruoloInstance);
    }

    @Override
    public void rimuovi(Ruolo ruoloInstance) {
        repository.delete(ruoloInstance);
    }

    @Override
    public List<Ruolo> findByExample(Ruolo example) {
        return null;
    }
}
