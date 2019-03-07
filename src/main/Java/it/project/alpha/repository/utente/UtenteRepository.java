package it.project.alpha.repository.utente;

import it.project.alpha.model.Utente;
import org.springframework.data.repository.CrudRepository;


public interface UtenteRepository extends CrudRepository<Utente, Long> {

    Utente findByEmailAndPassword(String email,String password);

    Utente findByEmail(String email);

}
