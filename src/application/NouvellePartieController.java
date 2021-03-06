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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class NouvellePartieController{

	@FXML private Button nclose, btnchien, btnchat, btnoiseau, create;
	@FXML private TextField nnom;
	@FXML private ImageView apercu;
	private Scene scene;
	private Stage primaryStage;
	private Parent root;
	private static String race  = "";
	Alert alert = new Alert(AlertType.INFORMATION);
	
	@FXML private void initialize(){
		alert.setHeaderText(null);
		nclose.setOnAction(e -> {
			try {
				root = FXMLLoader.load(getClass().getResource("main.fxml"));
				scene = new Scene(root);
				primaryStage = Main.window;
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
		create.setOnMouseEntered(e -> create.setText("~CREER"));
		btnchien.setOnMouseExited(e -> btnchien.setText("CHIEN"));
		btnchat.setOnMouseExited(e -> btnchat.setText("CHAT"));
		btnoiseau.setOnMouseExited(e -> btnoiseau.setText("OISEAU"));
		create.setOnMouseExited(e -> create.setText("CREER"));
		
		btnchien.setOnAction(e -> {
			apercu.setImage(new Image("/images/sprites/chien1.png"));
			race = Tamagotchi.CHIEN;
		});
		btnchat.setOnAction(e -> {
			apercu.setImage(new Image("/images/sprites/chat1.png"));
			race = Tamagotchi.CHAT;
		});
		btnoiseau.setOnAction(e -> {
			apercu.setImage(new Image("/images/sprites/oiseau1.png"));
			race = Tamagotchi.OISEAU;
		});
		create.setOnAction(e -> {
			if(nnom.getText().length() < 4){
				
				alert.setTitle("Information Dialog");
				alert.setContentText("le nom doit comporter au moins 4 caract�res!");
				alert.showAndWait();
			}
			else if (nnom.getText() != null && race != "") {
				Main.tama = new Tamagotchi(nnom.getText(), race);
				try {
					root = FXMLLoader.load(getClass().getResource("jeu.fxml"));
					scene = new Scene(root);
					primaryStage = Main.window;
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}else if(race == ""){
				alert.setTitle("Information Dialog");
				alert.setContentText("vous avez oubli� une etape de creation!");
				alert.showAndWait();
			}
			
		});
	}
	
}
