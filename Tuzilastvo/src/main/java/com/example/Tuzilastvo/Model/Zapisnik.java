package com.example.Tuzilastvo.Model;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class Zapisnik {

    private int idZapisnika;

    private String brojZnacke;

    private String jmbgOsumnjicenog;

    private LocalDateTime datumPravljenjaZapisnika;

    private String opisPrekrsaja;

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

    public int getIdZapisnika() {
        return idZapisnika;
    }

    public void setIdZapisnika(int idZapisnika) {
        this.idZapisnika = idZapisnika;
    }

    public Zapisnik(){

    }
}
