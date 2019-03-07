package it.project.alpha.service.utente;

import it.project.alpha.model.Utente;
import it.project.alpha.repository.utente.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UtenteServiceImpl implements UtenteService {

    @Autowired
    private UtenteRepository repository;

    @Transactional(readOnly = true)
    public List<Utente> listAllUtenti() {
        return (List<Utente>) repository.findAll();
    }

    @Transactional(readOnly = true)
    public Utente caricaSingoloUtente(long id) {
        return repository.findOne(id);
    }

    @Transactional
    public void aggiorna(Utente utenteInstance) {
        repository.save(utenteInstance);
    }

    @Transactional
    public void inserisciNuovo(Utente utenteInstance) {
        repository.save(utenteInstance);
    }

    @Transactional
    public void rimuovi(Utente utenteInstance) {
        repository.delete(utenteInstance);

    }

    @Transactional(readOnly = true)
    public List<Utente> findByExample(Utente example) {
        // TODO Auto-generated method stub
        return null;
    }

    @Transactional(readOnly = true)
    public Utente eseguiAccesso(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }

    @Override
    public Utente findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
