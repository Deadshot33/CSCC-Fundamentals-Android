package com.mbowen12.week_6.exercise_6;
/*
	Week_6 Exercise 6
	Name: Michael Bowen
	Date: 10/25/2016
	File Name: Main.java
	Description: tries and catches exceptions from various data entry
*/
import java.util.Scanner;

class UserInput{
    Scanner input = new Scanner(System.in);

    public int promptInt(String message){
        System.out.println(message);
        String userInput = input.nextLine();
        int userInt = 0;
        boolean isInt = false;
        while (!isInt) {
            try {
                userInt = Integer.parseInt(userInput);
                isInt = true;
            }
            catch (NumberFormatException e) {
                System.out.println(userInput +" is not a valid integer. " + message);
                userInput = input.nextLine();
            }
        }
        return userInt;
    }

    public double promptDouble(String message){
        System.out.println(message);
        String userInput = input.nextLine();
        double userDouble = 0;
        boolean isDouble = false;
        while (!isDouble) {
            try {
                userDouble = Double.parseDouble(userInput);
                isDouble = true;
            }
            catch (NumberFormatException e) {
                System.out.println(userInput +" is not a valid double. " + message);
                userInput = input.nextLine();
            }
        }
        return userDouble;
    }

    public String promptString(String message){
        System.out.println(message);
        return input.nextLine();
    }
}

public class Main{
    public static void main(String[] args){
        UserInput entry = new UserInput();
        String newString = entry.promptString("Enter a string: ");
        System.out.println("The string you entered is " + newString);
        System.out.println();
        int newInt = entry.promptInt("Enter an integer: ");
        System.out.println("The integer you entered is " + newInt);
        System.out.println();
        double newDouble = entry.promptDouble("Enter a double: ");
        System.out.println("The double you entered is " + newDouble);
        System.out.println();
    }
}