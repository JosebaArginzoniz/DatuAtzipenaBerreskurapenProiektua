package com.dambi.ariketa;

import jakarta.xml.bind.annotation.XmlElement;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlType( propOrder = {"taldea", ""} )
@XmlRootElement( name = "Taldea" )

public class Taldea 
{
    int id = 0;
    String taldea;

    public int getId(){
       return id;
    }

    @XmlAttribute(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    

    
    @Override
    public String toString() {
        return "Diskoa["+ id + "," + taldea +  "," +     + "]";
    }

}
