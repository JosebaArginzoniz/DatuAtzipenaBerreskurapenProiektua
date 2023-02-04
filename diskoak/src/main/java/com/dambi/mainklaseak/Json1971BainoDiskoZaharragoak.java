package com.dambi.mainklaseak;

import com.dambi.atzipenekoak.Jsona;
import com.dambi.pojoak.Diskoa;
import com.dambi.pojoak.Diskoak;

public class Json1971BainoDiskoZaharragoak {
    
    public static void main(String[] args) {
    
        Diskoak diskoak = new Diskoak();
        Diskoak diskoak1971BainoDiskoZaharragoak = new Diskoak();

        Jsona jsona = new Jsona("data/diskoak.json","data/1971BainoDiskoZaharragoak.json");

        diskoak = jsona.irakurri();

        if (diskoak != null) {
            for (Diskoa d : diskoak.getDiskoak()) {
                int urtea = d.getUrtea();
                int topatutakoUrtea = 1971;
                if (topatutakoUrtea >= urtea) {
                    diskoak1971BainoDiskoZaharragoak.add(d);
                }
            }
            System.out.println(jsona.idatzi(diskoak1971BainoDiskoZaharragoak)+" disko idatzi dira json fitxategian.");
        }
    }
}