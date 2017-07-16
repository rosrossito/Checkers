package game.domain;

import game.animation.ChessBoard;
import javafx.concurrent.Task;

/**
 * Created by Администратор on 16.06.2017.
 */
public class Player2 extends Task<Void>{

    ChessBoard chessBoard;


    public Player2(ChessBoard chessBoard){
        this.chessBoard=chessBoard;

    }


    @Override
    protected Void call() throws Exception {

        for (int i = 0; i < 1000000; i++) {
//            chessBoard.initializeThread2();
        
        chessBoard.initListeners1(chessBoard.buttons);
    }
//        chessBoard.btoVBOX.graphicProperty().set(chessBoard.vbox);
//        System.out.println("Passed vbox player 2");
//        chessBoard.btoBack.toBack();
//        System.out.println("Passed toback player 2");


//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        return null;
    }
}
