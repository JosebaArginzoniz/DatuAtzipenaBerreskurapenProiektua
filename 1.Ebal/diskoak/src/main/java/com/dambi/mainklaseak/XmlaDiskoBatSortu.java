package com.dambi.mainklaseak;

import java.io.File;

import com.dambi.atzipenekoak.Xmla;
import com.dambi.pojoak.Diskoa;
import com.dambi.pojoak.Diskoak;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

/**
 * Simple example of usage of jaxb marshaling functionalities showing how to
 * manage lists
 * 
 * @author dgutierrez-diez
 */
public class XmlaDiskoBatSortu {

    public static void main(String[] args) {
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
}


                    
