package dambi.accessingmongodiskografia.model;

import java.util.List;

import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Diskoa {
	
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
	

}
