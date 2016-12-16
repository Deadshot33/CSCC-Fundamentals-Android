package com.mbowen12.project3;

/*
	Project 3
	Name: Michael Bowen
	Date: 12/15/2016
	File Name: Main.java
	Description: Uses program to manage a task list
*/


import java.util.*;

class Task implements Comparable<Task>{

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

        do
        {
            try
            {
                System.out.println(message);
                userString = input.nextLine();
                if (userString == null) throw new Exception();
                done = true;
            }
            catch (Exception e)
            {
                System.out.println("Not a valid string");
                input.nextLine();
            }
        }
        while (!done);
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

    @Override

    public int compareTo(Task task)
    {

        if (this.priority>task.getPriority())
        {
            return -1;
        }
        else
        {
            if(this.priority <task.getPriority())
            {
                return 1;
            }
            else
            {
                return this.title.compareTo(task.getTitle());
            }
        }
    }
}

class TaskList implements Iterable<Task>
{
    static List<Task> tasksList = new ArrayList<>();

    static void add()
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

    static void remove(int deleteNum)
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

    static void update(int updateNum)
    {
        boolean validIndex = false;
        while (!validIndex)
        {
            try
            {
                Task updatedTask = tasksList.get(updateNum);
                String newTaskTitle = Task.promptString("Enter the new title");
                updatedTask.setTitle(newTaskTitle);
                String newTaskDescription = Task.promptString("Enter the new description");
                updatedTask.setDescription(newTaskDescription);
                int newTaskPriority = Task.promptInt("Enter the new priority");
                updatedTask.setPriority(newTaskPriority);
                System.out.println("Task  " + updateNum + " updated");
                validIndex = true;
            }
            catch (IndexOutOfBoundsException e)
            {
                System.out.println(updateNum + " is not a valid Index");
            }
        }
    }

    static void showList() {

        Collections.sort(tasksList);

        for (Task task : tasksList)
        {
            System.out.println("Index number: " + tasksList.indexOf(task) + ", Priority: " + task.getPriority() + ", Title: " + task.getTitle()
                    + ", Description: " + task.getDescription());
        }
    }

    static void showList(int Priority) {

        Collections.sort(tasksList);

        for (Task task : tasksList)
        {
            if (task.getPriority() == Priority)
                System.out.println("Index number: "  + ", Priority: " + task.getPriority() + tasksList.indexOf(task) + ", Title: "
                        + task.getTitle() + ", Description: " + task.getDescription());
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
        System.out.println("0. Exit program");
    }

    @Override

    public Iterator<Task> iterator()
    {
        return tasksList.iterator();
    }

}

public class Main{

    public static void main(String[] args) {

        int select;

        TaskList taskCollection = new TaskList();

        taskCollection.displaySwitch();
        select = Task.promptInt("Enter your option");

        while (select != 0)
        {
            switch (select) {
                case 1:
                    taskCollection.add();
                    break;

                case 2:
                    if (taskCollection.tasksList.size() == 0)
                        System.out.println("Error - No tasks in list.");
                    else
                        taskCollection.remove(Task.promptInt("Enter the index number of the task to delete"));
                    break;

                case 3:
                    if (taskCollection.tasksList.size() == 0)
                        System.out.println("Error - No tasks in list.");

                    else
                        taskCollection.update(Task.promptInt("Enter the index number of the task to update"));

                    break;

                case 4:
                    if (taskCollection.tasksList.size() == 0)
                        System.out.println("Error - No tasks in list.");
                    else
                        taskCollection.showList();
                    break;

                case 5:
                    if (taskCollection.tasksList.size() == 0)
                        System.out.println("Error - No tasks in list.");
                    else
                        taskCollection.showList(Task.promptInt("Enter a priority to search by"));
                    break;

                case 0:
                    System.exit(0);
            }
            taskCollection.displaySwitch();
            select = Task.promptInt("Enter your option");
        }
    }
}