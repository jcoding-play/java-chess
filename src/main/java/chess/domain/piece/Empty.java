package chess.domain.piece;

import chess.domain.point.Point;

import java.util.Map;

public class Empty extends Piece {

    public Empty() {
        super(Type.EMPTY, Team.EMPTY);
    }

    @Override
    public boolean isMovable(Point departure, Point destination, final Map<Point, Piece> board) {
        return false;
    }
}
