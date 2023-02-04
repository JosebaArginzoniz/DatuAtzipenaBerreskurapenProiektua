package com.dambi.mainklaseak;

import com.dambi.atzipenekoak.Jsona;
import com.dambi.pojoak.Diskoak;

public class JsonaDiskoakInprimatu {
    public static void main(String[] args) {
    
    Diskoak diskoak = new Diskoak();
    Jsona jsona= new Jsona("data/diskoak.json");
    diskoak = jsona.irakurri();
        if (diskoak != null) {
            System.out.println(jsona.strFileIn + " fitxategian disko hauek daude: ");
            System.out.println(diskoak);
        }
    }
}
