package com.example.Sudstvo.Model;


import javax.persistence.*;

@Entity
@Table(name = "presude")
public class Presuda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPresude;

    @JoinColumn(name = "sudija", referencedColumnName = "brojSudijskeLicence",nullable = false)
    private String sudija;

    @Column
    private String jmbgOptuzenog;

    @Column
    private int idOptuznice;

   @Column
    private boolean kriv;

    public int getIdPresude() {
        return idPresude;
    }

    public void setIdPresude(int idPresude) {
        this.idPresude = idPresude;
    }

    public String getSudija() {
        return sudija;
    }

    public void setSudija(String sudija) {
        this.sudija = sudija;
    }

    public int getIdOptuznice() {
        return idOptuznice;
    }

    public void setIdOptuznice(int idOptuznice) {
        this.idOptuznice = idOptuznice;
    }

    public boolean isKriv() {
        return kriv;
    }

    public void setKriv(boolean kriv) {
        this.kriv = kriv;
    }

    public String getJmbgOptuzenog() {
        return jmbgOptuzenog;
    }

    public void setJmbgOptuzenog(String jmbgOptuzenog) {
        this.jmbgOptuzenog = jmbgOptuzenog;
    }

    public Presuda(){

    }
}
