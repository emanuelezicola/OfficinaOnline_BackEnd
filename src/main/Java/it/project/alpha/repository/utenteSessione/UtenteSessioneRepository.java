package it.project.alpha.repository.utenteSessione;

import it.project.alpha.model.UtenteSessione;
import org.springframework.data.repository.CrudRepository;

public interface UtenteSessioneRepository extends CrudRepository<UtenteSessione, Long> {


    public UtenteSessione findByToken(String token);



}
