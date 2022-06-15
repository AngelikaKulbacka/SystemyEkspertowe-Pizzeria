package com.example.Pizzeria;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class OffersSceneController {
	@FXML
	private Button btnSubmit;
	
	// Event Listener on Button.onAction
		@FXML
		public void btnSubmitClick(ActionEvent event) {
			
			try {
				switchToMainScene();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void switchToMainScene() throws IOException {
			Parent root = FXMLLoader.load(getClass().getResource("/MainScene.fxml"));
			Stage window = (Stage) btnSubmit.getScene().getWindow();
			window.setScene(new Scene(root));
		}
}
