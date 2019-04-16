/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CSI_3450;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.CheckBox;

//import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Brandon
 */
public class Player_data{
    
    private SimpleStringProperty Rank, Player, Team; 
    private SimpleStringProperty GP, MPG, PTS, FGM_FGA, FGPer, threePMthreePA, threePer, FTM_FTA, 
            FTPer;
    private CheckBox check;

    public Player_data(String Rank, String Player, String Team, String GP, String MPG, String PTS, String FGM_FGA,
            String FGPer, String threePMthreePA, String threePer, String FTM_FTA, String FTPer) {
        this.Rank = new SimpleStringProperty(Rank);
        this.Player = new SimpleStringProperty(Player);
        this.Team = new SimpleStringProperty(Team);
        this.GP = new SimpleStringProperty(GP);
        this.MPG = new SimpleStringProperty(MPG);
        this.PTS = new SimpleStringProperty(PTS);
        this.FGM_FGA = new SimpleStringProperty(FGM_FGA);
        this.FGPer = new SimpleStringProperty(FGPer);
        this.threePMthreePA = new SimpleStringProperty(threePMthreePA);
        this.threePer = new SimpleStringProperty(threePer);
        this.FTM_FTA = new SimpleStringProperty(FTM_FTA);
        this.FTPer = new SimpleStringProperty(FTPer);

    }
    
    public String getTeam() {
        return Team.get();
    }

    public void setTeam(SimpleStringProperty Team) {
        this.Team = Team;
    }

    public String getPlayer() {
        return Player.get();
    }

    public void setPlayer(SimpleStringProperty Player) {
        this.Player = Player;
    }

    public String getGP() {
        return GP.get();
    }

    public void setGP(SimpleStringProperty GP) {
        this.GP = GP;
    }

    public String getMPG() {
        return MPG.get();
    }

    public void setMPG(SimpleStringProperty MPG) {
        this.MPG = MPG;
    }

    public String getPTS() {
        return PTS.get();
    }

    public void setPTS(SimpleStringProperty PTS) {
        this.PTS = PTS;
    }

    public String getFGM_FGA() {
        return FGM_FGA.get();
    }

    public void setFGM_FGA(SimpleStringProperty FGM_FGA) {
        this.FGM_FGA = FGM_FGA;
    }

    public String getFGPer() {
        return FGPer.get();
    }

    public void setFGPer(SimpleStringProperty FGPer) {
        this.FGPer = FGPer;
    }

    public String getThreePer() {
        return threePer.get();
    }

    public void setThreePer(SimpleStringProperty threePer) {
        this.threePer = threePer;
    }

    public String getFTM_FTA() {
        return FTM_FTA.get();
    }

    public void setFTM_FTA(SimpleStringProperty FTM_FTA) {
        this.FTM_FTA = FTM_FTA;
    }

    public String getFTPer() {
        return FTPer.get();
    }

    public void setFTPer(SimpleStringProperty FTPer) {
        this.FTPer = FTPer;
    }
    
    public String getRank() {
        return Rank.get();
    }

    public void setRank(SimpleStringProperty Rank) {
        this.Rank = Rank;
    }
    
    public String getThreePMthreePA(){
        return threePMthreePA.get();
    }
    
    public void setThreePMthreePA(SimpleStringProperty threePMthreePA){
        this.threePMthreePA = threePMthreePA;
    }
    
    public StringProperty TeamProperty() {
        return Team;
    }

    public StringProperty nameProperty() {
        return Rank;
    }

    public StringProperty PlayerProperty() {
        return Player;
    }

    public StringProperty ThreePerProperty() {
        return threePer;
    }

    public StringProperty GPProperty() {
        return GP;
    }

    public StringProperty FGM_FGAProperty() {
        return FGM_FGA;
    }

    public StringProperty MPGProperty() {
        return MPG;
    }

    public StringProperty FTM_FTAsProperty() {
        return FTM_FTA;
    }

    public StringProperty FTM_FTAsPercProperty() {
        return FTPer;
    }

    public StringProperty PTSProperty() {
        return PTS;
    }

    public StringProperty FGPerProperty() {
        return FGPer;
    }

    public StringProperty ThreePMThreePAProperty(){
        return threePMthreePA;
    }

    
}