package dambi.accessingmongodiskografia.model;

import java.util.List;

public class Diskoa {
	
	private int id;
	public Taldea taldea;
	public String izena;
	public int urtea;
	public String formatoa;
	public float iraupena;
	public float prezioa;
	public String disketxea;
	public String mediaCondition;
	public List<String> abestiak;
	
	// Getters
	public int getId() {
    return id;
	}

	public Taldea getTaldea() {
		return taldea;
	}

	public String getIzena() {
		return izena;
	}

	public int getUrtea() {
		return urtea;
	}

	public String getFormatoa() {
		return formatoa;
	}

	public float getIraupena() {
		return iraupena;
	}

	public float getPrezioa() {
		return prezioa;
	}

	public String getDisketxea() {
		return disketxea;
	}

	public String getMediaCondition() {
		return mediaCondition;
	}

	public List<String> getAbestiak() {
		return abestiak;
	}

	// Setters
	public void setId(int id) {
		this.id = id;
	}

	public void setTaldea (Taldea taldea) {
		this.taldea = taldea;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public void setUrtea(int urtea) {
		this.urtea = urtea;
	}

	public void setFormatoa(String formatoa) {
		this.formatoa = formatoa;
	}

	public void setIraupena(float iraupena) {
		this.iraupena = iraupena;
	}

	public void setPrezioa(float prezioa) {
		this.prezioa = prezioa;
	}

	public void setDisketxea(String disketxea) {
		this.disketxea = disketxea;
	}

	public void setMediaCondition(String mediaCondition) {
		this.mediaCondition = mediaCondition;
	}

	public void setAbestiak(List<String> abestiak) {
		this.abestiak = abestiak;
	}
	public String toString() {
		return "Diskoa [id=" + id + ", taldea=" + taldea + ", izena=" + izena + ", urtea=" + urtea + ", formatoa="
				+ formatoa + ", iraupena=" + iraupena + ", prezioa=" + prezioa + ", disketxea=" + disketxea
				+ ", mediaCondition=" + mediaCondition + ", abestiak=" + abestiak + "]";
	}

}