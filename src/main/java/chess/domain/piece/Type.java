package chess.domain.piece;

public enum Type {
    KING(0.0),
    QUEEN(9.0),
    ROOK(5.0),
    BISHOP(3.0),
    KNIGHT(2.5),
    PAWN(1),
    EMPTY(0.0);

    private final double score;

    Type(final double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }
}
