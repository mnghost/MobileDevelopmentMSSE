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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        _contactManager = ContactManager.getInstance();

        Intent intent = getIntent();

        UUID contactId = UUID.fromString(intent.getStringExtra(CURRENT_CONTACT_ID));
        _contact = _contactManager.getContact(contactId);

        setContentView(R.layout.activity_contact_detail);

        TextView nameView = (TextView)findViewById(R.id.contact_detail_name);
        TextView phoneView = (TextView)findViewById(R.id.contact_detail_phone);
        TextView emailView = (TextView)findViewById(R.id.contact_detail_email);
        TextView titleView = (TextView)findViewById(R.id.contact_detail_title);
        TextView twitterView = (TextView)findViewById(R.id.contact_detail_twitter);

        nameView.setText(_contact.getName());
        phoneView.setText(_contact.getPhone());
        emailView.setText(_contact.getEmail());
        titleView.setText(_contact.getTitle());
        twitterView.setText(_contact.getTwitterID());

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
