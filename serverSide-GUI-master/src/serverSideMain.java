// Blade Team: Derek, Kylie, Armaan
// Make sure under server side
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Optional;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;


public class serverSideMain extends Application 
{
	public static TextArea textArea;
	public static TextArea textArea_1;
	public static TextArea textArea_2;
	public static TextArea textArea_3;
	TextArea               clock;
	
	@Override
	public void start (Stage stage) throws FileNotFoundException
	{
		InetAddress ipAddress = null;
		try
		{
			ipAddress = InetAddress.getLocalHost();
		}
		catch (UnknownHostException el)
		{
			el.printStackTrace();
		}
		stage.setTitle("Simple Socket Server JAVA FX Rev 5.0   :   Rel Date March 21, 2020         " + 
	                   "IP : " + ipAddress.getHostAddress() + "     Port# : 3333");
		stage.setWidth(1400);
		stage.setHeight(800);
		
		
		//
		// text area for real time clock thread to display
		//
		clock = new TextArea();
		clock.setEditable(false);
		clock.setPrefHeight(30);
		clock.setPrefWidth(900);
		
		
		// available text area
		textArea_1 = new TextArea();
		textArea_1.setEditable(false);
		textArea_1.setPrefHeight(80);
		textArea_1.setPrefWidth(300);
		
		// Active / nonActive Helicopters
		boolean active1 = true, active2 = false, active3 = false;
			textArea_1.setText("Heli 1:" + active1 + ("\n") + "Heli 2:" + active2 + ("\n") + "Heli 3: " + active3);
		
		
		// main area for socket server to display messages
		textArea = new TextArea();
		textArea.setFont(Font.font("Verdana", 18));
		textArea.setEditable(false);
		textArea.setPrefHeight(80);
		textArea.setPrefWidth(300);
				
				
		// available text area
		textArea_3 = new TextArea();
		textArea_3.setEditable(false);
		textArea_3.setPrefHeight(80);
		textArea_3.setPrefWidth(300);
		
		
		// area for IP addresses of clients who connect to the socket server
		textArea_2 = new TextArea();
		textArea_2.setEditable(false);
		textArea_2.setPrefHeight(80);
		textArea_2.setPrefWidth(900);
		
		
		//
		// define all BUTTONS
		//
		Button exitButton = new Button("EXIT");
		exitButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
		 	public void handle(ActionEvent e)
		 	{
				Platform.runLater(new Runnable()
				{
					public void run()
					{
						Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
						alert.setTitle("---EXIT---");
						alert.setHeaderText("Are you sure you want to exit?");
						Optional <ButtonType> action = alert.showAndWait();
						if(action.get() == ButtonType.OK)
						{
							System.exit(0);
						}
						
					}
				});
			}
		});
		
		
