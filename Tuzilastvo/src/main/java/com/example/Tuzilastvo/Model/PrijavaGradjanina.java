package com.example.Tuzilastvo.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prijaveGradjanina")
public class PrijavaGradjanina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrijave;
    @Column
    private String opisPrekrsaja;
    @Column
    private String jmbgOsumnjicenog;
    @Enumerated
    private Status statusPrijave;
    @Column
    private LocalDate datumPodizanjaPrijave;
    @Column
    private Boolean anonimna;
    @Column(nullable = true)
    private String jmbgGradjanina;

    public int getIdPrijave() {
        return idPrijave;
    }

    public void setIdPrijave(int idPrijave) {
        this.idPrijave = idPrijave;
    }

    public LocalDate getDatumPodizanjaPrijave() {
        return datumPodizanjaPrijave;
    }

    public void setDatumPodizanjaPrijave(LocalDate datumPodizanjaPrijave) {
        this.datumPodizanjaPrijave = datumPodizanjaPrijave;
    }

    public String getOpisPrekrsaja() {
        return opisPrekrsaja;
    }

    public void setOpisPrekrsaja(String opisPrekrsaja) {
        this.opisPrekrsaja = opisPrekrsaja;
    }

    public String getJmbgOsumnjicenog() {
        return jmbgOsumnjicenog;
    }

    public void setJmbgOsumnjicenog(String jmbgOsumnjicenog) {
        this.jmbgOsumnjicenog = jmbgOsumnjicenog;
    }

    public Status getStatusPrijave() {
        return statusPrijave;
    }

    public void setStatusPrijave(Status statusPrijave) {
        this.statusPrijave = statusPrijave;
    }

    public Boolean getAnonimna() {
        return anonimna;
    }

    public void setAnonimna(Boolean anonimna) {
        this.anonimna = anonimna;
    }

    public String getJmbgGradjanina() {
        return jmbgGradjanina;
    }

    public void setJmbgGradjanina(String jmbgGradjanina) {
        this.jmbgGradjanina = jmbgGradjanina;
    }

    public PrijavaGradjanina(){

    }
}
