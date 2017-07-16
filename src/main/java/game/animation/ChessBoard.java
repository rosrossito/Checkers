package game.animation;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by ������������� on 03.06.2017.
 */
public class ChessBoard {

//    Stage primaryStage;
//    public ChessBoard(Stage primaryStage){
//        this.primaryStage=primaryStage;
//    }


    Semaphore s1 = new Semaphore(1);
    Semaphore s2 = new Semaphore(0);
    int counterMoves = 0;
    int counterButtons = 0;

    Label label = new Label("");
    VBox vboximage = new VBox();


//        FileInputStream input = new FileInputStream("src/main/resources/images/blackQween.png");
//        ImageView image = new ImageView(new Image(input));
//        image.setId("Qween");


    //        Button a1 = new Button("test",image);
    public Button a1 = new Button("");

    //        a1.graphicProperty().setValue(image);
    //        a1.setId("a1");
    public Button a2 = new Button("");
    public Button a3 = new Button("");
    public Button a4 = new Button("");
    public Button a5 = new Button("");
    public Button a6 = new Button("");
    public Button a7 = new Button("");
    public Button a8 = new Button("");

    public Button b1 = new Button("");
    public Button b2 = new Button("");
    public Button b3 = new Button("");
    public Button b4 = new Button("");
    public Button b5 = new Button("");
    public Button b6 = new Button("");
    public Button b7 = new Button("");
    public Button b8 = new Button("");

    public Button c1 = new Button("");
    public Button c2 = new Button("");
    public Button c3 = new Button("");
    public Button c4 = new Button("");
    public Button c5 = new Button("");
    public Button c6 = new Button("");
    public Button c7 = new Button("");
    public Button c8 = new Button("");

    public Button d1 = new Button("");
    public Button d2 = new Button("");
    public Button d3 = new Button("");
    public Button d4 = new Button("");
    public Button d5 = new Button("");
    public Button d6 = new Button("");
    public Button d7 = new Button("");
    public Button d8 = new Button("");

    public Button e1 = new Button("");
    public Button e2 = new Button("");
    public Button e3 = new Button("");
    public Button e4 = new Button("");
    public Button e5 = new Button("");
    public Button e6 = new Button("");
    public Button e7 = new Button("");
    public Button e8 = new Button("");

    public Button f1 = new Button("");
    public Button f2 = new Button("");
    public Button f3 = new Button("");
    public Button f4 = new Button("");
    public Button f5 = new Button("");
    public Button f6 = new Button("");
    public Button f7 = new Button("");
    public Button f8 = new Button("");

    public Button g1 = new Button("");
    public Button g2 = new Button("");
    public Button g3 = new Button("");
    public Button g4 = new Button("");
    public Button g5 = new Button("");
    public Button g6 = new Button("");
    public Button g7 = new Button("");
    public Button g8 = new Button("");

    public Button h1 = new Button("");
    public Button h2 = new Button("");
    public Button h3 = new Button("");
    public Button h4 = new Button("");
    public Button h5 = new Button("");
    public Button h6 = new Button("");
    public Button h7 = new Button("");
    public Button h8 = new Button("");

    public List<Button> buttons = new ArrayList();

    int sellSize = 80;
    GridPane grid2 = new GridPane();
    public Scene scene = new Scene(grid2, 1000, sellSize * 8);


    InitialPosition initialPosition;

    //Player2 player2 = new Player1(initialPosition);

