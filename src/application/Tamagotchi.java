package application;

import java.util.TimerTask;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Tamagotchi extends TimerTask{
	private IntegerProperty proprete;
	private IntegerProperty bonheur;
	private IntegerProperty sommeil;
	private IntegerProperty appetit;
	private IntegerProperty sante;
	private StringProperty nom;
	private StringProperty race;
	private IntegerProperty age;
	public static final String CHIEN = "chien", CHAT = "chat", OISEAU = "oiseau";

	public Tamagotchi(String nom, String race, int age, int sante, int proprete, int bonheur, int sommeil, int appetit){
		this.nom = new SimpleStringProperty(nom);
		this.race = new SimpleStringProperty(race);
		this.age = new SimpleIntegerProperty(age);
		this.sante = new SimpleIntegerProperty(sante);
		this.proprete = new SimpleIntegerProperty(proprete);
		this.bonheur = new SimpleIntegerProperty(bonheur);
		this.sommeil = new SimpleIntegerProperty(sommeil);
		this.appetit = new SimpleIntegerProperty(appetit);
	}

	@Override
	public void run() {
		Platform.runLater(() -> {
			this.setProprete(this.getProprete() - 1);
			this.setBonheur(this.getBonheur() - 1);
			this.setSommeil(this.getSommeil() - 2);
			this.setAppetit(this.getAppetit() - 2);
			changerStatutSante();
        });
		
		this.setAge(this.getAge() + 1);
	}

	public Tamagotchi(String nom, String race){
		this.nom = new SimpleStringProperty(nom);
		this.race = new SimpleStringProperty(race);
		this.age = new SimpleIntegerProperty(0);
		this.sante = new SimpleIntegerProperty(100);
		this.proprete = new SimpleIntegerProperty(100);
		this.bonheur = new SimpleIntegerProperty(100);
		this.sommeil = new SimpleIntegerProperty(100);
		this.appetit = new SimpleIntegerProperty(100);
	}
	
	public Tamagotchi(String nom){
		this.nom = new SimpleStringProperty(nom);
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
	
	public IntegerProperty ageProperty(){
		return age;
	}
	
	public StringProperty nomProperty(){
		return nom;
	}
	
	public StringProperty raceProperty(){
		return race;
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
		return nom.get();
	}
	public void setNom(String nom) {
		this.nom.set(nom);
	}
	public String getRace() {
		return race.get();
	}
	
	public void setRace(String race) {
		this.race.set(race);
	}

	public int getAge() {
		return age.get();
	}

	public void setAge(int age) {
		this.age.set(age);
	}

	public void nourir(){
		if (this.getAppetit() < 100) {
			this.setAppetit(this.getAppetit() + 20); 
		}
		if (this.getAppetit() >= 130) {
			this.setSante(this.getSante() - 1);
		}
	}
	
	public void soigner(){
		if (this.getSante() < 100) {
			this.setSante(this.getSante() + 20);
		}
		if (this.getSante() >= 100) {
			this.setSante(100);
		}
	}
	
	public void divertir(){
		if(this.getBonheur() >= 100){
			this.setSommeil(this.getSommeil() - 20);
		}
		this.setBonheur(this.getBonheur() + 20);
	}
	
	public void dormir(){
		if (this.getSommeil() < 100) {
			this.setSommeil(this.getSommeil() + 20);
		}
		if (this.getSommeil() >= 150) {
			this.setSante(this.getSante() - 2);
		}
	}
	
	public void laver(){
		if (this.getProprete() < 100) {
			this.setProprete(this.getProprete() + 20);
		}
		if (this.getProprete() > 100) {
			this.setSante(this.getSante() - 1);
		}
	}
	
	public void changerStatutSante(){
		if (this.getAppetit() <= 20 )
			this.setSante(this.getSante() - 3);
		if(this.getProprete() <= 20)
			this.setSante(this.getSante() - 1);
		if(this.getBonheur() <= 20)
			this.setSante(this.getSante() - 1);
		if(this.getSommeil() <= 20)
			this.setSante(this.getSante() - 2);
	}
	
	public String toString(){
	      return "Tama [ nom: "+ this.getNom() + ", age: " + this.getAge() + ", race: " + this.getRace() + ", sante: "+this.getSante()+" ]";
	   }
}