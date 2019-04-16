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
public class Players implements Initializable {
    
    @FXML private void exitCalculator(){
       System.exit(1);
    }

    @FXML private TableView<Player_data> tableView;
    @FXML private TableColumn<Player_data, String> Rank;
    @FXML private TableColumn<Player_data, String> Player; 
    @FXML private TableColumn<Player_data, String> Team;
    @FXML private TableColumn<Player_data, String> GP;
    @FXML private TableColumn<Player_data, String> MPG;
    @FXML private TableColumn<Player_data, String> PTS;
    @FXML private TableColumn<Player_data, String> FGM_FGA;
    @FXML private TableColumn<Player_data, String> FGPer;
    @FXML private TableColumn<Player_data, String> threePMthreePA;
    @FXML private TableColumn<Player_data, String> threePer;
    @FXML private TableColumn<Player_data, String> FTM_FTA;
    @FXML private TableColumn<Player_data, String> FTPer;
    @FXML private TableColumn<Player_data, String> TP_Per;
    @FXML private ChoiceBox SelectDatabase;
    private ObservableList<Player_data>data;
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
        Rank.setCellValueFactory(new PropertyValueFactory<Player_data, String>("Rank"));
        Player.setCellValueFactory(new PropertyValueFactory<Player_data, String>("Player"));
        Team.setCellValueFactory(new PropertyValueFactory<Player_data, String>("Team"));
        GP.setCellValueFactory(new PropertyValueFactory<Player_data, String>("GP"));
        MPG.setCellValueFactory(new PropertyValueFactory<Player_data, String>("MPG"));
        PTS.setCellValueFactory(new PropertyValueFactory<Player_data, String>("PTS"));
        FGM_FGA.setCellValueFactory(new PropertyValueFactory<Player_data, String>("FGM_FGA"));
        FGPer.setCellValueFactory(new PropertyValueFactory<Player_data, String>("FGPer"));
        threePMthreePA.setCellValueFactory(new PropertyValueFactory<Player_data, String>("threePMthreePA"));
        threePer.setCellValueFactory(new PropertyValueFactory<Player_data, String>("threePer"));
        FTM_FTA.setCellValueFactory(new PropertyValueFactory<Player_data, String>("FTM_FTA"));
        FTPer.setCellValueFactory(new PropertyValueFactory<Player_data, String>("FTPer"));
        //tableView.setItems(getStats());
        dc = new DbConnection();
        
        SelectDatabase.getItems().add("Teams");
        SelectDatabase.getItems().add("Coaches");
        SelectDatabase.getItems().add("Players");
        SelectDatabase.getItems().add("March Madness");
        SelectDatabase.setValue("Players");
        loadDataFromDatabase();
    }    
    
    public void loadDataFromDatabase(){
        try {
            Connection conn = dc.Connect();
            data=FXCollections.observableArrayList();
            ResultSet rs = conn.createStatement().executeQuery("SELECT Rank, Player, Team,"
                    + "GP, MPG, PTS, FGM_FGA, FGPer, threePMthreePA, threePer,"
                    + "FTM_FTA, FTPer FROM dbprojectv3.players");
            while(rs.next()){
                data.add(new Player_data(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), 
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
            ResultSet rs = conn.createStatement().executeQuery("SELECT Rank, Player, Team,"
                    + "GP, MPG, PTS, FGM_FGA, FGPer, threePMthreePA, threePer,"
                    + "FTM_FTA, FTPer FROM dbprojectv3.players"
                    + " WHERE Player LIKE '%"+search+"%'");
            while(rs.next()){
                data.add(new Player_data(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), 
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
    public ObservableList<Player_data> getStats(){
        
        ObservableList<Player_data> stats = FXCollections.observableArrayList();
        
        SelectDatabase.getItems().addAll("Teams", "Coaches", "Players", "March Madness");
        return stats;
    }*/
}    
    

