package game.animation;

import game.domain.Fields;
import javafx.scene.control.Button;

/**
 * Created by Администратор on 10.06.2017.
 */
public class FactoryFiguresMove {

    //перенести сюда getURL
    Fields fields;
    String colour;
    Button b2;
   // List<String> letters = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H");
    //    char characterInitial, characterNext;
    int digitInitial, digitNext, characterInitial, characterNext;
    int rawIndexb1, columnIndexb1, rawIndexb2, columnIndexb2;

    public FactoryFiguresMove(int rawIndexb1, int columnIndexb1, int rawIndexb2, int columnIndexb2, Fields fields,
                              String colour, Button b2) {
        this.rawIndexb1 = rawIndexb1;
        this.columnIndexb1 = columnIndexb1;
        this.rawIndexb2 = rawIndexb2;
        this.columnIndexb2 = columnIndexb2;
        this.fields = fields;
        this.colour = colour;
        this.b2 = b2;
    }

    public void transformationFields() {
        digitInitial = 8 - rawIndexb1;
        digitNext = 8 - rawIndexb2;
        characterInitial = columnIndexb1 + 1;
        characterNext = columnIndexb2 + 1;
    }


    public boolean isTheSameField() {
        if (characterInitial == characterNext && digitInitial == digitNext) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPawnBlocked() {

        int startMoveCh = characterInitial;
        int endMoveCh = characterNext;

        if (endMoveCh == startMoveCh && digitNext > digitInitial) {
            for (int i = digitInitial + 1; i < digitNext + 1; i++) {
                if (fields.isFieldContainFigure(endMoveCh, i)) {
                    return true;
                }
            }
        } else if (endMoveCh == startMoveCh && digitNext < digitInitial) {
            for (int i = digitInitial - 1; i > digitNext - 1; i--) {
                if (fields.isFieldContainFigure(endMoveCh, i)) {
                    return true;
                }
            }
        } else if (endMoveCh > startMoveCh && digitNext > digitInitial) {
            int j = startMoveCh + 1;
            for (int i = digitInitial + 1; i < digitNext + 1; i++, j++) {
                if (fields.isFieldContainFigure(j, i)) {
                    if (i == digitNext) {
                        if (!colour.equals(fields.getHashMap().get(b2).getColour())) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        } else if (endMoveCh < startMoveCh && digitNext < digitInitial) {
            int j = startMoveCh - 1;
            for (int i = digitInitial - 1; i > digitNext - 1; i--, j--) {
                if (fields.isFieldContainFigure(j, i)) {
                    if (i == digitNext) {
                        if (!colour.equals(fields.getHashMap().get(b2).getColour())) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        } else if (endMoveCh > startMoveCh && digitNext < digitInitial) {
            int j = startMoveCh + 1;
            for (int i = digitInitial - 1; i > digitNext - 1; i--, j++) {
                if (fields.isFieldContainFigure(j, i)) {
                    if (i == digitNext) {
                        if (!colour.equals(fields.getHashMap().get(b2).getColour())) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        } else if (endMoveCh < startMoveCh && digitNext > digitInitial) {
            int j = startMoveCh - 1;
            for (int i = digitInitial + 1; i < digitNext + 1; i++, j--) {
                if (fields.isFieldContainFigure(j, i)) {
                    if (i == digitNext) {
                        if (!colour.equals(fields.getHashMap().get(b2).getColour())) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }


    public boolean isYourFigure() {
        if (fields.isFieldContainFigure(characterNext, digitNext)) {
            if (!colour.equals(fields.getHashMap().get(b2).getColour())) {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean isFigureBlocked() {

        int startMoveCh = characterInitial;
        int endMoveCh = characterNext;

        if (endMoveCh > startMoveCh && digitNext == digitInitial) {
            for (int i = startMoveCh + 1; i < endMoveCh + 1; i++) {
                if (fields.isFieldContainFigure(i, digitNext)) {
                    if (i == endMoveCh) {
//                        Figures fig = fields.getHashMap().get(b2);
//                        String colour = fig.getColour();
                        if (!colour.equals(fields.getHashMap().get(b2).getColour())) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        } else if (endMoveCh < startMoveCh && digitNext == digitInitial) {
            for (int i = startMoveCh - 1; i > endMoveCh - 1; i--) {
                if (fields.isFieldContainFigure(i, digitNext)) {
                    if (i == endMoveCh) {
                        if (!colour.equals(fields.getHashMap().get(b2).getColour())) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        } else if (endMoveCh == startMoveCh && digitNext > digitInitial) {
            for (int i = digitInitial + 1; i < digitNext + 1; i++) {
                if (fields.isFieldContainFigure(endMoveCh, i)) {
                    if (i == digitNext) {
                        if (!colour.equals(fields.getHashMap().get(b2).getColour())) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        } else if (endMoveCh == startMoveCh && digitNext < digitInitial) {
            for (int i = digitInitial - 1; i > digitNext - 1; i--) {
                if (fields.isFieldContainFigure(endMoveCh, i)) {
                    if (i == digitNext) {
                        if (!colour.equals(fields.getHashMap().get(b2).getColour())) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        } else if (endMoveCh > startMoveCh && digitNext > digitInitial) {
            int j = startMoveCh + 1;
            for (int i = digitInitial + 1; i < digitNext + 1; i++, j++) {
                if (fields.isFieldContainFigure(j, i)) {
                    if (i == digitNext) {
                        if (!colour.equals(fields.getHashMap().get(b2).getColour())) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        } else if (endMoveCh < startMoveCh && digitNext < digitInitial) {
            int j = startMoveCh - 1;
            for (int i = digitInitial - 1; i > digitNext - 1; i--, j--) {
                if (fields.isFieldContainFigure(j, i)) {
                    if (i == digitNext) {
                        if (!colour.equals(fields.getHashMap().get(b2).getColour())) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        } else if (endMoveCh > startMoveCh && digitNext < digitInitial) {
            int j = startMoveCh + 1;
            for (int i = digitInitial - 1; i > digitNext - 1; i--, j++) {
                if (fields.isFieldContainFigure(j, i)) {
                    if (i == digitNext) {
                        if (!colour.equals(fields.getHashMap().get(b2).getColour())) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        } else if (endMoveCh < startMoveCh && digitNext > digitInitial) {
            int j = startMoveCh - 1;
            for (int i = digitInitial + 1; i < digitNext + 1; i++, j--) {
                if (fields.isFieldContainFigure(j, i)) {
                    if (i == digitNext) {
                        if (!colour.equals(fields.getHashMap().get(b2).getColour())) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }


    public boolean isRockMove() {
        if (characterInitial == characterNext || digitInitial == digitNext) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isKingMove() {
        if (Math.abs(characterInitial - characterNext) <= 1 && Math.abs(digitInitial - digitNext) <= 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isKnightMove() {
        if ((characterInitial - characterNext) != 0 && (digitInitial - digitNext) != 0 && (Math.abs(digitInitial - digitNext)
                + Math.abs(characterInitial - characterNext)) == 3) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBishopMove() {
        if (Math.abs(characterInitial - characterNext) == Math.abs((digitInitial - digitNext))) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isQweenMove() {
        if (isRockMove() || isBishopMove()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPawnMove() {
        if (characterInitial == characterNext && colour.equals("black") && digitInitial - digitNext == 1) {
            return true;
        } else if (characterInitial == characterNext && colour.equals("black") && digitInitial == 7 && digitInitial -
                digitNext == 2) {
            return true;
        } else if (Math.abs(characterInitial - characterNext) == 1 && digitInitial -
                digitNext == 1 && fields.isFieldContainFigure(characterNext, digitNext) && colour.equals("black")) {
            return true;
        } else if (characterInitial == characterNext && colour.equals("white") && digitNext - digitInitial == 1) {
            return true;
        } else if (characterInitial == characterNext && colour.equals("white") && digitInitial == 2 && digitNext -
                digitInitial == 2) {
            return true;
        } else if (Math.abs(characterInitial - characterNext) == 1 && digitNext -
                digitInitial == 1 && fields.isFieldContainFigure(characterNext, digitNext) && colour.equals("white")) {
            return true;
        } else {
            return false;
        }
    }
}
