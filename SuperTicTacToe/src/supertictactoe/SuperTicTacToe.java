/*
 * Logan Forman and Travis Dutton-Leyda
 * 11/20/2018
 * This program is the super Tic Tac Toe experience. 
 * “I pledge that this program represents my own program code. I received help from no one in designing and debugging my program.” 
 * Took me 4 hours
 */
package supertictactoe;
//import
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

//class SuperTicTacToe extends Application
public class SuperTicTacToe extends Application {
    //veriables
    private Board boardInstance = new Board();
    private Computer computerInstance;
    private int gameState;
    public ArrayList<GameCell> cellList = new ArrayList<>();
    
    public static final String TITLE_PREFIX = "Super T&L TicTacToe: ";
    private static Stage pStage; //holds the primary stage
    
    private int playerWins; //hold match statistics
    private int computerWins;
    private int ties;

    //getters and setters
    public int getTies() {
        return ties;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }
    
    public int getPlayerWins() {
        return playerWins;
    }

    public void setPlayerWins(int playerWins) {
        this.playerWins = playerWins;
    }

    public int getComputerWins() {
        return computerWins;
    }

    public void setComputerWins(int computerWins) {
        this.computerWins = computerWins;
    }
    
    public static Stage getPrimaryStage() {
        return pStage;
    }

    private void setPrimaryStage(Stage pStage) {
        SuperTicTacToe.pStage = pStage;
    }
    
