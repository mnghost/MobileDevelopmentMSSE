package com.msse.seth.contactviewer;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.UUID;

public class ContactDetail extends Activity {
    public final static String CURRENT_CONTACT_ID = "ContactDetail.CurrentContactId";
    private ContactManager _contactManager;
    private Contact _contact;

    private UUID _contactId;

    TextView _nameView;
    TextView _phoneView;
    TextView _emailView;
    TextView _titleView;
    TextView _twitterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _contactManager = ContactManager.getInstance();

        Intent intent = getIntent();

        _contactId = UUID.fromString(intent.getStringExtra(CURRENT_CONTACT_ID));

        setContentView(R.layout.activity_contact_detail);

        populateContactDetails(_contactId);

    }

    public void populateContactDetails(UUID contactId){

        _contact = _contactManager.getContact(contactId);
        _nameView = (TextView)findViewById(R.id.contact_detail_name);
        _phoneView = (TextView)findViewById(R.id.contact_detail_phone);
        _emailView = (TextView)findViewById(R.id.contact_detail_email);
        _titleView = (TextView)findViewById(R.id.contact_detail_title);
        _twitterView = (TextView)findViewById(R.id.contact_detail_twitter);

        _nameView.setText(_contact.getName());
        _phoneView.setText(_contact.getPhone());
        _emailView.setText(_contact.getEmail());
        _titleView.setText(_contact.getTitle());
        _twitterView.setText(_contact.getTwitterID());
    }

    @Override
    public void onResume()
    {  // After a pause OR at startup
        super.onResume();
        populateContactDetails(_contactId);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_delete) {
            _contactManager.deleteContact(_contact);
            _contactManager.saveContacts(this);
            finish();
        }else if(id == R.id.action_edit) {
            Intent editIntent = new Intent(ContactDetail.this, EditContactActivity.class);
            editIntent.putExtra(ContactDetail.CURRENT_CONTACT_ID, _contact.getId().toString());
            startActivity(editIntent);
        }


        return super.onOptionsItemSelected(item);
    }
}
