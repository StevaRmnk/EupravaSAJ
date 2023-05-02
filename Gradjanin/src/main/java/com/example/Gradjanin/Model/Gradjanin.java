package com.example.Gradjanin.Model;


import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection="gradjani")
public class Gradjanin {
    private String jmbgGradjanina;
    private String ime;
    private String prezime;
    private LocalDate datumRodjenja;
    private String adresa;

    public String getJmbgGradjanina() {
        return jmbgGradjanina;
    }

    public void setJmbgGradjanina(String jmbgGradjanina) {
        this.jmbgGradjanina = jmbgGradjanina;
    }

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

    public Gradjanin(){

    }

}