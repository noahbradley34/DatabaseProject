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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Brandon
 */
public class Coaches implements Initializable {
    
    @FXML private void exitCalculator(){
       System.exit(1);
    }

    @FXML private TableView<Coach_data> tableView;
    @FXML private TableColumn<Coach_data, String> Coach_Name;
    @FXML private TableColumn<Coach_data, String> School; 
    @FXML private TableColumn<Coach_data, String> Career_Record;
    @FXML private TableColumn<Coach_data, String> Age;
    @FXML private ChoiceBox SelectDatabase;
    private ObservableList<Coach_data>data;
    private DbConnection dc;
    
    
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
    
    /*public void changeScreenButtonPushed(javafx.event.ActionEvent event) throws IOException
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
    public void initialize(URL location, ResourceBundle resources) {
        Coach_Name.setCellValueFactory(new PropertyValueFactory<Coach_data, String>("Coach_Name"));
        School.setCellValueFactory(new PropertyValueFactory<Coach_data, String>("School"));
        Career_Record.setCellValueFactory(new PropertyValueFactory<Coach_data, String>("Career_Record"));
        Age.setCellValueFactory(new PropertyValueFactory<Coach_data, String>("Age"));
        //tableView.setItems(getStats());
        dc = new DbConnection();
        
        SelectDatabase.getItems().add("Teams");
        SelectDatabase.getItems().add("Coaches");
        SelectDatabase.getItems().add("Players");
        SelectDatabase.getItems().add("March Madness");
        SelectDatabase.setValue("Coaches");
        loadDataFromDatabase();
    }    
   
    public void loadDataFromDatabase(){
        try {
            Connection conn = dc.Connect();
            data=FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT Coach_Name,School, Career_Record, Age FROM dbprojectv3.coachs_table_");
            while(rs.next()){
                data.add(new Coach_data(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4)));
                
            }
            
        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
       
        tableView.setItems(null);
        tableView.setItems(data);
    }
    
    @FXML private TextField Search;
   
    @FXML
    private void SearchButton(ActionEvent event)throws IOException {
       String search = Search.getText();
       int dummyCount = 0;
        try {
            if(search.equals("") || search.equals(" ")){
                dummyCount = dummyCount + 0;
            }
            else{
                
            
            Connection conn = dc.Connect();
            data=FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT Coach_Name, School, Career_Record, Age FROM dbprojectv3.coachs_table_"
                    + " WHERE Coach_Name LIKE '%"+search+"%'");
            while(rs.next()){
                data.add(new Coach_data(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
            }
        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
        
        tableView.setItems(null);
        tableView.setItems(data);
        
    }
    
    /**
     *
     * @return
     *//*
    public ObservableList<Compare> getStats(){
        
        ObservableList<Compare> stats = FXCollections.observableArrayList();
        
        SelectDatabase.getItems().addAll("Teams", "Coaches", "Players", "Conferences");
        return stats;
    }*/
}    
    

