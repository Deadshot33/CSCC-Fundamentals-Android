package com.mbowen12.week_1;

public class Main {

    public static void main(String[] args) {
	    String cityName = "Columbus";
        int zipCode = 43215;
        float[] temperature = {32, 25, 27, 40, 45};
        float averageTemp = (temperature[0] + temperature[1] + temperature[2] +
                temperature[3] + temperature[4]) / 5;

        System.out.println("City:" + cityName);
        System.out.println("Zip Code:" + zipCode);
        System.out.println("Average temperature:" + averageTemp);

    }
}
