package fi.tuni.prog3.calc;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class Calculator extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Calculator");
        
        GridPane grid = new GridPane();
        
        Scene scene = new Scene(grid, 370, 170);
        
        stage.setScene(scene);
        
        Label firstLbl = new Label("First operand:");
        firstLbl.setId("labelOp1");
        Label secondLbl = new Label("Second operand:");
        secondLbl.setId("labelOp2");
        Label thirdLbl = new Label("Result:");
        thirdLbl.setId("labelRes");
        
        
        TextField firstTxt = new TextField();
        firstTxt.setId("fieldOp1");
        firstTxt.setPrefWidth(150);
        
        
        TextField secondTxt = new TextField();
        secondTxt.setId("fieldOp2");
        secondTxt.setPrefWidth(150);
        
        Label thirdTxt = new Label("");
        thirdTxt.setId("fieldRes");
        thirdTxt.setPrefWidth(150);
        thirdTxt.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        //thirdTxt.setBorder(new Border(new(BorderStroke(Color.BLACK),BorderStrokeStyle.SOLID,CornerRadii.EMPTY,BorderWidths.DEFAULT)));
        thirdTxt.setBorder(new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID,
        CornerRadii.EMPTY,
        BorderWidths.DEFAULT)));

        
        
        
        TextField output = new TextField();
        
        output.setPrefWidth(160);
        
        //var group = new FlowPane();
        HBox hbBtn = new HBox(3);
        HBox hbBtn2 = new HBox(3);
        grid.add(firstLbl, 0, 0);
        grid.add(secondLbl, 0, 1);
        grid.add(thirdLbl, 0, 4);
        grid.add(hbBtn,0,3);
        grid.add(hbBtn2,1,3);
        grid.add(firstTxt, 1, 0);
        grid.add(secondTxt,1,1);
        grid.add(thirdTxt, 1, 4);
        
        Button add = new Button("Add");
        add.setId("btnAdd");
        hbBtn.getChildren().add(add);
        
        Button subtract = new Button ("Subtract");
        subtract.setId("btnSub");
        hbBtn.getChildren().add(subtract);
        
        Button multiply = new Button ("Multiply");
        multiply.setId("btnMul");
        hbBtn2.getChildren().add(multiply);
        
        Button divide = new Button ("Divide");
        divide.setId("btnDiv");
        hbBtn2.getChildren().add(divide);
        
        
        add.setOnAction((event)-> {
            var a = Double.parseDouble(firstTxt.getText());
            var b = Double.parseDouble(secondTxt.getText());
            
            thirdTxt.setText(String.format("%.1f", a+b));
        });
        
        subtract.setOnAction((event)-> {
            var a = Double.parseDouble(firstTxt.getText());
            var b = Double.parseDouble(secondTxt.getText());
            
            thirdTxt.setText(String.format("%.1f", a-b));
        });
        multiply.setOnAction((event)-> {
            var a = Double.parseDouble(firstTxt.getText());
            var b = Double.parseDouble(secondTxt.getText());
            
            if (a*b % 1 == 0){
                thirdTxt.setText(String.format("%.1f", a*b));
            }else{
                thirdTxt.setText(String.format("%.2f", a*b));
            }
            
            
        });
        divide.setOnAction((event)-> {
            var a = Double.parseDouble(firstTxt.getText());
            var b = Double.parseDouble(secondTxt.getText());
            
            thirdTxt.setText(String.format("%.1f", a/b));
        });
        
        
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}