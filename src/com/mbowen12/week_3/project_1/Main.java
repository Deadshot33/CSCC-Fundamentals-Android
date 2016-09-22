package com.mbowen12.week_3.project_1;
/*
	Week_3 Project 1
	Name: Michael Bowen
	Date: 09/20/2016
	File Name: Main.java
	Description: uses a switch to manage an array of tasks
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    //allows user to add a task to the array
    static void addTask(ArrayList<String> array){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a new task: ");
        String newTask = input.nextLine();
        array.add(newTask);

    }

    //allows user to delete a task from the array
    static void deleteTask(ArrayList<String> array) {
        Scanner input = new Scanner(System.in);
        System.out.println(array);
        System.out.print("Enter the task to delete: ");
        String delTask = input.nextLine();
        array.remove(delTask);
    }

    //allows user to update a task from the array
    static void updateTask(ArrayList<String> array) {
        Scanner input = new Scanner(System.in);
        System.out.println(array);
        System.out.print("Enter the task to update: ");
        String task1 = input.nextLine();
        System.out.println("Enter the updated task: ");
        String task2 = input.nextLine();
        array.remove(task1);
        array.add(task2);
    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();
        int num = 1;

        //program loop
        while (num != 0) {
            System.out.println("Please choose an option:\n" +
                    "(1) Add a task.\n" +
                    "(2) Remove a task.\n" +
                    "(3) Update a task.\n" +
                    "(4) List all tasks.\n" +
                    "(0) Exit");
            num = input.nextInt();
            switch (num) {
                case 1:
                    addTask(tasks);
                    System.out.println();
                    break;
                case 2:
                    deleteTask(tasks);
                    System.out.println();
                    break;
                case 3:
                    updateTask(tasks);
                    System.out.println();
                    break;
                case 4:
                    System.out.println(tasks);
                    System.out.println();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Not a valid entry");
            }
        }
    }
}
