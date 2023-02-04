package com.dambi.mainklaseak;

import com.dambi.atzipenekoak.Jsona;
import com.dambi.pojoak.Diskoa;
import com.dambi.pojoak.Diskoak;

public class Json1987koDiskoak {
    
    public static void main(String[] args) {
    
        Diskoak diskoak = new Diskoak();
        Diskoak diskoak1987 = new Diskoak();

        Jsona jsona = new Jsona("data/diskoak.json","data/diskoak1987.json");

        diskoak = jsona.irakurri();

        if (diskoak != null) {
            for (Diskoa d : diskoak.getDiskoak()) {
                int urtea = 1987;
                int topatutakoUrtea = d.getUrtea();
                if (topatutakoUrtea == urtea) {
                    diskoak1987.add(d);
                }
            }
            System.out.println(jsona.idatzi(diskoak1987)+" disko idatzi dira json fitxategian.");
        }
    }
}

           