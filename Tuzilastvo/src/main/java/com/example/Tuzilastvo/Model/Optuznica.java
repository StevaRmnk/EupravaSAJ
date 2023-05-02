package com.example.Tuzilastvo.Model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "optuznice")
public class Optuznica {

    @Id
    private int idOptuznice;

    @Column
    private LocalDate datumPodizanjaOptuznice;

    @Column
    private String jmbgTuzioca;

    @Column
    private String jmbgOptuzenog;

    @Enumerated
    private Status statusOptuznice;


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

    public String getJmbgTuzioca() {
        return jmbgTuzioca;
    }

    public void setJmbgTuzioca(String jmbgTuzioca) {
        this.jmbgTuzioca = jmbgTuzioca;
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

    public Optuznica(){

    }
}
