package MainGame.controller;

import MainGame.logic.Game;
import MainGame.Main;
import javafx.scene.control.*;
import javafx.fxml.FXML;

import java.io.IOException;

public class Controller {

    Game game = new Game();

    @FXML
    private TextField textField;

    @FXML
    private Label text;

    @FXML
    void checkAnswer() {
        if (!textField.getText().isBlank()) {
            text.setText(game.checkAnswer(textField.getText()));
            textField.setText("");
            textField.requestFocus();
            if (game.endGame) {
                game.setRandomWord();
                game.endGame = false;
                try {
                    Main.showWinMessage();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            textField.requestFocus();
        }

    }

    @FXML
    void doExit() {
        System.exit(0);
    }

    @FXML
    void showHelp() {
        try {
            Main.showHelp(game.words);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
