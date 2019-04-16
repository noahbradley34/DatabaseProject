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
public class Teams implements Initializable {
    
    @FXML private void exitCalculator(){
       System.exit(1);
    }

    @FXML private TableView<Compare> tableView;
    @FXML private TableColumn<Compare, String> School;
    @FXML private TableColumn<Compare, String> GB; 
    @FXML private TableColumn<Compare, String> Conf_W_L;
    @FXML private TableColumn<Compare, String> Conf_Win_Per;
    @FXML private TableColumn<Compare, String> Overall_W_L;
    @FXML private TableColumn<Compare, String> Overall_Win_Per;
    @FXML private TableColumn<Compare, String> Home;
    @FXML private TableColumn<Compare, String> Away;
    @FXML private TableColumn<Compare, String> Win_Streak;
    @FXML private TableColumn<Compare, String> AP;
    @FXML private TableColumn<Compare, String> USA;
    @FXML private TableColumn<Compare, String> Conf;
    @FXML private ChoiceBox SelectDatabase;
    private ObservableList<Compare>data;
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
        Scene Players = new Scene(playerParent,visualBounds.getWidth(), visualBounds.getHeight());
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(Players);
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
    public void initialize(URL location, ResourceBundle resources) {
        School.setCellValueFactory(new PropertyValueFactory<Compare, String>("School"));
        GB.setCellValueFactory(new PropertyValueFactory<Compare, String>("GB"));
        Conf_W_L.setCellValueFactory(new PropertyValueFactory<Compare, String>("Conf_W_L"));
        Conf_Win_Per.setCellValueFactory(new PropertyValueFactory<Compare, String>("Conf_Win_Per"));
        Overall_W_L.setCellValueFactory(new PropertyValueFactory<Compare, String>("Overall_W_L"));
        Overall_Win_Per.setCellValueFactory(new PropertyValueFactory<Compare, String>("Overall_Win_Per"));
        Home.setCellValueFactory(new PropertyValueFactory<Compare, String>("Home"));
        Away.setCellValueFactory(new PropertyValueFactory<Compare, String>("Away"));
        Win_Streak.setCellValueFactory(new PropertyValueFactory<Compare, String>("Win_Streak"));
        AP.setCellValueFactory(new PropertyValueFactory<Compare, String>("AP"));
        USA.setCellValueFactory(new PropertyValueFactory<Compare, String>("USA"));
        Conf.setCellValueFactory(new PropertyValueFactory<Compare, String>("Conf"));
        //tableView.setItems(getStats());
        dc = new DbConnection();
        
        SelectDatabase.getItems().add("Teams");
        SelectDatabase.getItems().add("Coaches");
        SelectDatabase.getItems().add("Players");
        SelectDatabase.getItems().add("March Madness");
        SelectDatabase.setValue("Teams");
        loadDataFromDatabase();
    }    
    
    public void loadDataFromDatabase(){
        try {
            Connection conn = dc.Connect();
            data=FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT School ,Conf_W_L, GB, Conf_Win_Per, Overall_W_L, Overall_Win_Per, Home, "
                    + "Away, Win_Streak , AP, USA, Conf FROM dbprojectv3.teams");
            while(rs.next()){
                data.add(new Compare(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getFloat(6), 
                        rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11), rs.getString(12)));
                
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
            ResultSet rs = conn.createStatement().executeQuery("SELECT School ,Conf_W_L, GB, Conf_Win_Per, Overall_W_L, Overall_Win_Per, Home, "
                    + "Away, Win_Streak , AP, USA, Conf FROM dbprojectv3.teams"
                    + " WHERE School LIKE '%"+search+"%'");
            while(rs.next()){
                data.add(new Compare(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getFloat(6), 
                        rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11), rs.getString(12)));
                
            }
            }
        } catch (SQLException ex) {
            System.err.println("Error"+ex);
        }
        
        tableView.setItems(null);
        tableView.setItems(data);
        
    }
    
        @FXML
    private void confSearchButton(ActionEvent event)throws IOException {
       String search = Search.getText();
       int dummyCount = 0;
        try {
            if(search.equals("") || search.equals(" ")){
                dummyCount = dummyCount + 0;
            }
            else{
                
            
            Connection conn = dc.Connect();
            data=FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT School ,Conf_W_L, GB, Conf_Win_Per, Overall_W_L, Overall_Win_Per, Home, "
                    + "Away, Win_Streak , AP, USA, Conf FROM dbprojectv3.teams"
                    + " WHERE Conf LIKE '%"+search+"%'");
            while(rs.next()){
                data.add(new Compare(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getFloat(6), 
                        rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11), rs.getString(12)));
                
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
        
        SelectDatabase.getItems().addAll("Teams", "Coaches", "Players", "March Madness");
        return stats;
    }*/
}    
    

