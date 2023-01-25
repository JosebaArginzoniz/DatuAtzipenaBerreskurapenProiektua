package com.dambi.pojoak;

import jakarta.xml.bind.annotation.XmlElement;


import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


@XmlType( propOrder = { "taldea", "izena", "urtea", "formatoa","iraupena", "prezioa", "disketxea","mediaCondition" } )
@XmlRootElement( name = "Diskoa" )

public class Diskoa
{
    int id = 0;
    String taldea;
    String izena;
    int urtea;
    String formatoa;
    float iraupena;
    float prezioa;
    String disketxea;
    String mediaCondition;

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

    //izena
    @XmlElement( name = "izena" )
    public String getIzena()
    {
        return izena;
    }

    public void setIzena( String izena )
    {
        this.izena = izena;
    }

    //urtea
    @XmlElement( name = "urtea" )
    public int getUrtea()
    {
        return urtea;
    }

    public void setUrtea( int urtea )
    {
        this.urtea = urtea;
    }

    //formatoa
    
    @XmlElement( name = "formatoa" )
    public String getFormatoa()
    {
        return formatoa;
    }

    public void setFormatoa( String formatoa )
    {
        this.formatoa = formatoa;
    }
    
    //iraupena
    @XmlElement( name = "iraupena" )
    public float getIraupena()
    {
        return iraupena;
    }

    public void setIraupena( float iraupena )
    {
        this.iraupena = iraupena;
    }

    @XmlElement( name = "prezioa" )
    //prezioa
    public float getPrezioa()
    {
        return prezioa;
    }

    public void setPrezioa( float prezioa )
    {
        this.prezioa = prezioa;
    }

    //disketxea
    @XmlElement( name = "disketxea" )
    public String getDisketxea()
    {
        return disketxea;
    }
    
    public void setDisketxea( String disketxea )
    {
        this.disketxea = disketxea;
    }

    //mediaCondition
    @XmlElement( name = "mediaCondition" )
    public String getMediaCondition()
    {
        return mediaCondition;
    }
    
    public void setMediaCondition( String mediaCondition )
    {
        this.mediaCondition = mediaCondition;
    }

    @Override
    public String toString() {
        return "Diskoa["+ id + "," + taldea +  "," + izena + "," + urtea + "," + formatoa + "," + iraupena+ "," + prezioa+ "," + disketxea +  "," + mediaCondition + "]";
    }

}
