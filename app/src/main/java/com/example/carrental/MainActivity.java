package com.example.carrental;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[]= {"Pan Fried Dumplings", "Beef Ramen Noodles", "Italian Chicken Supper", "Club Sandwich"};
    String mDescription[]= {" Level: Easy \n Duration: 30 minutes ", " Level: Easy \n Duration: 25 minutes", " Level: Moderate\n Duration: 40 minutes" , " Level: Easy \n Duration: 15 minutes"};
    String mIngredients[] = {
            //Meal 1
            "1/2 cup finely chopped bok choy leaves\n" +
            "1/2 cup finely chopped napa cabbage\n" +
            "1/4 cup finely chopped green onion\n" +
            "1/4 cup chopped water chestnuts\n" +
            "1 pound ground pork\n" +
            "1 teaspoon light soy sauce\n" +
            "1 teaspoon dark soy sauce\n" +
            "2 teaspoons Chinese rice wine or dry sherry\n" +
            "1 teaspoon sesame oil\n" +
            "Dash of white pepper",
            //Meal 2
            "2 tablespoons canola oil\n" +
            "1 pound top sirloin steak sliced thinly against the grain\n" +
            "8 ounces ramen noodles cooked and drained\n" +
            "1 red bell pepper thinly sliced\n" +
            "1 large onion thinly sliced\n" +
            "3 carrots shredded\n" +
            "8 ounces baby bok choy roughly chopped, white and green parts separated\n" +
            "4 ounces shiitake mushrooms sliced\n" +
            "Sesame seeds for garnish, optional\n" +
            "sliced green onion for garnish, optional",
            //Meal 3
            "1/4 cup balsamic vinegar\n" +
            "1 teaspoon dried parsley flakes \n" +
            "1 teaspoon dried basil \n" +
            "1 teaspoon kosher salt \n" +
            "1/2 teaspoon freshly cracked black pepper \n" +
            "5 cloves garlic, minced \n" +
            "1 cup plus 3 tablespoons olive oil\n" +
            "8 bone-in, skin-on chicken thighs \n" +
            "1 pound green beans\n" +
            "2 cups mixed cherry tomatoes \n" +
            "1 loaf crusty ciabatta bread \n" +
            "2 tablespoons minced fresh parsley \n",
            //Meal 4
            "3 slices wheat bread (or bread of choice)\n" +
            "2 Tablespoons mayo (I recommend Duke's, Hellmann's or Trader Joe's)\n" +
            "lettuce\n" +
            "tomato slices\n" +
            "salt and pepper to taste (on the tomatoes)\n" +
            "2 ounces sliced deli ham\n" +
            "2 ounces sliced turkey\n" +
            "2 slices bacon cooked\n" +
            "1 slice Colby jack cheese (or cheese of choice - cheddar and Swiss work great too)"
    };
    String mInsructions[] = {
            //Meal 1
            "1. Gather the ingredients.\n" +
            "\n"+
            "2. Combine the filling ingredients in a large bowl, using your fingers to mix everything together. If preparing the filling ahead of time, store in a sealed container in the refrigerator until ready to use.\n" +
            "\n"+
            "3. Gently lift the edges of the moistened wrapper over the filling and bring together at the top center. Crimp the edges of the wrapper several times along the edge and pinch together to seal. Repeat with the remaining wonton wrappers and filling.\n"+
            "\n"+
            "4. Heat a wok or nonstick skillet over medium-high heat and add the oil. Add 10 to 12 potstickers at a time and cook for 2 to 3 minutes until the bottoms are browned.\n"+
            "\n"+
            "5. Add 1/3 cup water, cover, and steam the dumplings until the liquid is absorbed, about 5 minutes.\n"+
            "\n"+
            "6. Remove and cook the remainder of the dumplings, adding water as needed, keeping the amount to about 1/3 cup.\n"+
            "\n"+
            "7. Serve alone or with a homemade dipping sauce.\n"+
                    "\n"+
            "8. Enjoy!",
            //Meal 2
            "1. Whisk together all ingredients for the sauce, set aside.\n" +
                    "\n"+
            "2. In a large skillet or wok, heat 1 tablespoon of oil over medium high heat. When hot, add the beef and cook for 2-3 minutes per side, until cooked through. This may need to be done in two batches to avoid crowding the pan. Remove beef from pan and drain off any excess liquid, wipe or rinse pan if needed.\n"+
                    "\n"+
            "3. Return pan to heat and allow any excess moisture to evaporate. Add remaining tablespoon of oil to pan. \n" +
                    "\n"+
            "4. When hot, add onion and cook for 2-3 minutes, stirring as needed, until onion is starting to soften.\n" +
                    "\n"+
            "5. Add bell pepper, mushrooms and white parts of bok choy and cook for another 3-4 minutes. \n" +
                    "\n"+
            "6. Add carrots and green parts of bok choy, cook for another 2 minutes\n" +
                    "\n"+
            "7. When vegetables are crisp tender, add the beef and noodles to the pan.  Pour in the sauce, stirring to mix and coat everything in the sauce.\n" +
                    "\n"+
            "8. Cook for 1-2 minutes, until sauce has thickened.\n" +
                    "\n"+
            "9. Remove from heat. Garnish with sesame seeds and green onion if desired and serve.",
            //Meal 3
            "1. Preheat the oven to 425 degrees F.\n"+
                    "\n"+
            "2. To a bowl or pitcher, add the vinegar, parsley, basil, salt, pepper, garlic and 1 cup of the olive oil. Whisk until well combined.\n"+
                    "\n"+
            "3. Put the chicken in a large zipper bag and pour in half the dressing. Seal the bag and squish to coat the chicken.\n"+
                    "\n"+
            "4. Trim the ends of the green beans and put in a large bowl with the tomatoes. Pour over the remaining dressing and toss.\n"+
                    "\n"+
            "5. Using tongs, arrange the chicken skin-side up on a sheet pan. Use a slotted spoon to transfer the beans and tomatoes to the sheet pan, leaving the excess marinade behind. Roast for 20 minutes.\n"+
                    "\n"+
            "6. Meanwhile, rip the bread into large chunks. Add to a bowl, drizzle with the remaining 3 tablespoons olive oil and toss.\n"+
                    "\n"+
            "7. After the chicken and vegetables have roasted for 20 minutes, shake the pan to prevent sticking, then add the bread chunks to the pan. Continue to roast until the chicken is cooked through and the skin is golden and crisp, about another 10 minutes. Sprinkle the sheet pan with parsley and serve.",
            //Meal 4
            "1. Toast your bread, if you wish, and allow it to cool for a few minutes. This helps to avoid wilted lettuce.\n" +
                    "\n"+
            "2. Spread the 3 pieces of cooled toast with mayo.\n" +
                    "\n"+
            "3. On one slice, add your lettuce and tomato. Go ahead and add a little salt and pepper to those tomatoes.\n" +
                    "\n"+
            "4. Put a 2nd piece of bread, mayo side down, on the sandwich. Then add a little more mayo to the top of that piece.\n" +
                    "\n"+
            "5. Next, stack your meat and cheese, and top with the last slice of bread, mayo side down.\n" +
                    "\n"+
            "6. Use a well-sharpened knife to cut the sandwich into triangles, using toothpicks to hold everything together.\n" +
                    "\n"+
            "7. To up the visual game of your club sandwich, turn everything on its side to show all the pretty layers.\n" +
                    "\n"+
            "8. Serve immediately and enjoy!"
    };

    int images[] = {R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food4};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);



        MyAdapter adapter = new MyAdapter( this, mTitle, mDescription, images);
        listView.setAdapter(adapter);

        //If user selects any of the meals, open and pass data to Food Activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if (position == 0){
                    Intent intent = new Intent(getApplicationContext(),Food.class);
                    //Pass data from food1 to "Food" activity
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[0]);
                    intent.putExtras(bundle);

                    //Title and Description inside Food Activity
                    intent.putExtra("title", mTitle[0]);
                    intent.putExtra("description", mDescription[0]);
                    intent.putExtra("ingredients", mIngredients[0]);
                    intent.putExtra("instructions", mInsructions[0]);

                    //Position
                    intent.putExtra("position", +0);

                    startActivity(intent);


                }
                if (position == 1){
                    Intent intent = new Intent(getApplicationContext(),Food.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[1]);
                    intent.putExtras(bundle);


                    intent.putExtra("title", mTitle[1]);
                    intent.putExtra("description", mDescription[1]);
                    intent.putExtra("ingredients", mIngredients[1]);
                    intent.putExtra("instructions", mInsructions[1]);

                    //Position
                    intent.putExtra("position", +1);

                    startActivity(intent);

                }
                if (position == 2){
                    Intent intent = new Intent(getApplicationContext(),Food.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[2]);
                    intent.putExtras(bundle);


                    intent.putExtra("title", mTitle[2]);
                    intent.putExtra("description", mDescription[2]);
                    intent.putExtra("ingredients", mIngredients[2]);
                    intent.putExtra("instructions", mInsructions[2]);

                    //Position
                    intent.putExtra("position", +2);

                    startActivity(intent);

                }
                if (position == 3){
                    Intent intent = new Intent(getApplicationContext(),Food.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[3]);
                    intent.putExtras(bundle);


                    intent.putExtra("title", mTitle[3]);
                    intent.putExtra("description", mDescription[3]);
                    intent.putExtra("ingredients", mIngredients[3]);
                    intent.putExtra("instructions", mInsructions[3]);

                    //Position
                    intent.putExtra("position", +3);

                    startActivity(intent);

                }

            }
        });


    }

    class MyAdapter extends ArrayAdapter<String>{
        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]){
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }


    //Menu Navigation
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }
    //Menu Item Selection
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

       switch (item.getItemId()){
           case R.id.item1:
               Intent intent = new Intent(this, MainActivity.class);
               startActivity(intent);
               break;
           case R.id.item2:
               Intent intent2 = new Intent(this, ShoppingList.class);
               startActivity(intent2);
               break;
           case R.id.item3:
               //DialogFragment
               AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
               a_builder.setMessage("Are you sure you want to exit?")
                       .setCancelable(false)
                       .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               finishAffinity();
                           }
                       })
                       .setNegativeButton("No",new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialog, int which) {
                               dialog.cancel();
                           }
                       }) ;
               AlertDialog alert = a_builder.create();
               alert.setTitle("Exit");
               alert.show();
               break;
       }
        return super.onOptionsItemSelected(item);
    }

}
