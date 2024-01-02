package fi.tuni.prog3.wordle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class Wordle extends Application{
    
    private Label[] label;
    private String word;
    private ArrayList<String> words = new ArrayList<>();
    private int wordLength;
    private int row;
    private int sana;

    @Override
    public void start(Stage stage) throws IOException {
        lue();
        word=words.get(0);
        wordLength = 0;
        stage.setTitle("Wordle");
        //var group = new FlowPane();
        GridPane grid = new GridPane();
        
        var scene = new Scene(grid, 590, 440);
        //var scene = new Scene(group, 290, 340);
        
       label = create(grid,word.length());
        
        Button clear = new Button("Start new game");
        clear.setId("newGameBtn");
        grid.add(clear, 0, 0);
        clear.setFocusTraversable(false);
        Label end = new Label("");
        end.setId("infoBox");
        grid.add(end, 1, 0);
  
        scene.setOnKeyPressed((KeyEvent k) -> {
            if (k.getCode().equals(KeyCode.BACK_SPACE)){
                
                if (wordLength > 0){
                    kirjainDelete(grid);
                    wordLength-=1;
                }
                
            }else if (k.getCode().equals(KeyCode.ENTER) && row < 6){
                if (wordLength < word.length()){
                    end.setText("Give a complete word before pressing Enter!");
                    
                }else{
                    if (test()){
                        end.setText("Congratulations, you won!");
                        
                        row = 6;
                    }else{
                        row +=1;
                        if (row == 6){
                            end.setText("Game over, you lost!");
                            
                        }else{
                            wordLength = 0;
                        } 
                    }
                }
            }else if(wordLength< word.length()){
                kirjainAdd(grid,k);
                wordLength += 1;
            }
        });
        
        clear.setOnMousePressed((ActionEvent)-> {
                
                grid.getChildren().clear();
                end.setText("");
                grid.add(clear, 0, 0);
                grid.add(end,1,0);
                wordLength = 0;
                row = 0;
                sana += 1;
                word=words.get(sana);
                label = create(grid,word.length());
                
                
        });
        
        
        
        stage.setScene(scene);
        stage.show();
    }
    public boolean test(){
        int indx = 0;
        int trueback = 0;
        for (int i = row*word.length(); i < row*word.length() + word.length(); i++){
            
            if (label[i].getText().equals(String.valueOf(word.charAt(indx)))){
                    label[i].setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
                    trueback +=1;
                    
            }else{
                for (int a = 0; a < word.length(); a++){
                    if (label[i].getText().equals(String.valueOf(word.charAt(a)))){
                        label[i].setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
                        break;
                    }
                    label[i].setBackground(new Background(new BackgroundFill(Color.GRAY, CornerRadii.EMPTY, Insets.EMPTY)));
                }
            }
            indx += 1;
        }
        
        return trueback == word.length();
        
        
    }
        
        
    public void lue() throws IOException{
        //File file2 = new File("C:/Users/aksel/Desktop/Javatyöt/Wordle/src/main/java/fi/tuni/prog3/wordle/words.txt");
        //Scanner scan = new Scanner(file2);
        //
        //word = scan.nextLine();
        
        
        //var text3 = new BufferedReader(new FileReader(haha));
        
        //System.out.println(text3.readLine());
        
        
        try(BufferedReader br2 = new BufferedReader(new FileReader(new File("words.txt")))){
            //String text = new BufferedReader(new InputStreamReader(file)).lines().collect(Collectors.joining("\n"));
            //File haha = new File(this.getClass().getResource("/words.txt").getFile());
            //FileReader fr = new FileReader(haha);
            //BufferedReader br = new BufferedReader(fr);
            //System.out.println(br.readLine());
            //String[] tuppi = text.split("\n");
            String line;
            while((line = br2.readLine()) != null){
                words.add(line.strip().toUpperCase());
            }
            /*
            for (String tappi : tuppi){
                words.add(tappi.toUpperCase());
            }
            
*/
    
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public void kirjainAdd(GridPane grid, KeyEvent k){
        
        for (int i = row*word.length(); i < label.length; i++){
            if (label[i].getText().equals("")){
                label[i].setText(k.getText().toUpperCase());
                return;
            }
        }
        
    }
    public void kirjainDelete(GridPane grid){
        for (int i = row*word.length(); i < label.length; i++){
            if (label[i].getText().equals("")&& i!=0){
                
                label[i-1].setText("");
                return;
            }
        }
        
        
    }
    public Label[] create(GridPane grid, int x){
        Label[] label = new Label[x*6];
        int help = 0;
        for (int i = 0; i < 6; i++){
            for (int c = 0; c < x; c++){
                
                label[help] = new Label("");
                label[help].setAlignment(Pos.CENTER);
                label[help].setFont(new Font("Verdana",40));
                label[help].setPrefSize(80, 80);
                label[help].setBorder(new Border(new BorderStroke(Color.BLACK,
            BorderStrokeStyle.SOLID,
            CornerRadii.EMPTY,
            BorderWidths.DEFAULT)));
                label[help].setId(String.valueOf(i)+ "_" + String.valueOf(c));
                label[help].setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
                grid.add(label[help], c+1, i+1);
                help +=1;
                //group.getChildren(label[i]);
            }
        }
        return label;
    }

    public static void main(String[] args) {
        launch();
    }

}