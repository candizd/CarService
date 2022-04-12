package com.example.se_project2;

public class Cars {
    protected int preis;
    private String idNumber;
    protected String modell;
    protected String automarke;
    protected int motorleistung;
    protected String karossertyp;

    public Cars(int preis, String idNumber, String modell, String automarke, int motorleistung, String karossertyp) {
        this.preis = preis;
        this.idNumber = idNumber;
        this.modell = modell;
        this.automarke = automarke;
        this.motorleistung = motorleistung;
        this.karossertyp = karossertyp;
    }

    public String getIdNumber() {
        return this.idNumber;
    }
}