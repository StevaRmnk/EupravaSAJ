package com.example.Policija.Model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "zapisnici")
public class Zapisnik {

    @Id
    private int idZapisnika;

    @Column
    private String jmbgPolicajca;

    @Column
    private String jmbgOsumjicenog;

    @Column
    private LocalDate datumPravljenjaZapisnika;

    @Column
    private String opisPrekrsaja;

    @ManyToMany
    @JoinTable(
            name = "dokaziuzapisniku",
            joinColumns = @JoinColumn(name = "idZapisnika"),
            inverseJoinColumns = @JoinColumn(name = "idDokaza")
    )
    private List<Dokaz> listaDokaza;

    public int getIdZapisnika() {
        return idZapisnika;
    }

    public void setIdZapisnika(int idZapisnika) {
        this.idZapisnika = idZapisnika;
    }

    public String getJmbgPolicajca() {
        return jmbgPolicajca;
    }

    public void setJmbgPolicajca(String jmbgPolicajca) {
        this.jmbgPolicajca = jmbgPolicajca;
    }

    public String getJmbgOsumjicenog() {
        return jmbgOsumjicenog;
    }

    public void setJmbgOsumjicenog(String jmbgOsumjicenog) {
        this.jmbgOsumjicenog = jmbgOsumjicenog;
    }

    public LocalDate getDatumPravljenjaZapisnika() {
        return datumPravljenjaZapisnika;
    }

    public void setDatumPravljenjaZapisnika(LocalDate datumPravljenjaZapisnika) {
        this.datumPravljenjaZapisnika = datumPravljenjaZapisnika;
    }

    public String getOpisPrekrsaja() {
        return opisPrekrsaja;
    }

    public void setOpisPrekrsaja(String opisPrekrsaja) {
        this.opisPrekrsaja = opisPrekrsaja;
    }

    public List<Dokaz> getListaDokaza() {
        return listaDokaza;
    }

    public void setListaDokaza(List<Dokaz> listaDokaza) {
        this.listaDokaza = listaDokaza;
    }

    public Zapisnik(){

    }
}
