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

import java.util.Arrays;

import static java.lang.Integer.MAX_VALUE;

public class PlayBoard extends Stage{
      Button btn[][];
      GridPane gp;
      int board[][];
      int N;
      PlayBoard(int N, int board[][], boolean solved){
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
              //insert code

              int [][] solvedBoard = new int[board.length][]; // Create clone for referencing win
              for(int i = 0; i < board.length; i++)
              {
                  int[] aMatrix = board[i];
                  int   aLength = aMatrix.length;
                  solvedBoard[i] = new int[aLength];
                  System.arraycopy(aMatrix, 0, solvedBoard[i], 0, aLength);
              }

              for(int i = 0; i < N; i++){ // Reset board for play
                  for(int j = 0; j < N; j++){
                      board[i][j] = 0;
                  }
              }


              for(int i = 0; i < N; i++){
                  for(int j = 0; j < N; j++){
                      Button button = new Button();
                      button.maxWidth(MAX_VALUE);
                      button.setMaxWidth(MAX_VALUE);
                      button.setPrefSize(MAX_VALUE, MAX_VALUE);

                      button.maxHeight(MAX_VALUE);
                      button.setMaxHeight(MAX_VALUE);
                      button.setPrefSize(MAX_VALUE, MAX_VALUE);

                      button.setText("0");

                      //button.setText(String.valueOf(board[i][j]));
                      button.setOnAction(new EventHandler<ActionEvent>() {
                          @Override public void handle(ActionEvent e) {
                              int row = GridPane.getRowIndex(button);
                              int col = GridPane.getColumnIndex(button);

                              if(isSafe(board, row, col, N)){
                                  button.setStyle("-fx-background-color: #59db0d;");
                                  button.setText("1");
                                  board[row][col] = 1;
                              }
                              else if(button.getText().equals("1")){
                                  button.setStyle("");
                                  button.setText("0");
                                  board[row][col] = 1;
                              }

                              checkGameOver(board, solvedBoard);
                          }
                      });

                      gp.add(button, j, i);
                  }
              }
              
              setX(450);
              setY(10);
              setTitle("Play "+N+" x "+N+" Queen Game");
              setScene(new Scene(gp, 800, 800));
              show();
          }
          else{
              //Insert code here
              new DialogStage("No Solution!");
          }
      }

      void checkGameOver(int[][] board, int[][] solvedBoard){
          if(Arrays.deepEquals(board, solvedBoard)){
              new DialogStage("Well done, you did it!");
          }
      }
            
      boolean isSafe(int board[][],int col,int row,int N) {  // i is col and j is row
        for (int i=0;i<N;i++)
        {
           for (int j=0;j<N;j++)
           {
              if (board[i][j]==1)
              {
                 if (i==col) return false;
                 if (j==row) return false;
                 if (Math.abs(i-col)==Math.abs(j-row)) return false;
              } 
           }
        }
        return true;
      }

}
