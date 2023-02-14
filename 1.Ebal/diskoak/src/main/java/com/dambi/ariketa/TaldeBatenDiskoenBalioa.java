package com.dambi.ariketa;

import java.util.List;
import java.util.Scanner;
import java.util.function.ToDoubleBiFunction;

import com.dambi.atzipenekoak.Jsona;
import com.dambi.pojoak.Diskoa;
import com.dambi.pojoak.Diskoak;

public class TaldeBatenDiskoenBalioa {            
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Zein Taldearen Diskoen kolekzioaren prezio totala nahi duzu kalkulatu?");
        String taldea = in.nextLine(); 
        in.close();
        float kolekzioarenBalioa = aurkituTaldea(taldea);
        if (kolekzioarenBalioa == -1) {
            System.out.println(taldea +" taldea ez da existitzen");
        }
        else {
            System.out.println(taldea + " taldearen diskoen prezio totala " + kolekzioarenBalioa + " minutukoa da");
        }       
    }
    public static float aurkituTaldea(String taldea){
        Jsona jsona = new Jsona("data/diskoak.json");
        Diskoak diskoak = new Diskoak();
        diskoak = jsona.irakurri();
        float kolekzioarenBalioa = 0;
        if (diskoak != null) {
            for (Diskoa d : diskoak.getDiskoak()) {
                if (d.getTaldea().equals(taldea)) {
                    kolekzioarenBalioa = kolekzioarenBalioa + (float)d.getPrezioa();
                }
            }
        }
        
        return kolekzioarenBalioa;   
    }
}
