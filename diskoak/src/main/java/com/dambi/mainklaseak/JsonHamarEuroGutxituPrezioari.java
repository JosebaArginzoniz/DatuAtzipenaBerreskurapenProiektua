package com.dambi.mainklaseak;

import com.dambi.atzipenekoak.Jsona;
import com.dambi.pojoak.Diskoa;
import com.dambi.pojoak.Diskoak;

public class JsonHamarEuroGutxituPrezioari {
    public static void main(String[] args) {
    
        Diskoak diskoak = new Diskoak();
        Diskoak dtoa = new Diskoak();

        Jsona jsona = new Jsona("data/diskoak.json","data/diskoakprize.json");

        diskoak = jsona.irakurri();

        if (diskoak != null) {
            for (Diskoa d : diskoak.getDiskoak()) {
                float kenHammar = 10;
                float prezioa = d.getPrezioa();
                if (prezioa >= 0) {
                    prezioa = prezioa - kenHammar;
                    d.setPrezioa(prezioa);
                    dtoa.add(d);      
                }  
            } 
            System.out.println(jsona.idatzi(dtoa)+" disko idatzi dira json fitxategian.");
        }
    }
}
