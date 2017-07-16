package game.animation;

import game.repository.GameUserRepository;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Created by Администратор on 21.06.2017.
 */
public class Authorization {
    final Stage dialog1 = new Stage();
    public final String[] name = {null, null};
    Button button = new Button("OK");
    final TextField tf1 = new TextField();
    final TextField tf2 = new TextField();

    public void registration() {

        GridPane popup = new GridPane();
        popup.setId("registration");
        popup.setAlignment(Pos.CENTER);
        dialog1.setTitle("Registration");

        Label l1 = new Label("Player1: ");
        Label l2 = new Label("Player2: ");

        HBox hb = new HBox(10);
        hb.setAlignment(Pos.BOTTOM_RIGHT);
        hb.getChildren().add(button);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        grid.add(l1, 0, 0);
        grid.add(l2, 0, 1);
        grid.add(tf1, 1, 0);
        grid.add(tf2, 1, 1);
        grid.add(hb, 1, 2);

        Scene scene = new Scene(grid, 300, 275);
        dialog1.setScene(scene);
        dialog1.show();
        dialog1.setAlwaysOnTop(true);
        Scene dialog1Scene = new Scene(popup);
        dialog1Scene.getStylesheets().add(getClass().getResource("/application.css").toExternalForm());
        initListeners();
    }

    private void initListeners() {
        button.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                name[0] = tf1.getText();
                name[1] = tf2.getText();
                System.out.println(name[0]);
                System.out.println(name[1]);
                callRepository(name[0],name[1]);
                dialog1.close();
            }
        });
    }

void callRepository(String player1, String player2){
    GameUserRepository gameUserRepository = new GameUserRepository();
    gameUserRepository.connect_to_database_from_properties();
    if (!player1.equals("") && !player2.equals("") ){
    gameUserRepository.playerRegistration(player1, player2);}
}
}


