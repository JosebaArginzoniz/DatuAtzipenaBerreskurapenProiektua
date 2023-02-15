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
        diskoak = jsona.irakurri();

        Xmla xmla = new Xmla("", "data/diskoakkk.xml");
        System.out.println(xmla.idatzi(diskoak)+" disko idatzi dira xml fitxategian.");
        
    }
}
