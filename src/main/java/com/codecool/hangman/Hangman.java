package com.codecool.hangman;

import java.util.*;

public class Hangman {

    public static void main(String[] args) {
        Title showOnceTitle = new Title();
        showOnceTitle.title();
        Countries country = new Countries();
        List<String> countries = new ArrayList<>(country.getAllCountries());
        List<String> difficulty1 = new ArrayList<>();
        List<String> difficulty2 = new ArrayList<>();
        List<String> difficulty3 = new ArrayList<>();

        for (String element : countries) {
            if (element.length() <= 6) {
                difficulty1.add(element);
            }
            if (element.length() > 6 && element.length() <= 10) {
                difficulty2.add(element);
            }
            if (element.length() > 10) {
                difficulty3.add(element);
            }
        }
        Random rand = new Random();
        String word = "";
        int[] makeMove = new int[1];
        List<Character> playerGuess = new ArrayList<>();
        List<List<Character>> printPlayerGuess = new ArrayList<>();
        boolean diffy = true;
        
        while (diffy) {
            System.out.println("Please choose difficulty level between 1 & 3");
            Scanner sc = new Scanner(System.in);
            String difficulty = sc.nextLine();

            switch (difficulty) {
                case "1":
                    word = (difficulty1.get(rand.nextInt(difficulty1.size()))).toLowerCase();
                    diffy = false;
                    makeMove[0] = 5;
                    break;
                case "2":
                    word = (difficulty2.get(rand.nextInt(difficulty2.size()))).toLowerCase();
                    diffy = false;
                    makeMove[0] = 5;
                    break;
                case "3":
                    word = (difficulty3.get(rand.nextInt(difficulty3.size()))).toLowerCase();
                    diffy = false;
                    makeMove[0] = 5;
                    break;
                default:
                    System.out.println("Please enter a correct number");
                    diffy = true;
            }
        }
        System.out.println(word);

        System.out.println("Please enter a letter:");
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

            if (printWordDash(word, playerGuess)) {
                ;
                System.out.println("You win!");
                break;
            }

            playerGuessing(word, makeMove, playerGuess);
            printGuess(printPlayerGuess, playerGuess);
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
            }
            if (makeMove[0] == 5) {
                System.out.println("Your letter please!");
            } else {
                System.out.println("Enter your guess:");
            }

        }
    }

    private static boolean printWordDash(String word, List<Character> playerGuess) {
        int correctCount = 0;
        int chCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuess.contains(word.charAt(i))) {
                System.out.print(word.charAt(i));
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

    private static void printGuess(List<List<Character>> printPlayerGuess, List<Character> playerGuess) {
        if (!printPlayerGuess.isEmpty()) {
            printPlayerGuess.clear();
        }
        printPlayerGuess.add(playerGuess);
        for (List<Character> element : printPlayerGuess) {
            System.out.println("Player's quess:" + createPrintableString(element));
        }
    }

    private static String createPrintableString(List<Character> element) {
        String printableString = " ";
        for (Character current : element) {
            printableString += current + " ";
        }
        return printableString;
    }

    private static int[] playerGuessing(String word, int[] makeMove, List<Character> playerGuess) {
        makeMove[0] = 0;
        Scanner sc1 = new Scanner(System.in);
        String guessedLetter = sc1.nextLine();
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

}
