package com.dambi.mainklaseak;

import com.dambi.atzipenekoak.Jsona;
import com.dambi.pojoak.Diskoa;
import com.dambi.pojoak.Diskoak;

public class JsonRamones {
    public static void main(String[] args) {
    
        Diskoak diskoak = new Diskoak();
        Diskoak taldea = new Diskoak();

        Jsona jsona = new Jsona("data/diskoak.json","data/RamonesTaldearenDiskoak.json");

        diskoak = jsona.irakurri();

        if (diskoak != null) {
            for (Diskoa d : diskoak.getDiskoak()) {
                if (d.getTaldea().equals("Ramones")) {
                    taldea.add(d);
                }
            }
            System.out.println(jsona.idatzi(taldea)+" disko idatzi dira json fitxategian.");
        }
    }
}


