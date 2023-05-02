package com.example.Tuzilastvo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tuzioci")
public class Tuzilac {

    @Id
    private String jmbgTuzioca;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column
    private String brojLicenceTuzioca;

    public String getJmbgTuzioca() {
        return jmbgTuzioca;
    }

    public void setJmbgTuzioca(String jmbgTuzioca) {
        this.jmbgTuzioca = jmbgTuzioca;
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

    public String getBrojLicenceTuzioca() {
        return brojLicenceTuzioca;
    }

    public void setBrojLicenceTuzioca(String brojLicenceTuzioca) {
        this.brojLicenceTuzioca = brojLicenceTuzioca;
    }

    public Tuzilac(){

    }
}
