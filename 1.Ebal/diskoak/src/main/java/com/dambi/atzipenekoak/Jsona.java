package com.dambi.atzipenekoak;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

import com.dambi.pojoak.Diskoa;
import com.dambi.pojoak.Diskoak;

public class Jsona {

    public String strFileIn;
    public String strFileOut;

    /**
     * Konstruktoreak parametro bakarra jasotzen badu,
     * sarrera fitxategiaren izena jaso dugula suposatuko dugu.
     */
    public Jsona(String strFile) {
        this.strFileIn = strFile;
    }

    /**
     * Konstruktoreak parametro bi jasotzen baditu,
     * lehengoa, sarrera fitxategiaren izena dela eta bigarrena irteerakoarena
     * direla suposatuko dugu.
     * Sarrera fitxategirik erabiliko ez badugu, kate hutsa erabiliko dugu lehen
     * parametro moduan.
     */
    public Jsona(String strFileIn, String strFileOut) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    /** Osatu ezazu metodo hau
    *
    */	 

    //"id","taldea", "izena", "urtea", "formatoa","data", "prezioa", "disketxea","mediaCondition" 


    public Diskoak irakurri() {
        Diskoak diskoak = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jsonst = reader.read();
            JsonArray jsonarray = jsonst.asJsonArray();
            diskoak = new Diskoak();

            for (int i = 0; i < jsonarray.size(); i++) {
                JsonObject jsonobj = jsonarray.getJsonObject(i);
                Diskoa diskoa = new Diskoa();

                diskoa.setId(jsonobj.getInt("id"));
                diskoa.setTaldea(jsonobj.getString("taldea"));
                diskoa.setIzena(jsonobj.getString("izena"));
                diskoa.setUrtea(jsonobj.getInt("urtea"));
                diskoa.setFormatoa(jsonobj.getString("formatoa"));
                diskoa.setIraupena(jsonobj.getInt("iraupena"));
                diskoa.setPrezioa(jsonobj.getInt("prezioa"));
                diskoa.setDisketxea(jsonobj.getString("disketxea"));
                diskoa.setMediaCondition(jsonobj.getString("mediaCondition"));
                diskoak.add(diskoa);
            }
            
        } catch (Exception e) {
            System.out.println("Arazoak " + strFileIn + " fitxategia irakurtzerakoan.");
        }

        return diskoak;
    }

    public int idatzi(Diskoak diskoak) {
        int diskoKopurua = 0;
        JsonArray model = null;
        JsonArrayBuilder jab = Json.createArrayBuilder();

        for (Diskoa d : diskoak.getDiskoak()) {
            jab.add(Json.createObjectBuilder()
                .add("id", d.getId())
                .add("taldea", d.getTaldea())
                .add("izena", d.getIzena())
                .add("urtea", d.getUrtea())
                .add("formatoa", d.getFormatoa())
                .add("iraupena",d.getIraupena())
                .add("prezioa", d.getPrezioa())
                .add("disketxea",d.getDisketxea())
                .add("mediaCondition",d.getMediaCondition())
                .build());
            diskoKopurua++;
        }
        model=jab.build();

        try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream(strFileOut))) {
            jsonWriter.writeArray(model);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Fitxategia sortzerakoan arazoak.");
        }
        return diskoKopurua;

    }
}
