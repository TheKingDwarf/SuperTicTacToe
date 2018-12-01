/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

make grid pane of cells, will go in the go to game
 */
package supertictactoe;
//import
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

//class SuperTicTacToe extends Application
public class SuperTicTacToe extends Application {
    //veriables
    private Board boardInstance;
    private Computer computerInstance;
    private int gameState;
    
    public static final String TITLE_PREFIX = "Super T&L TicTacToe: ";
    
    //start runs the program
    @Override
    public void start(Stage primaryStage) {
        Button newGame = new Button();
        newGame.setText("New Game");
        newGame.setOnAction((ActionEvent event) -> {
            goToDifficultySelect(primaryStage);
        });
        //exit button to exit the game
        Button exit = new Button();
        exit.setText("Exit");
        exit.setOnAction((ActionEvent event) -> {
            try {
                stop();
            } catch (Exception ex) {
                Logger.getLogger(SuperTicTacToe.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        GridPane root = new GridPane();
        root.add(newGame, 0, 0);
        root.add(exit, 0, 1);

        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().add(getClass().getResource("GameStyles.css").toExternalForm());//import CSS
        
        primaryStage.setTitle(TITLE_PREFIX + "New Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void goToDifficultySelect(Stage primaryStage) {
        Label difficulty = new Label("Difficulty");
        
        Button easy = new Button();
        easy.setText("Easy");
        easy.setOnAction((ActionEvent event) -> {
            goToGame(primaryStage, 0);
        });
        
        Button medium = new Button();
        medium.setText("Medium");
        medium.setOnAction((ActionEvent event) -> {
            goToGame(primaryStage, 1);
        });
        
        Button hard = new Button();
        hard.setText("Hard");
        hard.setOnAction((ActionEvent event) -> {
            goToGame(primaryStage, 2);
        });
        
        GridPane root = new GridPane();
        root.add(difficulty, 0, 0);
        root.add(easy, 0, 1);
        root.add(medium, 0, 2);
        root.add(hard, 0, 3);
        
        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().add(getClass().getResource("GameStyles.css").toExternalForm());//import CSS
        primaryStage.setTitle(TITLE_PREFIX + "Difficulty Select");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void goToGame(Stage primaryStage, int difficulty){
        //#TODO: game GUI
        GameCell cell1 = new GameCell(0, 0, boardInstance, computerInstance);
        GameCell cell2 = new GameCell(1, 0, boardInstance, computerInstance);
        GameCell cell3 = new GameCell(2, 0, boardInstance, computerInstance);
        GameCell cell4 = new GameCell(0, 1, boardInstance, computerInstance);
        GameCell cell5 = new GameCell(1, 1, boardInstance, computerInstance);
        GameCell cell6 = new GameCell(2, 1, boardInstance, computerInstance);
        GameCell cell7 = new GameCell(0, 2, boardInstance, computerInstance);
        GameCell cell8 = new GameCell(1, 2, boardInstance, computerInstance);
        GameCell cell9 = new GameCell(2, 2, boardInstance, computerInstance);

        
        GridPane root = new GridPane();
        root.add(cell1, 0, 0);
        root.add(cell2, 1, 0);
        root.add(cell3, 2, 0);
        root.add(cell4, 0, 1);
        root.add(cell5, 1, 1);
        root.add(cell6, 2, 1);
        root.add(cell7, 0, 2);
        root.add(cell8, 1, 2);
        root.add(cell9, 2, 2);
          
        //3x3 gride to add cells to 

        
        Scene scene = new Scene(root, 300, 250);
        scene.getStylesheets().add(getClass().getResource("GameStyles.css").toExternalForm());//import CSS
        
        primaryStage.setTitle(TITLE_PREFIX + "In Game");
        primaryStage.setScene(scene);
        primaryStage.show(); 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
