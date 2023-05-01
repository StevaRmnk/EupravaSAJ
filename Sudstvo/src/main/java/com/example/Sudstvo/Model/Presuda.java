package com.example.Sudstvo.Model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "presude")
public class Presuda {

    @Id
    private int idPresude;

    @Column
    private String brojSudijskeLicence;

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

    public String getBrojSudijskeLicence() {
        return brojSudijskeLicence;
    }

    public void setBrojSudijskeLicence(String brojSudijskeLicence) {
        this.brojSudijskeLicence = brojSudijskeLicence;
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

    public Presuda(){

    }
}
