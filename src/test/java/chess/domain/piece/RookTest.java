package chess.domain.piece;

import chess.domain.point.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RookTest {

    @Test
    @DisplayName("위로 움직일 수 있다")
    void isMovablePoint1() {
        Rook rook = new Rook(Team.WHITE);

        boolean result = rook.isMovablePoint(
                Point.of('a', 1),
                Point.of('a', 8)
        );

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("아래로 움직일 수 있다")
    void isMovablePoint2() {
        Rook rook = new Rook(Team.WHITE);

        boolean result = rook.isMovablePoint(
                Point.of('a', 8),
                Point.of('a', 1)
        );

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("왼쪽으로 움직일 수 있다")
    void isMovablePoint3() {
        Rook rook = new Rook(Team.WHITE);

        boolean result = rook.isMovablePoint(
                Point.of('h', 1),
                Point.of('a', 1)
        );

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("오른쪽으로 움직일 수 있다")
    void isMovablePoint4() {
        Rook rook = new Rook(Team.WHITE);

        boolean result = rook.isMovablePoint(
                Point.of('a', 1),
                Point.of('h', 1)
        );

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("대각선으로 움질수 없다")
    void invalidMovablePoint() {
        Rook rook = new Rook(Team.WHITE);

        boolean result = rook.isMovablePoint(
                Point.of('a', 1),
                Point.of('b', 2)
        );

        assertThat(result).isFalse();
    }
}
