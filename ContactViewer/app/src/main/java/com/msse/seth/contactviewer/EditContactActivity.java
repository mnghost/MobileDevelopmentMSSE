package com.msse.seth.contactviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
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

//        Intent intent = getIntent();
//
//        UUID contactId = UUID.fromString(intent.getStringExtra(ContactDetail.CURRENT_CONTACT_ID));
//
//        Contact contact = _contactManager.getContact(contactId);
//
        setContentView(R.layout.activity_edit_contact);
//
//        TextView nameView = (TextView)findViewById(R.id.contact_detail_name);
//        TextView phoneView = (TextView)findViewById(R.id.contact_detail_phone);
//        TextView emailView = (TextView)findViewById(R.id.contact_detail_email);
//        TextView titleView = (TextView)findViewById(R.id.contact_detail_title);
//        TextView twitterView = (TextView)findViewById(R.id.contact_detail_twitter);
//
//        nameView.setText(contact.getName());
//        phoneView.setText(contact.getPhone());
//        emailView.setText(contact.getEmail());
//        titleView.setText(contact.getTitle());
//        twitterView.setText(contact.getTwitterID());
    }
}
