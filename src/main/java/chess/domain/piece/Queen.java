package chess.domain.piece;

import chess.domain.Point;

public final class Queen extends MultiMovePiece {

    public Queen(Team team) {
        super(Type.QUEEN, team);
    }

    @Override
    public boolean isMovableDirection(final Point departure, final Point destination) {
        return departure.isStraight(destination) || departure.isDiagonalWithSlopeOfOne(destination);
    }
}