    public Scene getScene() throws IOException {

        buttons.add(a1);
        buttons.add(a2);
        buttons.add(a3);
        buttons.add(a4);
        buttons.add(a5);
        buttons.add(a6);
        buttons.add(a7);
        buttons.add(a8);

        buttons.add(b1);
        buttons.add(b2);
        buttons.add(b3);
        buttons.add(b4);
        buttons.add(b5);
        buttons.add(b6);
        buttons.add(b7);
        buttons.add(b8);

        buttons.add(c1);
        buttons.add(c2);
        buttons.add(c3);
        buttons.add(c4);
        buttons.add(c5);
        buttons.add(c6);
        buttons.add(c7);
        buttons.add(c8);

        buttons.add(d1);
        buttons.add(d2);
        buttons.add(d3);
        buttons.add(d4);
        buttons.add(d5);
        buttons.add(d6);
        buttons.add(d7);
        buttons.add(d8);

        buttons.add(e1);
        buttons.add(e2);
        buttons.add(e3);
        buttons.add(e4);
        buttons.add(e5);
        buttons.add(e6);
        buttons.add(e7);
        buttons.add(e8);

        buttons.add(f1);
        buttons.add(f2);
        buttons.add(f3);
        buttons.add(f4);
        buttons.add(f5);
        buttons.add(f6);
        buttons.add(f7);
        buttons.add(f8);

        buttons.add(g1);
        buttons.add(g2);
        buttons.add(g3);
        buttons.add(g4);
        buttons.add(g5);
        buttons.add(g6);
        buttons.add(g7);
        buttons.add(g8);

        buttons.add(h1);
        buttons.add(h2);
        buttons.add(h3);
        buttons.add(h4);
        buttons.add(h5);
        buttons.add(h6);
        buttons.add(h7);
        buttons.add(h8);

        initialPosition = new InitialPosition(this);

        grid2.setAlignment(Pos.TOP_LEFT);
        grid2.setGridLinesVisible(true);
        int column = 0;
        int row = 7;

        int counter = 0;
        for (Button i : buttons) {
            counter++;
            if (row == 0) {
                i.setPrefSize(sellSize, sellSize);
                if (counter % 2 == 0) {
                    i.setStyle("-fx-background-color: #fffed6; -fx-border-color: black");
                } else {
                    i.setStyle("-fx-background-color: #8b5937; -fx-border-color: black");
                }
                counter++;
                grid2.add(i, column, row);
                column++;
                row = 7;

            } else {
                if (counter % 2 == 0) {
                    i.setStyle("-fx-background-color: #fffed6; -fx-border-color: black");
                } else {
                    i.setStyle("-fx-background-color: #8b5937; -fx-border-color: black");
                }

//                if (counter%2==0) {
//                    i.setStyle("-fx-background-color: white; -fx-border-color: black");
//                }else {
//                    i.setStyle("-fx-background-color: darkred; -fx-border-color: black");
//                }

                i.setPrefSize(sellSize, sellSize);
                grid2.add(i, column, row);
                row--;
            }
        }

        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPrefWidth(sellSize);
        ColumnConstraints columnConstraints1 = new ColumnConstraints();
        columnConstraints1.setPrefWidth(sellSize);
        ColumnConstraints columnConstraints2 = new ColumnConstraints();
        columnConstraints2.setPrefWidth(sellSize);
        ColumnConstraints columnConstraints3 = new ColumnConstraints();
        columnConstraints3.setPrefWidth(sellSize);
        ColumnConstraints columnConstraints4 = new ColumnConstraints();
        columnConstraints4.setPrefWidth(sellSize);
        ColumnConstraints columnConstraints5 = new ColumnConstraints();
        columnConstraints5.setPrefWidth(sellSize);
        ColumnConstraints columnConstraints6 = new ColumnConstraints();
        columnConstraints6.setPrefWidth(sellSize);
        ColumnConstraints columnConstraints7 = new ColumnConstraints();
        columnConstraints7.setPrefWidth(sellSize);

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPrefHeight(sellSize);
        RowConstraints rowConstraints1 = new RowConstraints();
        rowConstraints1.setPrefHeight(sellSize);
        RowConstraints rowConstraints2 = new RowConstraints();
        rowConstraints2.setPrefHeight(sellSize);
        RowConstraints rowConstraints3 = new RowConstraints();
        rowConstraints3.setPrefHeight(sellSize);
        RowConstraints rowConstraints4 = new RowConstraints();
        rowConstraints4.setPrefHeight(sellSize);
        RowConstraints rowConstraints5 = new RowConstraints();
        rowConstraints5.setPrefHeight(sellSize);
        RowConstraints rowConstraints6 = new RowConstraints();
        rowConstraints6.setPrefHeight(sellSize);
        RowConstraints rowConstraints7 = new RowConstraints();
        rowConstraints7.setPrefHeight(sellSize);

//        columnConstraints1.setPercentWidth(100);

        grid2.getColumnConstraints().addAll(columnConstraints, columnConstraints1, columnConstraints2,
                columnConstraints3, columnConstraints4, columnConstraints5, columnConstraints6, columnConstraints7);
        grid2.getRowConstraints().addAll(rowConstraints, rowConstraints1, rowConstraints2, rowConstraints3,
                rowConstraints4, rowConstraints5, rowConstraints6, rowConstraints7);

        initialPosition.initialize();

        grid2.setId("grid2");
        grid2.setGridLinesVisible(false);
        grid2.add(label,9,1);
        label.setId("player");
        label.setText("Player 1 (White) move");
        vboximage.setPrefHeight(336);
        vboximage.setPrefWidth(413);
        //grid2.add(vboximage,9,5);
        grid2.add(vboximage,9,3,1,4);
        vboximage.setId("chessPlayer");


        //initListeners(buttons);
        scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
        return scene;
    }


