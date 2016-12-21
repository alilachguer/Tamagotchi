package application;

import javafx.animation.Animation;
import javafx.application.Platform;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;

public class JeuController extends TimerTask{
    private static final int WIDTH    = 40;
    private static final int HEIGHT   = 40;
	private static final Image sprite_chien = new Image("/images/sprites/sprite_chien.png");
	private static final Image sprite_chat = new Image("/images/sprites/sprite_chat.png");
	private static final Image sprite_oiseau = new Image("/images/sprites/sprite_oiseau.png");
	private static final Image sprite_bebe = new Image("/images/sprites/sprite_bebe.png");
	private static final Image sprite_oeuf = new Image("/images/sprites/sprite_oeuf.png");
	@FXML private Label life, sante, jnom;
	@FXML private ImageView affichage;
	@FXML private Button laver, soigner, dormir, divertir, nourir;
	private Image sprite;
	private Animation animation;
	
	
	@FXML private void initialize(){
		if (Main.tama.getRace() == Caracteristique.CHIEN)
			sprite = sprite_chien;
		else if (Main.tama.getRace() == Caracteristique.CHAT)
			sprite = sprite_chat;
		else
			sprite = sprite_oiseau;
		
		Timer timer = new Timer();
		timer.schedule(Main.tama, 0, 5*1000);
		Timer default_sprite = new Timer();
		default_sprite.schedule(this, 0, 5*1000);
		
		if (Main.tama.getAge() <= 1) {
			animer(sprite_oeuf, 4, 4, 10, 50, Animation.INDEFINITE);
		}else{
			animer(sprite, 2, 2, 200, 300, Animation.INDEFINITE);
		}
		
		jnom.setText(Main.tama.getNom().substring(0, 4));
		
		Main.tama.santeProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				sante.setText(new Integer(Main.tama.getSante()).toString());
			}
		});
		
		Main.tama.ageProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				if (Main.tama.getAge() >= 10) {
					animer(sprite, 3, 3, 140, 40, Animation.INDEFINITE);
				}
			}
		});
		
		Main.tama.santeProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				if (Main.tama.getAge() >= 10) {
					if (Main.tama.getSante() <= 50) {
						animation.stop();
						animer(sprite, 2, 2, 470, 245, Animation.INDEFINITE);
					}
					if (Main.tama.getSante() <= 30) {
						animation.stop();
						animer(sprite, 2, 2, 470, 205, Animation.INDEFINITE);
					}
					
				}else if (Main.tama.getAge() < 10) {
					if (Main.tama.getSante() <= 50) {
						animation.stop();
						animer(sprite, 2, 2, 470, 245, Animation.INDEFINITE);
					}
					if (Main.tama.getSante() <= 30) {
						animation.stop();
						animer(sprite_bebe, 2, 2, 470, 205, Animation.INDEFINITE);
					}
				}
			}
		});
		
		Main.tama.appetitProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				if (Main.tama.getAge() >= 10) {
					if (Main.tama.getAppetit() <= 80) {
						animation.stop();
						animer(sprite, 2, 2, 280, 90, Animation.INDEFINITE);
					}
					if (Main.tama.getAppetit() <= 50) {
						animation.stop();
						animer(sprite, 2, 2, 280, 162, Animation.INDEFINITE);
					}
				}else if (Main.tama.getAge() < 10) {
					if (Main.tama.getAppetit() <= 80) {
						animation.stop();
						animer(sprite_bebe, 2, 2, 280, 90, Animation.INDEFINITE);
					}
					if (Main.tama.getAppetit() <= 50) {
						animation.stop();
						animer(sprite_bebe, 2, 2, 280, 162, Animation.INDEFINITE);
					}
				}	
			}
		});
		
		Main.tama.bonheurProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				if (Main.tama.getAge() >= 10) {
					if (Main.tama.getBonheur() <= 80) {
						animation.stop();
						animer(sprite, 2, 2, 280, 205, Animation.INDEFINITE);
					}
					if (Main.tama.getBonheur() <= 50) {
						animation.stop();
						animer(sprite, 2, 2, 280, 245, Animation.INDEFINITE);
					}
				}else if (Main.tama.getAge() < 10) {
					if (Main.tama.getBonheur() <= 80) {
						animation.stop();
						animer(sprite_bebe, 2, 2, 280, 205, Animation.INDEFINITE);
					}
					if (Main.tama.getBonheur() <= 50) {
						animation.stop();
						animer(sprite_bebe, 2, 2, 245, 162, Animation.INDEFINITE);
					}
				}	
			}
		});
		
		Main.tama.sommeilProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				if (Main.tama.getAge() >= 10) {
					if (Main.tama.getSommeil() <= 80) {
						animation.stop();
						animer(sprite, 3, 3, 470, 85, Animation.INDEFINITE);
					}
					if (Main.tama.getSommeil() <= 50) {
						animation.stop();
						animer(sprite, 2, 2, 470, 165, Animation.INDEFINITE);
					}
				}else if (Main.tama.getAge() < 10) {
					if (Main.tama.getSommeil() <= 80) {
						animation.stop();
						animer(sprite_bebe, 3, 3, 470, 85, Animation.INDEFINITE);
					}
					if (Main.tama.getSommeil() <= 50) {
						animation.stop();
						animer(sprite_bebe, 2, 2, 470, 165, Animation.INDEFINITE);
					}
				}	
			}
		});
		
		Main.tama.propreteProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				if (Main.tama.getAge() >= 10) {
					if (Main.tama.getProprete() <= 80) {
						animation.stop();
						animer(sprite, 2, 2, 470, 42, Animation.INDEFINITE);
					}
					if (Main.tama.getProprete() <= 50) {
						animation.stop();
						animer(sprite, 2, 2, 470, 0, Animation.INDEFINITE);
					}
				}else if (Main.tama.getAge() < 10) {
					if (Main.tama.getProprete() <= 80) {
						animation.stop();
						animer(sprite_bebe, 2, 2, 470, 42, Animation.INDEFINITE);
					}
					if (Main.tama.getProprete() <= 50) {
						animation.stop();
						animer(sprite_bebe, 2, 2, 470, 0, Animation.INDEFINITE);
					}
				}	
			}
		});
		
		laver.setOnAction(e->{
			Main.tama.laver();
			if (Main.tama.getAge() >= 10){
				animation.stop();
				animer(sprite, 2, 2, 140, 120, Animation.INDEFINITE);
			}else if (Main.tama.getAge() < 10) {
				animation.stop();
				animer(sprite_bebe, 2, 2, 140, 120, Animation.INDEFINITE);
			}
			
		});
		
		dormir.setOnAction(e->{
			Main.tama.dormir();
			if (Main.tama.getAge() < 10) {
				animation.stop();
				animer(sprite_bebe, 2, 2, 465, 122, Animation.INDEFINITE);
			}
			else if (Main.tama.getAge() >= 10){
				animation.stop();
				animer(sprite, 2, 2, 465, 122, Animation.INDEFINITE);
			}
		});
		
		divertir.setOnAction(e->{
			Main.tama.divertir();
			if (Main.tama.getAge() >= 10){
				animation.stop();
				animer(sprite, 2, 2, 140, 85, Animation.INDEFINITE);
			}else if (Main.tama.getAge() < 10) {
				animation.stop();
				animer(sprite_bebe, 2, 2, 140, 85, Animation.INDEFINITE);
			}
		});
		
		nourir.setOnAction(e->{
			Main.tama.nourir();
			if (Main.tama.getAge() >= 10){
				animation.stop();
				animer(sprite, 2, 3, 370, 165, Animation.INDEFINITE);
			}else if (Main.tama.getAge() < 10) {
				animation.stop();
				animer(sprite_bebe, 2, 3, 370, 165, Animation.INDEFINITE);
			}
		});
		
		soigner.setOnAction(e->{
			Main.tama.soigner();
			if (Main.tama.getAge() >= 10){
				animation.stop();
				animer(sprite, 3, 3, 0, 85, Animation.INDEFINITE);
			}else if (Main.tama.getAge() < 10) {
				animation.stop();
				animer(sprite_bebe, 3, 3, 0, 85, Animation.INDEFINITE);
			}
		});
	}


	@Override
	public void run() {
		Platform.runLater(() -> {
			if (Main.tama.getAge() >= 10){
				animation.stop();
				animer(sprite, 2, 2, 140, 40, Animation.INDEFINITE);
			}else if (Main.tama.getAge() < 10) {
				animation.stop();
				animer(sprite_bebe, 2, 2, 140, 40, Animation.INDEFINITE);
			}
        });
	}
	
	public void animer(Image sprite, int cols, int count, int x, int y, int duree){
		affichage.setImage(sprite);
		animation = new SpriteAnimation(affichage, Duration.millis(1000), cols, cols, x, y, WIDTH, HEIGHT);
		animation.setCycleCount(duree);
		animation.play();
	}
}
