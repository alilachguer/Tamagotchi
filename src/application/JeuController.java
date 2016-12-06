package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;

public class JeuController {
	private static final Image sprite_chien = new Image("/images/sprites/sprite_chien.png");
	private static final Image sprite_chat = new Image("/images/sprites/sprite_chat.png");
	private static final Image sprite_oiseau = new Image("/images/sprites/sprite_oiseau.png");
	private static final Image sprite_bebe = new Image("/images/sprites/sprite_bebe.png");
	private static final Image sprite_oeuf = new Image("/images/sprites/sprite_oeuf.png");
	@FXML private Label life, sante, jnom;
	
	@FXML private void initialize(){
		sante.setText(String.valueOf(Main.tama.getSante()));
		jnom.setText(Main.tama.getNom());
	}
}
