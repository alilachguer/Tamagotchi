package application;

public class Caracteristique {
	private String nom;
	public static final String CHIEN = "chien", CHAT = "chat", OISEAU = "oiseau";
	private String race;
	private int age;
	
	
	
	public Caracteristique(String nom, String race, int age){
		this.nom = nom;
		this.race = race;
		this.age = age;
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
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
