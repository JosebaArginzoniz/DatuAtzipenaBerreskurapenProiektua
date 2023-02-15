package com.dambi.ariketa;

import java.util.List;
import java.util.Scanner;
import java.util.function.ToDoubleBiFunction;

import com.dambi.atzipenekoak.Jsona;
import com.dambi.pojoak.Diskoa;
import com.dambi.pojoak.Diskoak;

public class TaldeBirenDiskoenBalioa {            
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Zein Taldeen Diskoen kolekzioaren prezio totala nahi duzu kalkulatu?");
        String taldea = in.nextLine(); 
        System.out.println("Sartu 2. taldea");
        String taldea2 = in.nextLine(); 
 
        in.close();
        
        float kolekzioarenBalioa = aurkituTaldea(taldea, taldea2);
        if (kolekzioarenBalioa == -1) {
            System.out.println(taldea +" taldea ez da existitzen");
            System.out.println(taldea2 +" taldea ez da existitzen");
        }
        else {
            System.out.println(taldea + " eta " + taldea2 + " taldeen diskoen prezio totala " + kolekzioarenBalioa + " eurokoa da");
        }       
    }
    public static float aurkituTaldea(String taldea, String taldea2){
        Jsona jsona = new Jsona("data/diskoak.json");
        Diskoak diskoak = new Diskoak();
        diskoak = jsona.irakurri();
        float kolekzioarenBalioa = 0;
        float kolekzioarenBalioa1 = 0;
        float kolekzioarenBalioa2 = 0;
        float kolekzioarenBalioa3 = 0;
        float kolekzioarenBalioa4 = 0;

        if (diskoak != null) {
            for (Diskoa d : diskoak.getDiskoak()) {
                if (d.getTaldea().equals(taldea)) {
                    kolekzioarenBalioa1 = (kolekzioarenBalioa1 + (float)d.getPrezioa());
                    kolekzioarenBalioa2 = kolekzioarenBalioa1;
                }
            }
            
            for (Diskoa d2 : diskoak.getDiskoak()) {
                if (d2.getTaldea().equals(taldea2)) {
                    kolekzioarenBalioa3 = (kolekzioarenBalioa3 + (float)d2.getPrezioa());
                    kolekzioarenBalioa4 = kolekzioarenBalioa3;

                }
            }
            kolekzioarenBalioa = kolekzioarenBalioa1 + kolekzioarenBalioa3;
        }
        return kolekzioarenBalioa;   
    }
}
