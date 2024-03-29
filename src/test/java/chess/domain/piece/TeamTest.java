package chess.domain.piece;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class TeamTest {

    @ParameterizedTest
    @CsvSource(value = {"WHITE, BLACK", "BLACK, WHITE"})
    @DisplayName("상대팀의 정보를 알 수 있다.")
    void opposite(Team currentTeam, Team expected) {
        Team actual = currentTeam.opposite();

        assertThat(actual).isEqualTo(expected);
    }
}
