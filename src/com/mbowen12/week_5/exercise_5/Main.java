package com.mbowen12.week_5.exercise_5;

/*
	Week_5 Exercise 5
	Name: Michael Bowen
	Date: 10/25/2016
	File Name: Main.java
	Description: stores contacts in address book
*/

import java.util.ArrayList;
import java.util.List;

class Contact{
    String name;
    String email;

    Contact(String name, String email){
        this.name = name;
        this.email = email;
    }

}

class AddressBook{

    List<Contact> contacts = new ArrayList<>();

    void add(Contact newEntry){
        contacts.add(newEntry);
    }

    String nameSearch(String name){
        for(Contact entry: contacts){
            if (entry.name.equals(name))
                return entry.email;
        }
        return null;
    }
}

public class Main{
    public static void main(String[] args){
        AddressBook rolodex = new AddressBook();
        Contact david = new Contact("David", "betterThanGoliath@msn.com");
        Contact lauren = new Contact("Lauren","splat@flyingpastries.com");

        rolodex.add(david);
        rolodex.add(lauren);

        System.out.println("Lauren's email address is " + rolodex.nameSearch("Lauren"));

    }
}