package com.example.se_project2;

import java.util.Date;

public class cars_service extends Cars {

    private String eigentümer;
    private Date verkaufsjahr;
    public cars_service(int preis, String idNumber, String modell, String automarke, int motorleistung,String karossertyp, String eigentümer, Date verkaufsjahr) {
        super(preis, idNumber, modell, automarke, motorleistung, karossertyp);
        this.eigentümer = eigentümer;
        this.verkaufsjahr = verkaufsjahr;
    }
}
