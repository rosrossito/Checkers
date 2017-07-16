package game.domain;

import game.animation.ChessBoard;
import javafx.concurrent.Task;

/**
 * Created by Администратор on 16.06.2017.
 */
public class Player1 extends Task <Void>{

    ChessBoard chessBoard;

    public Player1(ChessBoard chessBoard){
        this.chessBoard=chessBoard;
        }


    @Override
    protected Void call() throws Exception {


        for (int i=0;i<1000000; i++){
//        chessBoard.initializeThread1();
        chessBoard.initListeners(chessBoard.buttons);
        }
//        chessBoard.btoVBOX.graphicProperty().set(chessBoard.vbox);
//        System.out.println("Passed vbox player 1");
//        chessBoard.btoBack.toBack();
//        System.out.println("Passed toback player 1");


//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//

        return null;
    }
}
