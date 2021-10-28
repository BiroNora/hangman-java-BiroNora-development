package com.codecool.hangman;

import java.util.*;

public class Hangman {

    public static void main(String[] args) {
        Title showOnceTitle = new Title();
        showOnceTitle.title();
        System.out.println("Please enter a letter:");
        Countries country = new Countries();
        List<String> countries = new ArrayList<>(country.getAllCountries());
        Random rand = new Random();
        String word = (countries.get(rand.nextInt(countries.size()))).toLowerCase();
        Scanner sc = new Scanner(System.in);
        int[] makeMove = new int[1];
        List<Character> playerGuess = new ArrayList<>();
        System.out.println(word);

        int wrongCount = 0;
        while (true) {
            System.out.println(" _______");
            System.out.println(" |     |");
            if (wrongCount >= 1) {
                System.out.println(" O");
            }
            if (wrongCount >= 2) {
                System.out.print("\\ ");
                if (wrongCount >= 3) {
                    System.out.println("/");
                } else {
                    System.out.println(" ");
                }
            }
            if (wrongCount >= 4) {
                System.out.println(" |   ");
            }
            if (wrongCount >= 5) {
                System.out.print("/ ");
            }
            if (wrongCount >= 6) {
                System.out.println("\\");
                System.out.println("You lost!");
                break;
            } else {
                System.out.println("");
            }

            if (printWordDash(word, playerGuess)) {;
                System.out.println("You win!");
                break;
            }

            playerGuessing(sc, word, makeMove, playerGuess);
            if (makeMove[0] == 3) {
                wrongCount++;
            }
            if (makeMove[0] == 1) {
                System.out.println("You won!");
                break;
            }
            if (makeMove[0] == 0) {
                System.out.println("GoodBye");
                break;
            }
            if (makeMove[0] == 4) {
                System.out.println("Your letter please!");
            } else {
                System.out.println("Enter your guess:");
            }
        }
        //play(word, 6);
    }

    private static boolean printWordDash(String word, List<Character> playerGuess) {
        int correctCount = 0;
        int chCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuess.contains(word.charAt(i))) {
                //System.out.print(word.charAt(i));
                correctCount++;
            } else if ((word.charAt(i) != ' ')) {
                System.out.print("_");
            } else if ((word.charAt(i) == ' ')) {
                System.out.print(" ");
                chCount++;
            }
        }
        System.out.println();
        return ((word.length() - chCount) == correctCount);
    }

    private static int[] playerGuessing(Scanner sc, String word, int[] makeMove, List<Character> playerGuess) {
        makeMove[0] = 0;
        String guessedLetter = sc.nextLine();
        if ((guessedLetter).equals("")) {
            makeMove[0] = 4;
        } else {

            playerGuess.add((guessedLetter.toLowerCase()).charAt(0));

            if ((guessedLetter).equals("quit")) {
                makeMove[0] = 0;
            } else if ((guessedLetter).equals(word)) {
                makeMove[0] = 1;
            } else if (word.contains(guessedLetter)) {
                makeMove[0] = 2;
            } else if (!word.contains(guessedLetter)) {
                makeMove[0] = 3;
            }
        }
        return makeMove;
    }

    private static void play(String word, int lives) {

    }

}
