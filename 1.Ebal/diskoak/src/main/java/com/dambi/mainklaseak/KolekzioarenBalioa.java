package com.dambi.mainklaseak;

import com.dambi.atzipenekoak.Jsona;
import com.dambi.pojoak.Diskoa;
import com.dambi.pojoak.Diskoak;

public class KolekzioarenBalioa {
    public static void main(String[] args) {
    
        Diskoak diskoak = new Diskoak();

        Jsona jsona = new Jsona("data/diskoak.json");

        diskoak = jsona.irakurri();
        float kolekzioarenBalioak = 0;

        if (diskoak != null) {
            for (Diskoa d : diskoak.getDiskoak()) {
                float diskoBatenPrezioa = d.getPrezioa();

                kolekzioarenBalioak = kolekzioarenBalioak + diskoBatenPrezioa;
                
            }
            System.out.println("Kolekzio osoaren balioa " + kolekzioarenBalioak + "  eurokoa da.");
        }
    }
}
