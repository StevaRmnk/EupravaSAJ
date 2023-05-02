package com.example.Tuzilastvo.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "optuznice")
public class Optuznica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOptuznice;

    @Column
    private LocalDate datumPodizanjaOptuznice;

    @JoinColumn(name = "brojLicenceTuzioca", referencedColumnName = "brojLicenceTuzioca",nullable = false)
    private String brojLicenceTuzioca;

    @Column
    private String jmbgOptuzenog;

    @Enumerated
    private Status statusOptuznice;

    @Column(nullable = true)
    private int idZapisnika;

    @Column(nullable = true)
    private int idPrijaveGradjanina;


    public int getIdOptuznice() {
        return idOptuznice;
    }

    public void setIdOptuznice(int idOptuznice) {
        this.idOptuznice = idOptuznice;
    }

    public LocalDate getDatumPodizanjaOptuznice() {
        return datumPodizanjaOptuznice;
    }

    public void setDatumPodizanjaOptuznice(LocalDate datumPodizanjaOptuznice) {
        this.datumPodizanjaOptuznice = datumPodizanjaOptuznice;
    }

    public String getBrojLicenceTuzioca() {
        return brojLicenceTuzioca;
    }

    public void setBrojLicenceTuzioca(String brojLicenceTuzioca) {
        this.brojLicenceTuzioca = brojLicenceTuzioca;
    }

    public String getJmbgOptuzenog() {
        return jmbgOptuzenog;
    }

    public void setJmbgOptuzenog(String jmbgOptuzenog) {
        this.jmbgOptuzenog = jmbgOptuzenog;
    }

    public Status getStatusOptuznice() {
        return statusOptuznice;
    }

    public void setStatusOptuznice(Status statusOptuznice) {
        this.statusOptuznice = statusOptuznice;
    }

    public int getIdZapisnika() {
        return idZapisnika;
    }

    public void setIdZapisnika(int idZapisnika) {
        this.idZapisnika = idZapisnika;
    }

    public int getIdPrijaveGradjanina() {
        return idPrijaveGradjanina;
    }

    public void setIdPrijaveGradjanina(int idPrijaveGradjanina) {
        this.idPrijaveGradjanina = idPrijaveGradjanina;
    }

    public Optuznica(){

    }
}
