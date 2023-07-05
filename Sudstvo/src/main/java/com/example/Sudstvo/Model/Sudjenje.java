package com.example.Sudstvo.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "sudjenje")
public class Sudjenje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private int brojSale;

    @Column
    private String jmbgOptuzenog;

    @Column
    private String brojSudijskeLicence;

    @Column
    private int idOptuznice;

    @Column
    private LocalDate vremeSudjenja;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBrojSale() {
        return brojSale;
    }

    public void setBrojSale(int brojSale) {
        this.brojSale = brojSale;
    }

    public String getJmbgOptuzenog() {
        return jmbgOptuzenog;
    }

    public void setJmbgOptuzenog(String jmbgOptuzenog) {
        this.jmbgOptuzenog = jmbgOptuzenog;
    }

    public String getBrojSudijskeLicence() {
        return brojSudijskeLicence;
    }

    public void setBrojSudijskeLicence(String brojSudijskeLicence) {
        this.brojSudijskeLicence = brojSudijskeLicence;
    }

    public LocalDate getVremeSudjenja() {
        return vremeSudjenja;
    }

    public void setVremeSudjenja(LocalDate vremeSudjenja) {
        this.vremeSudjenja = vremeSudjenja;
    }

    public int getIdOptuznice() {
        return idOptuznice;
    }

    public void setIdOptuznice(int idOptuznice) {
        this.idOptuznice = idOptuznice;
    }

    public Sudjenje(){

    }

}
