package com.mbowen12.week_9.exercise_9;
/*
	Week_9 Exercise 9
	Name: Michael Bowen
	Date: 11/01/2016
	File Name: Main.java
	Description: accepts/extends contact class, adds to an address book
*/
import java.util.ArrayList;
import java.util.List;

abstract class Contact {
    private String name;

    Contact(String name) {
        this.name = name;
    }

    abstract public void contact();
}

class PhoneContact extends Contact {
    private String phoneNum;

    PhoneContact(String name, String phoneNumber) {
        super(name);
        this.phoneNum = phoneNumber;
    }

    @Override
    public void contact(){
        System.out.println("Calling..." + phoneNum);
    }
}

class EmailContact extends Contact {
    private String email;

    EmailContact(String name, String email) {
        super(name);
        this.email = email;
    }

    @Override
    public void contact() {
        System.out.println("Emailing..." + email);
    }
}

public class Main {
    public static void main(String[] args) {
        PhoneContact venkman = new PhoneContact("Venkman", "800-555-2368");
        EmailContact egon = new EmailContact("Egon", "Icollect@sporesandfungus.com");

        List<Contact> contacts = new ArrayList<>();
        contacts.add(venkman);
        contacts.add(egon);

        for (Contact e: contacts) {
            e.contact();
        }
    }
}