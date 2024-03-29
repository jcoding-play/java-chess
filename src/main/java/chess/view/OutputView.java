package chess.view;

import chess.domain.piece.Piece;
import chess.domain.piece.Team;
import chess.domain.piece.Type;
import chess.domain.point.Point;

import java.util.Map;

public class OutputView {
    private static final String ERROR_SUFFIX = "[ERROR]";
    private static final Map<Type, String> NAME_CLASSIFIER = Map.of(
            Type.KING, "K",
            Type.QUEEN, "Q",
            Type.ROOK, "R",
            Type.BISHOP, "B",
            Type.KNIGHT, "N",
            Type.PAWN, "P",
            Type.EMPTY, "."
    );

    public void printBoard(Map<Point, Piece> board) {
        final StringBuilder boardMessageBuilder = new StringBuilder();

        for (int rank = 8; rank > 0; rank--) {
            appendPieceName(boardMessageBuilder, board, rank);
            boardMessageBuilder.append(System.lineSeparator());
        }

        System.out.println(boardMessageBuilder);
    }

    private void appendPieceName(final StringBuilder boardMessageBuilder, final Map<Point, Piece> board, final int rank) {
        for (char file = 'a'; file <= 'h'; file++) {
            final Piece piece = board.get(Point.of(file, rank));
            boardMessageBuilder.append(findNameOf(piece));
        }
    }

    private String findNameOf(final Piece piece) {
        final Type pieceType = piece.getType();
        final String name = NAME_CLASSIFIER.get(pieceType);

        final Team team = piece.getTeam();
        if (team.isWhite()) {
            return name.toLowerCase();
        }
        return name;
    }

    public void printGameStart() {
        System.out.println("""
                > 체스 게임을 시작합니다.
                > 게임 시작 : start
                > 게임 종료 : end
                > 게임 이동 : move source위치 target위치 - 예. move b2 b3""");
    }

    public void printScore(final double whiteScore, final double blackScore) {
        System.out.printf("흰색 : %.1f, 검은색 : %.1f%n", whiteScore, blackScore);
    }

    public void printErrorMessage(final String errorMessage) {
        System.out.printf("%s %s%n", ERROR_SUFFIX, errorMessage);
    }
}
