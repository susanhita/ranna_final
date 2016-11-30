package com.habijabi.ranna;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


import cz.msebera.android.httpclient.Header;



public class MainActivity extends Activity {
    RecipeDatabase controller=new RecipeDatabase(this);
    ProgressDialog prgDialog;
    public static Boolean delete=false;
    public static Boolean add_grocery=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        System.gc();
        Button create=(Button)findViewById(R.id.create);
        Button view=(Button)findViewById(R.id.view);

        Button grocery=(Button)findViewById(R.id.grocery);

        Button random=(Button)findViewById(R.id.random);

        Button delete=(Button)findViewById(R.id.delete);

        Button suggest=(Button)findViewById(R.id.suggest);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/bangla.ttf");
        create.setTypeface(custom_font);
        view.setTypeface(custom_font);
        delete.setTypeface(custom_font);
        suggest.setTypeface(custom_font);
        grocery.setTypeface(custom_font);
        random.setTypeface(custom_font);



    }

    public void create_recipe(View view){
        add_grocery=false;
        Intent intent=new Intent(this,SelIngredients.class);
        startActivity(intent);
    }

    public void view_recipe(View view){
        Intent intent=new Intent(this,RecipeCategory.class);
        startActivity(intent);
    }
    public void random_receipe(View view){
        //Intent intent=new Intent(this,RandomReceipe.class);
        //startActivity(intent);

        //Create AsycHttpClient object
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        ArrayList<HashMap<String, String>> userList =  controller.getAllUsers();//seeing total rowas of local database entries
        System.out.println("Mainactivity: getAllUsers"+userList.size());

        if(userList.size()!=0){

                if(controller.dbSyncCount() != 0){
                    System.out.println("MainActivity called dbsyncCount:"+controller.dbSyncCount());//checking which entries in phonedatabase is not synced
                    params.put("usersJSON", controller.composeJSONfromSQLite());//putting the the rows of local phone which are not synced into JSON and putting it in params
                    client.post("http://172.16.16.32/sqlitemysqlsync/insertuser.php",params ,new TextHttpResponseHandler() {//sending the params to the server

                    @Override
                    public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers,String response) {//the new rows are tried to be inserted in server
                      //  System.out.println(response);
                        System.out.println("Sucess of httpasync"+response);

                        //prgDialog.hide();
                        try {
                            JSONArray arr = new JSONArray(response);
                            System.out.println(arr.length());
                            for(int i=0; i<arr.length();i++){
                            JSONObject obj = (JSONObject)arr.get(i);
                            System.out.println("Mainactivity:updatesyncstatus");

                            controller.updateSyncStatus(obj.get("name").toString(),obj.get("status").toString());//update the column of local database in phone updateStatus=yes, or updateStatus=no, if there is some problem
                        }
                        Toast.makeText(getApplicationContext(), "DB Sync completed!", Toast.LENGTH_LONG).show();
                        }
                        catch (JSONException e) {

                            // TODO Auto-generated catch block
                            Toast.makeText(getApplicationContext(), "Error Occured [Server's JSON response might be invalid]!", Toast.LENGTH_LONG).show();
                            e.printStackTrace();
                        }
                    }




                    @Override
                    public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers,String responseBytes, java.lang.Throwable throwable ) {
                        System.out.println("faillllllllllllllllllllllllllllllllllllllllllllllllllll"+controller.dbSyncCount());

                        // TODO Auto-generated method stub
                        //                            prgDialog.hide();
                        if(statusCode == 404){
                            Toast.makeText(getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
                        }
                        else if(statusCode == 500){
                            Toast.makeText(getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet]", Toast.LENGTH_LONG).show();
                        }

                    }
                    });

                }
                 else {
                    Toast.makeText(getApplicationContext(), "SQLite and Remote MySQL DBs are in Sync!", Toast.LENGTH_LONG).show();
                }



          }
         else{
            Toast.makeText(getApplicationContext(), "No data in SQLite DB, please do enter User name to perform Sync action", Toast.LENGTH_LONG).show();
          }
}
    public void delete_receipe(View view){
        this.delete=true;

        Intent intent=new Intent(this,ViewRecipe.class);
        intent.putExtra("category","অন্যান্য");
        startActivity(intent);
    }

    public void suggest(View view){
        Intent intent=new Intent(this,SuggestRecipe.class);
        startActivity(intent);
    }

    public void grocery(View view){
        Intent intent=new Intent(this,Grocery.class);
        startActivity(intent);
    }



}
