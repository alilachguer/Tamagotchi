package application;

import javafx.animation.Animation;
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

public class JeuController {
	private static final int COLUMNS  =   15;
    private static final int COUNT    =  2;
    private static final int OFFSET_X =  150;
    private static final int OFFSET_Y =  50;
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
	
	
	private static final Image IMAGE = new Image("/images/sprites/sprite_chien.png");
	
	@FXML private void initialize(){
		if (Main.tama.getRace() == Caracteristique.CHIEN)
			sprite = sprite_chien;
		else if (Main.tama.getRace() == Caracteristique.CHAT)
			sprite = sprite_chat;
		else
			sprite = sprite_oiseau;
		
		Timer timer = new Timer();
		timer.schedule(Main.tama, 0, 1000);
		
		jnom.setText(Main.tama.getNom().substring(0, 4));
		
		Main.tama.santeProperty().addListener(new ChangeListener<Object>() {
			@Override
			public void changed(ObservableValue<? extends Object> observable, Object oldValue, Object newValue) {
				sante.setText(new Integer(Main.tama.getSante()).toString());
				
			}
		});
		
		affichage.setImage(sprite_bebe);
		Animation animation_bebe = new SpriteAnimation(affichage, Duration.millis(1000), 
				4, 2, 
				150, 50,
                WIDTH, HEIGHT
        );
		animation_bebe.setCycleCount(Animation.INDEFINITE);
		animation_bebe.play();
		
		laver.setOnAction(e->{
			System.out.println(Main.tama.getAppetit());
			System.out.println(Main.tama.getBonheur());
			System.out.println(Main.tama.getProprete());
			System.out.println(Main.tama.getSommeil());
			System.out.println(Main.tama.getSante());
			System.out.println(Main.tama.santeProperty());
		});
		dormir.setOnAction(e->{
			System.out.println("laver");
		});
		divertir.setOnAction(e->{
			System.out.println("laver");
		});
		nourir.setOnAction(e->{
			System.out.println("laver");
		});
		soigner.setOnAction(e->{
			System.out.println("laver");
		});
		
		
		
	}
}
