package com.dambi.ariketa;

import jakarta.xml.bind.annotation.XmlElement;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlType( propOrder = {"taldea", "batezbestekoa"} )
@XmlRootElement( name = "Taldea" )

public class Taldea 
{
    int id = 0;
    String taldea;
    float batezbestekoa;

    public int getId(){
       return id;
    }

    @XmlAttribute(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    //taldea
    @XmlElement( name = "taldea" )
    public String getTaldea()
    {
        return taldea;
    }
    
    public void setTaldea( String taldea )
    {
        this.taldea = taldea;
    }

    //batezbestekoa
    @XmlElement( name = "batezbestekoa" )
    public Float getBatezbestekoa()
    {
        return batezbestekoa;
    }
    
    public void setBatezbestekoa( Float batezbestekoa )
    {
        this.batezbestekoa = batezbestekoa;
    }

    
    @Override
    public String toString() {
        return "Diskoa["+ id + "," + taldea +  "," + batezbestekoa + "]";
    }

}
