package chess;

import chess.controller.ChessController;
import chess.dao.ChessGameService;
import chess.view.InputView;
import chess.view.OutputView;

public class Application {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final ChessGameService chessGameService = new ChessGameService();
        final ChessController controller = new ChessController(chessGameService, inputView, outputView);

        controller.run();
    }
}
