package com.example.carrental;

import android.content.Intent;
import android.database.Cursor;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewListContents extends AppCompatActivity {

    private static final String TAG = "ViewListContents";
    DatabaseHelper myDB;
    private ListView mListView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        getSupportActionBar().setTitle("My Ingredients");
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        mListView = (ListView) findViewById(R.id.listView);
        myDB = new DatabaseHelper(this);
        populateListView();
    }

    private void populateListView() {
        Log.d(TAG, "populateListView: Displaying data in the ListView.");
        //get the data and append to a list
        Cursor data = myDB.getData();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()) {
            //get the value from the database in column 1
            //then add item to the ArrayList
            listData.add(data.getString(1));
        }
        //list adapter
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listData);
        mListView.setAdapter(adapter);

        //onItemClickListener to the ListView
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = adapterView.getItemAtPosition(i).toString();
                Log.d(TAG, "onItemClick: You Clicked on " + name);


                //Get the ID associated with that name
                Cursor data = myDB.getItemID(name);
                int itemID = -1;
                while(data.moveToNext()){
                    itemID = data.getInt(0);
                }
                if(itemID > 0){
                    Log.d(TAG, "onItemClick: The ID is: " + itemID);
                    //Go to editDataActivity
                    Intent editScreenIntent = new Intent(ViewListContents.this, EditDataActivity.class);
                    editScreenIntent.putExtra("id", itemID);
                    editScreenIntent.putExtra("name", name);
                    startActivity(editScreenIntent);
                }
                else{
                    toastMessage("No ID associated with that name");
                }
            }
        });
    }

    //All toast messages
    private void toastMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}

