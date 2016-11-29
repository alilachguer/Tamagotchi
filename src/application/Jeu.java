package application;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Jeu extends Application {
	public static Stage window;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		window = primaryStage;
		Parent root = FXMLLoader.load(getClass().getResource("jeu.fxml"));
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		window.setScene(scene);
		window.setTitle("TAMAGOTCHI");
		final URL resource = getClass().getResource("/images/theme_sound.mp3");
	    final Media media = new Media(resource.toString());
		MediaPlayer mediaPlayer = new MediaPlayer(media);
	    mediaPlayer.play();
		window.setResizable(false);
		window.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
}
