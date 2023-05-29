package com.example.Policija.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "zapisnici")
public class Zapisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idZapisnika;

    @JoinColumn(name = "brojZnacke", referencedColumnName = "brojZnacke",nullable = false)
    private String brojZnacke;

    @Column
    private String jmbgOsumnjicenog;

    @Column
    private LocalDateTime datumPravljenjaZapisnika;

    @Column
    private String opisPrekrsaja;


    public int getIdZapisnika() {
        return idZapisnika;
    }

    public void setIdZapisnika(int idZapisnika) {
        this.idZapisnika = idZapisnika;
    }

    public String getBrojZnacke() {
        return brojZnacke;
    }

    public void setBrojZnacke(String jmbgPolicajca) {
        this.brojZnacke = jmbgPolicajca;
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


    public Zapisnik(){

    }
}
