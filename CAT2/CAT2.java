/**
* <h1>This is the code for the implementation of the interface </h1> 
* This program simply demonstrates a basic rich GUI using JavaFX API
* driven by a DB called Cat2 on the back end
* @author  Group lead by Ashuza 
* @version 1.0 
*/

import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;


import javafx.scene.control.Button;
import javafx.scene.Group;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent; 

import java.sql.*; 
import java.util.*; 

//import java.io.FileInputStream;


public class CAT2 extends Application implements InterCat2 {
	 /**
   *  The program begins by declaring some global DB variables
   */
   Connection conn = null;	
   String DB_URL = "jdbc:mysql://localhost/Cat2";   
   String USER = "root"; 
   String  PASS = ""; 
	
	/**
   * This method is used to display the entire GUI on a stage
   */
   

    @Override
	public void start(Stage stage) throws Exception{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    conn = DriverManager.getConnection(DB_URL, USER, PASS);
		}catch(ClassNotFoundException ex) {
				System.out.println("Error: unable to load driver class!");
				System.exit(1);
		}
		
        
		/** step 2: creation of text labels */
		Text text1 = new Text ("Names:");
		
		
		Text text2 = new Text ("Date of Birth:");
                
                
                Text text3 = new Text ("Email Address:");
                Text text4 = new Text ("Home Address:");
                Text text5 = new Text ("Phone Number:");
                Text text6 = new Text ("Expected Salary:");
                Text text7 = new Text ("Referee's Names:");
		Text text8 = new Text ("Referee's Email Address:");
                Text text9 = new Text ("Career Profession:");
                Text text10 = new Text ("Academic Level:");
		/**step 3: creation Text Fields
		*/
		TextField textField1 = new TextField();
               
		TextField textField3 = new TextField();
                TextField textField4 = new TextField();
                TextField textField5 = new TextField();
                TextField textField6 = new TextField();
                TextField textField7 = new TextField();
                TextField textField8 = new TextField();
		
                
                TextField date = new TextField();
                 
                 
                 
                 Button button1 = new Button ("Save");
                 Button button2 = new Button ("Complete The registration");
                 
                
                 
                 TextField textField2 = new TextField();
                 
                 
                 TextField textField9 = new TextField ();
               
      
                EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() { 
         @Override 
         public void handle(MouseEvent e) {
            System.out.println("Take to DB form here");
			  try{ 
              String sql = "INSERT INTO User"+"(id,Names,DOB,Email,	Home,Pnumber,Salary,Refereen,Refereeem,	Cprofession,Alevel) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			  final PreparedStatement stmt = conn.prepareStatement(sql);			  
			  
			  stmt.setInt(1,1);
			  stmt.setString(2,textField1.getText());
			  stmt.setString(3,date.getText());
			  stmt.setString(4,textField3.getText());
			  stmt.setString(5,textField4.getText());
			  stmt.setString(6,textField5.getText());
			  stmt.setString(7,textField2.getText());
			  stmt.setString(8,textField9.getText());
			  stmt.setString(9,textField6.getText());
			  stmt.setString(10,textField7.getText());
			  stmt.setString(11,textField8.getText());
			  
			  stmt.executeUpdate();}catch(SQLException se){
				  se.printStackTrace();
				  }		 
             
            System.out.println("Congratulations Upon your Job Application Registration"); 
            button2.setStyle("-fx-background-color: Blue; -fx-font-size:13pt;");
         } 
      };  
                
                /**Registering the event filter */
                button2.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler); 
	        GridPane gridPane = new GridPane();
                
                
		gridPane.setMinSize(450, 600);
		
		/**step 8: Set padding*/
		gridPane.setPadding(new Insets(50, 50, 50, 50));
		
		/** step 9: Set the vertical and horinzotal gaps between the columns*/
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		
                
		/**step 10: Set the Grid Alignment*/
                
                
		gridPane.setAlignment(Pos.CENTER);
		
               
                
		/**step 11: Arrange all the nodes in the grid */
		gridPane.add(text1, 0, 0);
		gridPane.add(textField1, 1, 0);
		
		
		gridPane.add(text2, 0, 1);
              
		gridPane.add(date, 1, 1);
		
		gridPane.add(text3, 0, 3);
                
                
                gridPane.add(textField3,1, 3);
		
                gridPane.add(text4,0,4);
                gridPane.add(textField4,1,4);
                
                gridPane.add(text5,0,5);
                gridPane.add(textField5,1,5);
                
                gridPane.add(text6,0,8);
                gridPane.add(textField6,1,8);
                
                gridPane.add(text7,0,10);
                gridPane.add(textField7,1,10);
                
                gridPane.add(text8,0,11);
                gridPane.add(textField8,1,11);
                
                gridPane.add(button1, 1, 9);
                
                gridPane.add(text9,0,6);
                gridPane.add(textField2,1,6);
                
                gridPane.add(text10,0,7);
                gridPane.add(textField9,1,7);
                
                gridPane.add(button2,1,12);
                
		/** step 12: Style nodes be creative and more Styles */
		button1.setStyle("-fx-background-color: cornflowerblue; -fx-text-fill: white; -fx-font-size:13pt;");
                button2.setStyle("-fx-background-color: cornflowerblue; -fx-text-fill: white; -fx-font-size:13pt;");
		
		
		text1.setStyle("-fx-font: normal bold 20px 'serif' ");
		text2.setStyle("-fx-font: normal bold 20px 'serif' ");
		text3.setStyle("-fx-font: normal bold 20px 'serif' ");
		text4.setStyle("-fx-font: normal bold 20px 'serif' ");
                text5.setStyle("-fx-font: normal bold 20px 'serif' ");
                text6.setStyle("-fx-font: normal bold 20px 'serif' ");
                text7.setStyle("-fx-font: normal bold 20px 'serif' ");
                text8.setStyle("-fx-font: normal bold 20px 'serif' ");
                text9.setStyle("-fx-font: normal bold 20px 'serif' ");
                text10.setStyle("-fx-font: normal bold 20px 'serif' ");
                
		gridPane.setStyle("-fx-background-color: darkslategrey");
               
                
                  
		Scene scene = new Scene(gridPane);
		
                 
		/**Setting title to the Stage*/
		stage.setTitle("Jobseeker Application");
		
		
		stage.setScene(scene);
               
		
		/**Dispalying the contents of the stage*/
		stage.show();
        }
		
		 public void Registration() {  
      launch();  
   }  
}