package com.example.android.contacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nameTxt, phoneTxt, addressTxt, emailTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameTxt = (EditText)findViewById(R.id.txtName);
        phoneTxt = (EditText)findViewById(R.id.txtPhNumber);
        addressTxt = (EditText)findViewById(R.id.txtAddress);
        emailTxt = (EditText)findViewById(R.id.txtEmail);

        TabHost tabHost = (TabHost)findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec tabSpec;

        tabSpec = tabHost.newTabSpec("Creator");
        tabSpec.setContent(R.id.tabCreator);
        tabSpec.setIndicator("Creator");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("List");
        tabSpec.setContent(R.id.tabContactList);
        tabSpec.setIndicator("List");
        tabHost.addTab(tabSpec);

        final Button addButton = (Button)findViewById(R.id.btnAddContact);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Your Contact has been created!", Toast.LENGTH_SHORT).show();
            }
        });

        nameTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                addButton.setEnabled(!nameTxt.getText().toString().trim().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
