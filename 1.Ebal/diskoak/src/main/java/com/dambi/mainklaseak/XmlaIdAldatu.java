package com.dambi.mainklaseak;

import com.dambi.atzipenekoak.Xmla;
import com.dambi.pojoak.Diskoa;
import com.dambi.pojoak.Diskoak;

public class XmlaIdAldatu {
    public static void main(String[] args) {
    
        Diskoak diskoak = new Diskoak();
        Diskoak diskobatsortu = new Diskoak();

        Xmla xmla = new Xmla("data/diskobatsortu.xml","data/diskobatsortu.xml");

        diskoak = xmla.irakurri();

        if (diskoak != null) {
            for (Diskoa d : diskoak.getDiskoak()) {
                int idBarria = 344;
                int id = d.getId();
                if (id != idBarria) {
                    id = idBarria;
                    d.setId(id);
                    diskobatsortu.add(d);
                }
            }
            System.out.println(xmla.idatzi(diskobatsortu)+" disko idatzi dira xml fitxategian.");
        }
    }
}

               