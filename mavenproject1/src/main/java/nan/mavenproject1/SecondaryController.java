/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nan.mavenproject1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import org.json.simple.parser.ParseException;

public class SecondaryController {
    private DegreeProgramme pam;
    
    public void initialize(URL url, ResourceBundle rb){
        PrimaryController a = new PrimaryController();
        
    }
    @FXML
    private void switchToPrimary() throws IOException {
        
        App.setRoot("primary");
    }
    
    
}
