package game.domain;

import javafx.scene.control.Button;

import java.net.URL;

/**
 * Created by Администратор on 09.06.2017.
 */
public class Figures {

    URL url;
    public URL getURL() {
        return url;
    }
    private String colour;

    public boolean isMoveAccepted (int rawIndexb1, int columnIndexb1, int rawIndexb2, int columnIndexb2, Fields
            fields, Button b2){
        return false;
    }

    public String getColour() {
        return colour;
    }

    //    void initialPosition();
//    void beat();
//    void move();

}
