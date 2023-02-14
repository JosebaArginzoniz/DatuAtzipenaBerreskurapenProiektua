package com.dambi.ariketa;

import java.util.Scanner;

import com.dambi.atzipenekoak.Jsona;
import com.dambi.pojoak.Diskoa;
import com.dambi.pojoak.Diskoak;

public class TaldeBatenDiskoenIraupenarenBatezbestekoa {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Zein Taldearen Diskoen Iraupenaren Batezbestekoa nahi duzu kalkulatu?");
        String taldea = in.nextLine(); 
        in.close();
        float iraupenarenBatezbestekoa = aurkituTaldea(taldea);
        if (iraupenarenBatezbestekoa == -1) {
            System.out.println(taldea +" taldea ez da existitzen");
        }
        else {
            System.out.println(taldea + " taldearen diskoen iraupenaren batezbestekoa " + iraupenarenBatezbestekoa + " minutukoa da");
        }       
    }
    public static float aurkituTaldea(String taldea){
        Jsona jsona = new Jsona("data/diskoak.json");
        Diskoak diskoak = new Diskoak();
        diskoak = jsona.irakurri();
        float batezbestekoa = 0;
        float batuketa = 0;
        int kont = 0;
        if (diskoak != null) {
            for (Diskoa d : diskoak.getDiskoak()) {
                if (d.getTaldea().equals(taldea)) {
                    batuketa = batuketa + (float)d.getIraupena();
                    kont++;
                }
            }
        }
        if (kont != 0) {
            batezbestekoa = batuketa / kont;
        }
        else{
            batezbestekoa = -1;
        }
        return batezbestekoa;   
    }
}
