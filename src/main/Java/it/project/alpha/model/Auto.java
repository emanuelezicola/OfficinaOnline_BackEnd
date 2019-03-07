package it.project.alpha.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Auto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String marca;
    private String modello;
    private Date dataDiAcquisto;
    private Long km;
    private Integer prezzo;
    private String alimentazione;
    private Float cilindrata;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "abitante_id", nullable = false)
    private Utente utente;

    public Auto(){}

    public Auto(String marca, String modello, Long km, Integer prezzo, String alimentazione, Float cilindrata){
        this.marca = marca;
        this.modello = modello;
        this.km = km;
        this.prezzo = prezzo;
        this.alimentazione = alimentazione;
        this.cilindrata = cilindrata;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public Date getDataDiAcquisto() {
        return dataDiAcquisto;
    }

    public void setDataDiAcquisto(Date dataDiAcquisto) {
        this.dataDiAcquisto = dataDiAcquisto;
    }

    public Long getKm() {
        return km;
    }

    public void setKm(Long km) {
        this.km = km;
    }

    public Integer getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Integer prezzo) {
        this.prezzo = prezzo;
    }

    public String getAlimentazione() {
        return alimentazione;
    }

    public void setAlimentazione(String alimentazione) {
        this.alimentazione = alimentazione;
    }

    public Float getCilindrata() {
        return cilindrata;
    }

    public void setCilindrata(Float cilindrata) {
        this.cilindrata = cilindrata;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }
}
