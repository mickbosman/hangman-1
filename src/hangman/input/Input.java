package hangman.input;

import hangman.main.Main;

public class Input {

    public static void InputHandler(Main main, String input, boolean Ingame) {

        if(input.equals("STOP")) {System.exit(69); return;}
        if(!Ingame) {main.generate(); return;}
        if(input.isEmpty()) {main.error("Je hebt niks ingevuld!"); return;}

        if(input.length() > 1) {main.error("Je mag maximaal een letter per keer raden!"); return;}

        Main.chars += input;
        main.guess();

    }

}
