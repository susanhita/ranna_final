package com.habijabi.ranna;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class RecipeCategory extends Activity {
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_category);
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);

        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        animation2.setStartOffset(150);
        Animation animation3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        animation3.setStartOffset(300);
        Animation animation4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        animation4.setStartOffset(450);
        Animation animation5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        animation5.setStartOffset(600);
        Animation animation6 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        animation6.setStartOffset(750);
        Animation animation7 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        animation7.setStartOffset(900);

        Button veg=(Button)findViewById(R.id.veg);
        veg.startAnimation(animation3);

        Button nonveg=(Button)findViewById(R.id.nonveg);
        nonveg.startAnimation(animation4);

        Button snacks=(Button)findViewById(R.id.snacks);
        snacks.startAnimation(animation1);

            Button all=(Button)findViewById(R.id.all);
        all.startAnimation(animation7);


       Button desserts=(Button)findViewById(R.id.desserts);
        desserts.startAnimation(animation6);

        Button beverages=(Button)findViewById(R.id.beverages);
        beverages.startAnimation(animation2);


        Button bideshi=(Button)findViewById(R.id.festival);
        bideshi.startAnimation(animation5);




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