//		Button clients = new Button("Clients");
//		clients.setOnAction(new EventHandler<ActionEvent>()
//		{
//			@Override
//		 	public void handle(ActionEvent e)
//		 	{
//		
//			}
//		});
		Button showLog = new Button("Show Log");
		showLog.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
		 	public void handle(ActionEvent e)
		 	{
				Platform.runLater(new Runnable() 
				 {
					    String logString = "";
					    
				        public void run() 
				        {
				        	try
				            {
				        	      File f = new File("transactionLog.txt");
				        	      if (f.exists())
				        	      {
				                    FileReader reader = new FileReader("transactionLog.txt");
				                    BufferedReader br = new BufferedReader(reader);
				                  
				                    String line = br.readLine();
				                    while (line != null)
				                    {	
				                    	for (int i =0; i<10; i++) {
				                    	logString = logString + line + "\r\n";
				                    	line = br.readLine();
				                    	}
				                    }
				                    
				                    br.close();
				        	      }
				        	      else
				        	      {
				        	    	  logString = "No log File Found!";
				        	      }
				        	 }
				             catch(Exception e2)
				             {   
				        	    e2.printStackTrace(); 
				             }		
				        	
				             Alert alert = new Alert(Alert.AlertType.INFORMATION);
				             alert.setTitle("--- Ticket Kiosk ---");
				             alert.setHeaderText("Transaction Log File");
				          
				             alert.setContentText(logString);
				             alert.setWidth(300);
				             alert.setHeight(600);
				             alert.showAndWait();
				        }
				    });	
				
				
	               
			}
		});
		/*
		Button summary = new Button("Summary");
		summary.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
		 	public void handle(ActionEvent e)
		 	{
				Platform.runLater(new Runnable() 
				 {
					    String logString = "";
					    
				        public void run() 
				        {
				        	try
				            {
				        	      File f = new File("transactionLog.txt");
				        	      if (f.exists())
				        	      {
				                    FileReader reader = new FileReader("transactionLog.txt");
				                    BufferedReader br = new BufferedReader(reader);
				                  
				                    String line = br.readLine();
				                    while (line != null)
				                    {	
				                    	for (int i =0; i<10; i++) {
				                    	logString = logString + line + "\r\n";
				                    	line = br.readLine();
				                    	}
				                    }
				                    
				                    br.close();
				        	      }
				        	      else
				        	      {
				        	    	  logString = "No log File Found!";
				        	      }
				        	 }
				             catch(Exception e2)
				             {   
				        	    e2.printStackTrace(); 
				             }		
				        	
				             Alert alert = new Alert(Alert.AlertType.INFORMATION);
				             alert.setTitle("--- Summary ---");
				             alert.setHeaderText("Totale Price Summary of Flights");
				             String[] workingStr = null;
				             //System.out.println(logString);
				             String[]parts = logString.split("for:");
				             //workingStr = parts[1];
				             int j=0;
				             for(int i=0; i<logString.length(); i++)
				             {
				            	 if (i % 2 == 0) {
				            		 System.out.println(""); // do nothing
				            	 }
				            	 else {
				            		workingStr[j] = parts[i];
				            		j++;
				            	 }
				            	
				             }
				             //int price = Integer.parseInt(workingStr.replaceAll("[\\D]", ""));
				             
				             System.out.println(workingStr);
				
//				             alert.setContentText(logString);
//				             alert.setWidth(300);
//				             alert.setHeight(600);
//				             alert.showAndWait();
				        }
				    });	
			}
		});
		*/
		Button newKiosk = new Button("Total Trips");
		newKiosk.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
		 	public void handle(ActionEvent e)
		 	{
				Platform.runLater(new Runnable() 
				 {
				        public void run() 
				        {
				          sockServer.createNewKiosk();
				          
				          Alert alert = new Alert(Alert.AlertType.INFORMATION);
				          alert.setTitle("--- Trip Transactions ---");
				          alert.setHeaderText("Total Number of Transactions");
				          
				          alert.setContentText(sockServer.getAllTransactions());
				          
				          alert.showAndWait();
				        }
				    });	
			}
		});
		
		Button query1 = new Button("Help");
		query1.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
		 	public void handle(ActionEvent e)
		 	{
				Platform.runLater(new Runnable()
				{
					public void run()
					{
						//sockServer.createNewKiosk();
						
						Alert alert = new Alert(Alert.AlertType.INFORMATION);
						alert.setTitle("---- HELP ---");
						alert.setHeaderText("You can use the following things");
						alert.setContentText("Use 'Exit' to leave program \n"
								+ "Summary to show summary of server entries \n"
								+ "Show log will display anything sent into the server \n");
						
						alert.showAndWait();
					}
				});
			}
		});
		
		/*
		Button query2 = new Button("Query #2");
		query2.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
		 	public void handle(ActionEvent e)
		 	{
		
			}
		});
		
		Button query3 = new Button("Query #3");
		query3.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
		 	public void handle(ActionEvent e)
		 	{
				 Platform.runLater(new Runnable() 
				 {
				        public void run() 
				        {
				          Alert alert = new Alert(Alert.AlertType.INFORMATION);
				          alert.setTitle("--- What is this ---");
				          alert.setHeaderText("Total Number of Transactions");
				          
				          alert.setContentText(sockServer.getAllTransactions());
				          
				          alert.showAndWait();
				        }
				    });
			}
		});
	*/
		
		
		//
		// all buttons go to horizontal view
		//
		HBox hb = new HBox();
		hb.setPadding(new Insets(15, 12, 15, 12));
	    hb.setSpacing(220);
		hb.getChildren().addAll(exitButton, showLog, newKiosk, query1); //, summary, query2, query3);
		
		//
		// vertical has IP text area and buttons below
		//
		VBox vb = new VBox();
		vb.getChildren().addAll(textArea_2, hb);
		
		
		//
		// main BORDER PANE pane layout
		//
		BorderPane bp = new BorderPane();
		bp.setTop(clock);
		bp.setLeft(textArea_1);
		bp.setCenter(textArea);
		bp.setRight(textArea_3);
		bp.setBottom(vb);
		BackgroundFill background_fill = new BackgroundFill(Color.BLACK,
			CornerRadii.EMPTY, Insets.EMPTY);
		Background background = new Background(background_fill);
		bp.setBackground(background);
		
		
		// start all threads  for the GUI screen here
		startRealTimeClock();
		
		// start the socket server thread - will start to accept client connections
		startSockServer();
		
		//
		// lights, camera, action
		//
		Scene scene = new Scene(bp);
		stage.setScene(scene);
		stage.show();
	}

	
  /*
   * Thread to update weather info for NYC and Boston    
   */     
  private void startSockServer()
  {	
	 Thread refreshWeatherThread = new Thread()
	 {
	    public void run()
		  { 	
			  sockServer.runSockServer();
	      }
	 };

    refreshWeatherThread.start();
  }
	
  
  /*
   * Thread to update weather info for NYC and Boston    
   */     
  private void startRealTimeClock()
  {	
	   Thread refreshClock = new Thread()
	   {
		  public void run()
		  {   
			 clock.setFont(Font.font("Verdana", 14));
			 
			 while (true)
			 {	 			      
				   Date date = new Date();
				   String str = String.format("    %tc", date);
					 
				   clock.setText("");
				   clock.setText(str);
				   
			    	try
				    {
					   sleep(5000L);
				    }
				    catch (InterruptedException e)
				   {
					   // TODO Auto-generated catch block
					  e.printStackTrace();
				   }
             } // end while true 
	     }
	  };

    refreshClock.start();
   }
  


	
   //
   // main function starts here
   //
   public static void main(String[] args)
   {
		launch(args);
   }
}
