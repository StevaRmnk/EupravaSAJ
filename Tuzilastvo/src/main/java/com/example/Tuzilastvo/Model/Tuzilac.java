package com.example.Tuzilastvo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tuzioci")
public class Tuzilac {

    @Id
    private String brojLicenceTuzioca;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column
    private String lozinka;


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

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public void setBrojLicenceTuzioca(String brojLicenceTuzioca) {
        this.brojLicenceTuzioca = brojLicenceTuzioca;
    }

    public Tuzilac(){

    }
}
