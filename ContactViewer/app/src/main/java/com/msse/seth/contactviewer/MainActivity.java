package com.msse.seth.contactviewer;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ListActivity {
    ContactManager _contactManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _contactManager = ContactManager.getInstance();
        _contactManager.loadContacts(this);

        updateContacts();
    }

    private void updateContacts() {
        setListAdapter(new ContactAdapter(this, R.layout.contact_item, _contactManager.getAllContacts()));
    }

    @Override
    protected void onResume() {
        super.onResume();

        updateContacts();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Contact contact = (Contact)getListAdapter().getItem(position);
        //Toast.makeText(this,"Clicked " + contact.getName() + " (" + id + ")", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, ContactDetail.class);
        intent.putExtra(ContactDetail.CURRENT_CONTACT_ID, contact.getId().toString());
        startActivity(intent);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        _contactManager.saveContacts(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_new_contact) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    class ContactAdapter extends ArrayAdapter<Contact> {

        public ContactAdapter(Context context, int resource, Contact[] objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;

            if(convertView == null) {
                view = getLayoutInflater().inflate(R.layout.contact_item, parent, false);
            }
            else {
                view = convertView;
            }

            Contact contact = getItem(position);

            TextView nameView = (TextView)view.findViewById(R.id.item_name);
            TextView titleView = (TextView)view.findViewById(R.id.item_title);
            TextView phoneView = (TextView)view.findViewById(R.id.item_phone);

            nameView.setText(contact.getName());
            titleView.setText(contact.getTitle());
            phoneView.setText(contact.getPhone());

            return view;
        }
    }
}
