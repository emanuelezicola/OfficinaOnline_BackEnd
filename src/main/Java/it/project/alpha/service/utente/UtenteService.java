package it.project.alpha.service.utente;

import it.project.alpha.model.Utente;

import java.util.List;

public interface UtenteService {

    List<Utente> listAllUtenti() ;

    Utente caricaSingoloUtente(long id);

    void aggiorna(Utente utenteInstance);

    void inserisciNuovo(Utente utenteInstance);

    void rimuovi(Utente utenteInstance);

    List<Utente> findByExample(Utente example);

    Utente eseguiAccesso(String username, String password);

    Utente findByEmail(String email);

}
