package hangman.main;

import hangman.input.Input;

import java.util.Scanner;

public class Main {

    public Scanner scanner = new Scanner(System.in);
    public boolean Ingame;

    public static void main(String[] args) {
        Main main = new Main();
        main.init();
    }

    //Initializeer de variabelen
    //Start daarna het programma
    public void init() {
        Ingame = false;
        start();
    }

    //Geef de speler een introductie van de game.
    //Geef daarbij ook een optie om de game te starten!
    public void start() {

        System.out.println("Welkom bij Stanley's hangman game!");

        System.out.println("\n" +
                            "\n In hangman is het de bedoeling dat je het geheime woord raad!" +
                            "\n Je krijgt elke ronde 10 levens." +
                            "\n Elke poging die je doet kost een leven tenzij de letter in het woord voorkomt!" +
                            "\n Als je levens op zijn heb je verloren!" +
                            "\n Als je alle letters van het woord hebt geraden win je!" +
                            "\n De geheime woorden bestaan echt!");

        System.out.println("\n Klik op een toets om te starten!");

        new Input(this, scanner.nextLine(), Ingame);

    }

    //Kies een random woord en start het spel.
    public void generate() {



    }

}
