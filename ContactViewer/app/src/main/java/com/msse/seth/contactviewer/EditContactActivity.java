package com.msse.seth.contactviewer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

/**
 * Created by Seth on 2/22/2015.
 */
public class EditContactActivity extends Activity {

    private ContactManager _contactManager = null;
    private Contact _contact = null;

    private EditText _nameView = null;
    private EditText _phoneView = null;
    private EditText _emailView = null;
    private EditText _titleView = null;
    private EditText _twitterView = null;

    private UUID _contactId = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);

        _nameView = (EditText)findViewById(R.id.editName);
        _phoneView = (EditText)findViewById(R.id.editPhone);
        _emailView = (EditText)findViewById(R.id.editEmail);
        _titleView = (EditText)findViewById(R.id.editTitle);
        _twitterView = (EditText)findViewById(R.id.editTwitter);

        Intent intent = getIntent();

        _contactManager = ContactManager.getInstance();

        if (intent.hasExtra(ContactDetail.CURRENT_CONTACT_ID)) {
            //maybe set title thing to edit mode?
            _contactId = UUID.fromString(intent.getStringExtra(ContactDetail.CURRENT_CONTACT_ID));

            _contact = _contactManager.getContact(_contactId);

            _nameView.setText(_contact.getName());
            _phoneView.setText(_contact.getPhone());
            _emailView.setText(_contact.getEmail());
            _titleView.setText(_contact.getTitle());
            _twitterView.setText(_contact.getTwitterID());
        }
        else{
            //set title thing to create mode?
        }



        final Button save = (Button)findViewById(R.id.save);
        final Button cancel = (Button)findViewById(R.id.cancel);


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (_contact != null) {
                    _contact.setName(_nameView.getText().toString());
                    _contact.setPhone(_phoneView.getText().toString());
                    _contact.setEmail(_emailView.getText().toString());
                    _contact.setTitle(_titleView.getText().toString());
                    _contact.setTwitterID(_twitterView.getText().toString());
                }
                else {

                    _contact = new Contact(_nameView.getText().toString(), _phoneView.getText().toString(), _emailView.getText().toString(),
                            _titleView.getText().toString(),_twitterView.getText().toString());
                    _contactManager.addContact(_contact);
                }
                _contactManager.saveContacts(v.getContext());

                finish();
            }
        });

    }
}
