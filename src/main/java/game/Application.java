package game;

import game.animation.Authorization;
import game.animation.ChessBoard;
import game.domain.Player1;
import game.domain.Player2;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Администратор on 28.05.2017.
 */
public class Application extends javafx.application.Application {




    Stage primaryStage;
//    Label slogan = new Label("Chess");
    Label start = new Label("Start");
//    Button start = new Button("Start");

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {


        this.primaryStage = primaryStage;
        primaryStage.setTitle("Chess for Children. Made by Ruslan Omelchenko.");
        BorderPane root = new BorderPane();
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

            public void handle(WindowEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });

//        root.setLeft(slogan);
//        slogan.setId("slogan");
//        root.setAlignment(slogan, Pos.TOP_LEFT);
        root.setLeft(start);
        start.setId("start");
        root.setAlignment(start, Pos.TOP_LEFT);

//        root.setBottom(start);
//        Pane pane = new Pane();
//        pane.getChildren().add(start);
//        root.setBottom(pane);
//        start.setLayoutX(20.0);
//        start.setLayoutY(20.0);

        initListeners();

        Scene scene = new Scene(root, 647, 414);
        primaryStage.setScene(scene);
        primaryStage.show();
        scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());

 //       String bip = "./src/main/resources/ACDCHighwaytoHell.mp3";

              //URL bip = getClass().getResource("/ACDCHighwaytoHell.mp3");

        String path = Application.class.getResource("/ACDCHighwaytoHell.mp3").toString();

        Media hit = new Media(path);

        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();

    }

    private void initListeners() {
        start.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                try {
//                    ChessBoard chessBoard = new ChessBoard(primaryStage);
                    new Authorization().registration();
                    ChessBoard chessBoard = new ChessBoard();
                    primaryStage.setScene(chessBoard.getScene());
//                    initialPosition.initialize();
//                    primaryStage.setScene(chessBoard.scene);

                    //2 потока
        Player1 player1 = new Player1(chessBoard);
        new Thread(player1).start();
        Player2 player2 = new Player2(chessBoard);
        new Thread(player2).start();



                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }

}
