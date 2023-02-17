package dambi.accessingmongodiskografia.model;

public class Taldea {
   	public String izena;
	public String bateria;
	public String baxua;
	public String gitarraSolista;
	public String gitarra;
	public String ahotsa;

   public Taldea(String izena, String bateria, String baxua, String gitarraSolista, String gitarra, String ahotsa) {
		this.izena = izena;
		this.bateria = bateria;
		this.baxua = baxua;
		this.gitarraSolista = gitarraSolista;
		this.gitarra = gitarra;
		this.ahotsa = ahotsa;
	}

	public String getIzena() {
		return izena;
	}

	public void setIzena(String izena) {
		this.izena = izena;
	}

	public String getBateria() {
		return bateria;
	}

	public void setBateria(String bateria) {
		this.bateria = bateria;
	}

	public String getBaxua() {
		return baxua;
	}

	public void setBaxua(String baxua) {
		this.baxua = baxua;
	}

	public String getGitarraSolista() {
		return gitarraSolista;
	}

	public void setGitarraSolista(String gitarraSolista) {
		this.gitarraSolista = gitarraSolista;
	}

	public String getGitarra() {
		return gitarra;
	}

	public void setGitarra(String gitarra) {
		this.gitarra = gitarra;
	}

	public String getAhotsa() {
		return ahotsa;
	}

	public void setAhotsa(String ahotsa) {
		this.ahotsa = ahotsa;
	}

	@Override
	public String toString() {
		return "Taldea [izena=" + izena + ", bateria=" + bateria + ", baxua=" + baxua + ", gitarraSolista="
				+ gitarraSolista + ", gitarra=" + gitarra + ", ahotsa=" + ahotsa + "]";
	}
}