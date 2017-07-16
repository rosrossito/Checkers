package game.animation;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by Администратор on 21.06.2017.
 */
public class GifAnimation {

    int counter;
    public GifAnimation(int counter){
        this.counter=counter;
        final Stage dialog = new Stage();
        GridPane popup = new GridPane();

        StringBuilder sb = new StringBuilder("Gifka");
        counter++;
//        Random random = new Random();
//        int i = random.nextInt(7)+1;
        if (counter==8) counter=1;
        sb.append(counter);

        popup.setId(String.valueOf(sb));
        //popup.setId("Gifka");
        popup.setAlignment(Pos.CENTER);

//    BorderPane popup = new BorderPane();
//    Image image = new Image("file:resources/images/whitePawnHit.gif");
//        Image image = null;
//    VBox vBoxgifka = new VBox();
//    vBoxgifka.setId("chessPlayer");

//        ImageView view = new ImageView(image);
//        view.setId("chessPlayer");
//        popup.getChildren().add(view);
        Scene dialogScene = new Scene(popup);
        dialogScene.getStylesheets().add(getClass().getResource("../../application.css").toExternalForm());
        dialog.setScene(dialogScene);
        dialog.show();





        //dialog.showAndWait();
        //dialog.close();


    }


}
