package com.example.tp5;

public class Donnee {
    private String principal;
    private String auxiliaire;

    Donnee (String text1, String text2){
        principal = text1;
        auxiliaire = text2;
    }

    public String getPrincipal() {
        return principal;
    }

    public String getAuxiliaire() {
        return auxiliaire;
    }

}
