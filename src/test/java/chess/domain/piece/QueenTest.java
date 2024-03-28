package chess.domain.piece;

import chess.domain.point.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueenTest {

    @Test
    @DisplayName("위로 움직일 수 있다")
    void isMovablePoint1() {
        Queen queen = new Queen(Team.WHITE);

        boolean result = queen.isMovablePoint(
                Point.of('a', 1),
                Point.of('a', 8)
        );

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("아래로 움직일 수 있다")
    void isMovablePoint2() {
        Queen queen = new Queen(Team.WHITE);

        boolean result = queen.isMovablePoint(
                Point.of('a', 8),
                Point.of('a', 1)
        );

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("왼쪽으로 움직일 수 있다")
    void isMovablePoint3() {
        Queen queen = new Queen(Team.WHITE);

        boolean result = queen.isMovablePoint(
                Point.of('h', 1),
                Point.of('a', 1)
        );

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("오른쪽으로 움직일 수 있다")
    void isMovablePoint4() {
        Queen queen = new Queen(Team.WHITE);

        boolean result = queen.isMovablePoint(
                Point.of('a', 1),
                Point.of('h', 1)
        );

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("오른쪽 대각선 위로 움직일 수 있다.")
    void isMovablePoint5() {
        Queen queen = new Queen(Team.WHITE);
        boolean result = queen.isMovablePoint(
                Point.of('a', 1),
                Point.of('b', 2)
        );

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("오른쪽 대각선 아래로 움직일 수 있다.")
    void isMovablePoint6() {
        Queen queen = new Queen(Team.WHITE);
        boolean result = queen.isMovablePoint(
                Point.of('c', 4),
                Point.of('e', 2)
        );

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("왼쪽 대각선 위로 움직일 수 있다.")
    void isMovablePoint7() {
        Queen queen = new Queen(Team.WHITE);
        boolean result = queen.isMovablePoint(
                Point.of('h', 1),
                Point.of('a', 8)
        );

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("왼쪽 대각선 아래로 움직일 수 있다.")
    void isMovablePoint8() {
        Queen queen = new Queen(Team.WHITE);
        boolean result = queen.isMovablePoint(
                Point.of('h', 8),
                Point.of('b', 2)
        );

        assertThat(result).isTrue();
    }
}
