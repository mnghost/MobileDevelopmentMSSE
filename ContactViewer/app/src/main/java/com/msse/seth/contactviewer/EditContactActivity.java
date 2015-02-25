package com.msse.seth.contactviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by Seth on 2/22/2015.
 */
public class EditContactActivity extends Activity {

    private ContactManager _contactManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();

        UUID contactId = UUID.fromString(intent.getStringExtra(ContactDetail.CURRENT_CONTACT_ID));
        _contactManager = ContactManager.getInstance();
        Contact contact = _contactManager.getContact(contactId);

        setContentView(R.layout.activity_edit_contact);

        EditText nameView = (EditText)findViewById(R.id.editName);
        EditText phoneView = (EditText)findViewById(R.id.editPhone);
        EditText emailView = (EditText)findViewById(R.id.editEmail);
        EditText titleView = (EditText)findViewById(R.id.editTitle);
        EditText twitterView = (EditText)findViewById(R.id.editTwitter);

        nameView.setText(contact.getName());
        phoneView.setText(contact.getPhone());
        emailView.setText(contact.getEmail());
        titleView.setText(contact.getTitle());
        twitterView.setText(contact.getTwitterID());
    }
}
