package chess.dao;

import chess.db.JdbcTemplate;
import chess.dto.PieceDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PieceDaoTest {
    private PieceDao pieceDao = new PieceDao(new JdbcTemplate());

    @Test
    @DisplayName("피스를 저장하고 찾을 수 있다.")
    void findOne() {
        final var pieceDto = new PieceDto("A", "3", "WHITE", "PAWN");
        pieceDao.save(pieceDto);

        PieceDto findPiece = pieceDao.findOne("A", "3");

        assertThat(findPiece.team()).isEqualTo("WHITE");
        assertThat(findPiece.type()).isEqualTo("PAWN");
    }
}