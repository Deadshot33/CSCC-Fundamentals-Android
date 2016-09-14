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

    // convert from celsius to fahrenheit
    static double Celsius2Fahrenheit(double celsius){
        double fahrenheit = 9.0/5 * celsius + 32;
        return fahrenheit;
    }

    // displays temperatures
    static void displayTemp(double celsius, double fahrenheitTemp){
        System.out.println("The temperature of " + celsius +
                " degrees celsius converted is " + fahrenheitTemp + " degrees.");
    }

    // gets temperature from user
    static double getCelsius(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a temperature in celsius: ");
        double newCelsius = input.nextDouble();
        return newCelsius;

    }
    public static void main(String[] args){

        double celsius;
        double fahrenheitTemp;

        celsius = getCelsius();
        fahrenheitTemp = Celsius2Fahrenheit(celsius);
        displayTemp(celsius, fahrenheitTemp);



    }
}
