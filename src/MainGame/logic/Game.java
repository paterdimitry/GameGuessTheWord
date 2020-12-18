package MainGame.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class Game {

    public Random random = new Random();
    private String rightAnswer = "";
    public boolean endGame = false;
    public String[] words;

    public Game() {
        try {
            readWordsFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        setRandomWord();
    }

    private void readWordsFromFile() throws IOException {
        var file = new File("src/MainGame/logic/words.txt");
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n;
        while ((n = inputStream != null ? inputStream.read() : 0) != -1) {
            stringBuilder.append((char) n);
        }
        words = stringBuilder.toString().split("\r\n");
    }

    public void setRandomWord() {
        rightAnswer = words[random.nextInt(words.length)];
    }

    public String checkAnswer(String answer) {
        if (answer.equals(rightAnswer)) {
            endGame = true;
            return "Вы угадали! Поздравляем!";
        } else {
            return ("Проверка совпадений: " + checkCharsInAnswer(answer, rightAnswer));
        }
    }

    private String checkCharsInAnswer(String answer, String rightAnswer) {
        StringBuilder note = new StringBuilder();
        for (int i = 0; i < answer.length() & i < rightAnswer.length(); i++) {
            if (answer.charAt(i) == rightAnswer.charAt(i)) {
                note.append(answer.charAt(i));
            } else {
                note.append("#");
            }
        }
        note.append("#".repeat(Math.max(0, 15 - note.length())));
        return note.toString();
    }
}

