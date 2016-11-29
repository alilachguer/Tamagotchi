package application;

public class Tamagotchi {
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
	
	public Tamagotchi(Caracteristique caracteristique){
		this.nom = caracteristique.getNom();
		this.race = caracteristique.getRace();
		this.age = caracteristique.getAge();
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
	
}
