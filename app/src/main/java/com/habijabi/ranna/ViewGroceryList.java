package com.habijabi.ranna;

import android.app.ActionBar;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class ViewGroceryList extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_grocery_list);
        ActionBar actionBar=getActionBar();
        actionBar.setTitle(getString(R.string.grocery));
        actionBar.setDisplayShowHomeEnabled(true);

        new ViewListDB().execute();

    }

    private class ViewListDB extends AsyncTask<String, Void, String> {
        protected void onPreExecute() {
            System.gc();
        }
        protected String doInBackground(String...list1) {

            SQLiteOpenHelper recipedb = new RecipeDatabase(ViewGroceryList.this);
            SQLiteDatabase db = recipedb.getWritableDatabase();
            try {
                Cursor cursor = db.rawQuery("Select GROCERY_LIST from RECIPE where _id='1'", null);
                cursor.moveToFirst();
                String list = cursor.getString(0);
                return list;
            }
            catch (SQLiteException e){
                return "Database problem";
            }
        }
        protected void onPostExecute(String list) {
            TextView textView=(TextView)findViewById(R.id.groc_listv);
            textView.setText(list);
        }
    }
}

