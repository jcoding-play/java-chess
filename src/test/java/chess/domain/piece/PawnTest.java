package chess.domain.piece;

import static org.assertj.core.api.Assertions.assertThat;

import chess.domain.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PawnTest {

    @Test
    @DisplayName("폰은 팀의 진행 방향으로 한 칸 이동할 수 있다.")
    void isMovable1() {
        Pawn pawn = new Pawn(Team.WHITE);

        boolean result = pawn.isMovable(new Point("a", 3), new Point("a", 4));

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("처음 폰이 움직일 땐 위로 두 칸 이동할 수 있다.")
    void isMovable2() {
        Pawn pawn = new Pawn(Team.WHITE);

        boolean result = pawn.isMovable(new Point("a", 2), new Point("a", 4));

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("폰은 팀 진행 방향 대각선으로 한 칸 이동할 수 있다.")
    void isMovable3() {
        Pawn pawn = new Pawn(Team.BLACK);

        boolean result = pawn.isMovable(new Point("a", 3), new Point("b", 2));

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("하얀색 폰은 아래로 갈 수 없다.")
    void invalidIsMovable1() {
        Pawn pawn = new Pawn(Team.WHITE);

        boolean result = pawn.isMovable(new Point("a", 2), new Point("a", 1));

        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("초기 위치가 아닌 폰은 두 칸 움직일 수 없다")
    void invalidIsMovable2() {
        Pawn pawn = new Pawn(Team.WHITE);

        boolean result = pawn.isMovable(new Point("a", 3), new Point("a", 5));

        assertThat(result).isFalse();
    }
}