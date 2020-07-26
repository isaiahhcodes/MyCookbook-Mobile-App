package com.example.carrental;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EditDataActivity extends AppCompatActivity {

    private static final String TAG = "EditDataActivity";
    private Button btnSave, btnDelete;
    private EditText editText;
    DatabaseHelper myDB;

    private String selectedName;
    private int selectedID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_data_layout);

        //ActionBar
        getSupportActionBar().setTitle("Update Ingredients");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btnSave = (Button)findViewById(R.id.btnSave);
        btnDelete = (Button)findViewById(R.id.btnDelete);
        editText = (EditText) findViewById(R.id.editText);
        myDB = new DatabaseHelper(this);

        //Get the intent extra from ViewListContents
        Intent info = getIntent();

        //itemID extra
        selectedID = info.getIntExtra("id",-1);

        //name extra
        selectedName =info.getStringExtra("name");

        //sets text to show the current selected name
        editText.setText(selectedName);


        //When user clicks Delete or Save
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = editText.getText().toString();
                if(!item.equals("")){
                    myDB.updateName(item, selectedID, selectedName);

                }
                else{
                    toastMessage("You must enter a item");
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDB.deleteName(selectedID,selectedName);
                editText.setText("");
                toastMessage("Item has been removed");
            }
        });




    }
    //All toast messages
    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
