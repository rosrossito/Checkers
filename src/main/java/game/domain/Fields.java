package game.domain;

import game.animation.ChessBoard;
import javafx.scene.control.Button;

import java.util.HashMap;

/**
 * Created by Администратор on 08.06.2017.
 */
public class Fields {
    private HashMap<Button, Figures> hashMap = new HashMap<Button, Figures>();
    ChessBoard chessBoard;
    WhiteRook whiteRook = new WhiteRook();
    WhiteHorse whiteHorse = new WhiteHorse();
    WhiteBishop whiteBishop = new WhiteBishop();
    WhiteQween whiteQween = new WhiteQween();
    WhiteKing whiteKing = new WhiteKing();
    WhitePawn whitePawn = new WhitePawn();
    BlackQween blackQween = new BlackQween();
    BlackBishop blackBishop = new BlackBishop();
    BlackHorse blackHorse = new BlackHorse();
    BlackKing blackKing = new BlackKing();
    BlackPawn blackPawn = new BlackPawn();
    BlackRook blackRook = new BlackRook();

    public Fields(ChessBoard chessBoard) {
        this.chessBoard = chessBoard;

        for (Button b : chessBoard.buttons) {
            hashMap.put(b, null);
        }

        hashMap.put(chessBoard.a1, whiteRook);
        hashMap.put(chessBoard.b1, whiteHorse);
        hashMap.put(chessBoard.c1, whiteBishop);
        hashMap.put(chessBoard.d1, whiteQween);
        hashMap.put(chessBoard.e1, whiteKing);
        hashMap.put(chessBoard.f1, whiteBishop);
        hashMap.put(chessBoard.g1, whiteHorse);
        hashMap.put(chessBoard.h1, whiteRook);

        hashMap.put(chessBoard.a2, whitePawn);
        hashMap.put(chessBoard.b2, whitePawn);
        hashMap.put(chessBoard.c2, whitePawn);
        hashMap.put(chessBoard.d2, whitePawn);
        hashMap.put(chessBoard.e2, whitePawn);
        hashMap.put(chessBoard.f2, whitePawn);
        hashMap.put(chessBoard.g2, whitePawn);
        hashMap.put(chessBoard.h2, whitePawn);

        hashMap.put(chessBoard.a8, blackRook);
        hashMap.put(chessBoard.b8, blackHorse);
        hashMap.put(chessBoard.c8, blackBishop);
        hashMap.put(chessBoard.d8, blackQween);
        hashMap.put(chessBoard.e8, blackKing);
        hashMap.put(chessBoard.f8, blackBishop);
        hashMap.put(chessBoard.g8, blackHorse);
        hashMap.put(chessBoard.h8, blackRook);

        hashMap.put(chessBoard.a7, blackPawn);
        hashMap.put(chessBoard.b7, blackPawn);
        hashMap.put(chessBoard.c7, blackPawn);
        hashMap.put(chessBoard.d7, blackPawn);
        hashMap.put(chessBoard.e7, blackPawn);
        hashMap.put(chessBoard.f7, blackPawn);
        hashMap.put(chessBoard.g7, blackPawn);
        hashMap.put(chessBoard.h7, blackPawn);
    }

    public boolean isFieldContainFigure(int posLetter, int digit) {

        int position = 8 * (posLetter-1) + (digit-1);
        Button b = chessBoard.buttons.get(position);
        if (hashMap.get(chessBoard.buttons.get(position)) != null) {

            return true;
        }else{
            return false;
        }
    }

    public HashMap<Button, Figures> getHashMap() {
        return hashMap;
    }

    public void changePositionFigure(Button button, Figures figures) {
        System.out.println(hashMap.containsKey(button));
        hashMap.put(button, figures);

    }


    public void setHashMap(HashMap<Button, Figures> hashMap) {
        this.hashMap = hashMap;
    }


}
