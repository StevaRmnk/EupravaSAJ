package com.example.Policija.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "dokazi")
public class Dokaz {

    @Id
    private int idDokaza;

    @Column
    private LocalDate datumZavodjenjaDokaza;

    @Enumerated
    private TipDokaza tipDokaza;

    @JoinColumn(name = "idZapisnika", referencedColumnName = "idZapisnika",nullable = false)
    private int idZapisnika;


    public int getIdDokaza() {
        return idDokaza;
    }

    public void setIdDokaza(int idDokaza) {
        this.idDokaza = idDokaza;
    }

    public LocalDate getDatumZavodjenjaDokaza() {
        return datumZavodjenjaDokaza;
    }

    public void setDatumZavodjenjaDokaza(LocalDate datumZavodjenjaDokaza) {
        this.datumZavodjenjaDokaza = datumZavodjenjaDokaza;
    }

    public TipDokaza getTipDokaza() {
        return tipDokaza;
    }

    public void setTipDokaza(TipDokaza tipDokaza) {
        this.tipDokaza = tipDokaza;
    }

    public int getIdZapisnika() {
        return idZapisnika;
    }

    public void setIdZapisnika(int idZapisnika) {
        this.idZapisnika = idZapisnika;
    }
}
