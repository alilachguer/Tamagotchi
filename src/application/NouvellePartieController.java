package application;

import java.io.IOException;

import com.sun.javafx.event.EventHandlerManager;

import javafx.animation.Animation;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class NouvellePartieController{

	@FXML private Button nclose, btnchien, btnchat, btnoiseau;
	@FXML private TextField nnom;
	@FXML private ImageView apercu;
	private Scene scene;
	private Stage primaryStage;
	private Parent root;
	private static final Image CHIEN = new Image("/images/sprites/sprite_chien.png");
	
	@FXML private void initialize(){
		nclose.setOnAction(e -> {
			try {
				root = FXMLLoader.load(getClass().getResource("jeu.fxml"));
				scene = new Scene(root);
				primaryStage = Jeu.window;
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		});
		btnchien.setOnMouseEntered(e -> btnchien.setText("~CHIEN"));
		btnchat.setOnMouseEntered(e -> btnchat.setText("~CHAT"));
		btnoiseau.setOnMouseEntered(e -> btnoiseau.setText("~OISEAU"));
		btnchien.setOnMouseExited(e -> btnchien.setText("CHIEN"));
		btnchat.setOnMouseExited(e -> btnchat.setText("CHAT"));
		btnoiseau.setOnMouseExited(e -> btnoiseau.setText("OISEAU"));
		
		btnchien.setOnAction(e -> {
			apercu.setImage(new Image("/images/sprites/chien1.png"));
		});
		btnchat.setOnAction(e -> {
			apercu.setImage(new Image("/images/sprites/chat1.png"));
		});
		btnoiseau.setOnAction(e -> {
			apercu.setImage(new Image("/images/sprites/oiseau1.png"));
		});
	}
	
}
