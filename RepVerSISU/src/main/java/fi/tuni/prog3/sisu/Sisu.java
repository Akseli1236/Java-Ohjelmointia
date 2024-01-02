package fi.tuni.prog3.sisu;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
//import fi.tuni.prog3.sisu.course.Course;
//import fi.tuni.prog3.sisu.module.Module;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import static javafx.geometry.Pos.BOTTOM_LEFT;
import static javafx.geometry.Pos.TOP_CENTER;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.simple.parser.ParseException;


//poistettu valmis gui pohja ja tosiaan toi extends Application.
//lisätty 'extends Application', ei kai toimi ilman? -Jere
public class Sisu extends Application {
    private Map<String, DegreeProgramme> dataStructure;
    private API apu = new API();

    @Override
    public void start(Stage stage) {
        
        // Asetusikkuna
        Label nameLabel = new Label("Syötä nimi: ");
        TextField nameField = new TextField();

        Label idLabel = new Label("Opiskelijanumero: ");
        TextField idField = new TextField();
        
        Button loginButton = new Button("Kirjaudu");
        
        var group = new GridPane();
        group.add(nameLabel, 0, 0);
        group.add(nameField, 1, 0);
        group.add(idLabel, 0, 1);
        group.add(idField, 1, 1);
        group.add(loginButton, 1, 2);
        
        Scene settings = new Scene(group, 300, 300);
        stage.setScene(settings);
        stage.setTitle("Asetusikkuna");
        
        // Pääikkuna
        var groupMain = new GridPane();
        Scene sceneMain = new Scene(groupMain, 800, 500);
        
        Button returnButton = new Button("Takaisin");
        
        groupMain.add(returnButton, 0, 0);
        
        loginButton.setOnAction((event) -> {
            stage.setScene(sceneMain);
        });
        
        returnButton.setOnAction((event) -> {
            stage.setScene(settings);
        });
        
        // Esimerkki nested listasta
        TreeView courseTree = new TreeView();
        
        TreeItem courseRoot = new TreeItem();
        courseTree.setMinWidth(600);
        
        TreeItem rootItem = new TreeItem("Opintokokonaisuudet");
        try {
            dataStructure = apu.main();
            } catch (IOException | ParseException ex) {
        }

        for (var b : dataStructure.keySet()){
            rootItem.getChildren().add(new TreeItem<>(b));
        }
        courseTree.setRoot(rootItem);
        courseRoot.getChildren().add(rootItem);
        
        
        courseTree.setRoot(courseRoot);
        courseTree.setShowRoot(false);
        groupMain.add(courseTree, 0, 2);
        
        Label searchLabel = new Label("Etsi kursseja");
        groupMain.add(searchLabel, 1, 0);
        TextField searchBar = new TextField();
        groupMain.add(searchBar, 1, 1);
        Button searchButton = new Button("Etsi");
        groupMain.add(searchButton, 1, 3);
        
        // Pienennysnappi
        Button collapseButton = new Button("Pienennä kaikki");
        groupMain.add(collapseButton, 0, 3);
        
        collapseButton.setOnAction((ActionEvent event) -> {
            collapseTreeView(courseRoot);
            courseRoot.setExpanded(true);
        });
        
        // Hakupalkki kurssien etsimiseen
        searchButton.setOnAction((ActionEvent event) -> {
            courseRoot.getChildren().clear();
            rootItem.getChildren().clear();
            for (var b : dataStructure.keySet()){
                System.out.println(searchBar.getText());
                if (searchBar.getText().isBlank()){
                    rootItem.getChildren().add(new TreeItem<>(b));
                }
                else if (b.toLowerCase().contains(searchBar.getText().toLowerCase())){
                    rootItem.getChildren().add(new TreeItem<>(b));
                }
                
            }
            courseRoot.getChildren().add(rootItem);
        });
        
        stage.show();
    }
    
    // Apufunktio jolla voi "romahduttaa" kurssilistan
    private void collapseTreeView(TreeItem<?> item){
        if(item != null && !item.isLeaf()){
            item.setExpanded(false);
            for(TreeItem<?> child:item.getChildren()){
                collapseTreeView(child);
            }
        }
    }

    public static void main(String[] args){

        //Testejä vaan, Kerää jsonit kursseiksi ja moduuleiksi ja listaa ne konsoliin.
        launch();
    }
}