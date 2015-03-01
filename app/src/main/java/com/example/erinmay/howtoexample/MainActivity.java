package com.example.erinmay.howtoexample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    EditText name, username, email, phone;
    List<Contact> Contacts = new ArrayList<Contact>();
    ListView contactListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        contactListView = (ListView) findViewById(R.id.listView);

        TabHost tabhost = (TabHost) findViewById(R.id.tabHost);

        tabhost.setup();

        TabHost.TabSpec tabSpec = tabhost.newTabSpec("add");
        tabSpec.setContent(R.id.tabAdd);
        tabSpec.setIndicator("add");
        tabhost.addTab(tabSpec);

        tabSpec = tabhost.newTabSpec("view");
        tabSpec.setContent(R.id.tabView);
        tabSpec.setIndicator("view");
        tabhost.addTab(tabSpec);



        final Button addContact = (Button) findViewById(R.id.doit);
        addContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addContacts(name.getText().toString(), username.getText().toString(), email.getText().toString(), phone.getText().toString());
                populateList();
                Toast.makeText(getApplicationContext(), "contact created", Toast.LENGTH_SHORT).show();
            }
        });

        populateList();
    }

    private void populateList() {
        ArrayAdapter<Contact> adapter = new ContactListAdaptor();
        contactListView.setAdapter(adapter);
    }

    private void addContacts(String name, String username, String phone, String email) {
        Contacts.add(new Contact(name, username, phone, email));
    }

    private class ContactListAdaptor extends ArrayAdapter {
        public ContactListAdaptor() {
            super (MainActivity.this, R.layout.listview_item, Contacts);
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if (view == null)
                view = getLayoutInflater().inflate(R.layout.listview_item, parent, false);

            Contact currentContact = Contacts.get(position);

            TextView name = (TextView) view.findViewById(R.id.name);
            name.setText(currentContact.getName());
            TextView username = (TextView) view.findViewById(R.id.username);
            username.setText(currentContact.getUsername());
            TextView phone = (TextView) view.findViewById(R.id.phone);
            phone.setText(currentContact.getPhone());
            TextView email = (TextView) view.findViewById(R.id.email);
            email.setText(currentContact.getEmail());

            return view;
        }

    }
}
