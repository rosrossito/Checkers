package game.animation;

import game.domain.Fields;
import game.domain.Figures;
import game.domain.Player1;
import game.domain.Player2;
import javafx.animation.TranslateTransition;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 * Created by јдминистратор on 07.06.2017.
 */
public class InitialPosition {

    Fields fields;
    Player1 player1;
    Player2 player2;

    public InitialPosition(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;
        fields = new Fields(chessBoard);
    }

    ChessBoard chessBoard;
    ArrayList<Button> move = new ArrayList<Button>();


    public void initialize() {
        //Draw images of figures
        for (Button b : chessBoard.buttons) {
            if (fields.getHashMap().get(b) != null) {
                draw(b);
            }

        }
    }

    public boolean changePosition(Button button) {

        if (move.size() == 0 && fields.getHashMap().get(button) == null) {
            System.out.println("Move is not accepted");
            move.clear();
            return false;
        } else {

            move.add(button);
            if (move.size() == 2) {
// check move availability
                if (isMoveAccepted(move.get(0), move.get(1))) {
// move
//draw + change hashmap

                    imageMove(move.get(0), move.get(1));

// если во второй €чейке не null, тогда убить фигуру

//    move.get(0).toBack();
//        b2.graphicProperty().set(vbox);
//        b1.graphicProperty().set(null);
                    move.clear();
                    return true;
                } else {
                    System.out.println("Move is not accepted");
                    move.clear();
                    return false;
                }
            } else {
//pick the field
//button.setStyle(button.getStyle() + "; -fx-transition: all 0.3s ease; -fx-background-color:  transparent;");
//            button.setStyle(button.getStyle() + "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0)" +
//                    ";");
                System.out.println("Where to go?");
                return false;
            }

        }
    }

    boolean isMoveAccepted(Button b1, Button b2) {

        if (fields.getHashMap().get(b1) == null) {
            return false;
        } else {

            Figures figures1 = fields.getHashMap().get(b1);

//        Figures figures2 = fields.getHashMap().get(b2);
            return figures1.isMoveAccepted(chessBoard.grid2.getRowIndex(b1), chessBoard.grid2.getColumnIndex(b1),
                    chessBoard.grid2.getRowIndex(b2), chessBoard.grid2.getColumnIndex(b2), fields, b2);
        }
    }

    public void draw(Button b) {

//        Image image = new Image(fields.getHashMap().get(b).getURL().toString(),true);
//        ImageView imageView = new ImageView();
//        imageView.setImage(image);
//        imageView.setFitHeight(chessBoard.sellSize*0.8);
//        imageView.setFitWidth(chessBoard.sellSize*0.8);
//        VBox vbox = new VBox();

//        chessBoard.grid2.add(vbox,chessBoard.grid2.getColumnIndex(b),chessBoard.grid2.getRowIndex(b));
//        b.graphicProperty().set(vbox);
//        vbox.setAlignment(Pos.CENTER);
//        vbox.getChildren().add(imageView);
        //vbox.toBack();

        b.setStyle(b.getStyle() + "; -fx-background-image: url('" + fields.getHashMap().get(b).getURL() +
                "');" +
                "-fx-background-repeat: stretch;-fx-background-size : 55 65;-fx-background-position: center center;");
    }


    public void drawEmpty(Button b, int raw, int column) {

        if (raw % 2 == 0 && column % 2 == 0 || raw % 2 != 0 && column % 2 != 0) {
            b.setStyle("-fx-background-color: #fffed6; -fx-border-color: black");
        } else {
            b.setStyle("-fx-background-color: #8b5937; -fx-border-color: black");
        }
    }


    //    public ImageView imageView;
    int counter = 0;

    void imageMove(Button b1, Button b2) {

        //void transition(Button b1, Button b2);

        //launch gif file
        Figures fig = fields.getHashMap().get(b2);
        if (fig != null) {
            counter++;
            if (counter == 8) counter = 1;
            new GifAnimation(counter);
        }


        //Changing hashmap
        fields.changePositionFigure(b2, fields.getHashMap().get(b1));
        fields.changePositionFigure(b1, null);

        //Search position

        //Draw new position

        drawEmpty(b1, chessBoard.grid2.getRowIndex(b1), chessBoard.grid2.getColumnIndex(b1));
        draw(b2);
        //chessBoard.grid2.getColumnIndex(b1), chessBoard.grid2.getRowIndex(b1)

    }

//    int getFigurePosition(Button b1) {
//        return (chessBoard.grid2.getRowIndex(b1) * 8 + chessBoard.grid2.getColumnIndex(b1));
//    }


    public boolean isYourTurn(String colour, Button button) {
        if (fields.isFieldContainFigure(chessBoard.grid2.getColumnIndex(button) + 1, 8 - chessBoard.grid2.getRowIndex(button)
        )) {
            if (colour == fields.getHashMap().get(button).getColour()) {
                return true;
            } else return false;
        } else {
            return true;
        }
    }


    void transition(Button b1, Button b2) {
        VBox vbox = (VBox) b1.graphicProperty().getValue();

        b1.toFront();


//        b1.graphicProperty().setValue(new VBox());

//        Image image = new Image(fields.getHashMap().get(b1).getURL().toString(),true);
//        VBox vbox = new VBox();
//        vbox.setAlignment(Pos.CENTER);
//        chessBoard.grid2.add(vbox, chessBoard.grid2.getColumnIndex(b1), chessBoard.grid2.getRowIndex(b1));
//        ImageView imageView = new ImageView();
//        imageView.setImage(image);
//        vbox.getChildren().add(imageView);

//        Image image = new Image(fields.getHashMap().get(b1).getURL().toString(),true);
//        imageView = new ImageView();
//        imageView.setImage(image);
//        imageView.setFitHeight(chessBoard.sellSize * 0.8);
//        imageView.setFitWidth(chessBoard.sellSize*0.8);
//        chessBoard.grid2.add(imageView,chessBoard.grid2.getColumnIndex(b1), chessBoard.grid2.getRowIndex(b1));

        //Creating Translate Transition
        TranslateTransition translateTransition = new TranslateTransition();
//        PathTransition pathTransition = new PathTransition();
        //Setting the duration of the transition
        translateTransition.setDuration(Duration.millis(400));
//        pathTransition.setDuration(Duration.millis(1000));
        //translateTransition.setOnFinished();
        //translateTransition.getCycleDuration()

        //Setting the node for the transition
        translateTransition.setNode(vbox);
//        translateTransition.setNode(imageView);
//        pathTransition.setNode(imageView);

        //Setting the value of the transition
        translateTransition.setByY((chessBoard.grid2.getRowIndex(b2) - chessBoard.grid2.getRowIndex(b1)) * b1.getHeight());
        translateTransition.setByX((chessBoard.grid2.getColumnIndex(b2) - chessBoard.grid2.getColumnIndex(b1)) * b1
                .getHeight());


//        final Path path = new Path();
//        path.getElements().add(new MoveTo((chessBoard.grid2.getRowIndex(b2)-chessBoard.grid2.getRowIndex(b1))*b1
//                .getHeight(), (chessBoard.grid2.getColumnIndex(b2)-chessBoard.grid2.getColumnIndex(b1))*b1
//                .getHeight()));


        //Setting auto reverse value to false
        translateTransition.setAutoReverse(false);
//        pathTransition.setAutoReverse(false);

        //Playing the animation
        translateTransition.play();
//        pathTransition.play();

//        b2.graphicProperty().set(vbox);
//        chessBoard.grid2.getChildren().remove(imageView);

//        b2.toFront();
//        draw(b2);
    }
}
