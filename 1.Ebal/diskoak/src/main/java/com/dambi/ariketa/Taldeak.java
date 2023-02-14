package com.dambi.ariketa;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "Taldeak" )
public class Taldeak
{
    List<Taldea> taldeak;

    public List<Taldea> getTaldeak()
    {
        return taldeak;
    }

    /**
     * element that is going to be marshaled in the xml
     */
    @XmlElement( name = "Taldea" )
    public void setDiskoak( List<Taldea> diskoak )
    {
        this.taldeak = taldeak;
    }
}