    //start runs the program
    @Override
    public void start(Stage primaryStage) {
        //make two new buttons
        Button newGame = new Button();
        newGame.setText("New Game");
        newGame.setOnAction((ActionEvent event) -> {
            goToDifficultySelect();
        });
        //exit button to exit the game
        Button exit = new Button();
        exit.setText("Exit");
        
        BorderPane root = new BorderPane();
        GridPane groot = new GridPane();
        root.setCenter(groot);
        newGame.setMaxWidth(Double.MAX_VALUE);
        exit.setMaxWidth(Double.MAX_VALUE);
        newGame.setMaxHeight(Double.MAX_VALUE);
        exit.setMaxHeight(Double.MAX_VALUE);
        groot.setVgap(50);
        Label l = new Label(TITLE_PREFIX);
        root.setTop(l);
        root.setAlignment(l, Pos.CENTER);
        groot.add(newGame, 1, 1);
        groot.add(exit, 1, 2);
        gridPaneSetEqualSizes(groot, 5, 3);

        //create the scene and set the stage
        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add(getClass().getResource("GameStyles.css").toExternalForm());//import CSS
        setPrimaryStage(primaryStage);
        primaryStage.setTitle(TITLE_PREFIX + "New Game");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        //we need to set the buttons event after stage is created
        exit.setOnAction((ActionEvent event) -> exitButtonScript(primaryStage));

    }
    /**
     * goes to difficulty select screen
     */
    public void goToDifficultySelect() {
        Label difficulty = new Label("Difficulty");
        
        Button easy = new Button();
        easy.setText("Easy");
        easy.setOnAction((ActionEvent event) -> {
            goToGame(0);
        });
        
        Button medium = new Button();
        medium.setText("Medium");
        medium.setOnAction((ActionEvent event) -> {
            goToGame(1);
        });
        
        Button hard = new Button();
        hard.setText("Hard");
        hard.setOnAction((ActionEvent event) -> {
            goToGame(2);
        });
        //exit button to exit the game
        Button exit = new Button();
        exit.setText("Exit");
        exit.setOnAction((ActionEvent event) -> {
            try {
                start(getPrimaryStage());
            } catch (Exception ex) {
                Logger.getLogger(SuperTicTacToe.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        //set alignments and positioning;
        BorderPane root = new BorderPane();
        GridPane groot = new GridPane();
        root.setCenter(groot);
        easy.setMaxWidth(Double.MAX_VALUE);
        medium.setMaxWidth(Double.MAX_VALUE);
        hard.setMaxWidth(Double.MAX_VALUE);
        exit.setMaxWidth(Double.MAX_VALUE);
        easy.setMaxHeight(Double.MAX_VALUE);
        medium.setMaxHeight(Double.MAX_VALUE);
        hard.setMaxHeight(Double.MAX_VALUE);
        exit.setMaxHeight(Double.MAX_VALUE);
        groot.setVgap(50);
        groot.add(difficulty, 1, 0);
        groot.add(easy, 1, 1);
        groot.add(medium, 1, 2);
        groot.add(hard, 1, 3);
        groot.add(exit, 1, 4);
        gridPaneSetEqualSizes(groot, 5, 3);
        
        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add(getClass().getResource("GameStyles.css").toExternalForm());//import CSS
        getPrimaryStage().setTitle(TITLE_PREFIX + "Difficulty Select");
        getPrimaryStage().setScene(scene);
        getPrimaryStage().show();
    }
    
    public void goToGame(int difficulty){
        boardInstance = new Board();
        computerInstance = new Computer(boardInstance, difficulty);

        //#TODO: game GUI
        GameCell cell1 = new GameCell(0, 0, boardInstance, computerInstance, this);
        GameCell cell2 = new GameCell(1, 0, boardInstance, computerInstance, this);
        GameCell cell3 = new GameCell(2, 0, boardInstance, computerInstance, this);
        GameCell cell4 = new GameCell(0, 1, boardInstance, computerInstance, this);
        GameCell cell5 = new GameCell(1, 1, boardInstance, computerInstance, this);
        GameCell cell6 = new GameCell(2, 1, boardInstance, computerInstance, this);
        GameCell cell7 = new GameCell(0, 2, boardInstance, computerInstance, this);
        GameCell cell8 = new GameCell(1, 2, boardInstance, computerInstance, this);
        GameCell cell9 = new GameCell(2, 2, boardInstance, computerInstance, this);
       // Rectangle cell9 = new Rectangle(100, 100);
        
        BorderPane root = new BorderPane();
        
        GridPane textGrid = new GridPane();
        root.setTop(textGrid);
        gridPaneSetEqualSizes(textGrid, 1, 3);
        textGrid.add(new Label("Player Wins: " + String.valueOf(getPlayerWins())), 0, 0);
        textGrid.add(new Label("Computer Wins: " + String.valueOf(getComputerWins())), 2, 0);
        textGrid.add(new Label("Ties: " + String.valueOf(getTies())), 1, 0);
       
        //set alignments
        GridPane grid = new GridPane();
        root.setCenter(grid);
        grid.setHgap(5);
        grid.setVgap(5);
        gridPaneSetEqualSizes(grid, 3, 3);
                
        grid.add(cell1, 0, 0);
        grid.add(cell2, 1, 0);
        grid.add(cell3, 2, 0);
        grid.add(cell4, 0, 1);
        grid.add(cell5, 1, 1);
        grid.add(cell6, 2, 1);
        grid.add(cell7, 0, 2);
        grid.add(cell8, 1, 2);
        grid.add(cell9, 2, 2);
        cellList.add(cell1);
        cellList.add(cell2);
        cellList.add(cell3);
        cellList.add(cell4);
        cellList.add(cell5);
        cellList.add(cell6);
        cellList.add(cell7);
        cellList.add(cell8);
        cellList.add(cell9);
        updateAll();
        //3x3 gride to add cells to 

        
        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add(getClass().getResource("GameStyles.css").toExternalForm());//import CSS
        
        getPrimaryStage().setTitle(TITLE_PREFIX + "In Game");
        getPrimaryStage().setScene(scene);
        getPrimaryStage().show(); 
    }
    public void updateAll() {
        for (GameCell i: cellList) {
            i.update();
        }
        
        if (boardInstance.checkWin(1) || boardInstance.checkWin(2)) {
            winPopup(getPrimaryStage(), boardInstance.checkWin(1));
        }
        if (boardInstance.checkDraw()) {
            drawPopup(getPrimaryStage());
        }
    }
    
    public void winPopup(Stage primaryStage, boolean playerWon) {
       if (playerWon) {
           //set all alignments
            setPlayerWins(getPlayerWins()+1); //add to player wins
            BorderPane borderPane = new BorderPane();
            borderPane.setTop(new Label("You Won!"));
            borderPane.setAlignment(borderPane.getTop(), Pos.CENTER);
            GridPane bGrid = new GridPane();
            borderPane.setCenter(bGrid);

            Scene scene = new Scene(borderPane, 200, 200); 
            Stage stage = new Stage(); 
            stage.setScene(scene); 
            stage.setTitle("Player Won"); 
            stage.show(); 
            scene.getStylesheets().add(getClass().getResource("GameStyles.css").toExternalForm());//import CSS

            
            Button exit = new Button();
            exit.setText("Exit");
            exit.setOnAction((ActionEvent event) -> {
                goToDifficultySelect();
                stage.close();
            });

            Button retry = new Button();
            retry.setText("Retry");
            retry.setOnAction((ActionEvent event) -> {
                goToGame(computerInstance.difficulty);
                stage.close();
            });
            bGrid.add(exit, 0, 0); bGrid.add(retry, 1, 0);
            gridPaneSetEqualSizes(bGrid, 1, 2);
            
       } else {
           //set all alignments
            setComputerWins(getComputerWins()+1); //add to the computers wins
            BorderPane borderPane = new BorderPane();
            borderPane.setTop(new Label("You Lost!"));
            borderPane.setAlignment(borderPane.getTop(), Pos.CENTER);
            GridPane bGrid = new GridPane();
            borderPane.setCenter(bGrid);
           
            Scene scene = new Scene(borderPane, 200, 200); 
            scene.getStylesheets().add(getClass().getResource("GameStyles.css").toExternalForm());//import CSS
            Stage stage = new Stage(); 
            stage.setScene(scene); 
            
            stage.setTitle("Player Lost"); 
            stage.show();
            
            Button exit = new Button();
            exit.setText("Exit");
            exit.setOnAction((ActionEvent event) -> {
                goToDifficultySelect();
                stage.close();
            });

            Button retry = new Button();
            retry.setText("Retry");
            retry.setOnAction((ActionEvent event) -> {
                goToGame(computerInstance.difficulty);
                stage.close();

            });
            bGrid.add(exit, 0, 0); bGrid.add(retry, 1, 0);
            gridPaneSetEqualSizes(bGrid, 1, 2);

       }
    }
    
    public void drawPopup(Stage primaryStage) {
        setTies(getTies()+1); //add one to the amount of ties
        //set alignments
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(new Label("It's a Tie!"));
        borderPane.setAlignment(borderPane.getTop(), Pos.CENTER);
        GridPane bGrid = new GridPane();
        borderPane.setCenter(bGrid);

        Scene scene = new Scene(borderPane, 200, 200); 
        scene.getStylesheets().add(getClass().getResource("GameStyles.css").toExternalForm());//import CSS
        Stage stage = new Stage(); 
        stage.setScene(scene); 
        stage.setTitle("Tie"); 
        stage.show();  
        
        Button exit = new Button();
        exit.setText("Exit");
        exit.setOnAction((ActionEvent event) -> {
            goToDifficultySelect();
            stage.close();
        });

        Button retry = new Button();
        retry.setText("Retry");
        retry.setOnAction((ActionEvent event) -> {
            goToGame(computerInstance.difficulty);
            stage.close();
            
        });
        bGrid.add(exit, 0, 0); bGrid.add(retry, 1, 0);
        gridPaneSetEqualSizes(bGrid, 1, 2);
    }
    /**
     * makes all elements of a gridPane the same size, completely filling up the available space
     * @param p
     * @param rows
     * @param cols 
     */
    public void gridPaneSetEqualSizes(GridPane p, int rows, int cols) {
        for (int i = 0 ; i < rows ; i++) {
            RowConstraints rc = new RowConstraints();
            rc.setPercentHeight(100.0 / rows);
            rc.setValignment(VPos.CENTER);
            p.getRowConstraints().add(rc);
        }
        for (int i = 0 ; i < cols ; i++) {
            ColumnConstraints cc = new ColumnConstraints();
            cc.setHalignment(HPos.CENTER);
            cc.setPercentWidth(100.0 / cols);
            p.getColumnConstraints().add(cc);
        }
    }
    
    public void exitButtonScript(Stage stage) {
        stage.close();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
