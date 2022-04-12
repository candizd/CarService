package com.example.se_project2;

import java.util.Date;

public class cars_sold extends Cars {

    private String eigentumer;
    private Date verkaufsdate;

    public cars_sold(int preis, String idNumber, String modell, String automarke, int motorleistung, String karossertyp, String eigentumer, Date verkaufsdate) {
        super(preis, idNumber, modell, automarke, motorleistung, karossertyp);
        this.eigentumer = eigentumer;
        this.verkaufsdate = verkaufsdate;
    }

}
