package com.mbowen12.week_7.exercise_7;
/*
	Week_7 Exercise 7
	Name: Michael Bowen
	Date: 10/25/2016
	File Name: Main.java
	Description: accepts and extends contact class
*/
class Contact{
    private String name;
    private String email;


    Contact(String name, String email){
        this.name = name;
        this.email = email;
    }

    public void display(){
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }
}

class BusinessContact extends Contact{
    private String phoneNum;

    BusinessContact(String name, String email, String phoneNum){
        super(name, email);
        this.phoneNum = phoneNum;
    }

    public void display(){
        super.display();
        System.out.println("Phone number: " + phoneNum);
    }
}

public class Main{
    public static void main(String[] args){
        Contact david = new Contact("David", "BetterThanGoliath@msn.com");
        david.display();
        System.out.println();
        BusinessContact ghostbusters = new BusinessContact("Egon", "Icollect@sporesandfungus.com", "800-555-2368");
        ghostbusters.display();
        System.out.println();
    }
}