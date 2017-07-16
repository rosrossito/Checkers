package game.domain;

import game.animation.FactoryFiguresMove;
import javafx.scene.control.Button;

import java.net.URL;

/**
 * Created by Администратор on 09.06.2017.
 */
public class BlackPawn extends Figures {
    private URL url;
    private String colour = "black";

    public BlackPawn() {

        url = this.getClass().getClassLoader().getResource("images/BlackPawn.png");

//        try {
//            url = new URL("file://" + "/E:/MYBUSY/Files/Idea/Project/Checkers/src/main/resources/images/BlackPawn" +
//                    ".png");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
        //currentPosition = initialPosition;
    }

    @Override
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isMoveAccepted(int rawIndexb1, int columnIndexb1, int rawIndexb2, int columnIndexb2,Fields fields,
                                  Button b2                             ) {

//        String fieldInitialPosition = button1.textProperty().getName();//имен то нету пока
//        String fieldNextPosition = button1.textProperty().getName();
//        char characterInitial = fieldInitialPosition.charAt(0);
//        int digitInitial = fieldInitialPosition.charAt(1);
//        char characterNext = fieldNextPosition.charAt(0);
//        int digitNext = fieldNextPosition.charAt(1);

        FactoryFiguresMove factoryFunctionsFigures = new FactoryFiguresMove(rawIndexb1, columnIndexb1, rawIndexb2,
                columnIndexb2, fields, colour, b2);
        factoryFunctionsFigures.transformationFields();
        if (factoryFunctionsFigures.isTheSameField()) {
            return false;
        } else if (!factoryFunctionsFigures.isPawnMove()) {
            return false;
        } else if (factoryFunctionsFigures.isPawnBlocked()) {
            return false;
        } else {
            return true;
        }
    }

    public URL getURL() {
        return url;
    }

    public void setURL(URL url) {
        this.url = url;
    }

//превращение пешки в другую фигуру (у пешки)
//битое поле (у пешки)



}
