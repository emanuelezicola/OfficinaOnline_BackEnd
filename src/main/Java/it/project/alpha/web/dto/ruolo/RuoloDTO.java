package it.project.alpha.web.dto.ruolo;

import it.project.alpha.model.Ruolo;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class RuoloDTO {


    private Long id;
    private String descrizione;
    private String codice;


    public RuoloDTO createRuoloDTO(Ruolo ruolo){
        this.id = ruolo.getId();
        this.descrizione = ruolo.getDescrizione();
        this.codice = ruolo.getCodice();

        return this;
    }


    public Map<String, String> validate(){
        Map<String, String> errors = new HashMap<>();

        if(id!=null){
            if(id<=0){
                errors.put("id", "ID non valido per l'input " + id);
            }
        }
        else {
            errors.put("id", "ID nullo");
        }

        if(descrizione == null || StringUtils.containsWhitespace(descrizione) || descrizione.length()<=1){
            errors.put("descrizione", "Errore nella descrizione!");
        }

        if(codice == null || StringUtils.containsWhitespace(codice) || codice.length()<=1){
            errors.put("codice", "Errore nel codice!");
        }

        return errors;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }
}
