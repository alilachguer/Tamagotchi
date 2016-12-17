package application;

import java.util.TimerTask;

public class Tamagotchi extends TimerTask{
	private int proprete;
	private int bonheur;
	private int sommeil;
	private int appetit;
	private int sante;
	private String nom;
	private String race;
	private int age;
	
	public Tamagotchi(){
		this.proprete = this.bonheur = this.sommeil = this.appetit = this.sante = 100;
	}

	@Override
	public void run() {
		this.proprete -= 5;
		this.bonheur -= 5;
		this.sommeil -= 5;
		this.appetit -= 5;
		diminuerSante();
	}

	public Tamagotchi(Caracteristique caracteristique){
		this.nom = caracteristique.getNom();
		this.race = caracteristique.getRace();
		this.age = caracteristique.getAge();
		this.proprete = this.bonheur = this.sommeil = this.appetit = this.sante = 100;
	}

	public int getProprete() {
		return proprete;
	}

	public int getBonheur() {
		return bonheur;
	}

	public int getSommeil() {
		return sommeil;
	}

	public int getAppetit() {
		return appetit;
	}

	public int getSante() {
		return sante;
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

	public void setRace(String race) {
		this.race = race;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void nourir(){
		this.appetit = this.getAppetit() + 20;
	}
	
	public void soigner(){
		this.sante = this.getSante() + 20;
	}
	
	public void divertir(){
		this.bonheur = this.getBonheur() + 20;
	}
	
	public void dormir(){
		this.sommeil = this.getSommeil() + 20;
	}
	
	public void laver(){
		this.proprete = this.getProprete() + 20;
	}
	
	public void diminuerSante(){
		if (this.appetit <= 20 )
			this.sante = this.getSante() - 5;
		if(this.proprete <= 20)
			this.sante = this.getSante() -5;
		if(this.bonheur <= 20)
			this.sante = this.getSante() -5;
		if(this.sommeil <= 20)
			this.sante = this.getSante() -5;
		
		
	}
	
}
