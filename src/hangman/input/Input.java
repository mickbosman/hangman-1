package hangman.input;

import hangman.main.Main;

public class Input {

    //Hiermee handel ik alle inputs die ik hier binnenkrijg!
    public static void InputHandler(Main main, String input, boolean Ingame) {

        if(input.equals("STOP")) {System.exit(69); return;}
        if(!Ingame) {main.generate(); return;}
        if(input.isEmpty()) {main.error("Je hebt niks ingevuld!"); return;}

        if(input.length() > 1) {main.error("Je mag maximaal een letter per keer raden!"); return;}
        if(Main.chars.contains(input)) {main.error("Je hebt deze letter al ingevuld!"); return;}

        //Met dit korte stukje handle ik HP
        if(!Main.word.contains(input)) Main.HP--;
        if(Main.HP <= 0) {
            System.out.println("Je hebt verloren!");
            System.out.println("Het woord was: " + Main.word);
            System.exit(420);
            return;
        }

        //Hiermee geven we de speler nog een poging!
        Main.chars += input;
        main.guess();

    }

}
