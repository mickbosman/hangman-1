package hangman.main;

import hangman.input.Input;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public Scanner scanner = new Scanner(System.in);
    public boolean Ingame;
    public static String word;

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }

    //Initializeer de variabelen
    //Start daarna het programma
    public void init() {
        Ingame = false;
        Words.wordAdder();

        start();
    }

    //Geef de speler een introductie van de game.
    //Geef daarbij ook een optie om de game te starten!
    public void start() {

        System.out.println("Welkom bij Stanley's hangman game!");

        System.out.println("\n" +
                            "\nIn hangman is het de bedoeling dat je het geheime woord raad!" +
                            "\nJe krijgt elke ronde 10 levens." +
                            "\nElke poging die je doet kost een leven tenzij de letter in het woord voorkomt!" +
                            "\nAls je levens op zijn heb je verloren!" +
                            "\nAls je alle letters van het woord hebt geraden win je!" +
                            "\nDe geheime woorden bestaan echt en zijn allemaal Nederlands!");

        System.out.println("\nKlik op een toets om te starten!");

        new Input(this, scanner.nextLine(), Ingame);

    }

    //Kies een random woord en start het spel.
    public void generate() {

        Random rand = new Random(Words.words.size());
        word = Words.words.get(rand.nextInt(Words.words.size()));

    }

}
