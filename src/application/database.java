package application;

import java.sql.*;

import javafx.scene.control.Alert;

public class database {
	static Connection conn = null;
	public static Connection dbconnect(){
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\ali\\Documents\\GitHub\\Tamagotchi\\src\\lib\\tama.sqlite");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("could not connect");
			return null;
		}
		return conn;
	}
}
