package com.dambi.atzipenekoak;

import java.io.File;

import com.dambi.pojoak.Diskoak;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Xmla {

    public String strFileIn;
    public String strFileOut;

    /**
     * Konstruktoreak parametro bakarra jasotzen badu,
     * sarrera fitxategiaren izena jaso dugula suposatuko dugu.
     */
    public Xmla(String strFile) {
        strFileIn = strFile;
    }

    /**
     * Konstruktoreak parametro bi jasotzen baditu,
     * lehengoa, sarrera fitxategiaren izena dela eta bigarrena irteerakoarena
     * direla suposatuko dugu.
     * Sarrera fitxategirik erabiliko ez badugu, kate hutsa erabiliko dugu lehen
     * parametro moduan.
     */
    public Xmla(String strFileIn, String strFileOut) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public Diskoak irakurri() {
        Diskoak diskoak = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Diskoak.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            diskoak = (Diskoak) jaxbUnmarshaller.unmarshal(new File(strFileIn));
        } catch (Exception ex) {
            System.out.println("Arazoren bat " + strFileIn + " irakurtzerakoan.");
        }
        return diskoak;
    }

    public int idatzi(Diskoak diskoak) {
        int diskoKopurua = 0;
        try {

            /* init jaxb marshaler */
            JAXBContext jaxbContext = JAXBContext.newInstance(Diskoak.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            /* set this flag to true to format the output */
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            /* marshaling of java objects in xml (output to file and standard output) */
            jaxbMarshaller.marshal(diskoak, new File(strFileOut));
            // jaxbMarshaller.marshal(diskoak, System.out);
            diskoKopurua = diskoak.getDiskoak().size();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return diskoKopurua;
    }
}
