package com.dambi.mainklaseak;

import java.util.Scanner;

import com.dambi.atzipenekoak.Jsona;
import com.dambi.atzipenekoak.Xmla;
import com.dambi.pojoak.Diskoa;
import com.dambi.pojoak.Diskoak;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.io.IOException;

public class MainMenu {

    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int aukera = 0;
        do {
            System.out.println();
            System.out.println("MENUAREN IZENBURUA");
            System.out.println("====================================");
            System.out.println("1.- Diskoen zerrenda ikusi json artxibo baten");
            System.out.println("2.- 1971 Baino zaharragoak ikusi");
            System.out.println("3.- Ramones taldearen diskoak ikusu");
            System.out.println("4.- 1987-ko diskoak bistaratu");
            System.out.println("5.- Kolekzioaren balioa bistaratu");
            System.out.println("6.- Talde Baten Diskoen Balioa");
            System.out.println("7.- Talde Baten Diskoen  Iraupenaren Batezbestekoa");
            System.out.println("8.- Talde Biren Diskoen Balioa");
            System.out.println("9.- Diskoen zerrenda ikusi xml artxibo baten");
            System.out.println("10.- Json-etik Xml-ra");
            System.out.println("11.- Xml-tik Json-era");
            System.out.println("12.- Xml-tik disko bat sortu");
            System.out.println("13.- Prezioa hamar eurotan gutxitu");
            System.out.println("14.- Irten");
            System.out.println("");
            System.out.print("Aukeratu zenbaki bat: ");
            aukera = in.nextInt();
            switch (aukera) {
                case 1:
                    jsonaDiskoakInprimatu();
                    break;
                case 2:
                    json1971BainoDiskoZaharragoak();
                    break;
                case 3:
                    jsonRamones();
                    break;
                case 4:
                    json1987koDiskoak();
                    break;
                case 5:
                    kolekzioarenBalioa();
                    break;
                case 6:
                    taldeBatenDiskoenBalioa();
                    break;
                case 7:
                    taldeBatenDiskoenIraupenarenBatezbestekoa();
                    break;
                case 8:
                    taldeBirenDiskoenBalioa();
                    break;
                case 9:
                    xmlaDiskoakInprimatu();
                    break;
                case 10:
                    jsonetikXmlra();
                    break;
                case 11:
                    xmltikJsonera();
                    break;
                case 12:
                    xmltikDiskoBatSortu();
                case 13:
                    prezioaHamarEurotanGutxitu();
                    break;    
                case 14:
                    System.out.println("Eskerrik asko programa hau erabiltzeagatik.");
                    break;
                default:
                    System.out.println("Aukera okerra. Saiatu berriz.");
            }
        } while (aukera != 10);
        in.next();
    }

    private static void jsonaDiskoakInprimatu() throws IOException{
        Diskoak diskoak = new Diskoak();
        Jsona jsona= new Jsona("data/diskoak.json");
        diskoak = jsona.irakurri();
            if (diskoak != null) {
                System.out.println(jsona.strFileIn + " fitxategian disko hauek daude: ");
                System.out.println(diskoak);
            }
    }

    private static void json1971BainoDiskoZaharragoak() throws IOException{
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
    
    private static void jsonRamones() throws IOException{
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
    private static void json1987koDiskoak() throws IOException{
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
    private static void kolekzioarenBalioa() throws IOException{
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
    private static void taldeBatenDiskoenBalioa() throws IOException{
        Scanner in = new Scanner(System.in);
        System.out.println("Zein Taldeen Diskoen kolekzioaren prezio totala nahi duzu kalkulatu?");
        String taldea = in.nextLine(); 
 
        in.close();
        
        float kolekzioarenBalioa = aurkituTaldea(taldea);
        if (kolekzioarenBalioa == -1) {
            System.out.println(taldea +" taldea ez da existitzen");
        }
        else {
            System.out.println(taldea + " taldearen diskoen prezio totala " + kolekzioarenBalioa + " eurokoa da");
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
                        kolekzioarenBalioa = (kolekzioarenBalioa + (float)d.getPrezioa());
                    }
                }
            }
            return kolekzioarenBalioa;   
        }

    private static void taldeBatenDiskoenIraupenarenBatezbestekoa() throws IOException{
        Scanner in = new Scanner(System.in);
        System.out.println("Zein Taldearen Diskoen Iraupenaren Batezbestekoa nahi duzu kalkulatu?");
        String taldea = in.nextLine(); 
        in.close();
        float iraupenarenBatezbestekoa = aurkituTaldea2(taldea);
        if (iraupenarenBatezbestekoa == -1) {
            System.out.println(taldea +" taldea ez da existitzen");
        }
        else {
            System.out.println(taldea + " taldearen diskoen iraupenaren batezbestekoa " + iraupenarenBatezbestekoa + " minutukoa da");
        }       
    }
        public static float aurkituTaldea2 (String taldea){
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
    private static void taldeBirenDiskoenBalioa() throws IOException{
        Scanner in = new Scanner(System.in);
        System.out.println("Zein Taldeen Diskoen kolekzioaren prezio totala nahi duzu kalkulatu?");
        String taldea = in.nextLine(); 
        System.out.println("Sartu 2. taldea");
        String taldea2 = in.nextLine(); 

        in.close();
        
        float kolekzioarenBalioa = aurkituTaldea3(taldea, taldea2);
        if (kolekzioarenBalioa == -1) {
            System.out.println(taldea +" taldea ez da existitzen");
            System.out.println(taldea2 +" taldea ez da existitzen");
        }
        else {
            System.out.println(taldea + " eta " + taldea2 + " taldeen diskoen prezio totala " + kolekzioarenBalioa + " eurokoa da");
        }   
    }    
        public static float aurkituTaldea3(String taldea, String taldea2){
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
        
    private static void xmlaDiskoakInprimatu() throws IOException{
        Diskoak diskoak = new Diskoak();
        Jsona jsona= new Jsona("data/diskoak.json");
        diskoak = jsona.irakurri();
            if (diskoak != null) {
                System.out.println(jsona.strFileIn + " fitxategian disko hauek daude: ");
                System.out.println(diskoak);
            }
    }     
    
    public static void jsonetikXmlra() throws IOException{
        Diskoak diskoak = new Diskoak();
        Diskoak taldea = new Diskoak();

        
        Jsona jsona = new Jsona("data/diskoak.json");
        diskoak = jsona.irakurri();

        Xmla xmla = new Xmla("", "data/diskoakkk.xml");
        System.out.println(xmla.idatzi(diskoak)+" disko idatzi dira xml fitxategian.");
    }

    public static void xmltikJsonera() throws IOException{
        Diskoak diskoak = new Diskoak();

        Xmla xmla = new Xmla("data/diskoakkk.xml");   
        diskoak = xmla.irakurri();

        Jsona jsona = new Jsona("","data/diskoakkk.json");

       System.out.println(jsona.idatzi(diskoak)+" disko idatzi dira json fitxategian.");
    }

    public static void xmltikDiskoBatSortu() throws IOException{
        try {
            /* init a list with a couple of diskoak to marshal */
            //"taldea", "izena", "urtea", "formatoa","data", "prezioa", "disketxea","mediaCondition" 
            

            /*
            * La Polla Records; Salve; 45; Mariano Goñi; 39,23; 22,5; Euskal rock
            * Kortatu; Azken guda dantza; 90; Kaki Arkarazo; 96,7; 53,7; Euskal rock
            * Barricada; Barrio conflictivo; 45; Rosendo Mercado; 45,50; 34; Euskal rock
            * Marea; La Patera; 1999; El Drogas; 49.44; 34; Euskal rock
            */
            
            Diskoa eskorbuto = new Diskoa();
                eskorbuto.setId(343);
                eskorbuto.setTaldea("Eskorbuto");
                eskorbuto.setIzena("Anti-todo");
                eskorbuto.setUrtea(1983);
                eskorbuto.setFormatoa("Long Play");
                eskorbuto.setIraupena(37.84f);
                eskorbuto.setPrezioa(127.6f);
                eskorbuto.setDisketxea("Spansuls");
                eskorbuto.setMediaCondition("Very Good +");

            Diskoak diskoakLista = new Diskoak();
            diskoakLista.add(eskorbuto);
            

            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance(Diskoak.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal(diskoakLista, new File("data/diskobatsortu.xml"));
            jaxbMarshaller.marshal(diskoakLista, System.out);
        }
    
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void prezioaHamarEurotanGutxitu() throws IOException{
        Diskoak diskoak = new Diskoak();
        Diskoak dtoa = new Diskoak();

        Jsona jsona = new Jsona("data/diskoak.json","data/diskoakdeskontuarekin.json");

        diskoak = jsona.irakurri();

        if (diskoak != null) {
            for (Diskoa d : diskoak.getDiskoak()) {
                float kenHammar = 10;
                float prezioa = d.getPrezioa();
                if (prezioa >= 0) {
                    prezioa = prezioa - kenHammar;
                    d.setPrezioa(prezioa);
                    dtoa.add(d);      
                }  
            } 
            System.out.println(jsona.idatzi(dtoa)+" disko idatzi dira json fitxategian.");
        }
    }
    
}
