package nqueen;
import javafx.application.Application;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.collections.*; 
import javafx.geometry.*;

import static java.lang.Integer.MAX_VALUE;

public class DisplaySolution extends Stage{
      Text txt;
      Button btn[][];
      GridPane gp;
      int board[][];
      int N;
      DisplaySolution(int N, int board[][], boolean solved){
          if (solved){
              gp = new GridPane();
              for(int row = 0; row < N; row++) {
                 RowConstraints rc = new RowConstraints();
                 rc.setFillHeight(true);
                 rc.setVgrow(Priority.ALWAYS);
                 gp.getRowConstraints().add(rc);
              }
              for(int col = 0; col < N; col++) {
                 ColumnConstraints cc = new ColumnConstraints();
                 cc.setFillWidth(true);
                 cc.setHgrow(Priority.ALWAYS);
                 gp.getColumnConstraints().add(cc);
              }
              //Insert code here

              for(int i = 0; i < N; i++){
                  for(int j = 0; j < N; j++){
                      Button button = new Button();
                      button.maxWidth(MAX_VALUE);
                      button.setMaxWidth(MAX_VALUE);
                      button.setPrefSize(MAX_VALUE, MAX_VALUE);

                      button.maxHeight(MAX_VALUE);
                      button.setMaxHeight(MAX_VALUE);
                      button.setPrefSize(MAX_VALUE, MAX_VALUE);

                      if(board[i][j] == 1){
                          button.setStyle("-fx-background-color: #e34a24;");
                      }

                      button.setText(String.valueOf(board[i][j]));

                      gp.add(button, j, i);
                  }
              }

              //gp.getChildren().
              
              setX(450); 
              setY(10);  
              setTitle("Solution for "+N+" x "+N+" Queen Game");
              setScene(new Scene(gp, 800, 800));
              show();
          }
          else{
              new DialogStage("No Solution!");
          }
      }

}
