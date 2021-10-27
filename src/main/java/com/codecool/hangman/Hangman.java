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
        char ch = '˘';
        String word2 = word.replace(' ', ch);
        Scanner sc = new Scanner(System.in);
        String guessedLetter = "";
        List<Character> playerGuess = new ArrayList<>();
        System.out.println(word);

        int wrongCount = 0;
        while (true) {
            System.out.println("-------");
            System.out.println("|     |");
            if (wrongCount >= 1) {
                System.out.println(" O");
            }
            if (wrongCount >= 2) {
                System.out.print("\\ ");
                if (wrongCount >= 3) {
                    System.out.println("/");
                } else {
                    System.out.println("");
                }
            }
            if (wrongCount >= 4) {
                System.out.println(" |");
            }
            if (wrongCount >= 5) {
                System.out.print("/ ");
            } if (wrongCount >= 6) {
                System.out.println("\\");
            } else {
                System.out.println("");
            }
            System.out.println(word);
            System.out.println(playerGuess);
            if (word.equals(playerGuess)) {
                System.out.println("You won!");
                break;
            }
            printWordDash(word, playerGuess);
            if (playerGuessing(sc, word, playerGuess)) {
                System.out.println("GoodBye");
                break;
            }

            if (printWordDash(word, playerGuess)) {
                System.out.println();
                System.out.println("You win!");
                break;
            }
            else {
                System.out.println("Enter your guess:");
            }
        }
        //play(word, 6);
    }

    private static boolean printWordDash(String word, List<Character> playerGuess) {
        char ch = '˘';
        String word2 = word.replace(' ', ch);
        int correctCount = 0;
        int chCount = 0;
        for (int i = 0; i < word2.length(); i++) {
            if (playerGuess.contains(word2.charAt(i))) {
                System.out.print(word2.charAt(i));
                correctCount++;
            }
            else if ((word2.charAt(i) != ch)){
                System.out.print("_");
            }
            else if ((word2.charAt(i) == ch)){
                System.out.print(" ");
                chCount++;
            }
        }
        System.out.println();
        return ((word.length()-chCount) == correctCount);
    }

    private static boolean playerGuessing(Scanner sc, String word, List<Character> playerGuess) {
        boolean quit = false;
        String guessedLetter = sc.nextLine();
        if ((guessedLetter).equals("quit")){
            quit = true;
        }
        playerGuess.add((guessedLetter.toLowerCase()).charAt(0));
        return quit;
    }

    private static void play(String word, int lives) {

    }

}
