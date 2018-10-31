package hangman.main;

import hangman.input.Input;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public Scanner scanner = new Scanner(System.in);
    public static String chars = "";
    public boolean Ingame;
    public static String word;
    public static int HP;

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }

    //Initializeer de variabelen
    //Start daarna het programma
    public void init() {
        Ingame = false;
        HP = 10;
        Words.wordAdder();

        start();
    }

    //Geef de speler een introductie van de game.
    //Geef daarbij ook een optie om de game te starten!
    public void start() {

        System.out.println(Color.RED + "Welkom bij Stanley's hangman game!" + Color.RESET);

        System.out.println( "\nIn hangman is het de bedoeling dat je het geheime woord raad!" +
                            "\nJe krijgt elke ronde 10 levens." +
                            "\nElke poging die je doet kost een leven tenzij de letter in het woord voorkomt!" +
                            "\nAls je levens op zijn heb je verloren!" +
                            "\nAls je alle letters van het woord hebt geraden win je!" +
                            "\nDe geheime woorden bestaan echt en zijn allemaal Nederlands!" +
                            "\n\nType STOP om te stoppen! (Hoofdletter gevoelig)");

        System.out.println("\nKlik op enter om te starten!");

        Input.InputHandler(this, scanner.nextLine(), Ingame);

    }

    //Geef een error message
    public void error(String message) {
        System.out.println(Color.RED + message + Color.RESET);
        Input.InputHandler(this, scanner.nextLine(), Ingame);
    }

    //Kies een random woord en start het spel.
    public void generate() {

        Ingame = true;
        Random rand = new Random();
        word = Words.words.get(rand.nextInt(Words.words.size()));

        guess();

    }

    //Laat speler een letter kiezen
    public void guess() {

        String text = "";
        for(int i = 0; i < word.length(); i++) {

            if(chars.isEmpty()) {text+="_ "; continue;}

            if(chars.contains(Character.toString(word.charAt(i)))) {
                text+=Character.toString(word.charAt(i));
            } else {
                text+="_ ";
            }
        }
        System.out.println("Levens: " + HP);
        System.out.println(text);

        if(!chars.isEmpty()) {

            String colorerdChars = "";
            for(int i = 0; i < chars.length(); i++) {
                if(word.contains(Character.toString(chars.charAt(i)))){
                    colorerdChars += (Color.GREEN + chars.charAt(i));
                } else {
                    colorerdChars += (Color.RED + chars.charAt(i));
                }
            }

            System.out.println("Gerade letters: " + colorerdChars + Color.RESET);

        }

        if(!text.contains("_")) {
            System.out.println("Je hebt gewonnen!");
            System.out.println("Het woord was: " + Main.word);
            System.exit(1);
        }

        Input.InputHandler(this, scanner.nextLine(), Ingame);

    }

}
