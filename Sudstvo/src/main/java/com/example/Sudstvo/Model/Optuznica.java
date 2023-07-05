package com.example.Sudstvo.Model;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import java.time.LocalDate;

public class Optuznica {

    @Column
    private int idOptuznice;

    @Column
    private LocalDate datumPodizanjaOptuznice;

    @Column
    private String brojLicenceTuzioca;

    @Column
    private String jmbgOptuzenog;

    @Enumerated
    private Status statusOptuznice;

    @Column(nullable = true)
    private int idZapisnika;

    @Column(nullable = true)
    private int idPrijaveGradjanina;

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

    public int getIdOptuznice() {
        return idOptuznice;
    }

    public void setIdOptuznice(int idOptuznice) {
        this.idOptuznice = idOptuznice;
    }

    public Optuznica(){

    }
}
