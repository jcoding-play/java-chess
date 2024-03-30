package chess.dao;

import chess.db.JdbcTemplate;
import chess.domain.piece.Team;
import chess.dto.TurnDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TurnDaoTest {

    @Test
    @DisplayName("턴을 저장할 수 있다.")
    void update() {
        TurnDto whiteTurn = TurnDto.from(Team.WHITE);
        TurnDao turnDao = new TurnDao(new JdbcTemplate());

        turnDao.update(whiteTurn);

        assertThat(turnDao.findOne().turn()).isEqualTo("WHITE");
    }
}