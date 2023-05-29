package com.example.Policija.DTO;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ZapisnikDTO {
    @NotBlank
    private String brojZnacke;
    @NotBlank
    private String jmbgOsumnjicenog;
    @NotNull
    private LocalDateTime datumPravljenjaZapisnika;
    @NotBlank
    private String opisPrekrsaja;
    @NotBlank
    private String tipDokaza;
    @NotNull
    private LocalDate datumZavodjenjaDokaza;

    public String getBrojZnacke() {
        return brojZnacke;
    }

    public void setBrojZnacke(String brojZnacke) {
        this.brojZnacke = brojZnacke;
    }

    public String getJmbgOsumnjicenog() {
        return jmbgOsumnjicenog;
    }

    public void setJmbgOsumnjicenog(String jmbgOsumnjicenog) {
        this.jmbgOsumnjicenog = jmbgOsumnjicenog;
    }

    public LocalDateTime getDatumPravljenjaZapisnika() {
        return datumPravljenjaZapisnika;
    }

    public void setDatumPravljenjaZapisnika(LocalDateTime datumPravljenjaZapisnika) {
        this.datumPravljenjaZapisnika = datumPravljenjaZapisnika;
    }

    public String getOpisPrekrsaja() {
        return opisPrekrsaja;
    }

    public void setOpisPrekrsaja(String opisPrekrsaja) {
        this.opisPrekrsaja = opisPrekrsaja;
    }

    public String getTipDokaza() {
        return tipDokaza;
    }

    public void setTipDokaza(String tipDokaza) {
        this.tipDokaza = tipDokaza;
    }

    public LocalDate getDatumZavodjenjaDokaza() {
        return datumZavodjenjaDokaza;
    }

    public void setDatumZavodjenjaDokaza(LocalDate datumZavodjenjaDokaza) {
        this.datumZavodjenjaDokaza = datumZavodjenjaDokaza;
    }

    public ZapisnikDTO(){

    }

    public ZapisnikDTO(String brojZnacke, String jmbgOsumnjicenog, LocalDateTime datumPravljenjaZapisnika, String opisPrekrsaja, String tipDokaza, LocalDate datumZavodjenjaDokaza) {
        this.brojZnacke = brojZnacke;
        this.jmbgOsumnjicenog = jmbgOsumnjicenog;
        this.datumPravljenjaZapisnika = datumPravljenjaZapisnika;
        this.opisPrekrsaja = opisPrekrsaja;
        this.tipDokaza = tipDokaza;
        this.datumZavodjenjaDokaza = datumZavodjenjaDokaza;
    }
}
