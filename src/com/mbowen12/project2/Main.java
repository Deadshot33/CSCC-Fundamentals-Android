package com.mbowen12.project2;

/*
	Project 2
	Name: Michael Bowen
	Date: 12/13/2016
	File Name: Main.java
	Description: Uses switch to manage a task list
*/


import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

class Task {

    public String title;
    public String description;
    public int priority;


    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }


    public void setPriority(int priority)
    {
        this.priority = priority;
    }

    public int getPriority()
    {
        return priority;
    }

    public static String promptString(String message)
    {
        Scanner input = new Scanner(System.in);
        String userString = null;
        boolean done = false;

        while (!done)
        {
            try
            {
                System.out.println(message);
                userString = input.nextLine();
                done = true;
            }
            catch (Exception e)
            {
                System.out.println("Not a valid string");
                input.nextLine();
            }
        }
        return userString;
    }

    public static int promptInt(String message)
    {
        Scanner input = new Scanner(System.in);
        int userInt = 0;
        boolean done = false;

        do
        {
            try
            {
                System.out.println(message);
                userInt = input.nextInt();
                if (userInt < 0 || userInt > 5) throw new Exception();
                done = true;
            }
            catch (Exception f)
            {
                System.out.println("Enter an integer between 0 and 5");
                input.nextLine();
            }
        }
        while (!done);
        return userInt;
    }
}

public class Main{

    static List<Task> tasksList = new ArrayList<>();

    static void addTask()
    {
        Task newTask = new Task();
        String taskTitle = Task.promptString("Enter the title of the new task: ");
        newTask.setTitle(taskTitle);
        String taskDescription = Task.promptString("Enter the description of the new task: ");
        newTask.setDescription(taskDescription);
        int taskPriority = Task.promptInt("Enter the Priority of the new task (0 - 5): ");
        newTask.setPriority(taskPriority);
        tasksList.add(newTask);
        System.out.println(taskTitle + " added");
    }

    static void removeTask(int deleteNum)
    {
        try
        {
            tasksList.remove(deleteNum);
            System.out.println("Task " + deleteNum + " deleted");
        }
        catch (IndexOutOfBoundsException e)
        {
            System.out.println("Error - Index not valid");
        }
    }

    static void updateTask(int updateNum)
    {
        boolean validIndex = false;
        while (!validIndex)
        {
            try
            {
                validIndex = true;
                Task updatedTask = tasksList.get(updateNum);
                String newTaskTitle = Task.promptString("Enter the new title");
                updatedTask.setTitle(newTaskTitle);
                String newTaskDescription = Task.promptString("Enter the new description");
                updatedTask.setDescription(newTaskDescription);
                int newTaskPriority = Task.promptInt("Enter the new priority");
                updatedTask.setPriority(newTaskPriority);
                System.out.println("Task  " + updateNum + " updated");
            }
            catch (IndexOutOfBoundsException e)
            {
                System.out.println(updateNum + " is not a valid Index");
                validIndex = true;
            }
        }
    }

    static void showList() {
        for (Task task : tasksList)
        {
            System.out.println("Index number: " + tasksList.indexOf(task) + ", Title: " + task.getTitle() + ", Description: "
                    + task.getDescription() + ", Priority: " + task.getPriority());
        }
    }

    static void showList(int Priority) {

        for (Task task : tasksList)
        {
            if (task.getPriority() == Priority)
                System.out.println("Index number: " + tasksList.indexOf(task) + ", Title: " + task.getTitle() + ", Description: "
                        + task.getDescription() + ", Priority: " + task.getPriority());
        }
    }

    static void displaySwitch()
    {

        System.out.println("Select an option:");
        System.out.println("1. Add a task.");
        System.out.println("2. Remove a task.");
        System.out.println("3. Update a task.");
        System.out.println("4. List all tasks.");
        System.out.println("5. List all tasks by priority.");
        System.out.println("0.  Exit program");
    }

    public static void main(String[] args) {

        int select;

        displaySwitch();
        select = Task.promptInt("Enter your option");

        while (select != 0)
        {
            switch (select) {
                case 1:
                    addTask();
                    break;

                case 2:
                    if (tasksList.size() == 0)
                        System.out.println("Error - No tasks in list.");
                    else
                        removeTask(Task.promptInt("Enter the index number of the task to delete"));
                    break;

                case 3:
                    if (tasksList.size() == 0)
                        System.out.println("Error - No tasks in list.");

                    else
                        updateTask(Task.promptInt("Enter the index number of the task to update"));

                    break;

                case 4:
                    if (tasksList.size() == 0)
                        System.out.println("Error - No tasks in list.");
                    else
                        showList();
                    break;

                case 5:
                    if (tasksList.size() == 0)
                        System.out.println("Error - No tasks in list.");
                    else
                        showList(Task.promptInt("Enter a priority to search by"));
                    break;

                case 0:
                    System.exit(0);
            }
            displaySwitch();
            select = Task.promptInt("Enter your option");
        }
    }
}

