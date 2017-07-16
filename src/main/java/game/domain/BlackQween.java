package game.domain;

import game.animation.FactoryFiguresMove;
import javafx.scene.control.Button;

import java.net.URL;

/**
 * Created by Администратор on 28.05.2017.
 */
public class BlackQween  extends Figures{

    public BlackQween() {

        url = this.getClass().getClassLoader().getResource("images/BlackQween.png");
//        try {
//            url = new URL("file://" + "/E:/MYBUSY/Files/Idea/Project/Checkers/src/main/resources/images/BlackQween" +
//                                               ".png");
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
    //currentPosition = initialPosition;
    }


    private URL url;
    private String colour="black";

    @Override
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public URL getURL() {
        return url;
    }

    public void setURL(URL url) {
        this.url = url;
    }

    public boolean isMoveAccepted (int rawIndexb1, int columnIndexb1, int rawIndexb2, int columnIndexb2,Fields
            fields, Button b2){

        FactoryFiguresMove factoryFunctionsFigures = new FactoryFiguresMove(rawIndexb1, columnIndexb1, rawIndexb2,
                columnIndexb2, fields, colour, b2);
        factoryFunctionsFigures.transformationFields();
        if (factoryFunctionsFigures.isTheSameField()){
            return false;
        } else if (!factoryFunctionsFigures.isQweenMove()){
            return false;
        }else if (factoryFunctionsFigures.isFigureBlocked()) {
            return false;
        }else {
            return true;
        }
    }
}
