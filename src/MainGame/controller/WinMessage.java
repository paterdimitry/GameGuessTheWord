package MainGame.controller;

import javafx.fxml.FXML;
import javafx.stage.Stage;


public class WinMessage {
    public Stage winMsg;

    @FXML
    private void playMore() {
        winMsg.close();
    }

    @FXML
    private void doExit() {
        System.exit(0);
    }
}
