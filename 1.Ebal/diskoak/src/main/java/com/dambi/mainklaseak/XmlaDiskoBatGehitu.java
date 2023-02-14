package com.dambi.mainklaseak;

import java.io.File;

import com.dambi.atzipenekoak.Xmla;
import com.dambi.pojoak.Diskoa;
import com.dambi.pojoak.Diskoak;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class XmlaDiskoBatGehitu {
    public static void main( String[] args )
    {
        try
        {
            Diskoak diskoak = new Diskoak();
            Diskoa eskorbuto = new Diskoa();

            Xmla xmla = new Xmla("data/diskoak.xmla");

            diskoak = xmla.irakurri();

            if (diskoak != null) {
                for (Diskoa d : diskoak.getDiskoak()) {
                
                    //"taldea", "izena", "urtea", "formatoa","urtea", "formatoa", "iraupena", "prezioa", "disketxea","mediaCondition" 

                    /* init very simple data to marshal */
                    /*
                    Beti Mugan; Oreka Desorekan; 1993; Long Play; 53.30; 27.6; Soinua; Very Good
                    */

                    eskorbuto.setId(d.getId()+1);
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
                    JAXBContext jaxbContext = JAXBContext.newInstance( Diskoa.class );
                    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                    /* set this flag to true to format the output */
                    jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

                    /* marshaling of java objects in xml (output to file and standard output) */
                    jaxbMarshaller.marshal( eskorbuto, new File( "data/diskobatgehituta.xml" ) );
                    }

            }
        }
        catch( JAXBException e )
        {
            e.printStackTrace();
        }

    }
}
