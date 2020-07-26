package com.example.carrental;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ShoppingList extends MainActivity {

    DatabaseHelper myDB;
    Button btnAdd, btnView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.additem);

        editText = (EditText) findViewById(R.id.editText);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnView = (Button) findViewById(R.id.btnView);
        myDB = new DatabaseHelper(this);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingList.this, ViewListContents.class);
                startActivity(intent);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //EditText Error Check
                String newEntry = editText.getText().toString();
                if (editText.length() != 0){
                    AddData(newEntry);
                    editText.setText("");
                }
                else{
                    Toast.makeText(ShoppingList.this, "You must put something in the text field", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void AddData (String newEntry){
        boolean insertData = myDB.addData(newEntry);
        //When user adds an entry
        if (insertData ==  true){
            Toast.makeText(ShoppingList.this,"Ingredient Added!", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(ShoppingList.this,"Please validate input", Toast.LENGTH_LONG).show();
        }
    }
}
