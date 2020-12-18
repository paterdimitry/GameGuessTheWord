package MainGame;

import MainGame.controller.Help;
import MainGame.controller.WinMessage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Arrays;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxml/main.fxml"));
        primaryStage.setTitle("Угадай слово");
        primaryStage.setScene(new Scene(root, 400, 200));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    public static void showHelp(String[] words) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("fxml/help.fxml"));
        AnchorPane dialog = loader.load();
        Stage helpStage = new Stage();
        helpStage.setTitle("Помощь в игре");
        helpStage.setScene(new Scene(dialog, 350, 400));
        Help help = loader.getController();
        help.textArea.setText(getHelpWords(words));
        help.helpStg = helpStage;
        helpStage.showAndWait();
    }

    public static String getHelpWords(String[] words) {
        StringBuilder helpWords = new StringBuilder();
        Arrays.sort(words);
        for (String word : words) {
            helpWords.append(word).append("\n");
        }
        return helpWords.toString();
    }

    public static void showWinMessage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("fxml/win_message.fxml"));
        AnchorPane dialog = loader.load();
        Stage winStage = new Stage();
        winStage.setTitle("Победа");
        winStage.setScene(new Scene(dialog, 300, 130));
        WinMessage winMessage = loader.getController();
        winMessage.winMsg = winStage;
        winStage.showAndWait();
    }
}
