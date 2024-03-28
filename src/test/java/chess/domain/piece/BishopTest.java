package chess.domain.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.fixture.PointFixture.포인트;
import static org.assertj.core.api.Assertions.assertThat;

class BishopTest {
    private Bishop bishop = new Bishop(Team.WHITE);

    @Test
    @DisplayName("오른쪽 대각선 위로 움직일 수 있다.")
    void isMovablePoint1() {
        boolean result = bishop.isMovablePoint(
                포인트("A1"),
                포인트("B2"));

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("오른쪽 대각선 아래로 움직일 수 있다.")
    void isMovablePoint2() {
        boolean result = bishop.isMovablePoint(
                포인트("C4"),
                포인트("E2"));

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("왼쪽 대각선 위로 움직일 수 있다.")
    void isMovablePoint3() {
        boolean result = bishop.isMovablePoint(
                포인트("H1"),
                포인트("A8"));

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("왼쪽 대각선 아래로 움직일 수 있다.")
    void isMovablePoint4() {
        boolean result = bishop.isMovablePoint(
                포인트("H8"),
                포인트("B2"));

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("오른쪽 일직선으로 움직일 수 없다.")
    void isNotMovablePoint1() {
        boolean result = bishop.isMovablePoint(
                포인트("A1"),
                포인트("H1"));

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("왼쪽 일직선으로 움직일 수 없다.")
    void isNotMovablePoint2() {
        boolean result = bishop.isMovablePoint(
                포인트("C4"),
                포인트("A4"));

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("위 일직선으로 움직일 수 없다.")
    void isNotMovablePoint3() {
        boolean result = bishop.isMovablePoint(
                포인트("A1"),
                포인트("A8"));

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("아래 일직선으로 움직일 수 없다.")
    void isNotMovablePoint4() {
        boolean result = bishop.isMovablePoint(
                포인트("H8"),
                포인트("B8"));

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("같은 위치로 움직일 수 없다.")
    void isNotMovablePoint5() {
        boolean result = bishop.isMovablePoint(
                포인트("H8"),
                포인트("H8"));

        assertThat(result).isFalse();
    }
}
