package com.example.Sudstvo.DTO;

public class LoginDTO {
    private String brojLicence;
    private String lozinka;

    public String getBrojLicence() {
        return brojLicence;
    }

    public void setBrojLicence(String brojZnacke) {
        this.brojLicence = brojZnacke;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public LoginDTO(){

    }

    public LoginDTO(String brojLicence, String lozinka) {
        this.brojLicence = brojLicence;
        this.lozinka = lozinka;
    }
}
