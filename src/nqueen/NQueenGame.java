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
import javafx.geometry.Insets;

class DialogStage extends Stage{         //Dialog Message Window
      DialogStage(String message){
          Label lb = new Label();
          Button btn = new Button("Close");     
          lb.setText(message);
          lb.setTranslateX(30);
          lb.setTranslateY(50);
          btn.setTranslateX(120);
          btn.setTranslateY(100);
          Pane root= new Pane();
          root.getChildren().add(lb);
          root.getChildren().add(btn);
          btn.setOnAction(e->close());
          setTitle("Dialog Message");
          setScene(new Scene(root, 300, 200));
          this.setResizable(false);
          show();
      }
}


public class NQueenGame extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();        
        //Insert code here
        Label promptLabel = new Label("Enter Board Size(2<=N<=20):");
        promptLabel.setFont(Font.font("Arial", 24));
        root.add(promptLabel, 0, 0, 1 , 1);

        TextField input = new TextField();
        input.setPrefWidth(100);
        input.setPadding(new Insets(5,5,5,5));
        root.add(input, 0, 1, 2 , 1);

        Button playButton = new Button("Play");
        playButton.setPrefSize(100, 50);
        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try {
                    int size = Integer.parseInt(input.getText());

                    if(size < 2 || size > 20){
                        new DialogStage("Board size is out of bounds.");
                        return;
                    }

                    NQueen game = new NQueen(size);

                    new PlayBoard(size, game.getBoard(), game.getSolved());


                } catch (NumberFormatException numberFormatException) {
                    numberFormatException.printStackTrace();
                    new DialogStage("Incorrect input format; numberFormatException");
                    return;
                }
            }
        });
        root.add(playButton, 0, 3, 1, 1);


        Button solutionButton = new Button("Solution");
        solutionButton.setPrefSize(100, 50);
        solutionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                try {
                    int size = Integer.parseInt(input.getText());

                    if (size < 2 || size > 20) {
                        new DialogStage("Board size is out of bounds.");
                        return;
                    }

                    NQueen game = new NQueen(size);

                    new DisplaySolution(size, game.getBoard(), game.getSolved());
                }
                catch (NumberFormatException numberFormatException) {
                    numberFormatException.printStackTrace();
                    new DialogStage("Incorrect input format; numberFormatException");
                    return;
                }
            }
        });
        root.add(solutionButton, 1, 3, 1, 1);

        primaryStage.setX(500);
        primaryStage.setY(500);
        primaryStage.setWidth(450);
        primaryStage.setHeight(150);
        primaryStage.setResizable(false);
        primaryStage.setTitle("NQueen Problem Game");
        primaryStage.setScene(new Scene(root, 400, 200));
        primaryStage.show();
    }
}

