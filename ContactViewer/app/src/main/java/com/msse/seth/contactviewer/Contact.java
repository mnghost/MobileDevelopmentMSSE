package com.msse.seth.contactviewer;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Seth on 2/13/2015.
 */
public class Contact implements Parcelable {

    public static Contact[] getAll() {
        return new Contact[] {
                new Contact("Malcom Reynolds", "Captain", "555-1234", "email@email.com", "@iamtwitter"),
                new Contact("Jayne Cobb", "Muscle", "555-6374", "email@email.com", "@iamtwitter"),
                new Contact("Wash", "Pilot", "555-7263", "email@email.com", "@iamtwitter"),
                new Contact("Kaylee", "Engineer", "555-0987", "email@email.com", "@iamtwitter"),
                new Contact("Malcom Reynolds", "Captain", "555-1234", "email@email.com", "@iamtwitter"),
                new Contact("Jayne Cobb", "Muscle", "555-6374", "email@email.com", "@iamtwitter"),
                new Contact("Wash", "Pilot", "555-7263", "email@email.com", "@iamtwitter"),
                new Contact("Kaylee", "Engineer", "555-0987", "email@email.com", "@iamtwitter"),
                new Contact("Malcom Reynolds", "Captain", "555-1234", "email@email.com", "@iamtwitter"),
                new Contact("Jayne Cobb", "Muscle", "555-6374", "email@email.com", "@iamtwitter"),
                new Contact("Wash", "Pilot", "555-7263", "email@email.com", "@iamtwitter"),
                new Contact("Kaylee", "Engineer", "555-0987", "email@email.com", "@iamtwitter"),
                new Contact("Malcom Reynolds", "Captain", "555-1234", "email@email.com", "@iamtwitter"),
                new Contact("Jayne Cobb", "Muscle", "555-6374", "email@email.com", "@iamtwitter"),
                new Contact("Wash", "Pilot", "555-7263", "email@email.com", "@iamtwitter"),
                new Contact("Kaylee", "Engineer", "555-0987", "email@email.com", "@iamtwitter")
        };
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(title);
        dest.writeString(email);
        dest.writeString(phone);
        dest.writeString(twitterID);
    }

    public Contact(Parcel parcel) {
        readFromParcel(parcel);
    }

    private void readFromParcel(Parcel parcel)
    {
        this.name = parcel.readString();
        this.title = parcel.readString();
        this.email = parcel.readString();
        this.phone = parcel.readString();
        this.twitterID = parcel.readString();
    }

//boiler plate code from http://shri.blog.kraya.co.uk/2010/04/26/android-parcel-data-to-pass-between-activities-using-parcelable-classes/
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator()
    {
        public Contact createFromParcel(Parcel in)
        { return new Contact(in); }

        public Contact[] newArray(int size)
        { return new Contact[size]; }
    };
}
