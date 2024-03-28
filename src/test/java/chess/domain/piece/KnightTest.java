package chess.domain.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.fixture.PointFixture.포인트;
import static org.assertj.core.api.Assertions.assertThat;

class KnightTest {
    private Knight knight = new Knight(Team.WHITE);

    @Test
    @DisplayName("위로 두칸을 이동한 뒤 좌로 한칸 이동할 수 있다.")
    void isMovablePoint1() {
        boolean result = knight.isMovablePoint(
                포인트("A4"),
                포인트("D6"));

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("위로 두칸을 이동한 뒤 우로 한칸 이동할 수 있다.")
    void isMovablePoint2() {
        boolean result = knight.isMovablePoint(
                포인트("E4"),
                포인트("F6"));

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("아래로 두칸을 이동한 뒤 좌로 한칸 이동할 수 있다.")
    void isMovablePoint3() {
        boolean result = knight.isMovablePoint(
                포인트("E4"),
                포인트("D2"));

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("아래로 두칸을 이동한 뒤 우로 한칸 이동할 수 있다.")
    void isMovablePoint4() {
        boolean result = knight.isMovablePoint(
                포인트("E4"),
                포인트("F2"));

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("우로 두칸을 이동한 뒤 위로 한칸 이동할 수 있다.")
    void isMovablePoint5() {
        boolean result = knight.isMovablePoint(
                포인트("E4"),
                포인트("G5"));

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("우로 두칸을 이동한 뒤 아래로 한칸 이동할 수 있다.")
    void isMovablePoint6() {
        boolean result = knight.isMovablePoint(
                포인트("E4"),
                포인트("G3"));

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("좌로 두칸을 이동한 뒤 위로 한칸 이동할 수 있다.")
    void isMovablePoint7() {
        boolean result = knight.isMovablePoint(
                포인트("E4"),
                포인트("C5"));

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("좌로 두칸을 이동한 뒤 아래로 한칸 이동할 수 있다.")
    void isMovablePoint8() {
        boolean result = knight.isMovablePoint(
                포인트("E4"),
                포인트("G3"));

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("한 방향으로 두 칸 이동 후 다른 방향으로 한 칸이 아니면 이동할 수 없다.")
    void invalidMovablePoint1() {
        boolean result = knight.isMovablePoint(
                포인트("E4"),
                포인트("G2"));

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("수직으로 이동할 수 없다.")
    void invalidMovablePoint2() {
        boolean result = knight.isMovablePoint(
                포인트("E4"),
                포인트("H4"));

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("대각선으로 이동할 수 없다.")
    void invalidMovablePoint3() {
        boolean result = knight.isMovablePoint(
                포인트("B2"),
                포인트("D4"));

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("같은 위치로 이동할 수 없다.")
    void invalidMovablePoint4() {
        boolean result = knight.isMovablePoint(
                포인트("E4"),
                포인트("E4"));

        assertThat(result).isFalse();
    }
}
