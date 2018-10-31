package hangman.input;

import hangman.main.Main;

public class Input {

    Main main;
    String input;
    boolean Ingame;

    public Input(Main main, String input, boolean Ingame) {

        this.main = main;
        this.input = input;
        this.Ingame = Ingame;

        InputHandler();

    }

    public void InputHandler() {

        if(!Ingame) intro();

    }

    private void intro() {
        main.generate();
    }

}
