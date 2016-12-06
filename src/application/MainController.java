package application;

import java.io.IOException;

import javax.crypto.spec.SecretKeySpec;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class JeuController {
	@FXML private Button npartie, cpartie;
	private Scene scene;
	private Stage primaryStage;
	public Parent root;
	
	@FXML private void initialize() throws IOException{
		cpartie.setOnAction(e -> System.out.println("charger partie"));
		npartie.setOnAction(e -> {
			try {
				root = FXMLLoader.load(getClass().getResource("NouvellePartie.fxml"));
				scene = new Scene(root);
				primaryStage = Jeu.window;
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		cpartie.setOnMouseEntered(e -> cpartie.setText("~CHARGER PARTIE"));
		npartie.setOnMouseEntered(e -> npartie.setText("~NOUVELLE PARTIE"));
		cpartie.setOnMouseExited(e -> cpartie.setText("CHARGER PARTIE"));
		npartie.setOnMouseExited(e -> npartie.setText("NOUVELLE PARTIE"));
	}
	
	
}
