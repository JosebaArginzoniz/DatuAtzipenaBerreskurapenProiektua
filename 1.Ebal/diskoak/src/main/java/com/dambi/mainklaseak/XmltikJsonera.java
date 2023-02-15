package com.dambi.mainklaseak;

import com.dambi.atzipenekoak.Jsona;
import com.dambi.atzipenekoak.Xmla;
import com.dambi.pojoak.Diskoa;
import com.dambi.pojoak.Diskoak;

public class XmltikJsonera {
    public static void main(String[] args) {

        Diskoak diskoak = new Diskoak();

        Xmla xmla = new Xmla("data/diskoak.xml");   
        diskoak = xmla.irakurri();

        Jsona jsona = new Jsona("","data/diskoakkk.json");

       System.out.println(jsona.idatzi(diskoak)+" disko idatzi dira json fitxategian.");
        
    }
}
