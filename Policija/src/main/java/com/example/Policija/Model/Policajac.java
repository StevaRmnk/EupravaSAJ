package com.example.Policija.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "policajci")
public class Policajac {

    @Id
    private String brojZnacke;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column
    private LocalDate datumRodjenja;

    @Column
    private String adresa;


    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public LocalDate getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(LocalDate datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getBrojZnacke() {
        return brojZnacke;
    }

    public void setBrojZnacke(String brojZnacke) {
        this.brojZnacke = brojZnacke;
    }

    public Policajac(){

    }
}
