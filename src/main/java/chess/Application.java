package chess;

import chess.controller.ChessController;
import chess.dao.ChessDaoService;
import chess.view.InputView;
import chess.view.OutputView;

public class Application {

    public static void main(String[] args) {
        final InputView inputView = new InputView();
        final OutputView outputView = new OutputView();
        final ChessDaoService chessDaoService = new ChessDaoService();
        final ChessController controller = new ChessController(chessDaoService, inputView, outputView);

        controller.run();
    }
}
