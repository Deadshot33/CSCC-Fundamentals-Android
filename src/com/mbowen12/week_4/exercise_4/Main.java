package com.mbowen12.week_4.exercise_4;

/*
	Week_4 Exercise 4
	Name: Michael Bowen
	Date: 10/11/2016
	File Name: Main.java
	Description: stores cities, temperatures and calculates averages
*/


import java.util.*;

public class Main{
    static List<String> getCities(){
        List<String> cities = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter END when done with cities");
        System.out.print("Enter a city: ");
        String city = input.nextLine();
        while (!city.equals("END")){
            if (!cities.equals("END"))
                cities.add(city);
            System.out.print("Enter a city: ");
            city = input.nextLine();
        }
        return cities;
    }

    static Map<String, int[]> getTemp(List<String> cities) {
        Map<String, int[]> temperatureMap = new TreeMap<>();
        Scanner input = new Scanner(System.in);
        for (String city : cities) {
            System.out.println("Enter the five average temps for " + city);
            String tempString = input.nextLine();

            int[] tempArray = new int[5];
            String[] tempStringArray = tempString.split(" ");
            for (int i = 0; i < 5; i++) {
                tempArray[i] = Integer.parseInt(tempStringArray[i]);
            }

            temperatureMap.put(city, tempArray);

        }
        return temperatureMap;
    }

    public static void displayAverage(Map<String, int[]> tempMap){
        for(String city: tempMap.keySet()){
            int[] tempArray  = tempMap.get(city);
            int average = 0;
            for(int  temp: tempArray){
                average+= temp;
            }
            average /= 5;

            System.out.println("The average temperature for " + city + " is " + average);
        }
    }

    public static void main(String[] args){
        List<String> cities = getCities();
        Map<String, int[]> temperatures = getTemp(cities);
        displayAverage(temperatures);
    }

}
