package application;

import java.util.TimerTask;

import javafx.beans.InvalidationListener;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class Tamagotchi extends TimerTask{
	private int proprete;
	private int bonheur;
	private int sommeil;
	private int appetit;
	private IntegerProperty sante;
	private String nom;
	private String race;
	private int age;
	private int s;
	
	public Tamagotchi(){
		this.proprete = this.bonheur = this.sommeil = this.appetit = this.s = 100;
		sante = new SimpleIntegerProperty(100);
	}

	@Override
	public void run() {
		this.proprete -= 5;
		this.bonheur -= 5;
		this.sommeil -= 5;
		this.appetit -= 5;
		this.sante = new SimpleIntegerProperty(s);
		this.s += 1;
		//diminuerSante();
		//this.sante.bind(this.sante.add(1));
	}

	public Tamagotchi(Caracteristique caracteristique){
		this.nom = caracteristique.getNom();
		this.race = caracteristique.getRace();
		this.age = caracteristique.getAge();
		this.proprete = this.bonheur = this.sommeil = this.appetit = this.s = 100;
		sante = new SimpleIntegerProperty(s);
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}
	
	public int getSante() {
		return sante.get();
	}
	
	public IntegerProperty santeProperty(){
		return sante;
	}
	
	public void setSante(int sante) {
		this.sante.set(sante);
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
	
	public void setProprete(int proprete) {
		this.proprete = proprete;
	}

	public void setBonheur(int bonheur) {
		this.bonheur = bonheur;
	}

	public void setSommeil(int sommeil) {
		this.sommeil = sommeil;
	}

	public void setAppetit(int appetit) {
		this.appetit = appetit;
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
		this.appetit = this.getAppetit() + 10;
	}
	
	public void soigner(){
		this.s = this.getS() + 10;
	}
	
	public void divertir(){
		this.bonheur = this.getBonheur() + 10;
	}
	
	public void dormir(){
		this.sommeil = this.getSommeil() + 10;
	}
	
	public void laver(){
		this.proprete = this.getProprete() + 10;
	}
	
	public void diminuerSante(){
		if (this.appetit <= 20 )
			this.s = this.getS() - 3;
		if(this.proprete <= 20)
			this.s = this.getS() -1;
		if(this.bonheur <= 20)
			this.s = this.getS() -1;
		if(this.sommeil <= 20)
			this.s = this.getS() -2;
	}
	
}
