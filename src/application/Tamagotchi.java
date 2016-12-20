package application;

import java.util.TimerTask;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Tamagotchi extends TimerTask{
	private IntegerProperty proprete;
	private IntegerProperty bonheur;
	private IntegerProperty sommeil;
	private IntegerProperty appetit;
	private IntegerProperty sante;
	private String nom;
	private String race;
	private int age;

	public Tamagotchi(){
		this.sante = new SimpleIntegerProperty(100);
		this.proprete = new SimpleIntegerProperty(100);
		this.bonheur = new SimpleIntegerProperty(100);
		this.sommeil = new SimpleIntegerProperty(100);
		this.appetit = new SimpleIntegerProperty(100);
	}

	@Override
	public void run() {
		
		Platform.runLater(() -> {
			this.setProprete(this.getProprete() - 2);
			this.setBonheur(this.getBonheur() - 2);
			this.setSommeil(this.getSommeil() - 2);
			this.setAppetit(this.getAppetit() - 2);
			diminuerSante();
        });
		
		
		System.out.println(Main.tama.getSante());
	}

	public Tamagotchi(Caracteristique caracteristique){
		this.nom = caracteristique.getNom();
		this.race = caracteristique.getRace();
		this.age = caracteristique.getAge();
		this.sante = new SimpleIntegerProperty(100);
		this.proprete = new SimpleIntegerProperty(100);
		this.bonheur = new SimpleIntegerProperty(100);
		this.sommeil = new SimpleIntegerProperty(100);
		this.appetit = new SimpleIntegerProperty(100);
	}
	
	public IntegerProperty santeProperty(){
		return sante;
	}
	public IntegerProperty propreteProperty(){
		return proprete;
	}
	
	public IntegerProperty bonheurProperty(){
		return bonheur;
	}
	
	public IntegerProperty sommeilProperty(){
		return sommeil;
	}
	
	public IntegerProperty appetitProperty(){
		return appetit;
	}
	
	public int getSante() {
		return sante.get();
	}
	
	public void setSante(int sante) {
		this.sante.set(sante);
	}

	public int getProprete() {
		return proprete.get();
	}

	public int getBonheur() {
		return bonheur.get();
	}

	public int getSommeil() {
		return sommeil.get();
	}

	public int getAppetit() {
		return appetit.get();
	}
	
	public void setProprete(int proprete) {
		this.proprete.set(proprete);
	}

	public void setBonheur(int bonheur) {
		this.bonheur.set(bonheur);
	}

	public void setSommeil(int sommeil) {
		this.sommeil.set(sommeil);
	}

	public void setAppetit(int appetit) {
		this.appetit.set(appetit);
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
		if (this.getAppetit() < 100) {
			this.setAppetit(this.getAppetit() + 10); 
		}
		if (this.getAppetit() >= 130) {
			this.setSante(this.getSante() - 1);
		}
	}
	
	public void soigner(){
		if (this.getSante() < 100) {
			this.setSante(this.getSante() + 10);
		}
		if (this.getSante() >= 100) {
			this.setSante(100);
		}
	}
	
	public void divertir(){
		this.setBonheur(this.getBonheur() + 10);
	}
	
	public void dormir(){
		if (this.getSommeil() < 100) {
			this.setSommeil(this.getSommeil() + 10);
		}
		if (this.getSommeil() >= 150) {
			this.setSante(this.getSante() - 2);
		}
	}
	
	public void laver(){
		if (this.getProprete() < 100) {
			this.setProprete(this.getProprete() + 10);
		}
		if (this.getProprete() > 100) {
			this.setSante(this.getSante() - 1);
		}
	}
	
	public void diminuerSante(){
		if (this.getAppetit() <= 20 )
			this.setSante(this.getSante() - 3);
		if(this.getProprete() <= 20)
			this.setSante(this.getSante() - 1);
		if(this.getBonheur() <= 20)
			this.setSante(this.getSante() - 1);
		if(this.getSommeil() <= 20)
			this.setSante(this.getSante() - 2);
	}
	
}