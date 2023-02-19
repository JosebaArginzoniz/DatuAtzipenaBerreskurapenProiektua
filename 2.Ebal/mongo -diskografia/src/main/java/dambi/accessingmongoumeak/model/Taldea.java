package dambi.accessingmongoumeak.model;

public class Taldea {
     private String izena;
     private String bateria;
     private String baxua;
     private String gitarraSolista;
     private String gitarra;
     private String ahotsa;
 
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
         return "Taldea{" + "izena=" + izena + ", bateria=" + bateria + ", baxua=" + baxua +
                 ", gitarraSolista=" + gitarraSolista + ", gitarra=" + gitarra + ", ahotsa=" + ahotsa + "}";
     }
 }
 