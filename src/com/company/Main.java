package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Superhero> superhero = new ArrayList<Superhero>();
        try {
            BufferedReader in = new BufferedReader(new FileReader("input.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                Superhero superheroInstance = new Superhero();
                superheroInstance.setSuperheroName(str);
                superheroInstance.setRealIdentity(in.readLine());
                superheroInstance.setPlaceOfBirth(in.readLine());
                superhero.add(superheroInstance);
                System.out.println(str);
            }
            in.close();
        } catch (IOException e) {
            System.out.println("ERROR: unable to read file " + e.getMessage());
            e.printStackTrace();
        }
//        for (Superhero item : superhero) {
//            System.out.println("I love " + item.superheroName + item.realIdentity + item.residence + "!");
//        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name:");
        String playerName = scanner.nextLine();

        System.out.println("Enter your superhero name:");
        String userInputSuperheroName = scanner.nextLine();

        String result = game(userInputSuperheroName, scanner, superhero);

        BufferedWriter output = null;
        try {
            File file = new File("output.txt");
            output = new BufferedWriter(new FileWriter(file));
            output.write(playerName + " " + result);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if ( output != null ) {
                output.close();
            }
        }
    }

    public static String game(String username, Scanner scanner, ArrayList<Superhero> superhero) {
        int yes = 0;
        int no = 0;
        String win = "";
        String lose = "";
        String gameResult = "";
        //Not an efficient way to approach the below... Also aware of the IndexOutOfBoundsException if you input other types - need to catch these
        switch (username) {
            case "Batman":
                System.out.println("What is Batman's real name?");
                String realNameB = scanner.nextLine();
                if (realNameB.equals(superhero.get(1).realIdentity.toString())) {
                    yes++;
                    System.out.println("You're right!");
                } else {
                    no++;
                    System.out.println("Sorry that is not right");
                }
                System.out.println("Where does Batman live?");
                String residenceB = scanner.nextLine();
                if (residenceB.equals(superhero.get(1).residence.toString())) {
                    yes++;
                    System.out.println("You're right!");
                } else {
                    no++;
                    System.out.println("Sorry that is not right");
                }
                if (yes > no) {
                    win = "You win";
                    System.out.println("You win!");
                    gameResult = win;
                } else {
                    lose = "You lose";
                    System.out.println("You lose");
                    gameResult = lose;
                }

                break;
            case "Superman":
                System.out.println("What is Superman's real name?");
                String realNameSu = scanner.nextLine();
                if (realNameSu.equals(superhero.get(0).realIdentity.toString())) {
                    yes++;
                    System.out.println("You're right!");
                } else {
                    no++;
                    System.out.println("Sorry that is not right");
                }
                System.out.println("Where does Superman live?");
                String residenceSu = scanner.nextLine();
                if (residenceSu.equals(superhero.get(0).residence.toString())) {
                    yes++;
                    System.out.println("You're right!");
                } else {
                    no++;
                    System.out.println("Sorry that is not right");
                }
                if (yes > no) {
                    win = "You win";
                    System.out.println("You win!");
                    gameResult = win;
                } else {
                    lose = "You lose";
                    System.out.println("You lose");
                    gameResult = lose;
                }
                break;
            case "Spiderman":
                System.out.println("What is Spiderman's real name?");
                String realNameSp = scanner.nextLine();
                if (realNameSp.equals(superhero.get(3).realIdentity.toString())) {
                    yes++;
                    System.out.println("You're right!");
                } else {
                    no++;
                    System.out.println("Sorry that is not right");
                }
                System.out.println("Where does Spiderman live?");
                String residenceSp = scanner.nextLine();
                if (residenceSp.equals(superhero.get(3).residence.toString())) {
                    yes++;
                    System.out.println("You're right!");
                } else {
                    no++;
                    System.out.println("Sorry that is not right");
                }
                if (yes > no) {
                    win = "You win";
                    System.out.println("You win!");
                    gameResult = win;
                } else {
                    lose = "You lose";
                    System.out.println("You lose");
                    gameResult = lose;
                }
                break;
        }
        return gameResult;
    }
}
