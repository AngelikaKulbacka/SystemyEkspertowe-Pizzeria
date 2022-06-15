package com.example.Pizzeria;

import javafx.scene.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.kie.api.runtime.KieSession;

import com.example.Pizzeria.config.DroolsFactory;
import com.example.Pizzeria.models.Country;
import com.example.Pizzeria.models.Hotel;
import com.example.Pizzeria.models.Travel;
import com.example.Pizzeria.models.TravelPrice;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

public class MainSceneController {
	@FXML
	private DatePicker stayFromDate;
	@FXML
	private DatePicker stayToDate;
	@FXML
	private Label countDaysLabel;
	@FXML
	private Label labelDateError;
	@FXML
	private Label labelChildrenNumber;
	@FXML
	private Label labelAdultsNumber;
	@FXML
	private Button btnMinusAdults;
	@FXML
	private Button btnMinusChildren;
	@FXML
	private ComboBox<String> comboBoxHotelMeals;
	@FXML
	private ComboBox<String> comboBoxHotelRating;
	@FXML
	private ComboBox<String> comboBoxHotelRoom;
	@FXML
	private ComboBox<String> comboBoxCountry;
	@FXML
	private Label labelRuleTest;
	@FXML
	private CheckBox checkboxWithPool;
	@FXML
	private Button btnSubmit;
	private BigDecimal bd;
	
	
	// is called on start
	public void initialize() {
        stayFromDate.valueProperty().addListener((ov, oldValue, newValue) -> {
        	labelDateError.setVisible(false);
        });
        
        stayToDate.valueProperty().addListener((ov, oldValue, newValue) -> {
        	labelDateError.setVisible(false);
        });
        
        labelChildrenNumber.textProperty().addListener((ov, oldValue, newValue) -> {
        	int currentChildrenNumber = Integer.parseInt(labelChildrenNumber.getText().toString());
        	if (currentChildrenNumber == 0) btnMinusChildren.setDisable(true);
        	else btnMinusChildren.setDisable(false);
        });
        
        labelAdultsNumber.textProperty().addListener((ov, oldValue, newValue) -> {
        	int currentAdultsNumber = Integer.parseInt(labelAdultsNumber.getText().toString());
        	if (currentAdultsNumber == 1) btnMinusAdults.setDisable(true);
        	else btnMinusAdults.setDisable(false);
        });
        
        comboBoxHotelMeals.getItems().addAll(
        		"brak",
        		"jeden",
        		"dwa",
        		"trzy"
        		);
        comboBoxHotelMeals.getSelectionModel().selectFirst();
        
        comboBoxHotelRoom.getItems().addAll(
        		"normalny",
        		"ekskluzywny"
        		);
        comboBoxHotelRoom.getSelectionModel().selectFirst();
        
        comboBoxHotelRating.getItems().addAll(
        		"2",
        		"3",
        		"4",
        		"5"
        		);
        comboBoxHotelRating.getSelectionModel().selectFirst();
        
        comboBoxCountry.getItems().addAll(
        		"Niemcy",
        		"Hiszpania",
        		"Austria",
        		"Czechy",
        		"Portugalia",
        		"Litwa",
        		"Włochy"
        		);
        comboBoxCountry.getSelectionModel().selectFirst();

	}
	
	// Event Listener on Button.onAction
	@FXML
	public void btnSubmitClick(ActionEvent event) {
		
		
		// HOTEL	
		int ratingStarsNumber = Integer.parseInt(comboBoxHotelRating.getValue());
		String mealsType = comboBoxHotelMeals.getValue();
		boolean hasPool = checkboxWithPool.isSelected();
		String roomType = comboBoxHotelRoom.getValue();
		Hotel hotel = new Hotel(ratingStarsNumber, mealsType, hasPool, roomType);
		
		// COUNTRY
		Country country = new Country(comboBoxCountry.getValue());
		
		// TRAVEL
		Travel travel = new Travel();
		
		LocalDate date1 = stayFromDate.getValue();
		LocalDate date2 = stayToDate.getValue();
		
		if (date1 == null || date2 == null) {
			labelDateError.setText("Daty nie mogą być puste");
			labelDateError.setVisible(true);
			return;
		}
		travel.setStayFrom(date1);
		travel.setStayTo(date2);
//		countDaysLabel.setText(travel.getDaysOfStay() + ""); // ilosc dni pobytu :P
		if (travel.getDaysOfStay() <= 0) {
			labelDateError.setText("Data ,,od'' nie może być później niż data ,,do'' i nie może być to ta sama data");
			labelDateError.setVisible(true);
			return;
		}
		
		travel.setHotel(hotel);
		travel.setCountry(country);
		int adultsNumber = Integer.parseInt(labelAdultsNumber.getText());
		int childrenNumber = Integer.parseInt(labelChildrenNumber.getText());
		travel.setAdultsNumber(adultsNumber);
		travel.setChildrenNumber(childrenNumber);
		TravelPrice travelPrice = new TravelPrice();
		
		KieSession ksession = new DroolsFactory().getKieSession();
		ksession.insert(travel);
		ksession.insert(travelPrice);
		ksession.fireAllRules();
		
		BigDecimal travelCompletePrice = travelPrice.getPrice();
		bd = travelCompletePrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		labelRuleTest.setText(bd.toString() + " zl");
		
//		try {
//			switchToOffersScene();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	public void switchToOffersScene() throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/OffersScene.fxml"));
		Stage window = (Stage) btnSubmit.getScene().getWindow();
		window.setScene(new Scene(root));
	}
	
	@FXML
	public void btnMinusAdultsClick(ActionEvent event) {
		int adultsNumber = Integer.parseInt(labelAdultsNumber.getText().toString());
		adultsNumber--;
		labelAdultsNumber.setText(adultsNumber + "");
	}

	@FXML
	public void btnPlusAdultsClick(ActionEvent event) {
		int adultsNumber = Integer.parseInt(labelAdultsNumber.getText().toString());
		adultsNumber++;
		labelAdultsNumber.setText(adultsNumber + "");
	}
	
	@FXML
	public void btnMinusChildrenClick(ActionEvent event) {
		int childrenNumber = Integer.parseInt(labelChildrenNumber.getText().toString());
		childrenNumber--;
		labelChildrenNumber.setText(childrenNumber + "");
	}

	@FXML
	public void btnPlusChildrenClick(ActionEvent event) {
		int childrenNumber = Integer.parseInt(labelChildrenNumber.getText().toString());
		childrenNumber++;
		labelChildrenNumber.setText(childrenNumber + "");
	}
}
