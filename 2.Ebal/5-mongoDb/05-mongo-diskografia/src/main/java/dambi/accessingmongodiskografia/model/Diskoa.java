package dambi.accessingmongodiskografia.model;

import java.util.List;

import org.bson.types.ObjectId;

public class Diskoa {
	
	 //private ObjectId id;  //Berdin ei da id zein _id jarri  (Eta eremu hau ez erabiltzea be aukera bat da)

	private int id;
	public String taldea;
	public TaldeDatuak taldeDatuak;
	public String izena;
	public int urtea;
	public String formatoa;
	public float iraupena;
	public float prezioa;
	public String disketxea;
	public String mediaCondition;
	public List<String> abestiak;
	
	@Override
	public String toString() {
		return "Diskoa [izena=" + izena + "]";
	}
	
}
