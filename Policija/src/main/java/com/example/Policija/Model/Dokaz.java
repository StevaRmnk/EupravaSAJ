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

    @ManyToMany(mappedBy = "listaDokaza")
    private List<Zapisnik> listaZapisnika;


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

    public List<Zapisnik> getListaZapisnika() {
        return listaZapisnika;
    }

    public void setListaZapisnika(List<Zapisnik> listaZapisnika) {
        this.listaZapisnika = listaZapisnika;
    }
}
