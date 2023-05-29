package com.example.Policija.DTO;

public class LoginDTO {

    private String brojZnacke;
    private String lozinka;

    public String getBrojZnacke() {
        return brojZnacke;
    }

    public void setBrojZnacke(String brojZnacke) {
        this.brojZnacke = brojZnacke;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public LoginDTO(){

    }

    public LoginDTO(String brojZnacke, String lozinka) {
        this.brojZnacke = brojZnacke;
        this.lozinka = lozinka;
    }
}
