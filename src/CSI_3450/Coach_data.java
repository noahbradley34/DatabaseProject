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

/**
 *
 * @author nbradley
 */
public class Coach_data {
    private SimpleStringProperty Coach_Name, School, Career_Record, Age; 
    private CheckBox check;

    public Coach_data(String Coach_Name, String School, String Career_Record, String Age) {
        this.Coach_Name = new SimpleStringProperty(Coach_Name);
        this.School = new SimpleStringProperty(School);
        this.Career_Record = new SimpleStringProperty(Career_Record);
        this.Age = new SimpleStringProperty(Age);
    }
    
    public String getCoach_Name() {
        return Coach_Name.get();
    }

    public void setCoach_Name(SimpleStringProperty Coach_Name) {
        this.Coach_Name = Coach_Name;
    }    
    
    public String getSchool() {
        return School.get();
    }

    public void setSchool(SimpleStringProperty School) {
        this.School = School;
    }    
    
    public String getCareer_Record() {
        return Career_Record.get();
    }

    public void setCareer_Record(SimpleStringProperty Career_Record) {
        this.Career_Record = Career_Record;
    }    
    
    public String getAge() {
        return Age.get();
    }

    public void setAge(SimpleStringProperty Age) {
        this.Age = Age;
    }
    
    public StringProperty Coach_NameProperty() {
        return Coach_Name;
    }
    
    public StringProperty SchoolProperty() {
        return School;
    }
        
    public StringProperty Career_RecordProperty() {
        return Career_Record;
    }
        
    public StringProperty AgeProperty() {
        return Age;
    }
    
    
    
}
