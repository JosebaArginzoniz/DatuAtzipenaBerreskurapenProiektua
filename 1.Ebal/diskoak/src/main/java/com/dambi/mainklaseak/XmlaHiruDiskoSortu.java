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
public class XmlaHiruDiskoSortu {

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
            Diskoa salve = new Diskoa();
            salve.setId(340);
            salve.setTaldea("La Polla Records");
            salve.setIzena("Salve");
            salve.setUrtea(1925);
            salve.setFormatoa("Mariano Goñi");
            salve.setIraupena(56.56f);
            salve.setPrezioa(27.6f);
            salve.setDisketxea("Euskal rock");
            salve.setMediaCondition("QQ");

            Diskoa azkenGudaDantza = new Diskoa();
            azkenGudaDantza.setId(341);
            azkenGudaDantza.setTaldea("Kortatu");
            azkenGudaDantza.setIzena("Aken guda dantza");
            azkenGudaDantza.setUrtea(1988);
            azkenGudaDantza.setFormatoa("Kaki Arkarazo");
            azkenGudaDantza.setIraupena(56.56f);
            azkenGudaDantza.setPrezioa(27.6f);
            azkenGudaDantza.setDisketxea("Euskal rock");
            azkenGudaDantza.setMediaCondition("wwww");

            Diskoa laPatera = new Diskoa();
            laPatera.setId(343);
            laPatera.setTaldea("Marea");
            laPatera.setIzena("La Patera");
            laPatera.setUrtea(1999);
            laPatera.setFormatoa("El Drogas");
            laPatera.setIraupena(56.56f);
            laPatera.setPrezioa(27.6f);
            laPatera.setDisketxea("Euskal rock");
            laPatera.setMediaCondition("tt");

            Diskoak diskoakLista = new Diskoak();
            diskoakLista.add(salve);
            diskoakLista.add(azkenGudaDantza);
            diskoakLista.add(laPatera);

            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance(Diskoak.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal(diskoakLista, new File("data/hirudiskosortu.xml"));
            jaxbMarshaller.marshal(diskoakLista, System.out);
        }
    
        catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
