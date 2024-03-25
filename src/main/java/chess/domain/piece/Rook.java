package chess.domain.piece;

import chess.domain.Point;

public final class Rook extends MultiMovePiece {

    public Rook(Team team) {
        super(Type.ROOK, team);
    }

    @Override
    public boolean isMovableDirection(final Point departure, final Point destination) {
        return departure.isStraight(destination);
    }
}
