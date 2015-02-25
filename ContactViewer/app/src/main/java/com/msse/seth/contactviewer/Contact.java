package com.msse.seth.contactviewer;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.UUID;

/**
 * Created by Seth on 2/13/2015.
 */
public class Contact{

    public Contact(String name, String title, String phone, String email, String twitterID) {
        this.name = name;
        this.title = title;
        this.phone = phone;
        this.email = email;
        this.twitterID = twitterID;
    }


    private String name;
    private String title;
    private String email;
    private String phone;
    private String twitterID;


    private UUID id;

    public UUID getId() {
        return id;
    }

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

    public void setId(UUID id) {
        this.id = id;
    }

    public void foo() {  return;};

}
