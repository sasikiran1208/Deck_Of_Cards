package pkg241project01startingfiles;

/**
 *
 * Class: 44-241 Computer Programming II
 *
 * Author: Sasi Kiran Kodali & Peyton Stahl
 *
 * Description: Shuffle playing deck of cards and deal them into hands
 *
 * Due: 10-10-2024
 *
 * I pledge that I have completed the programming assignment independently.
 *
 * I have not copied the code from a student or any source.
 *
 * I have not given my code to any other student and will not share this code
 * with anyone under any circumstances.
 *
 */
import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Orginal Order of the deck");
        String[] deck = newDeck();

        printDeck(deck);
        System.out.println();

        deck = newDeck();
        System.out.println("Shuffle-1: ");
        deck = newDeck();
        for (int i = 0; i < deck.length; i++) {
            printCard(deck, deal(deck));
            System.out.println();
        }
        System.out.println();

        deck = newDeck();
        System.out.println("Shuffle-2: ");
        deck = newDeck();
        for (int i = 0; i < deck.length; i++) {
            printCard(deck, deal(deck));
            System.out.println();
        }
        deck = newDeck();
        System.out.println();
        System.out.println("Five random hands (sets) of cards from the same deck: ");
        for (int x = 1; x <= 5; x++) {
            System.out.print(" Hand " + x + ": ");
            for (int y = 0; y < 5; y++) {
                printCard(deck, deal(deck));
                System.out.print(", ");

            }
            System.out.println();

        }

    }

    public static String[] newDeck() {

        String[] deck = new String[52];
        for (int i = 0; i < 52; i++) {

            if (i <= 9 || (i >= 40 && i <= 42)) {
                deck[i] = "Clubs";
            }
            if ((i >= 10 && i <= 19) || (i >= 43 && i <= 45)) {
                deck[i] = "Diamonds";
            }
            if ((i >= 20 && i <= 29) || (i >= 46 && i <= 48)) {
                deck[i] = "Hearts";
            }
            if ((i >= 30 && i <= 39) || (i >= 49 && i <= 51)) {
                deck[i] = "Spades";
            }
        }
        return deck;
    }

    public static String draw(String[] deck, int index) {
        String rank = "";
        String suit = deck[index];

        if (index == 0 || index == 10 || index == 20 || index == 30) {
            rank = "A";
        }
        if (index == 40 || index == 43 || index == 46 || index == 49) {
            rank = "J";
        }
        if (index == 41 || index == 44 || index == 47 || index == 50) {
            rank = "Q";
        }
        if (index == 42 || index == 45 || index == 48 || index == 51) {
            rank = "K";
        }
        if (rank != "A" && rank != "J" && rank != "Q" && rank != "K") {
            rank = String.valueOf((index % 10) + 1);
        }

        deck[index] = "USED";

        return rank + " of " + suit;

    }

    public static void printCard(String[] deck, int index) {
        System.out.print(draw(deck, index));
    }

    public static void printDeck(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            printCard(deck, i);
            System.out.println();
        }
    }

    public static int deal(String[] deck) {
        Random rand = new Random();
        int index = rand.nextInt(52);

        while ((deck[index].equals("USED"))) {
            index = rand.nextInt(52);
        }
        return index;
    }

}
