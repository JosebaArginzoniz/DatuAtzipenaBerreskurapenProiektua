package com.dambi.pojoak;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "Diskoak" )
public class Diskoak
{
    List<Diskoa> diskoak;

    public List<Diskoa> getDiskoak()
    {
        return diskoak;
    }

    /**
     * element that is going to be marshaled in the xml
     */
    @XmlElement( name = "Diskoa" )
    public void setDiskoak( List<Diskoa> diskoak )
    {
        this.diskoak = diskoak;
    }
    
    /**
     * This method is not used by jaxb, just used for business reasons. In the case that this class
     * would be generated using xml schemas definitions, this method has to be added to the
     * generated class or to some helper or util one
     * 
     * @param Diskoa
     */
    public void add( Diskoa diskoa )
    {
        if( this.diskoak == null )
        {
            this.diskoak = new ArrayList<Diskoa>();
        }
        this.diskoak.add( diskoa );

    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Diskoa d : this.diskoak) {
            str.append(d.toString());
            str.append("\n");
        }
        return str.toString();
    }
}
