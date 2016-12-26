package application;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ChargerPartieController {
	@FXML private Button charger;
	@FXML private TableView<Tamagotchi> tablePartie;
	@FXML private TableColumn<Tamagotchi, String> nomPartie;
	@FXML private TableColumn<Tamagotchi, String> racePartie;
	@FXML private TableColumn<Tamagotchi, String> agePartie;
	private Connection connection = null;
	public static final ObservableList data = FXCollections.observableArrayList();
	
	
	@FXML private void initialize(){
		connection = database.dbconnect();
		
		try {
			String query = "select * from tamagotchi;";
			ResultSet rs = connection.createStatement().executeQuery(query);
			while ( rs.next() ) {
		         int id = rs.getInt("id");
		         String nom = rs.getString("nom");
		         int age  = rs.getInt("age");
		         String  race = rs.getString("race");
		         int sante = rs.getInt("sante");
		         int appetit = rs.getInt("appetit");
		         int proprete = rs.getInt("proprete");
		         int bonheur = rs.getInt("bonheur");
		         int sommeil = rs.getInt("sommeil");
		         data.add(new Tamagotchi(nom, race, age, sante, proprete, bonheur, sommeil, appetit));
		      }
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		nomPartie.setCellValueFactory(new PropertyValueFactory<>("nom"));
        racePartie.setCellValueFactory(new PropertyValueFactory<>("race"));
        agePartie.setCellValueFactory(new PropertyValueFactory<>("age"));
		
		tablePartie.setItems(null);
		tablePartie.setItems(data);
		
		
		tablePartie.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            //Check whether item is selected and set value of selected item to Label
			Main.tama = new Tamagotchi(tablePartie.getSelectionModel().getSelectedItem().getNom(), 
					tablePartie.getSelectionModel().getSelectedItem().getRace(), 
					tablePartie.getSelectionModel().getSelectedItem().getAge(), 
					tablePartie.getSelectionModel().getSelectedItem().getSante(), 
					tablePartie.getSelectionModel().getSelectedItem().getProprete(), 
					tablePartie.getSelectionModel().getSelectedItem().getBonheur(), 
					tablePartie.getSelectionModel().getSelectedItem().getSommeil(), 
					tablePartie.getSelectionModel().getSelectedItem().getAppetit());
            System.out.println(Main.tama);
        });
		
		
		charger.setOnAction(e ->{
			
			if (tablePartie.getSelectionModel().getSelectedItem() == null) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("choisir la partie");
				alert.setHeaderText("Vous devez selectionner une partie pour continuer");
				alert.show();
			}
			else{
				try {
					Parent root = FXMLLoader.load(getClass().getResource("jeu.fxml"));
					Scene scene = new Scene(root);
					Stage primaryStage = Main.window;
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setScene(scene);
					primaryStage.show();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		});
    }
}
