package com.example.Pizzeria;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application {

	
  public static void main(String[] args) {
	  launch(args);
  }

@Override
public void start(Stage stage) throws Exception {
//	AnchorPane mainPane = FXMLLoader.load(getClass().getResource("/MainScene.fxml"));
	Parent root = FXMLLoader.load(getClass().getResource("/MainScene.fxml"));
	stage.setScene(new Scene(root));
	stage.setTitle("Pizzeria");
	stage.show();
	
}
  

}
