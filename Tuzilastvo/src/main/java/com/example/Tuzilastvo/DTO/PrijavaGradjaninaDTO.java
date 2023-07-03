package com.example.Tuzilastvo.DTO;

import com.example.Tuzilastvo.Model.PrijavaGradjanina;
import com.example.Tuzilastvo.Model.Status;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDate;

public class PrijavaGradjaninaDTO {


    private String opisPrekrsaja;
    private String jmbgOsumnjicenog;
    private LocalDate datumPodizanjaPrijave;
    private Boolean anonimna;
    private String jmbgGradjanina;

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

    public LocalDate getDatumPodizanjaPrijave() {
        return datumPodizanjaPrijave;
    }

    public void setDatumPodizanjaPrijave(LocalDate datumPodizanjaPrijave) {
        this.datumPodizanjaPrijave = datumPodizanjaPrijave;
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

    public PrijavaGradjaninaDTO(String opisPrekrsaja, String jmbgOsumnjicenog, LocalDate datumPodizanjaPrijave, Boolean anonimna, String jmbgGradjanina) {
        this.opisPrekrsaja = opisPrekrsaja;
        this.jmbgOsumnjicenog = jmbgOsumnjicenog;
        this.datumPodizanjaPrijave = datumPodizanjaPrijave;
        this.anonimna = anonimna;
        this.jmbgGradjanina = jmbgGradjanina;
    }

    public PrijavaGradjaninaDTO(){

    }
}
