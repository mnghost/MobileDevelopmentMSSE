package com.msse.seth.contactviewer;

/**
 * Created by Seth on 2/13/2015.
 */
public class Contact {

    public static Contact[] getAll() {
        return new Contact[] {
                new Contact("Malcom Reynolds", "Captain", "555-1234"),
                new Contact("Jayne Cobb", "Muscle", "555-6374"),
                new Contact("Wash", "Pilot", "555-7263"),
                new Contact("Kaylee", "Engineer", "555-0987"),
                new Contact("Malcom Reynolds", "Captain", "555-1234"),
                new Contact("Jayne Cobb", "Muscle", "555-6374"),
                new Contact("Wash", "Pilot", "555-7263"),
                new Contact("Kaylee", "Engineer", "555-0987"),
                new Contact("Malcom Reynolds", "Captain", "555-1234"),
                new Contact("Jayne Cobb", "Muscle", "555-6374"),
                new Contact("Wash", "Pilot", "555-7263"),
                new Contact("Kaylee", "Engineer", "555-0987"),
                new Contact("Malcom Reynolds", "Captain", "555-1234"),
                new Contact("Jayne Cobb", "Muscle", "555-6374"),
                new Contact("Wash", "Pilot", "555-7263"),
                new Contact("Kaylee", "Engineer", "555-0987")
        };
    }

    public Contact(String name, String title, String phone) {
        this.name = name;
        this.title = title;
        this.phone = phone;
    }

    private String name;
    private String title;
    private String email;
    private String phone;
    private String twitterID;

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getTwitterID() {
        return twitterID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setTwitterID(String twitterID) {
        this.twitterID = twitterID;
    }
}
