package com.example.Pizzeria;

import com.example.Pizzeria.models.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.fxml.Initializable;

import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.kie.api.runtime.KieSession;

import com.example.Pizzeria.config.DroolsFactory;
import org.mvel2.conversion.BigDecimalCH;

public class PizzaController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private ComboBox<String> typePizza;
    @FXML
    private RadioButton small;
    @FXML
    private ToggleGroup togglepizzas;
    @FXML
    private ToggleGroup toggledrinks;
    @FXML
    private ToggleGroup toggledippings;
    @FXML
    private ToggleGroup togglestudent;
    @FXML
    private RadioButton medium;
    @FXML
    private RadioButton large;
    @FXML
    private TextField pizzaNum;
    @FXML
    private CheckBox cheese;
    @FXML
    private CheckBox pepperoni;
    @FXML
    private CheckBox mushrooms;
    @FXML
    private CheckBox olives;
    @FXML
    private CheckBox tomato;
    @FXML
    private CheckBox bacon;
    @FXML
    private CheckBox onion;
    @FXML
    private CheckBox pineapple;
    @FXML
    private RadioButton coke;
    @FXML
    private RadioButton sevenup;
    @FXML
    private RadioButton juice;
    @FXML
    private RadioButton pepsi;
    @FXML
    private RadioButton fanta;
    @FXML
    private RadioButton redbull;
    @FXML
    private TextField drinkNum;
    @FXML
    private RadioButton ranch;
    @FXML
    private RadioButton garlic;
    @FXML
    private RadioButton marinara;
    @FXML
    private RadioButton bbq;
    @FXML
    private RadioButton hot;
    @FXML
    private RadioButton chipotle;
    @FXML
    private TextField dippingNum;
    @FXML
    private TextArea receipt;
    @FXML
    private Button confirm;
    @FXML
    private Button cancel;
    @FXML
    private Button exit;
    @FXML
    private Button minus;
    @FXML
    private Label amountOfPizzas;
    @FXML
    private Label labelOrderDate;
    @FXML
    private Button plus;
    @FXML
    private Button minus1;
    @FXML
    private Label amountOfDrinks;
    @FXML
    private Label amountOfDippings;
    @FXML
    private Button plus1;
    @FXML
    private Button addPizza;

    @FXML
    private Label cena;
    @FXML
    private TextArea discountArea;
    //    PizzaReceipt pizzaReceipt;
    final String[] pizzaItems ={"Margherita","Hawaian","Capricciosa"};
    final ObservableList<String> pizzaList = FXCollections.observableArrayList(pizzaItems);

    Drink drink;
    OrderDate orderDate;
    OrderTime orderTime;
    int amountPizza =1;
    int amountDrink =0;
    int amountDipping =0;
    int amountAllDrink =0;

    int price=0;
    List<Pizza> listaPizz;
    boolean isStudent = false;
    @Override
    public void initialize(URL url, ResourceBundle rb){
        typePizza.setItems(pizzaList);
        listaPizz = new ArrayList<Pizza>();
        orderDate = new OrderDate();
        orderTime = new OrderTime();
        String orderDateText = orderDate.getOrderDate().getDayOfMonth() +  " " + orderDate.getOrderDate().getMonth() + " " + orderDate.getOrderDate().getYear();
        labelOrderDate.setText(orderDateText);
        System.out.println(orderDate.getOrderDate().getDayOfWeek());
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public  void typePizzaChanged(ActionEvent event)
    {
//        receipt.setText(typePizza.getValue());
    }
    
    public  void amountMinus(ActionEvent event)
    {
        if(amountPizza>1) {
            amountPizza -= 1;
            amountOfPizzas.setText("" + amountPizza);
        }
    }
    
    public  void amountPlus(ActionEvent event)
    {
        amountPizza+=1;
        amountOfPizzas.setText(""+amountPizza);
    }

    public  void amountMinusDrink(ActionEvent event)
    {
        if(amountDrink>=1) {
            amountDrink -= 1;
            amountOfDrinks.setText("" + amountDrink);
        }
    }
    
    public  void amountPlusDrink(ActionEvent event)
    {
        amountDrink+=1;
        amountOfDrinks.setText(""+amountDrink);
    }

    public  void amountMinusDipping(ActionEvent event)
    {
        if(amountDipping>=1) {
            amountDipping -= 1;
            amountOfDippings.setText("" + amountDipping);
        }
    }
    
    public  void amountPlusDipping(ActionEvent event)
    {
        amountDipping+=1;
        amountOfDippings.setText(""+amountDipping);
    }
    
    public void addPizza(ActionEvent event)
    {
    	BigDecimal pizzaPrice = new BigDecimal(0.0);
    	BigDecimal drinkPrice = new BigDecimal(0.0);
    	BigDecimal dippingPrice = new BigDecimal(0.0);
    	
        RadioButton selectedRadioButton = null;
        RadioButton selectedDrinkRadioButton = null;
        RadioButton selectedDippingRadioButton = null;
        RadioButton selectedStudentRadioButton = null;

        if(togglepizzas.getSelectedToggle()!=null) {
            selectedRadioButton = (RadioButton) togglepizzas.getSelectedToggle();
        }
//        String toogleGroupValue = selectedRadioButton.getText();
        String napis="";
        if(typePizza.getValue()!=null){
        	
        	if (typePizza.getValue().equals("Margherita")) {
        		pizzaPrice = pizzaPrice.add(BigDecimal.valueOf(20.0));
        	} else if (typePizza.getValue().equals("Capricciosa")) {
        		pizzaPrice = pizzaPrice.add(BigDecimal.valueOf(24.0));
        	} else if (typePizza.getValue().equals("Hawaian")) {
        		pizzaPrice = pizzaPrice.add(BigDecimal.valueOf(22.0));
        	}
        	
        	
            price+=20;
            napis="Type: "+typePizza.getValue()+" x"+amountOfPizzas.getText()+ "\n";
            //typePizza.setValue(null);
            
        }

        String pizzaSize = "";
        if( selectedRadioButton!=null){
            napis+="Size: "+ selectedRadioButton.getText()+"\n";
            switch (selectedRadioButton.getText()){
                case "Small":
//                    price+=2;
                	pizzaPrice = pizzaPrice.multiply(BigDecimal.valueOf(1.05));
//                	price *= 1.05;
                    pizzaSize = "Small";
                    break;
                case "Medium":
                	pizzaPrice = pizzaPrice.multiply(BigDecimal.valueOf(1.1));
//                    price+=4;
                    pizzaSize = "Medium";
                    break;
                case "Large":
                	pizzaPrice = pizzaPrice.multiply(BigDecimal.valueOf(1.15));
//                    price+=6;
                    pizzaSize = "Large";
                    break;
            }

            selectedRadioButton.setSelected(false);
        }
//        if(!amountOfPizzas.getText().equals("0")){
//            napis+= "Amount of pizzas: "+ amountOfPizzas.getText()+ "\n";
//            amountOfPizzas.setText("0");
//            amountPizza=0;
//        }

        if(toggledrinks.getSelectedToggle()!=null) {
            selectedDrinkRadioButton = (RadioButton) toggledrinks.getSelectedToggle();
        }


        if( selectedDrinkRadioButton!=null){
            napis+="Drink: "+ selectedDrinkRadioButton.getText()+" x"+amountOfDrinks.getText() +"\n";
            price+=(Integer.parseInt(amountOfDrinks.getText())*5);
            pizzaPrice = pizzaPrice.add(BigDecimal.valueOf(Integer.parseInt(amountOfDrinks.getText())*5));
            selectedDrinkRadioButton.setSelected(false);
            amountAllDrink+=Integer.parseInt(amountOfDrinks.getText());
        }

        if(cheese.isSelected() || pepperoni.isSelected()|| mushrooms.isSelected()||
                olives.isSelected()|| tomato.isSelected()|| bacon.isSelected()||
                onion.isSelected()|| pineapple.isSelected()){
            napis+="Toppings: ";
        }

        if(cheese.isSelected()){
            napis+=cheese.getText()+" ";
//            cheese.setSelected(false);
            price+=2;
            pizzaPrice = pizzaPrice.add(BigDecimal.valueOf(2));
        }
        if(pepperoni.isSelected()){
            napis+=pepperoni.getText()+ " ";
            price+=2;
//            pepperoni.setSelected(false);
            pizzaPrice = pizzaPrice.add(BigDecimal.valueOf(2));
        }
        if(mushrooms.isSelected()){
            napis+=mushrooms.getText()+ " ";
            price+=2;
            pizzaPrice = pizzaPrice.add(BigDecimal.valueOf(2));
//            mushrooms.setSelected(false);
        }
        if(olives.isSelected()){
            napis+=olives.getText()+ " ";
            price+=2;
            pizzaPrice = pizzaPrice.add(BigDecimal.valueOf(2));
//            olives.setSelected(false);
        }
        if(tomato.isSelected()){
            napis+=tomato.getText()+ " ";
            price+=2;
            pizzaPrice = pizzaPrice.add(BigDecimal.valueOf(2));
//            tomato.setSelected(false);
        }
        if(bacon.isSelected()){
            napis+=bacon.getText()+ " ";
            price+=2;
            pizzaPrice = pizzaPrice.add(BigDecimal.valueOf(2));
//            bacon.setSelected(false);
        }
        if(onion.isSelected()){
            napis+=onion.getText()+ " ";
            price+=2;
            pizzaPrice = pizzaPrice.add(BigDecimal.valueOf(2));
//            onion.setSelected(false);
        }
        if(pineapple.isSelected()){
            napis+=pineapple.getText()+ " ";
            price+=2;
            pizzaPrice = pizzaPrice.add(BigDecimal.valueOf(2));
//            pineapple.setSelected(false);
        }

        if(cheese.isSelected() || pepperoni.isSelected()|| mushrooms.isSelected()||
                olives.isSelected()|| tomato.isSelected()|| bacon.isSelected()||
                onion.isSelected()|| pineapple.isSelected()){
            cheese.setSelected(false);
            pepperoni.setSelected(false);
            mushrooms.setSelected(false);
            olives.setSelected(false);
            tomato.setSelected(false);
            bacon.setSelected(false);
            onion.setSelected(false);
            pineapple.setSelected(false);
            napis+="\n";
        }

        if(toggledippings.getSelectedToggle()!=null) {
            selectedDippingRadioButton = (RadioButton) toggledippings.getSelectedToggle();
        }

        if( selectedDippingRadioButton!=null){
            napis+="Dippings: "+ selectedDippingRadioButton.getText()+" x"+amountOfDippings.getText() +"\n";
            price+=Integer.parseInt(amountOfDippings.getText())*3;
            pizzaPrice = pizzaPrice.add(BigDecimal.valueOf(Integer.parseInt(amountOfDippings.getText())*3));
            selectedDippingRadioButton.setSelected(false);
        }

        if(togglestudent.getSelectedToggle()!=null) {
            selectedStudentRadioButton = (RadioButton) togglestudent.getSelectedToggle();
        }

        if( selectedStudentRadioButton!=null){
            napis+="Student: "+ selectedStudentRadioButton.getText() +"\n";
            if(selectedStudentRadioButton.getText().equals("Yes")){
            	isStudent = true;
                price*=0.9;
            }
            selectedStudentRadioButton.setSelected(false);
            for (Toggle t : togglestudent.getToggles()) {
                if (t instanceof RadioButton) {
                    ((RadioButton) t).setDisable(true);
                }
            }
        }
        
        receipt.setText(receipt.getText()+napis);
        receipt.setText(receipt.getText()+"\n"+pizzaPrice);
        
        
        Pizza p = new Pizza();
        
        p.setPizzaSize(pizzaSize);
        p.setPizzaCount(amountPizza);
        p.setPizzaType(typePizza.getValue());
        
        pizzaPrice = pizzaPrice.multiply(BigDecimal.valueOf(amountPizza));
        p.setPrice(pizzaPrice);
        if (selectedDippingRadioButton != null)
        	p.setDipping(selectedDippingRadioButton.getText());
        
        // pizza
        amountOfPizzas.setText("1");
        amountPizza=1;
        // drinks
        amountOfDrinks.setText("0");
        amountDrink=0;
        //  dippings
        amountOfDippings.setText("0");
        amountDipping=0;
        p.setStudent(isStudent);
        listaPizz.add(p);
    }

    public void clearReceipt(ActionEvent event)
    {
        receipt.setText("");
        for (Toggle t : togglestudent.getToggles()) {
            if (t instanceof RadioButton) {
                ((RadioButton) t).setDisable(false);
            }
        }
        price=0;
        listaPizz.clear();
    }
    public void confirmOrder(ActionEvent event)
    {
        PizzaReceipt pr = new PizzaReceipt();
        pr.setPrice(BigDecimal.valueOf(0));
        drink=new Drink(amountAllDrink);
        KieSession ksession = new DroolsFactory().getKieSession();

        BigDecimal totalPrice = new BigDecimal(0.0);

        for (Pizza p: listaPizz) {
        	totalPrice =  totalPrice.add(p.getPrice());
        	System.out.println(p.getPizzaSize());
        	System.out.println(p.getPizzaCount());
        	ksession.insert(p);
        }
        ksession.insert(orderDate);
        ksession.insert(orderTime);
        ksession.insert(drink);
        ksession.insert(pr);
		ksession.fireAllRules();

        BigDecimal zero = new BigDecimal(0.0);

        if(pr.getPrice().compareTo(zero) == 0){
            cena.setText("Total price: " + totalPrice);
        }

        else {
            cena.setText("Total price: " + totalPrice  + ", po regulach: " + pr.getPrice());
        }

        BigDecimal poZnizce=totalPrice;
        for(Discount discount:pr.getDiscountHashSet()){
//            System.out.println(totalPrice.multiply(discount.getDiscount()));
            poZnizce=poZnizce.subtract(totalPrice.multiply(discount.getDiscount()));
//            System.out.println("po:"+poZnizce);
            discountArea.setText(discountArea.getText() +"discount: "+discount.getNameDiscount() + " " + discount.getDiscount()+"\n");
        }
        discountArea.setText(discountArea.getText() + "\npo znizce: "+poZnizce);
    }
}