    public Button btoBack;
    public Button btoVBOX;
    public VBox vbox;
    public boolean MoveIsCompleted = false;


    public void initListeners(List<Button> buttons) {
        //thread capture

        final String colour = "white";
        try {
//            if (counterMoves % 2 == 0) {
            s1.acquire();
//            primaryStage.setScene(getScene());
//            } else {
//                s2.acquire();
//            }
        } catch (InterruptedException e) {
            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
        }
//        if (vbox!=null && btoVBOX!=null){
//            btoVBOX.graphicProperty().set(vbox);
//        }


        for (final Button b : buttons) {
//        for (int i =0; i<buttons.size();++i) {
//            b =buttons.get(i);
            b.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {

                    //change figure position
                    // ���� ��������� ������ �� ������ ����
                    counterButtons++;
                    if (initialPosition.isYourTurn(colour, b) || counterButtons == 2) {
                        MoveIsCompleted = initialPosition.changePosition(b);
                        //thread to another player
                        if (counterButtons == 2) {
                            if (MoveIsCompleted) {
                                counterButtons = 0;
//                        btoVBOX = b;

                                label.textProperty().set("Player 2 (Black) move.");
                                s2.release();

                            } else {
                                counterButtons = 0;
                                s1.release();
                            }
                        } else if (counterButtons == 1) {
//                        btoBack = b;
//                        vbox = (VBox) b.graphicProperty().getValue();
                            s1.release();
                        } else {
                            s1.release();
                        }
                    } else {
                        System.out.println("Play your figures");
                        counterButtons = 0;
                        s1.release();
                    }
                }
            });
        }
    }


    public void initListeners1(List<Button> buttons) {
        //thread capture
//

        final String colour = "black";
        try {
            s2.acquire();
//            primaryStage.setScene(getScene());

//            b2.toFront();
        } catch (InterruptedException e) {
            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
        }
//        if (vbox!=null && btoVBOX!=null){
//            btoVBOX.graphicProperty().set(vbox);
//        }


        for (final Button b : buttons) {
//        for (int i =0; i<buttons.size();++i) {
//            b =buttons.get(i);

            b.setOnMouseClicked(new EventHandler<MouseEvent>() {
                public void handle(MouseEvent event) {

                    //change figure position

                    counterButtons++;
                    if (initialPosition.isYourTurn(colour, b) || counterButtons == 2) {

                        MoveIsCompleted = initialPosition.changePosition(b);
                        //thread to another player
                        if (counterButtons == 2) {
                            if (MoveIsCompleted) {
                                counterButtons = 0;
                                btoVBOX = b;
                                label.textProperty().set("Player 1 (White) move");
                                s1.release();
                            } else {
                                counterButtons = 0;
                                 s2.release();

                            }
                        }
                            else if (counterButtons == 1) {
                            btoBack = b;
//                        vbox = (VBox) b.graphicProperty().getValue();
//
                            s2.release();
                        } else {
                            s2.release();
                        }
                    }else {
                        System.out.println("Play your figures");
                        counterButtons = 0;
                        s2.release();
                    }
                }


            });
        }

    }
}
