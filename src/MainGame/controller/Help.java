package MainGame.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


public class Help {
    public Stage helpStg;

    @FXML
    public TextArea textArea;

    @FXML
    void backToGame() {
        helpStg.close();
    }

}
