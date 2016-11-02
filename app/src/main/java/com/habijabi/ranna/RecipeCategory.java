package com.habijabi.ranna;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RecipeCategory extends Activity {
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_category);
    }


    public void veg(View view){
        Intent intent=new Intent(this,ViewRecipe.class);
        category="veg";
        intent.putExtra("category", category);
        startActivity(intent);
    }
    public void nonveg(View view){
        Intent intent=new Intent(this,ViewRecipe.class);
        category="nonveg";
        intent.putExtra("category", category);
        startActivity(intent);

    }
    public void festival(View view){
        Intent intent=new Intent(this,ViewRecipe.class);
        category="festival";

        intent.putExtra("category", category);
        startActivity(intent);

    }

    public void beverage(View view){
        Intent intent=new Intent(this,ViewRecipe.class);
        category="beverage";
        intent.putExtra("category", category);
        startActivity(intent);

    }

    public void all(View view){
        Intent intent=new Intent(this,ViewRecipe.class);
        category="all";
        intent.putExtra("category", category);
        startActivity(intent);

    }

    public void snacks(View view){
        Intent intent=new Intent(this,ViewRecipe.class);
        category="snacks";
        intent.putExtra("category", category);
        startActivity(intent);

    }
}
