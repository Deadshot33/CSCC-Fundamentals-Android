package com.mbowen12.week_8.exercise_8;
/*
	Week_8 Exercise 8
	Name: Michael Bowen
	Date: 10/25/2016
	File Name: Main.java
	Description: accepts/extends contact class, adds to an address book
*/
import java.util.ArrayList;
import java.util.List;

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

class AddressBook{
    List<Contact> rolodex = new ArrayList<>();

    public void add(Contact e){
        rolodex.add(e);
    }

    public void display(){
        for(Contact e: rolodex){
            e.display();
            System.out.println();
        }
    }
}

public class Main{
    public static void main(String[] args){
        Contact david = new Contact("David", "BetterThanGoliath@msn.com");
        BusinessContact ghostbusters = new BusinessContact("Egon", "Icollect@sporesandfungus.com", "800-555-2368");
        AddressBook rolodex = new AddressBook();
        rolodex.add(david);
        rolodex.add(ghostbusters);
        rolodex.display();
    }
}