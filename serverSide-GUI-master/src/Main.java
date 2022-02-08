// Blade Team: Derek Armaan Kylie
//GUI layout for application

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Optional;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
//import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.stage.Stage;


public class Main extends Application
{
	TextArea clock;
	final ScrollBar sc = new ScrollBar();
	final ScrollPane sp = new ScrollPane();
	final Label fileName = new Label();
	final String [] imageNames = new String [] {"fw1.jpg", "fw2.jpg",
	        "fw3.jpg", "fw4.jpg", "fw5.jpg"};
	//Todo add in prices
	Float total;
	String timeSelect = "";	
	
	GridPane gridPane = new GridPane();

    public void start(Stage stage) throws FileNotFoundException
    {
   	 
    	// Title of the window
        stage.setTitle("Welcome to Blade");
        stage.setWidth(1000);
        stage.setHeight(750);

        // This will create a field for the clock at the top of the application
        clock = new TextArea();
        clock.setEditable(false);
        clock.setPrefHeight(30);
        clock.setPrefWidth(900);

        // Used for adding pictures which would eventually become buttons users can push for locations, etc
        Image pic         = new Image("/bladeLogoBlack.jpg");
        ImageView imageOK = new ImageView(pic);
        // since this is the logo, clicking this in the future could lead to giving a FAQ or something like that
        //Button button1    = new Button("Logo", imageOK);
        // You may have to mess with the sizing here to make sure it properly fits
        // Using something like .setWidth(1000) instead of .fitWidthProperty may be better
        GridPane.setHalignment(imageOK, HPos.CENTER);
        
        //Flight Times
    	
    	final ToggleGroup group = new ToggleGroup();

    	RadioButton time1 = new RadioButton("8:00 am");
    	time1.setTextFill(Color.WHITE);
    	time1.setToggleGroup(group);
    	RadioButton time2 = new RadioButton("9:15 am");
    	time2.setTextFill(Color.WHITE);
    	time2.setToggleGroup(group);
    	RadioButton time3 = new RadioButton("11:30 am");
    	time3.setTextFill(Color.WHITE);
    	time3.setToggleGroup(group);
    	RadioButton time4 = new RadioButton("12:45 pm");
    	time4.setTextFill(Color.WHITE);
    	time4.setToggleGroup(group);
    	RadioButton time5 = new RadioButton("2:00 pm");
    	time5.setTextFill(Color.WHITE);
    	time5.setToggleGroup(group);
    	RadioButton time6 = new RadioButton("3:15 pm");
    	time6.setTextFill(Color.WHITE);
    	time6.setToggleGroup(group);
    	RadioButton time7 = new RadioButton("4:30 pm");
    	time7.setTextFill(Color.WHITE);
    	time7.setToggleGroup(group);
    	
    	
    	group.selectedToggleProperty().addListener(new ChangeListener<Toggle>(){
    	    public void changed(ObservableValue<? extends Toggle> ov, Toggle old_toggle, Toggle new_toggle) {

    	         if (group.getSelectedToggle() != null) {

    	             //timeSelect = group.getSelectedToggle().getClass().toString();
    	             if(group.getSelectedToggle() == time1){
    	            	 timeSelect = "8:00 am";
    	             }else if(group.getSelectedToggle() == time2){
    	            	 timeSelect = "9:15 am";
    	             }else if(group.getSelectedToggle() == time3){
    	            	 timeSelect = "11:30 am";
    	             }else if(group.getSelectedToggle() == time4){
    	            	 timeSelect = "12:45 pm";
    	             }else if(group.getSelectedToggle() == time5){
    	            	 timeSelect = "2:00 pm";
    	             }else if(group.getSelectedToggle() == time6){
    	            	 timeSelect = "3:15 pm";
    	             }else if(group.getSelectedToggle() == time7){
    	            	 timeSelect = "4:30 pm";
    	             }

    	        	 
    	        	 
    	         }

    	     } 
    	});

        // Setting up buttons, starting with New York
        //declare combo box buttons
        final ComboBox<String> fromBoxNY = new ComboBox<String>();
        fromBoxNY.getItems().addAll(
            "E 34 ST",
            "JFK",
            "LaGuardia",
            "Newark",
            "W 30 ST",
            "Wall Street"
        );
        GridPane.setValignment(fromBoxNY, VPos.BOTTOM);
        final ComboBox<String> toBoxNY = new ComboBox<String>();
        toBoxNY.getItems().addAll(
        		"E 34 ST",
                "JFK",
                "LaGuardia",
                "Newark",
                "W 30 ST",
                "Wall Street"
        );
        GridPane.setValignment(toBoxNY, VPos.BOTTOM);
        Label fromLabel = new Label("From : ");
        Label toLabel = new Label("To : ");
        BackgroundFill bg_fill = new BackgroundFill(Color.WHITESMOKE,
                CornerRadii.EMPTY, Insets.EMPTY);
        Background myBg = new Background(bg_fill);
        fromLabel.setBackground(myBg);
        toLabel.setBackground(myBg);
        GridPane.setValignment(fromLabel, VPos.CENTER);
        GridPane.setValignment(toLabel, VPos.CENTER);

        
        GridPane.setValignment(time1, VPos.TOP);
        GridPane.setValignment(time2, VPos.CENTER);
        GridPane.setValignment(time3, VPos.BOTTOM);
        GridPane.setValignment(time5, VPos.CENTER);
        GridPane.setValignment(time6, VPos.BOTTOM);
        GridPane.setValignment(time7, VPos.CENTER);
        // This implementation should be very similar to the one above
        Image pic2         = new Image("/newyork.jpg");
        ImageView image2 = new ImageView(pic2);
        // Fitting the width and height may not be better than manually setting width and height
        image2.fitWidthProperty();
        image2.fitHeightProperty();
        Button button2    = new Button("New York", image2);
        button2.setContentDisplay(ContentDisplay.BOTTOM);

        //Set the actual action of the button, adds the combobox
        button2.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent e){
				gridPane.add(fromBoxNY, 3,0,1,1);
				gridPane.add(fromLabel, 3,0,1,1);
				gridPane.add(toBoxNY, 3, 1,1,1);
				gridPane.add(toLabel, 3, 1,1,1);
				gridPane.add(time1, 4, 0,1,1);
				gridPane.add(time2, 4, 0,1,1);
				gridPane.add(time3, 4, 0,1,1);
				gridPane.add(time5, 4, 1,1,1);
				gridPane.add(time6, 4, 1,1,1);
			//	gridPane.add(time7, 4, 2,1,1);
				
			}
		});


        // below is what allows an action to be attributed to this button
        // button2.setOnAction(new EventHandler<ActionEvent>()

        // Same as above


        //Chicago
        // Chicago Heliports added from list of non-emergency heliports in chicago area
        final ComboBox<String> fromBoxChicago = new ComboBox<String>();
        fromBoxChicago.getItems().addAll(
            "Vertiport Chicago Heliport ",
            "WGN-TV Heliport ",
            "Chicago Helicopter Experience Heliport"
        );
        final ComboBox<String> toBoxChicago = new ComboBox<String>();
        toBoxChicago.getItems().addAll(
        	"Vertiport Chicago Heliport  ",
            "WGN-TV Heliport ",
            "Chicago Helicopter Experience Heliport "
        );
        GridPane.setValignment(fromBoxChicago, VPos.BOTTOM);
        GridPane.setValignment(toBoxChicago, VPos.BOTTOM);

        Image pic3        = new Image("/chicago.jpg");
        ImageView imageBan= new ImageView(pic3);
        Button button3    = new Button("Chicago", imageBan);
        button3.setContentDisplay(ContentDisplay.BOTTOM);
        button3.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent e){
				gridPane.add(fromBoxChicago, 3,0,1,1);
				gridPane.add(fromLabel, 3,0,1,1);
				gridPane.add(toBoxChicago, 3, 1,1,1);
				gridPane.add(toLabel, 3, 1,1,1);
				gridPane.add(time1, 4, 0,1,1);
				gridPane.add(time2, 4, 0,1,1);
				gridPane.add(time3, 4, 0,1,1);
				gridPane.add(time5, 4, 1,1,1);
				gridPane.add(time6, 4, 1,1,1);
				//gridPane.add(time7, 4, 2,1,1);
			}
		});

        // Same as above
        // LA
        final ComboBox<String> fromBoxLA = new ComboBox<String>();
        fromBoxLA.getItems().addAll(
            "LAX ",
            "DTLA ",
            "Westside "
        );
        final ComboBox<String> toBoxLA = new ComboBox<String>();
        toBoxLA.getItems().addAll(
        	"LAX  ",
            "DTLA ",
            "Westside "
        );
        GridPane.setValignment(fromBoxLA, VPos.BOTTOM);
        GridPane.setValignment(toBoxLA, VPos.BOTTOM);
        
        Image pic4        = new Image("/losangeles.jpg");
        ImageView imageBan2= new ImageView(pic4);
        Button button4    = new Button("Los Angeles", imageBan2);
        button4.setContentDisplay(ContentDisplay.BOTTOM);
        button4.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent e){
				gridPane.add(fromBoxLA, 3,0,1,1);
				gridPane.add(fromLabel, 3,0,1,1);
				gridPane.add(toBoxLA, 3, 1,1,1);
				gridPane.add(toLabel, 3, 1,1,1);
				gridPane.add(time1, 4, 0,1,1);
				gridPane.add(time2, 4, 0,1,1);
				gridPane.add(time3, 4, 0,1,1);
				gridPane.add(time5, 4, 1,1,1);
				gridPane.add(time6, 4, 1,1,1);
				//gridPane.add(time7, 4, 2,1,1);
			}
		});
        //imageOK.fitWidthProperty();
        //imageOK.fitHeightProperty();

        // Adds the buttons to the application window
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        
        //Miami
        final ComboBox<String> fromBoxMiami = new ComboBox<String>();
        fromBoxMiami.getItems().addAll(
            "MIA ",
            "FLL ",
            "PBI ",
            "OPF ",
            "Miami Beach "
        );
        final ComboBox<String> toBoxMiami = new ComboBox<String>();
        toBoxMiami.getItems().addAll(
        	"MIA  ",
            "FLL ",
            "PBI ",
            "OPF ",
            "Miami Beach "
        );
        GridPane.setValignment(fromBoxMiami, VPos.BOTTOM);
        GridPane.setValignment(toBoxMiami, VPos.BOTTOM);
        

        Image pic5         = new Image("/miami.jpg");
        ImageView image5 = new ImageView(pic5);
        // Fitting the width and height may not be better than manually setting width and height
        image5.fitWidthProperty();
        image5.fitHeightProperty();
        Button button5    = new Button("Miami", image5);
        button5.setContentDisplay(ContentDisplay.BOTTOM);
        button5.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent e){
				gridPane.add(fromBoxMiami, 3,0,1,1);
				gridPane.add(fromLabel, 3,0,1,1);
				gridPane.add(toBoxMiami, 3, 1,1,1);
				gridPane.add(toLabel, 3, 1,1,1);
				gridPane.add(time1, 4, 0,1,1);
				gridPane.add(time2, 4, 0,1,1);
				gridPane.add(time3, 4, 0,1,1);
				gridPane.add(time5, 4, 1,1,1);
				gridPane.add(time6, 4, 1,1,1);
				//gridPane.add(time7, 4, 2,1,1);
			}
		});
        // below is what allows an action to be attributed to this button
        // button2.setOnAction(new EventHandler<ActionEvent>()

        // Same as above
        // Houston
        // Heliports are added from a list of known public heliports in the houston area
        final ComboBox<String> fromBoxHouston = new ComboBox<String>();
        fromBoxHouston.getItems().addAll(
            "12th Street Heliport ",
            "Star Houston Heliport ",
            "The American Tower Heliport",
            "Bear Creek Heliport ",
            "Post Oak Central Heliport "
        );
        final ComboBox<String> toBoxHouston = new ComboBox<String>();
        toBoxHouston.getItems().addAll(
        	"12th Street Heliport  ",
            "Star Houston Heliport",
            "The American Tower Heliport ",
            "Bear Creek Heliport",
            "Post Oak Central Heliport "
        );
        GridPane.setValignment(fromBoxHouston, VPos.BOTTOM);
        GridPane.setValignment(toBoxHouston, VPos.BOTTOM);
        
        Image pic6        = new Image("/houston.jpg");
        ImageView image6= new ImageView(pic6);
        Button button6    = new Button("Houston", image6);
        button6.setContentDisplay(ContentDisplay.BOTTOM);
        button6.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent e){
				gridPane.add(fromBoxHouston, 3,0,1,1);
				gridPane.add(fromLabel, 3,0,1,1);
				gridPane.add(toBoxHouston, 3, 1,1,1);
				gridPane.add(toLabel, 3, 1,1,1);
				gridPane.add(time1, 4, 0,1,1);
				gridPane.add(time2, 4, 0,1,1);
				gridPane.add(time3, 4, 0,1,1);
				gridPane.add(time5, 4, 1,1,1);
				gridPane.add(time6, 4, 1,1,1);
				//gridPane.add(time7, 4, 2,1,1);
			}
		});
        //imageOK.fitWidthProperty();
        //imageOK.fitHeightProperty();

        // Same as above
        // Newark
        // Heliports generated from a list of public / private heliports in the Newark Area
        final ComboBox<String> fromBoxNewark = new ComboBox<String>();
        fromBoxNewark.getItems().addAll(
        	"Albert Guido Memorial Heliport  ",
            "Port Newark Helistop ",
            "Essex Generating Station Heliport "
        );
        final ComboBox<String> toBoxNewark = new ComboBox<String>();
        toBoxNewark.getItems().addAll(
        	"Albert Guido Memorial Heliport  ",
            "Port Newark Helistop ",
            "Essex Generating Station Heliport "
        );
        GridPane.setValignment(fromBoxNewark, VPos.BOTTOM);
        GridPane.setValignment(toBoxNewark, VPos.BOTTOM);

        
        Image pic7        = new Image("/newark.jpg");
        ImageView imageBan7= new ImageView(pic7);
        Button button7    = new Button("Newark", imageBan7);
        button7.setContentDisplay(ContentDisplay.BOTTOM);
        button7.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override public void handle(ActionEvent e){
				gridPane.add(fromBoxNewark, 3,0,1,1);
				gridPane.add(fromLabel, 3,0,1,1);
				gridPane.add(toBoxNewark, 3, 1,1,1);
				gridPane.add(toLabel, 3, 1,1,1);
				gridPane.add(time1, 4, 0,1,1);
				gridPane.add(time2, 4, 0,1,1);
				gridPane.add(time3, 4, 0,1,1);
				gridPane.add(time5, 4, 1,1,1);
				gridPane.add(time6, 4, 1,1,1);
				//gridPane.add(time7, 4, 2,1,1);
			}
		});

        Button helpButton    = new Button("HELP");
    	helpButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
		 	public void handle(ActionEvent e)
		 	{
				Platform.runLater(new Runnable()
				{
					public void run()
					{
						
						Alert alert = new Alert(Alert.AlertType.INFORMATION);
						alert.setTitle("---- HELP ---");
						alert.setHeaderText("You can use the following things");
						alert.setContentText("Use 'Exit' to leave program \n"
								+ "Click on the correct city to identify which city you wish to travel within \n"
								+ "Submit will submit your request for reservation on that flight \n");
						
						alert.showAndWait();
					}
				});
			}
		});
       // helpButton.setContentDisplay(ContentDisplay.BOTTOM);
       
    	// Logic for computing flat rate prices from origin to destination

    	  /* "E 34 ST",
           "JFK",
           "LaGuardia",
           "Newark",
           "W 30 ST",
           "Wall Street"*/
    	
    	
       // SUBMIT
        Button submitButton = new Button("SUBMIT");
        submitButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				Platform.runLater(new Runnable()
				{
					public void run()
					{
						socketUtils su = new socketUtils();
						
						if (su.socketConnect() == true)
						{
							if(timeSelect != ""){
							String strValue = new String();
							String from = null; // to be used for popup
							String to = null; // to be used for popup
							// PRICING
							double price = 0; // init
							if((fromBoxNY.getValue() == "E 34 ST" && toBoxNY.getValue() == "JFK") || (fromBoxNY.getValue() == "JFK" && toBoxNY.getValue() == "E 34 ST")) {
								price = 100; 
								from = fromBoxNY.getValue();
								to = toBoxNY.getValue();
							}
							else if ((fromBoxNY.getValue() == "E 34 ST" && toBoxNY.getValue() == "LaGuardia") || (fromBoxNY.getValue() == "LaGuardia" && toBoxNY.getValue() == "E 34 ST")) {
								price = 110;
								from = fromBoxNY.getValue();
								to = toBoxNY.getValue();
							}
							else if ((fromBoxNY.getValue() == "E 34 ST" && toBoxNY.getValue() == "Newark") || (fromBoxNY.getValue() == "Newark" && toBoxNY.getValue() == "E 34 ST")) {
								price = 150;
								from = fromBoxNY.getValue();
								to = toBoxNY.getValue();
							}
							else if ((fromBoxNY.getValue() == "E 34 ST" && toBoxNY.getValue() == "W 30 ST") || (fromBoxNY.getValue() == "W 30 ST" && toBoxNY.getValue() == "E 34 ST")) {
								price = 50;
								from = fromBoxNY.getValue();
								to = toBoxNY.getValue();
							}
							else if ((fromBoxNY.getValue() == "E 34 ST" && toBoxNY.getValue() == "Wall Street") || (fromBoxNY.getValue() == "Wall Street" && toBoxNY.getValue() == "E 34 ST")) {
								price = 55;
								from = fromBoxNY.getValue();
								to = toBoxNY.getValue();
							}
							else if ((fromBoxNY.getValue() == "JFK" && toBoxNY.getValue() == "LaGuardia") || (fromBoxNY.getValue() == "LaGuardia" && toBoxNY.getValue() == "JFK")) {
								price = 45;
								from = fromBoxNY.getValue();
								to = toBoxNY.getValue();
							}
							else if ((fromBoxNY.getValue() == "JFK" && toBoxNY.getValue() == "Newark") || (fromBoxNY.getValue() == "Newark" && toBoxNY.getValue() == "JFK")) {
								price = 75;
								from = fromBoxNY.getValue();
								to = toBoxNY.getValue();
							}
							else if ((fromBoxNY.getValue() == "JFK" && toBoxNY.getValue() == "W 30 ST") || (fromBoxNY.getValue() == "W 30 ST" && toBoxNY.getValue() == "JFK")) {
								price = 100;
								from = fromBoxNY.getValue();
								to = toBoxNY.getValue();
							}
							else if ((fromBoxNY.getValue() == "JFK" && toBoxNY.getValue() == "Wall Street") || (fromBoxNY.getValue() == "Wall Street" && toBoxNY.getValue() == "JFK")) {
								price = 105;
								from = fromBoxNY.getValue();
								to = toBoxNY.getValue();
							}
							else if ((fromBoxNY.getValue() == "LaGuardia" && toBoxNY.getValue() == "Newark") || (fromBoxNY.getValue() == "Newark" && toBoxNY.getValue() == "LaGuardia")) {
								price = 150;
								from = fromBoxNY.getValue();
								to = toBoxNY.getValue();
							}
							else if ((fromBoxNY.getValue() == "LaGuardia" && toBoxNY.getValue() == "W 30 ST") || (fromBoxNY.getValue() == "W 30 ST" && toBoxNY.getValue() == "LaGuardia")) {
								price = 90;
								from = fromBoxNY.getValue();
								to = toBoxNY.getValue();
							}
							else if ((fromBoxNY.getValue() == "LaGuardia" && toBoxNY.getValue() == "Wall Street") || (fromBoxNY.getValue() == "Wall Street" && toBoxNY.getValue() == "LaGuardia")) {
								price = 150;
								from = fromBoxNY.getValue();
								to = toBoxNY.getValue();
							}
							else if ((fromBoxNY.getValue() == "Newark" && toBoxNY.getValue() == "W 30 ST") || (fromBoxNY.getValue() == "W 30 ST" && toBoxNY.getValue() == "Newark")) {
								price = 120;
								from = fromBoxNY.getValue();
								to = toBoxNY.getValue();
							}
							else if ((fromBoxNY.getValue() == "Newark" && toBoxNY.getValue() == "Wall Street") || (fromBoxNY.getValue() == "Wall Street" && toBoxNY.getValue() == "Newark")) {
								price = 110;
								from = fromBoxNY.getValue();
								to = toBoxNY.getValue();
							}
							else if ((fromBoxNY.getValue() == "Wall Street" && toBoxNY.getValue() == "W 30 ST") || (fromBoxNY.getValue() == "W 30 ST" && toBoxNY.getValue() == "Wall Street")) {
								price = 60;
								from = fromBoxNY.getValue();
								to = toBoxNY.getValue();
							}
							// standard prices set up for all flights within the following cities
							else if ((fromBoxChicago.getValue() != null) || (toBoxChicago.getValue() != null)) {
								price = 85;
								from = fromBoxChicago.getValue();
								to = toBoxChicago.getValue();
							}
							else if ((fromBoxLA.getValue() != null) || (toBoxLA.getValue() != null)) {
								price = 75;
								from = fromBoxLA.getValue();
								to = toBoxLA.getValue();
							}
							else if ((fromBoxMiami.getValue() != null) || (toBoxMiami.getValue() != null)) {
								price = 120;
								from = fromBoxMiami.getValue();
								to = toBoxMiami.getValue();
							}
							else if ((fromBoxHouston.getValue() != null) || (toBoxHouston.getValue() != null)) {
								price = 50;
								from = fromBoxHouston.getValue();
								to = toBoxHouston.getValue();
							}
							else if ((fromBoxNewark.getValue() != null) || (toBoxNewark.getValue() != null)) {
								price = 100;
								from = fromBoxNewark.getValue();
								to = toBoxNewark.getValue();
							}
							
							Alert alert = new Alert(Alert.AlertType.INFORMATION);
							alert.setTitle("---- SUBMIT ---");
							alert.setHeaderText("Are you sure you wish to submit your trip?");
							alert.setContentText("You are flying from " + from +  "\n"
									+ "To " + to +  "\n"
									+ "at " + timeSelect + "\n"
									+ "for $" + price);
							
							alert.showAndWait();
							
							
							
							
							// INSTEAD OF USING fileIO write make these variables
							if(fromBoxNY.getValue() != null){	
								strValue = ("New York " + "From : " + fromBoxNY.getValue() + " To : " + toBoxNY.getValue() + " at " + timeSelect + " for: $" + price);
							} else if (fromBoxChicago.getValue() != null){
								strValue = ("Chicago " + "From : " + fromBoxChicago.getValue() + " To : " + toBoxChicago.getValue() + " at " + timeSelect + " for: $" + price);
							} else if (fromBoxLA.getValue() != null){
								strValue = ("LA " + "From : " + fromBoxLA.getValue() + " To : " + toBoxLA.getValue() + " at " + timeSelect + " for $" + price);
							String strDouble = String.format("%.2f", total);
							} else if (fromBoxMiami.getValue() != null){
								strValue = ("Miami " + "From : " + fromBoxMiami.getValue() + " To : " + toBoxMiami.getValue() + " at " + timeSelect + " for: $" + price);
							} else if (fromBoxHouston.getValue() != null){
								strValue = ("Houston " + "From : " + fromBoxHouston.getValue() + " To : " + toBoxHouston.getValue() + " at " + timeSelect + " for: $" + price);
							} else if (fromBoxNewark.getValue() != null){
								strValue = ("Newark " + "From : " + fromBoxNewark.getValue() + " To : " + toBoxNewark.getValue() + " at " + timeSelect + " for: $" + price);
							}
							
							// call variables from above to add to the string msg below
							String msg = "Transaction>Transaction#1" + strValue;
							su.sendMessage(msg);				            	
            	               				String rs = su.recvMessage();
            	                			su.closeSocket();
            	                
            	                			total= 0.0f;
            	                		//	ta.setText("");
            	                		//	ta2.setText("");
            	                
            	                		//	ta2.setText("RECV : " + rs);
            	                		Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            	                		alert1.setTitle("Success!");
				            			}
				            			else
				            			{
				            				Alert alert1 = new Alert(Alert.AlertType.ERROR);
						        			alert1.setTitle("--- Network Communications Error ---");
						       				alert1.setHeaderText("Unable to talk to Socket Server!");
						       				alert1.setContentText("Be sure that you have filled out all of the fields.");
						          
						        			alert1.showAndWait();
				            			}
				        		}
					}
				    		});	
			}
		});

        //Exit button
        Button exitButton = new Button("EXIT");
		exitButton.setOnAction(new EventHandler<ActionEvent>(){
			@Override public void handle(ActionEvent e){
				System.exit(0);
			}
		});

		GridPane.setHalignment(exitButton, HPos.CENTER);
		GridPane.setHalignment(helpButton, HPos.CENTER);

        //  gridPane.setCenter(imageOK);
        gridPane.add(imageOK,     1, 0, 1, 1);
        gridPane.add(helpButton,  0, 0, 1, 1);
        gridPane.add(exitButton,  2, 0, 1, 1);

        gridPane.add(button2,     0, 1, 1, 1);
        gridPane.add(button3,     1, 1, 1, 1);
        gridPane.add(button4,     2, 1, 1, 1);
        gridPane.add(button5,     0, 2, 1, 1);
        gridPane.add(button6,     1, 2, 1, 1);
        gridPane.add(button7,     2, 2, 1, 1);
        gridPane.add(submitButton,4, 2, 1, 1);


        // This code is what confuses me: It has something to do with creating the box layout, but you might have to play with
        // setting it to the exact right places
        VBox vb = new VBox();
        BorderPane bp = new BorderPane();
        bp.setTop(clock);
        //bp.setTop(imageOK);
        //bp.setLeft("");
        bp.setCenter(gridPane);
        bp.setRight(vb);
        //bp.setBottom("");


        // start all ---threads--- for the GUI screen
        refreshClock();

        BackgroundFill background_fill = new BackgroundFill(Color.BLACK,
                CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        gridPane.setBackground(background);

        Scene scene = new Scene(bp);

        sc.setLayoutX(scene.getHeight()-sc.getHeight());
        sc.setMin(0);
        sc.setOrientation(Orientation.HORIZONTAL);
        sc.setPrefHeight(180);
        sc.setMax(360);
        
        sp.setVmax(440);
        sp.setPrefSize(115, 150);
        sp.setContent(vb);
        sp.vvalueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
                Number old_val, Number new_val) {
                    scene.getHeight();
            }
        });

        stage.setScene(scene);
        stage.show();

    }


	// Kounivales' code for constantly running the clock at the top of the window
    private void refreshClock()
    {
    	Thread refreshClock = new Thread()
		   {
			  public void run()
			  {
				while (true)
				{
					Date dte = new Date();

					String topMenuStr = "       " + dte.toString();
				    clock.setText(topMenuStr);

				    try
				    {
					   sleep(3000L);
				    }
				    catch (InterruptedException e)
				    {
					   // TODO Auto-generated catch block
					   e.printStackTrace();
				    }

	            }  // end while ( true )

		    } // end run thread
		 };

	     refreshClock.start();
    }


	public static void main(String[] args)
	{
		launch(args);
	}

}
