package com.dambi.mainklaseak;

import com.dambi.atzipenekoak.Jsona;
import com.dambi.atzipenekoak.Xmla;
import com.dambi.pojoak.Diskoa;
import com.dambi.pojoak.Diskoak;

public class JsonXmlra {

    public static void main(String[] args) {

        Diskoak diskoak = new Diskoak();
        Diskoak taldea = new Diskoak();

        
        Jsona jsona = new Jsona("data/diskoak.json");
        Xmla xmla = new Xmla("", "data/diskoak.xmla");
        
        diskoak = jsona.irakurri();

        if (diskoak != null) {
            for (Diskoa d : diskoak.getDiskoak()) {
                taldea.add(d);
            }
            System.out.println(xmla.idatzi(taldea)+" disko idatzi dira json fitxategian.");
        }
    }
}
