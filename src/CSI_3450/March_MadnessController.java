/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSI_3450;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nbradley
 */
public class March_MadnessController implements Initializable {

    @FXML private void exitCalculator(){
       System.exit(1);
    }
    
    @FXML private ChoiceBox SelectDatabase;
   
    @FXML 
    private void SceneSelectorButton(ActionEvent event)throws IOException{
        if (SelectDatabase.getValue() == "March Madness"){
            goToMarch_Madness(event);
        }
        if (SelectDatabase.getValue() == "Teams"){
            goToTeams(event);
        }
        if (SelectDatabase.getValue() == "Coaches"){
            goToCoaches(event);
        }
        if (SelectDatabase.getValue() == "Players"){
            goToPlayers(event);
        }
    }
    
    private void goToTeams(ActionEvent event)throws IOException {
        Parent playerParent = FXMLLoader.load(getClass().getResource("Teams.fxml"));
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        Scene Teams = new Scene(playerParent,visualBounds.getWidth(), visualBounds.getHeight());
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(Teams);
        window.show();
    }
    
    private void goToCoaches(ActionEvent event)throws IOException {
        Parent playerParent = FXMLLoader.load(getClass().getResource("Coaches.fxml"));
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        Scene Coaches = new Scene(playerParent,visualBounds.getWidth(), visualBounds.getHeight());
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(Coaches);
        window.show();
    }
    
    private void goToPlayers(ActionEvent event)throws IOException {
        Parent playerParent = FXMLLoader.load(getClass().getResource("Players.fxml"));
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        Scene Players = new Scene(playerParent,visualBounds.getWidth(), visualBounds.getHeight());
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(Players);
        window.show();
    }
    
    private void goToMarch_Madness(ActionEvent event)throws IOException {
        Parent playerParent = FXMLLoader.load(getClass().getResource("March_Madness.fxml"));
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        Scene March_Madness = new Scene(playerParent,visualBounds.getWidth(), visualBounds.getHeight());
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(March_Madness);
        window.show();
    }
    
      /*  public void changeScreenButtonPushed(javafx.event.ActionEvent event) throws IOException
    {
        Parent HomeScreen = FXMLLoader.load(getClass().getResource("Teams.fxml"));
        Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
        Scene Home = new Scene(HomeScreen,visualBounds.getWidth(), visualBounds.getHeight());
        
        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(Home);
        window.show();
        }*/
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
         SelectDatabase.getItems().add("Teams");
         SelectDatabase.getItems().add("Coaches");
         SelectDatabase.getItems().add("Players");
         SelectDatabase.getItems().add("March Madness");
         SelectDatabase.setValue("March Madness");
    }    
    
    @FXML
    public Button roundTwogameOneteamOneButton = new Button();
    @FXML 
    private void roundOnegameOneteamOneButton(ActionEvent event)throws IOException{
        roundTwogameOneteamOneButton.setText("Duke");
    }
    
    @FXML 
    private void roundOnegameOneteamTwoButton(ActionEvent event)throws IOException{
        roundTwogameOneteamOneButton.setText("North Dakota St");
    }
    @FXML 
    private void roundTwogameOneteamOneButton(ActionEvent event)throws IOException{

    }
/*
    public ObservableList<Compare> getStats(){
        
        ObservableList<Compare> stats = FXCollections.observableArrayList();
        
        SelectDatabase.getItems().addAll("Teams", "Coaches", "Players", "March Madness");
        return stats;
    }*/




}
