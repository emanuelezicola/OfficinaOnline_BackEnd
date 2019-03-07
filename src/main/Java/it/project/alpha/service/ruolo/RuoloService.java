package it.project.alpha.service.ruolo;

import it.project.alpha.model.Ruolo;

import java.util.List;

public interface RuoloService {

    List<Ruolo> listAllRuoli() ;

    Ruolo findByCodice(String codice);

    Ruolo caricaSingoloRuolo(long id);

    void aggiorna(Ruolo ruoloInstance);

    void inserisciNuovo(Ruolo ruoloInstance);

    void rimuovi(Ruolo ruoloInstance);

    List<Ruolo> findByExample(Ruolo example);

}
