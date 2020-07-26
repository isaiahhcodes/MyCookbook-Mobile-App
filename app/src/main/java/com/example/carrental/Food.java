package com.example.carrental;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Food extends AppCompatActivity {

    ImageView imageView;
    TextView title, description, ingredients, instructions;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        //ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#003333")));
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        imageView = findViewById(R.id.another_imageView);
        title = findViewById(R.id.titleText);
        description = findViewById(R.id.descriptionText);
        ingredients = findViewById(R.id.ingredientsText);
        instructions = findViewById(R.id.instructionsText);



        //PASS DATA: GetIntents from MainActivity
        if (position == 0){
            Intent intent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
            int pic = bundle.getInt("image");
            String aTitle = intent.getStringExtra("title");
            String aDescription = intent.getStringExtra("description");
            String aIngredient = intent.getStringExtra("ingredients");
            String aInstruction = intent.getStringExtra("instructions");

            imageView.setImageResource(pic);
            title.setText(aTitle);
            description.setText(aDescription);
            ingredients.setText(aIngredient);
            instructions.setText(aInstruction);


            actionBar.setTitle(aTitle);

        }

        if (position == 1){
            Intent intent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
            int pic = bundle.getInt("image");
            String aTitle = intent.getStringExtra("title");
            String aDescription = intent.getStringExtra("description");
            String aIngredient = intent.getStringExtra("ingredients");
            String aInstruction = intent.getStringExtra("instructions");

            imageView.setImageResource(pic);
            title.setText(aTitle);
            description.setText(aDescription);
            ingredients.setText(aIngredient);
            instructions.setText(aInstruction);

            actionBar.setTitle(aTitle);

            //If user clicks on imageButton open Youtube Vid

            /*imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent ytIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=SK98ayjhk1E"));

                    startActivity(ytIntent);
                }
            });

             */
        }

        if (position == 2){
            Intent intent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
            int pic = bundle.getInt("image");
            String aTitle = intent.getStringExtra("title");
            String aDescription = intent.getStringExtra("description");
            String aIngredient = intent.getStringExtra("ingredients");
            String aInstruction = intent.getStringExtra("instructions");

            imageView.setImageResource(pic);
            title.setText(aTitle);
            description.setText(aDescription);
            ingredients.setText(aIngredient);
            instructions.setText(aInstruction);

            actionBar.setTitle(aTitle);
        }


        if (position == 3){
            Intent intent = getIntent();

            Bundle bundle = this.getIntent().getExtras();
            int pic = bundle.getInt("image");
            String aTitle = intent.getStringExtra("title");
            String aDescription = intent.getStringExtra("description");
            String aIngredient = intent.getStringExtra("ingredients");
            String aInstruction = intent.getStringExtra("instructions");

            imageView.setImageResource(pic);
            title.setText(aTitle);
            description.setText(aDescription);
            ingredients.setText(aIngredient);
            instructions.setText(aInstruction);

            actionBar.setTitle(aTitle);
        }

    }
}
