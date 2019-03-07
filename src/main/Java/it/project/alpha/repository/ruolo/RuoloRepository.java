package it.project.alpha.repository.ruolo;

import it.project.alpha.model.Ruolo;
import org.springframework.data.repository.CrudRepository;

public interface RuoloRepository extends CrudRepository<Ruolo, Long> {

    Ruolo findByCodice(String codice);

}
