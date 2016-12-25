package application;

import javafx.animation.Animation;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
	public static List<Tamagotchi> listTama = new ArrayList<Tamagotchi>();
	Timer timer = new Timer();
	Timer default_sprite = new Timer();
	private Connection connection;
	
	
	@FXML private void initialize(){
		connection = database.dbconnect();
		if (Main.tama.getRace() == Tamagotchi.CHIEN)
			sprite = sprite_chien;
		else if (Main.tama.getRace() == Tamagotchi.CHAT)
			sprite = sprite_chat;
		else
			sprite = sprite_oiseau;
		
		
		timer.schedule(Main.tama, 0, 5*1000);
		default_sprite.schedule(this, 0, 5*1000);
		
		Main.window.setOnCloseRequest(e -> {
			e.consume();
			fermerFenetre();
		});
		
		if (Main.tama.getAge() == 0) {
			animer(sprite_oeuf, 4, 4, 10, 50, 3);
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
				if (Main.tama.getAge() == 10) {
					animation.stop();
					animer(sprite, 3, 3, 140, 40, 2);
					//animation.stop();
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
				if (Main.tama.getAge() > 10) {
					if (Main.tama.getAppetit() <= 70) {
						animation.stop();
						animer(sprite, 2, 2, 280, 90, Animation.INDEFINITE);
					}
					if (Main.tama.getAppetit() <= 40) {
						animation.stop();
						animer(sprite, 2, 2, 280, 162, Animation.INDEFINITE);
					}
				}else if (Main.tama.getAge() < 10) {
					if (Main.tama.getAppetit() <= 70) {
						animation.stop();
						animer(sprite_bebe, 2, 2, 280, 90, Animation.INDEFINITE);
					}
					if (Main.tama.getAppetit() <= 40) {
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
					if (Main.tama.getBonheur() <= 60) {
						animation.stop();
						animer(sprite, 2, 2, 280, 205, Animation.INDEFINITE);
					}
					if (Main.tama.getBonheur() <= 35) {
						animation.stop();
						animer(sprite, 2, 2, 280, 245, Animation.INDEFINITE);
					}
				}else if (Main.tama.getAge() < 10) {
					if (Main.tama.getBonheur() <= 60) {
						animation.stop();
						animer(sprite_bebe, 2, 2, 280, 205, Animation.INDEFINITE);
					}
					if (Main.tama.getBonheur() <= 35) {
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
					if (Main.tama.getSommeil() <= 70) {
						animation.stop();
						animer(sprite, 3, 3, 470, 85, Animation.INDEFINITE);
					}
					if (Main.tama.getSommeil() <= 50) {
						animation.stop();
						animer(sprite, 2, 2, 470, 165, Animation.INDEFINITE);
					}
				}else if (Main.tama.getAge() < 10) {
					if (Main.tama.getSommeil() <= 70) {
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
					if (Main.tama.getProprete() <= 70) {
						animation.stop();
						animer(sprite, 2, 2, 470, 42, Animation.INDEFINITE);
					}
					if (Main.tama.getProprete() <= 40) {
						animation.stop();
						animer(sprite, 2, 2, 470, 0, Animation.INDEFINITE);
					}
				}else if (Main.tama.getAge() < 10) {
					if (Main.tama.getProprete() <= 70) {
						animation.stop();
						animer(sprite_bebe, 2, 2, 470, 42, Animation.INDEFINITE);
					}
					if (Main.tama.getProprete() <= 40) {
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
			if (Main.tama.getAge() < 10) {
				animation.stop();
				animer(sprite_bebe, 2, 2, 140, 40, Animation.INDEFINITE);
			}
			else{
				animation.stop();
				animer(sprite, 2, 2, 140, 40, 4);
			}
			
        });
	}
	
	public void animer(Image sprite, int cols, int count, int x, int y, int duree){
		affichage.setImage(sprite);
		animation = new SpriteAnimation(affichage, Duration.millis(1000), cols, cols, x, y, WIDTH, HEIGHT);
		animation.setCycleCount(duree);
		animation.play();
	}
	
	public void fermerFenetre(){
		
		Alert fermer = new Alert(AlertType.CONFIRMATION);
		fermer.setTitle("Confirmer la sauvegarde avant de quitter");
		fermer.setHeaderText("voulez vous sauvegarder la partie avant de quitter?");
		ButtonType oui = new ButtonType("Oui");
		ButtonType non = new ButtonType("Non");
		ButtonType annuler = new ButtonType("Annuler", ButtonData.CANCEL_CLOSE);
		fermer.getButtonTypes().setAll(oui, non, annuler);
		Optional<ButtonType> res = fermer.showAndWait();
		if (res.get() == oui) {
			int count = 0;
			try {
				final String queryCheck = "SELECT count(*) from tamagotchi WHERE nom = '"+Main.tama.getNom()+"' ;";
				Statement stm = connection.createStatement();
				ResultSet resultSet = stm.executeQuery( queryCheck );
				if(resultSet.next()) {
					count = resultSet.getInt(1);
				}
				if (count > 0) {
					Statement stmt = connection.createStatement();
					String sql = "UPDATE tamagotchi set age = "+Main.tama.getAge()+", sante = "+Main.tama.getSante()+
							", sommeil = "+Main.tama.getSommeil()+", proprete = "+Main.tama.getProprete()+
							", appetit = "+Main.tama.getAppetit()+", bonheur = "+Main.tama.getBonheur()+
							" where nom = '"+Main.tama.getNom()+"' and race = '"+Main.tama.getRace()+"' ;";
					stmt.executeUpdate(sql);
				    connection.commit();
				}else{
					Statement stmt = connection.createStatement();
					String sql = "INSERT INTO tamagotchi(nom, race, age, sante, proprete, sommeil, appetit, bonheur)"
							+ " VALUES ('"+Main.tama.getNom()+"', '"+Main.tama.getRace()+"' ,"+Main.tama.getAge()+","+Main.tama.getSante()
							+","+Main.tama.getProprete()+","+Main.tama.getSommeil()+","+Main.tama.getAppetit()+","+Main.tama.getBonheur()+");";
					stmt.executeUpdate(sql);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(Main.tama);
			timer.cancel();
			default_sprite.cancel();
			Main.window.close();
		}else if (res.get() == non) {
			timer.cancel();
			default_sprite.cancel();
			Main.window.close();
		}
	}
}
