package chess.domain.board;

import chess.domain.piece.Empty;
import chess.domain.piece.Piece;
import chess.domain.piece.Team;
import chess.domain.point.Point;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Board {
    private final Map<Point, Piece> board;

    public Board(final Map<Point, Piece> board) {
        this.board = board;
    }

    public void move(final Team team, final Point departure, final Point destination) {
        final Piece piece = board.get(departure);

        validateMove(team, departure, destination, piece);

        movePiece(departure, destination, piece);
    }

    private void movePiece(final Point departure, final Point destination, final Piece piece) {
        board.put(departure, Empty.INSTANCE);
        board.put(destination, piece);
    }

    private void validateMove(final Team team, final Point departure, final Point destination, final Piece piece) {
        validateMyPiece(team, piece);
        validateMovePoint(departure, destination, piece);
    }

    private void validateMyPiece(final Team team, final Piece piece) {
        if (!piece.isTeamMatch(team)) {
            throw new IllegalArgumentException("상대방의 기물을 움직일 수 없습니다.");
        }
    }

    private void validateMovePoint(final Point departure, final Point destination, final Piece piece) {
        if (!piece.canMove(departure, destination, board)) {
            throw new IllegalArgumentException("해당 기물이 이동할 수 있는 위치가 아닙니다.");
        }
    }

    public Piece findPieceByPoint(final Point point) {
        return board.get(point);
    }

    public double calculateTotalScore(final Team team) {
        final double score = calculateScore(team);
        final double penalty = calculatePenalty(team);

        return score - penalty;
    }

    private double calculateScore(final Team team) {
        return board.values()
                .stream()
                .filter(piece -> piece.isTeamMatch(team))
                .mapToDouble(Piece::getScore)
                .sum();
    }

    private double calculatePenalty(final Team team) {
        final Map<Character, Integer> pawnCountInSameLine = countPawnInSameLine(team);

        return pawnCountInSameLine.values()
                .stream()
                .filter(count -> count >= 2)
                .mapToDouble(count -> count * 0.5)
                .sum();
    }

    private Map<Character, Integer> countPawnInSameLine(final Team team) {
        final Map<Character, Integer> pawnCountInSameLine = new HashMap<>();

        for (char file = 'a'; file <= 'h'; file++) {
            for (int rank = 1; rank <= 8; rank++) {
                final Piece piece = board.get(Point.of(file, rank));
                if (piece.isPawn() && piece.isTeamMatch(team)) {
                    pawnCountInSameLine.put(file, pawnCountInSameLine.getOrDefault(file, 0) + 1);
                }
            }
        }
        return pawnCountInSameLine;
    }

    public Map<Point, Piece> getBoard() {
        return Collections.unmodifiableMap(board);
    }
}
