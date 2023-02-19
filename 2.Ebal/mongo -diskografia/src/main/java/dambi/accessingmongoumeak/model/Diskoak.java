package dambi.accessingmongoumeak.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Diskoak {
	
	 int id;
	 Taldea taldea;
	 String izena;
	 int urtea;
	 String formatoa;
	 float iraupena;
	 float prezioa;
	 String disketxea;
	 String mediaCondition;
	 List<String> abestiak;

}
