package application;

public class Caracteristique {
	private String nom;
	public static final String CHIEN = "chien", CHAT = "chat", OISEAU = "oiseau";
	private String race;
	
	
	
	public Caracteristique(String nom, String race){
		this.nom = nom;
		this.race = race;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getRace() {
		return race;
	}
	
	
}
