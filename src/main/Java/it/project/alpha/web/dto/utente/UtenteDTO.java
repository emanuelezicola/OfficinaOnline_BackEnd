package it.project.alpha.web.dto.utente;

import it.project.alpha.model.Utente;
import it.project.alpha.utils.StringUtility;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class UtenteDTO {

    private Long id;
    private String nome;
    private String cognome;
    private String email;
    private String password;
    private Date dataRegistrazione;



    public Map<String, String> validate(){
        Map<String, String> errors  = new HashMap<>();

        if(id!=null && id<=0 ){
                errors.put("id", "ID non valido per l'input " + id);
        }

        if(nome == null || StringUtils.isBlank(nome) || !StringUtility.containsOnlyLetters(nome)){
            errors.put("nome", "Nome non valido per l\'input " + nome);
        }

        if(cognome == null || StringUtils.isBlank(cognome) || !StringUtility.containsOnlyLetters(nome)){
            errors.put("cognome", "Nome non valido per l\'input " + cognome);
        }

        if(email == null || StringUtils.isBlank(email) || !StringUtility.isValidEmail(email)){
            errors.put("email", "Email non valida per l\'input " + email);
        }

        if(password == null || StringUtils.isBlank(password) || !StringUtility.containsOnlyLettersAndNumbers(password)){
            errors.put("password", "Password non valida per l\'input " + password);
        }

        return errors;
    }

    public Map<String, String> validateForLogin(){
        Map<String, String> errors = new HashMap<>();

        if(email == null || StringUtils.isBlank(email)){
            errors.put("email", "Email non valida per l\'input " + email);
        }

        if(password == null || StringUtils.isBlank(password) || !StringUtility.containsOnlyLettersAndNumbers(password)){
            errors.put("password", "Password non valida per l\'input " + password);
        }

        return errors;
    }


    public void createDTO(Utente input){
        this.id = input.getId();
        this.nome = input.getNome();
        this.cognome = input.getCognome();
        this.email = input.getEmail();
        this.password = input.getPassword();
        this.dataRegistrazione = input.getDataRegistrazione();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) { this.password = password; }

    public String getPassword() { return this.password; }

    public Date getDataRegistrazione() {
        return dataRegistrazione;
    }

    public void setDataRegistrazione(Date dataRegistrazione) {
        this.dataRegistrazione = dataRegistrazione;
    }




}
