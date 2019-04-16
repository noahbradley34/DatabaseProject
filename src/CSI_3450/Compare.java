package CSI_3450;

//import javafx.beans.property.SimpleStringegerProperty;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
public class Compare{
    
    private SimpleStringProperty School, Conf_W_L, GB; 
    private SimpleStringProperty Conf_Win_Per, Overall_W_L, Home, Away, Win_Streak, AP, USA, Conf;
    private SimpleFloatProperty  Overall_Win_Per;
    private CheckBox check;

    public Compare(String School, String Conf_W_L, String GB, String Conf_Win_Per, String Overall_W_L, Float Overall_Win_Per, String Home,
            String Away, String Win_Streak, String AP, String USA, String Conf) {
        this.School = new SimpleStringProperty(School);
        this.GB = new SimpleStringProperty(GB);
        this.Conf_W_L = new SimpleStringProperty(Conf_W_L);
        this.Conf_Win_Per = new SimpleStringProperty(Conf_Win_Per);
        this.Overall_W_L = new SimpleStringProperty(Overall_W_L);
        this.Overall_Win_Per = new SimpleFloatProperty(Overall_Win_Per);
        this.Home = new SimpleStringProperty(Home);
        this.Away = new SimpleStringProperty(Away);
        this.Win_Streak = new SimpleStringProperty(Win_Streak);
        this.AP = new SimpleStringProperty(AP);
        this.USA = new SimpleStringProperty(USA);
        this.Conf = new SimpleStringProperty(Conf);

    }
    
    public String getConf_W_L() {
        return Conf_W_L.get();
    }

    public void setConf_W_L(SimpleStringProperty Conf_W_L) {
        this.Conf_W_L = Conf_W_L;
    }

    public void seConf_Win_PeresButton(CheckBox check) {
        this.check = check;
    }

    public String getGB() {
        return GB.get();
    }

    public void setConference(SimpleStringProperty GB) {
        this.GB = GB;
    }

    public String getConf_Win_Per() {
        return Conf_Win_Per.get();
    }

    public void setConf_Win_Per(SimpleStringProperty Conf_Win_Per) {
        this.Conf_Win_Per = Conf_Win_Per;
    }

    public String getOverall_W_L() {
        return Overall_W_L.get();
    }

    public void setOverall_W_L(SimpleStringProperty Overall_W_L) {
        this.Overall_W_L = Overall_W_L;
    }

    public float getOverall_Win_Per() {
        return Overall_Win_Per.get();
    }

    public void setOverall_Win_Per(SimpleFloatProperty Overall_Win_Per) {
        this.Overall_Win_Per = Overall_Win_Per;
    }

    public String getHome() {
        return Home.get();
    }

    public void setHome(SimpleStringProperty Home) {
        this.Home = Home;
    }

    public String getAway() {
        return Away.get();
    }

    public void setAway(SimpleStringProperty Away) {
        this.Away = Away;
    }

    public String getAP() {
        return AP.get();
    }

    public void setAP(SimpleStringProperty AP) {
        this.AP = AP;
    }

    public String getUSA() {
        return USA.get();
    }

    public void setUSA(SimpleStringProperty USA) {
        this.USA = USA;
    }

    
    public String getSchool() {
        return School.get();
    }

    public void setSchool(SimpleStringProperty School) {
        this.School = School;
    }


    public String getWin_Streak() {
        return Win_Streak.get();
    }

    public void setWin_Streak(SimpleStringProperty Win_Streak) {
        this.Win_Streak = Win_Streak;
    }
    
    public String getConf(){
        return Conf.get();
    }
    
    public void setConf(SimpleStringProperty Conf){
        this.Conf = Conf;
    }
    
    public StringProperty Conf_W_LProperty() {
        return Conf_W_L;
    }

    public StringProperty nameProperty() {
        return School;
    }

    public StringProperty GBProperty() {
        return GB;
    }

    public StringProperty LongestProperty() {
        return AP;
    }

    public StringProperty Conf_Win_PerProperty() {
        return Conf_Win_Per;
    }

    public StringProperty HomeProperty() {
        return Home;
    }

    public StringProperty Overall_W_LProperty() {
        return Overall_W_L;
    }

    public StringProperty USAsProperty() {
        return USA;
    }

    public FloatProperty apgProperty() {
        return Overall_Win_Per;
    }

    public StringProperty avgHomeProperty() {
        return Away;
    }

    public StringProperty Win_StreakProperty() {
        return Win_Streak;
    }

    public StringProperty ConfProperty(){
        return Conf;
    }
    
}