package com.mbowen12.week_3.exercise_3;
/*
	Week_3 Exercise 3
	Name: Michael Bowen
	Date: 09/13/2016
	File Name: Main.java
	Description: converts entered celsius temperature to fahrenheit.
*/

import java.util.Scanner;

public class Main {

    // convert from fahrenheit to celsius
    static double fahrenheit2Celsius(double fahrenheit){
        double celsius = 5.0/9 *  (fahrenheit - 32);
        return celsius;
    }

    // displays temperatures
    static void displayTemp(double temperature, double celsius){
        System.out.println("The temperature of " + temperature +
                " degrees celsius converted is " + celsius + " degrees.");
    }

    // gets temperature from user
    static double getTemperature(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a temperature in fahrenheit: ");
        String input = scanner.nextLine();
        double fahrenheit = Double.parseDouble(input);
        return fahrenheit;

    }
    public static void main(String[] args){

        // declarations
        double fahrenheit;
        double temperature;

        fahrenheit = getTemperature();
        while(fahrenheit >= -460){
            temperature = fahrenheit2Celsius(fahrenheit);
            displayTemp(fahrenheit, temperature);
            fahrenheit = getTemperature();
        }


    }
}
