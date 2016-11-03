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
        category="নিরামিষ";
        intent.putExtra("category", category);
        startActivity(intent);
    }
    public void nonveg(View view){
        Intent intent=new Intent(this,ViewRecipe.class);
        category="আমিষ";
        intent.putExtra("category", category);
        startActivity(intent);

    }
    public void festival(View view){
        Intent intent=new Intent(this,ViewRecipe.class);
        category="উৎসব";

        intent.putExtra("category", category);
        startActivity(intent);

    }

    public void beverage(View view){
        Intent intent=new Intent(this,ViewRecipe.class);
        category="পানীয়";
        intent.putExtra("category", category);
        startActivity(intent);

    }

    public void all(View view){
        Intent intent=new Intent(this,ViewRecipe.class);
        category="অন্যান্য";
        intent.putExtra("category", category);
        startActivity(intent);

    }

    public void snacks(View view){
        Intent intent=new Intent(this,ViewRecipe.class);
        category="জলখাবার";
        intent.putExtra("category", category);
        startActivity(intent);

    }

    public void desserts(View view){
        Intent intent=new Intent(this,ViewRecipe.class);
        category="মিষ্টান্";
        intent.putExtra("category", category);
        startActivity(intent);

    }
}
