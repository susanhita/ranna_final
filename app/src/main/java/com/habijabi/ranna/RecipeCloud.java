package com.habijabi.ranna;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
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

public class RecipeCloud extends Activity {
    RecipeDatabase controller=new RecipeDatabase(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_cloud);
        ActionBar actionBar=getActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
    }

    public void sync_recipe(View view){
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
}
