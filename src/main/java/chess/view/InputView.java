package chess.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String COMMAND_DELIMITER = " ";
    private static final Pattern VALID_COMMAND_PATTERN = Pattern.compile("^start$|^end$|^move|^status$");

    public List<String> readCommand() {
        final String input = SCANNER.nextLine();
        validateCommand(input);

        return Arrays.stream(input.split(COMMAND_DELIMITER, -1))
                .toList();
    }

    private void validateCommand(final String input) {
        if (isInvalidInput(input)) {
            throw new IllegalArgumentException("start, end, move, status 명령만 입력할 수 있습니다.");
        }
    }

    private boolean isInvalidInput(final String input) {
        return !VALID_COMMAND_PATTERN.matcher(input)
                .find();
    }
}
