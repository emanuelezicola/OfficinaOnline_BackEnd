package it.project.alpha.service.auto;

import it.project.alpha.model.Auto;
import it.project.alpha.model.Utente;

import java.util.List;

public interface AutoService {


    List<Auto> listAllAuto() ;

    Auto caricaSingolaAuto(long id);

    void aggiorna(Auto autoInstance);

    void inserisciNuova(Auto autoInstance);

    void rimuovi(Auto autoInstance);

    List<Auto> findByExample(Auto example);

}
