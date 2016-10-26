package com.habijabi.ranna;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.content.ClipboardManager;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.content.DialogInterface;
import android.app.AlertDialog;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import android.Manifest;

public class CreateRecipe extends Activity {
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    Uri uriSavedImage1,galleryUri;
    String photo_name, EXTRA = "message", columns, values,uriSavedImageString,ingredients,recipe_name;
    Uri uriSavedImage=Uri.parse("android.resource://com.habijabi.ranna/"+R.drawable.default_pic);
    boolean camera_flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);
        Intent intent = getIntent();
        columns = intent.getStringExtra("Tot_col");
        values = intent.getStringExtra("Tot_val");
        recipe_name=intent.getStringExtra("recipe_name");
        ingredients=intent.getStringExtra("ingredients");

        ActionBar actionBar = getActionBar();
        actionBar.setTitle(getString(R.string.create_rec));
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setHomeButtonEnabled(false);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/bangla.ttf");
        Button pic=(Button)findViewById(R.id.recipepic);
        Button save=(Button)findViewById(R.id.save);
        Button paste=(Button)findViewById(R.id.paste);
        pic.setTypeface(custom_font);
        save.setTypeface(custom_font);
        paste.setTypeface(custom_font);





    }


    public void recipe_pic(View view) throws IOException {
        int permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if (permission != PackageManager.PERMISSION_GRANTED) {
            // We don't have permission so prompt the user
            ActivityCompat.requestPermissions(
                    this,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );

        }
        File dir;
        photo_name = recipe_name.replaceAll("\\s+", "");
        /* creating folder*/
        //   File sdDir = Environment.getExternalStorageDirectory();
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
             dir = new File(Environment.getExternalStoragePublicDirectory(
                    Environment.DIRECTORY_DCIM), "Ranna_images");
        }
        else {
             dir = new File((this
                    .getApplicationContext().getFileStreamPath("Ranna_images_inside")
                    .getPath()));
        }
        /*folder created*/

       uriSavedImage = Uri.parse("file://"+dir+"/"+ photo_name + ".JPG");


        final CharSequence[] items = {"ক্যামেরা", "গ্যালারি থেকে পছন্দ করে নিন", "Cancel"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ল্যান্ডস্কেপ মোডে ছবি তুলুন");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("ক্যামেরা")) {
                    camera_flag = true;
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
                    startActivityForResult(intent, 1);
                } else if (items[item].equals("গ্যালারি থেকে পছন্দ করে নিন")) {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    //           android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    intent.setAction(Intent.ACTION_GET_CONTENT);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
                    startActivityForResult(intent, 1);
                } else if (items[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();

    }



    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        System.gc();
        super.onActivityResult(requestCode, resultCode, data);


        if (resultCode == RESULT_OK && camera_flag==false) {
            if(data.getData() != null)
            {
                InputStream image_stream = null;
                try
                {
                    image_stream = getContentResolver().openInputStream(data.getData());
                }
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }

                Bitmap bmp= BitmapFactory.decodeStream(image_stream);
                OutputStream os = null;
                try
                {
                    os = getContentResolver().openOutputStream(uriSavedImage);//saving the gallery pic in urisavedimage
                } catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }


                bmp.compress(Bitmap.CompressFormat.JPEG, 50, os);//saving the pic as png

            }

        }
        Bitmap bmp1 = BitmapFactory.decodeFile(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)+"/Ranna_images/" + photo_name + ".JPG");
        ImageView imageView=(ImageView)findViewById(R.id.selected_pic);
        imageView.setImageBitmap(bmp1);

    }





    public void paste(View view) {
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        if (clipboard.getPrimaryClip() != null) {
            ClipData.Item pastetext = clipboard.getPrimaryClip().getItemAt(0);
            EditText editText = (EditText) findViewById(R.id.createRecipe);
            editText.append(pastetext.coerceToText(this));
        } else {
            Toast toast = Toast.makeText(this, "পেস্ট করার মত কিছুই নেই!", Toast.LENGTH_SHORT);
            toast.show();
        }

    }


    public void save(View view) throws FileNotFoundException {
        ////////////////
        uriSavedImage1 = Uri.parse(uriSavedImage.toString());

        uriSavedImageString=uriSavedImage1.toString();


        EditText editText1 = (EditText) findViewById(R.id.createRecipe);
        String description = editText1.getText().toString();
        if (description.length() <= 10) {
            Toast toast = Toast.makeText(this, "প্রণালীর বিবরণ ১০ অক্ষরের বেশি হতে হবে", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        ArrayList<String> params=new ArrayList<String>();
        params.add(recipe_name);
        params.add(ingredients+"\n"+description);
        params.add(uriSavedImageString);

        params.add(values);
        if (camera_flag==true) {
          //  new RotateImageClass().execute();
        }
        new SaveRecipeClass().execute(params);
    }

























    private class SaveRecipeClass extends AsyncTask<ArrayList<String>, Void, Boolean> {
        protected void onPreExecute() {
        }

        protected Boolean doInBackground(ArrayList<String>...params) {

            SQLiteOpenHelper starbuzzdb1 = new RecipeDatabase(CreateRecipe.this);
            String recipe_name=params[0].get(0), description=params[0].get(1),uriSavedImage1=params[0].get(2),values=params[0].get(3);

            try {
                SQLiteDatabase db = starbuzzdb1.getWritableDatabase();
                String insert = "INSERT INTO RECIPE(NAME,DESCRIPTION,IMAGE_RESOURCE_ID" + columns + ")VALUES('" + recipe_name + "','" + description + "','" + uriSavedImage1 + "'" + values + ");";
                db.execSQL(insert);
                db.close();
                return true;
            } catch (SQLiteException e) {
                return false;
            }
        }


        protected void onPostExecute(Boolean success) {
            if (success) {
                Toast toast = Toast.makeText(CreateRecipe.this, "রেসিপি যোগ করা হয়েছে", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(CreateRecipe.this, MainActivity.class);
                startActivity(intent);
                finish();
            } else {
                Toast toast = Toast.makeText(CreateRecipe.this, "ডেটাবেসের গন্ডগোল", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}
