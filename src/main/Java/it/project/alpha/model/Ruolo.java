package it.project.alpha.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Ruolo implements Serializable{

    private static final long serialVersionUID = 4000618329909480037L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String descrizione;
    private String codice;
    @ManyToMany(mappedBy="ruoli")
    private Set<Utente> utenti = new HashSet<>();

    public Ruolo(){}

    public Ruolo(String descrizione, String codice) {
        super();
        this.descrizione = descrizione;
        this.codice = codice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

