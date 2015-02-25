package com.msse.seth.contactviewer;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.zip.CheckedOutputStream;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by Jake on 2/21/2015.
 */
public class ContactManager {

    private static ContactManager ourInstance;

    public static ContactManager getInstance() {
        if(ourInstance == null) {
            ourInstance = new ContactManager();
        }

        return ourInstance;
    }

    private final String _contactFileName = "contacts_storage";
    Map<UUID, Contact> _contacts;

    private ContactManager() {

    }

    private void generateTestData()
    {
        addContact(new Contact("Malcom Reynolds", "Captain", "555-1234", "email@email.com", "@iamtwitter") );
        addContact(new Contact("Malcom Reynolds", "Captain", "555-1234", "email@email.com", "@iamtwitter"));
        addContact(new Contact("Jayne Cobb", "Muscle", "555-6374", "email@email.com", "@iamtwitter"));
        addContact(new Contact("Wash", "Pilot", "555-7263", "email@email.com", "@iamtwitter"));
        addContact(new Contact("Kaylee", "Engineer", "555-0987", "email@email.com", "@iamtwitter"));
        addContact(new Contact("Malcom Reynolds", "Captain", "555-1234", "email@email.com", "@iamtwitter"));
        addContact(new Contact("Jayne Cobb", "Muscle", "555-6374", "email@email.com", "@iamtwitter"));
        addContact(new Contact("Wash", "Pilot", "555-7263", "email@email.com", "@iamtwitter"));
        addContact(new Contact("Kaylee", "Engineer", "555-0987", "email@email.com", "@iamtwitter"));
        addContact(new Contact("Malcom Reynolds", "Captain", "555-1234", "email@email.com", "@iamtwitter"));
        addContact(new Contact("Jayne Cobb", "Muscle", "555-6374", "email@email.com", "@iamtwitter"));
        addContact(new Contact("Wash", "Pilot", "555-7263", "email@email.com", "@iamtwitter"));
        addContact(new Contact("Kaylee", "Engineer", "555-0987", "email@email.com", "@iamtwitter"));
        addContact(new Contact("Malcom Reynolds", "Captain", "555-1234", "email@email.com", "@iamtwitter"));
        addContact(new Contact("Jayne Cobb", "Muscle", "555-6374", "email@email.com", "@iamtwitter"));
        addContact(new Contact("Wash", "Pilot", "555-7263", "email@email.com", "@iamtwitter"));
        addContact(new Contact("Kaylee", "Engineer", "555-0987", "email@email.com", "@iamtwitter"));
    }

    public Contact[] getAllContacts() {
        return _contacts.values().toArray(new Contact[_contacts.size ()]);
    }

    public void addContact(Contact contact)
    {
        contact.setId(UUID.randomUUID());
        _contacts.put(contact.getId(), contact);
    }

    public Contact getContact(UUID id) {
        if (_contacts.containsKey(id)) {
            return _contacts.get(id);
        } else {
            return null;
        }
    }

    public void deleteContact(Contact contact) {

    }

    public void saveContacts(Context context) {
        Gson gson = new Gson();
        String json = gson.toJson(_contacts);

        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput(_contactFileName, Context.MODE_PRIVATE);
            fos.write(json.getBytes());
            fos.close();
        }
        catch(FileNotFoundException ex) {
            ex.printStackTrace();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }


    }

    public void loadContacts(Context context) {
        File file = context.getFileStreamPath(_contactFileName);
        StringBuffer jsonBuffer = new StringBuffer("");
        if (file.exists()) {
            FileInputStream fis = null;
            try {
                FileInputStream fIn = context.openFileInput(_contactFileName) ;
                InputStreamReader isr = new InputStreamReader ( fIn ) ;
                BufferedReader buffreader = new BufferedReader ( isr ) ;

                String readString = buffreader.readLine ( ) ;
                while ( readString != null ) {
                    jsonBuffer.append(readString);
                    readString = buffreader.readLine ( ) ;
                }

                isr.close ( ) ;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Type contactsDictionaryType = new TypeToken<Map<UUID, Contact>>() {}.getType();
            try {
                _contacts = new Gson().fromJson(jsonBuffer.toString().trim(), contactsDictionaryType);
            }
            catch(Exception ex) {
                ex.printStackTrace();
            }
        }
        else{
            //if the file wasnt found, load initially using test data
            _contacts = new HashMap<UUID, Contact>();
            generateTestData();
        }

    }

}
