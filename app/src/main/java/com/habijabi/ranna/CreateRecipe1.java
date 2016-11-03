package com.habijabi.ranna;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateRecipe1 extends Activity {
    static String columns, values,category;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe1);
        Intent intent = getIntent();
        columns = intent.getStringExtra("Tot_col");
        values = intent.getStringExtra("Tot_val");
        EditText editText = (EditText) findViewById(R.id.ingredients);
        editText.setText("উপকরণ:-" + columns.replaceAll(",", "\n").replaceAll("_", " "));
        ActionBar actionBar = getActionBar();
        actionBar.setTitle(getString(R.string.create_rec));
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setHomeButtonEnabled(false);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/bangla.ttf");
        Button next=(Button)findViewById(R.id.next);
        next.setTypeface(custom_font);

        final CharSequence[] items = {"জলখাবার", "নিরামিষ", "আমিষ", "উৎসব","পানীয়","মিষ্টান্"};
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setTitle("এই রেসিপি কোন বিভাগের অংশভুক্ত?");
        builder1.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("জলখাবার")) {
                    CreateRecipe1.category = "জলখাবার";

                } else if (items[item].equals("নিরামিষ")) {
                    CreateRecipe1.category = "নিরামিষ";

                } else if (items[item].equals("মিষ্টান্")) {
                    CreateRecipe1.category = "মিষ্টান্";
                } else if (items[item].equals("উৎসব")) {
                    CreateRecipe1.category = "উৎসব";
                } else if (items[item].equals("পানীয়")) {
                    CreateRecipe1.category = "পানীয়";
                }
                else if (items[item].equals("আমিষ")) {
                    CreateRecipe1.category = "আমিষ";
                }
            }
        });
        builder1.show();





    }
    public void next(View view){
        columns = columns.concat("," + CreateRecipe1.category);
        values = values.concat(",'YES'");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXxcreate1xxxxXXXXold version is "+CreateRecipe1.category);

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXxcreate1xxxxXXXXold version is "+columns);


        EditText editText = (EditText) findViewById(R.id.recipe_name);
        String recipe_name = editText.getText().toString();
        if (recipe_name.length() == 0) {
            Toast toast = Toast.makeText(this, "রেসিপিটির নাম লিখুন", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }









        EditText editText2 = (EditText) findViewById(R.id.ingredients);
        String ingredients = editText2.getText().toString()+"\n\n প্রণালী:-\n";



        Intent intent =new Intent(this,CreateRecipe.class);
        intent.putExtra("Tot_col", columns);
        intent.putExtra("Tot_val", values);
        intent.putExtra("recipe_name", recipe_name);
        intent.putExtra("ingredients", ingredients);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void clear_all(View view){
        EditText editText = (EditText) findViewById(R.id.ingredients);
        editText.getText().clear();
    }

    public void cup(View view){
        EditText editText = (EditText) findViewById(R.id.ingredients);
        editText.getText().insert(editText.getSelectionStart(), getString(R.string.cup));
    }
    public void spoon(View view){
        EditText editText = (EditText) findViewById(R.id.ingredients);
        editText.getText().insert(editText.getSelectionStart(), getString(R.string.spoon));
    }
    public void samanno(View view){
        EditText editText = (EditText) findViewById(R.id.ingredients);
        editText.getText().insert(editText.getSelectionStart(), getString(R.string.samanno));
    }
    public void piece(View view){
        EditText editText = (EditText) findViewById(R.id.ingredients);
        editText.getText().insert(editText.getSelectionStart(), getString(R.string.piece));
    }
    public void gram(View view){
        EditText editText = (EditText) findViewById(R.id.ingredients);
        editText.getText().insert(editText.getSelectionStart(), getString(R.string.gram));
    }
    public void one(View view){
        EditText editText = (EditText) findViewById(R.id.ingredients);
        editText.getText().insert(editText.getSelectionStart(), getString(R.string.one));
    } public void two(View view){
        EditText editText = (EditText) findViewById(R.id.ingredients);
        editText.getText().insert(editText.getSelectionStart(), getString(R.string.two));
    } public void three(View view){
        EditText editText = (EditText) findViewById(R.id.ingredients);
        editText.getText().insert(editText.getSelectionStart(), getString(R.string.three));
    } public void four(View view){
        EditText editText = (EditText) findViewById(R.id.ingredients);
        editText.getText().insert(editText.getSelectionStart(), getString(R.string.four));
    } public void five(View view){
        EditText editText = (EditText) findViewById(R.id.ingredients);
        editText.getText().insert(editText.getSelectionStart(), getString(R.string.five));
    }
}
