package chess.dto;

import chess.domain.piece.Team;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TurnDtoTest {

    @Test
    @DisplayName("dto로 변환할 수 있다.")
    void toDto() {
        final TurnDto turnDto = TurnDto.from(Team.BLACK);

        assertThat(turnDto.turn()).isEqualTo("BLACK");
    }
}