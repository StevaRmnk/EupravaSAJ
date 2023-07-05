package com.example.Sudstvo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sudije")
public class Sudija {

    @Id
    private String brojSudijskeLicence;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column
    private String lozinka;

    public String getBrojSudijskeLicence() {
        return brojSudijskeLicence;
    }

    public void setBrojSudijskeLicence(String brojSudijskeLicence) {
        this.brojSudijskeLicence = brojSudijskeLicence;
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

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Sudija(){

    }
}
