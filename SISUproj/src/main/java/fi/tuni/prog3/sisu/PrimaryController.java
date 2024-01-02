package fi.tuni.prog3.sisu;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;



public class PrimaryController implements Initializable{
    private Map<String, DegreeProgramme> dataStructure;
    private API apu = new API();
    private String currentProgramme;
    private String currenItem;
    @FXML
    private TreeView treeView;
    
    @FXML
    private TreeView treeView2;
    
    
    public void selectItem2(){
        TreeItem<String> Item = (TreeItem<String>) treeView2.getSelectionModel().getSelectedItem();
        if (Item != null && !Item.getValue().equals(this.currenItem)){
            System.out.println(Item.getValue());
            
            apu.changeCredits(Item,dataStructure.get(currentProgramme).getObj());
           
            this.currenItem = Item.getValue();
            
        }
        
        
        
    }
    public void selectItem() throws IOException, ParseException{
        TreeItem<String> Item = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();
        
        if (Item != null && !Item.getValue().equals("Files")){
            
            currentProgramme = Item.getValue();
            if (dataStructure.get(Item.getValue()).getObj().isEmpty()){
                apu.id(dataStructure.get(Item.getValue()).getId(),dataStructure, Item.getValue());
                try(FileWriter file = new FileWriter("myJSON.json")){
                    file.write(dataStructure.get(Item.getValue()).getObj().toString());
                }catch (IOException e){
                }
            }
            
            for (var a : treeView.getRoot().getChildren()){
                if (a.equals(Item)){
                    TreeItem<String> rootItem = new TreeItem<>(Item.getValue());
                    DegreeProgramme deg = dataStructure.get(Item.getValue());
                    
                    for (var b : deg.getObj()){
                        
                        JSONObject print = (JSONObject) b;
                        rekursio2(rootItem,print,1);
                    }
                    treeView2.setRoot(rootItem);
                }
            }
        }  
    }
    public void rekursio2(TreeItem<String> rootItem, JSONObject obj, int layer){
        JSONArray help = new JSONArray();
        String name = null;
        for (var a : obj.keySet()){
            name = (String) a;
            if (obj.get(a) instanceof JSONArray){
                help = (JSONArray) obj.get(a);
            }
            
        }
        rootItem.getChildren().add(new TreeItem<>(name));
        
        if(!help.isEmpty()){
            for (int i = 0; i < help.size(); i++){
                rekursio2(rootItem.getChildren().get(rootItem.getChildren().size()-1), (JSONObject) help.get(i), layer);  
            }
        } 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        TreeItem<String> rootItem = new TreeItem<>("Files");
        
        //API apu = new API();
        try {
            dataStructure = apu.main();
            } catch (IOException | ParseException ex) {
        }

        for (var b : dataStructure.keySet()){
            rootItem.getChildren().add(new TreeItem<>(b));
        }
        treeView.setRoot(rootItem);
    }
}