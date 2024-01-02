package nan.mavenproject1;

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



public class PrimaryController extends API implements Initializable{
    private Map<String, DegreeProgramme> dataStructure;
    @FXML
    private TreeView treeView;
    
    @FXML
    private TreeView treeView1;
    
    @FXML
    private TreeView treeView2;
    
    public void selectItem2(){
        
    }
    public void selectItem() throws IOException, ParseException{
        TreeItem<String> Item = (TreeItem<String>) treeView.getSelectionModel().getSelectedItem();
        if (Item != null){
            
            if (dataStructure.get(Item.getValue()).getObj().isEmpty()){
                id(dataStructure.get(Item.getValue()).getId(),dataStructure, Item.getValue());
            }
            
            for (var a : treeView.getRoot().getChildren()){
                
                if (a.equals(Item)){
                    TreeItem<String> rootItem = new TreeItem<>(Item.getValue());
                    DegreeProgramme deg = dataStructure.get(Item.getValue());
                    for (var b : deg.getKokeilu()){
                        String layer = b.substring(0, 1);
                        String name2 = b.substring(1);
                        rekursio(rootItem,Integer.parseInt(layer), name2);  
                    }
                    treeView1.setRoot(rootItem);  
                }

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
    public void rekursio2(TreeItem<String> rootItem,JSONObject obj, int layer){
        JSONArray help = new JSONArray();
        String name = null;
        for (var a : obj.keySet()){
            name = (String) a;
            help = (JSONArray) obj.get(a);
        }
        rootItem.getChildren().add(new TreeItem<>(name));
        if(!help.isEmpty()){
            for (int i = 0; i < help.size(); i++){
                rekursio2(rootItem.getChildren().get(rootItem.getChildren().size()-1), (JSONObject) help.get(i), layer);
            }
        } 
    }
    public void rekursio(TreeItem<String> rootItem, int layer, String name){
        if (layer == 1){
            rootItem.getChildren().add(new TreeItem<>(name));
        }else{
            layer--;
            rekursio(rootItem.getChildren().get(rootItem.getChildren().size()-1),layer,name);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb){
        TreeItem<String> rootItem = new TreeItem<>("Files");
        
        API apu = new API();
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
