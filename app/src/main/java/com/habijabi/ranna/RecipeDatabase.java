
package com.habijabi.ranna;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by susanhita on 17-01-2016.
 */

public class RecipeDatabase  extends SQLiteOpenHelper {
    private static final int DB_VERSION=8;
    private static final String DB_NAME="RecipeDatabase";
     public static int j;

    RecipeDatabase(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE RECIPE(_id INTEGER PRIMARY KEY AUTOINCREMENT," //0
                + "NAME TEXT, "                                                                                                                             //1
                + "DESCRIPTION TEXT,"                                                                                                              //2
                + "IMAGE_RESOURCE_ID TEXT,"                                                                                             //3
                + "GROCERY_LIST TEXT,"                                                                                                          //4
                + "চিনি TEXT,"                                                                                                                                   //5
                + "দুধ TEXT,"                                                                                                                                      //6
                + "বেকিং_পাউডার TEXT,"                                                                                                                     //7
                + "লবণ TEXT,"                                                                                                                                   //8

              ///////
                + "ঘি TEXT,"                                                                                                                                        //9
                + "মাখন TEXT,"                                                                                                                                  //10
                + "শর্ষের_তেল TEXT,"                                                                                                                       //11
                + "রীফাইন্ড_তেল TEXT,"                                                                                                                     //12

                ///////
                + "পালং_শাক TEXT,"                                                                                                                          //13
                + "পুইঁশাক TEXT,"                                                                                                                               //14
                //////////
                + "ময়দা TEXT,"                                                                                                                                 //15
                + "আটা TEXT,"                                                                                                                                   //16
                + "চাল TEXT,"                                                                                                                                   //17

                //////
                + "আখের_গুড় TEXT,"                                                                                                                     //18
                + "খেজুরের_গুড় TEXT,"                                                                                                                  //19
                //////
                + "আদা TEXT,"                                                                                                                               //20
                + "রসুন TEXT,"                                                                                                                                  //21
                + "পেঁয়াজ TEXT,"                                                                                                                            //22
                + "আলু TEXT,"                                                                                                                                 //23
                + "টমেটো TEXT,"                                                                                                                             //24
                + "এঁচোড় TEXT,"                                                                                                                            //25
                + "বেগুন TEXT,"                                                                                                                                 //26
                + "কুমড়া  TEXT,"                                                                                                                               //27
                + "লাউ TEXT,"                                                                                                                               //28
                + "শসা  TEXT,"                                                                                                                                     //29
                + "ফুলকপি  TEXT,"                                                                                                                               //30
                + "বাঁধাকপি  TEXT,"                                                                                                                             //31
                + "পটল TEXT,"                                                                                                                                   //32
                + "করলা TEXT,"                                                                                                                                  //33
                + "নারকেল TEXT,"                                                                                                                                //34


                /////////
                + "ডিম TEXT,"                                                                                                                                   //35
                + "রুই_মাছ TEXT,"                                                                                                                            //36
                + "ইলিশ_মাছ TEXT,"                                                                                                                      //37
                + "চিংড়ি TEXT,"                                                                                                                            //38
            ////////


                +"ধনেপাতা TEXT,"                                                                                                                            //39
                + "তেজপাতা TEXT,"                                                                                                                           //40
                + "এলাচ TEXT,"                                                                                                                          //41
                + "লবঙ্গ TEXT,"                                                                                                                         //42
                + "লঙ্কা TEXT,"                                                                                                                         //43
                + "হলুদ TEXT,"                                                                                                                          //44
                + "গোটা_জিরা TEXT,"                                                                                                                         //45
                + "ধনে_গুঁড়া TEXT,"                                                                                                                            //46
                + "জিরা_গুঁড়া TEXT,"                                                                                                                           //47
                + "লাল_মরিচ_গুঁড়া TEXT,"                                                                                                                           //48
                + "লাল_মরিচ TEXT,"                                                                                                                          //49
                + "কালো_জিরে  TEXT,"                                                                                                                            //50
                + "৫_ফোড়ন TEXT,"                                                                                                                           //51
                + "শর্ষে  TEXT,"                                                                                                                            //52
                + "পোস্ত TEXT,"                                                                                                                         //53
                + "মেথি  TEXT,"                                                                                                                         //54
                + "মৌব়ি  TEXT,"                                                                                                                            //55
                + "গোলমরিচ TEXT,"                                                                                                                           //56
                + "কাসুন্দি TEXT,"                                                                                                                          //57





                /////////////////////
                +"জলখাবার TEXT,"                                                                                                                            //58
                +"নিরামিষ TEXT,"                                                                                                                            //59
                +"উৎসব TEXT," //bideshi                                                                                                                         //60
                +"আমিষ TEXT,"                                                                                                                           //61
                +"মিষ্টান্ TEXT,"                                                                                                                           //62
                +"অন্যান্য TEXT,"                                                                                                                           //63
                +"পানীয় TEXT,"                                                                                                                         //64
                +"updateStatus TEXT,"                                                                                                                           //65
                /////////////////////
                +"মসুর_ডাল TEXT,"                                                                                                                           //66
                + "মুগ_ডাল TEXT"                                                                                                                            //67


                + ");");

        //The grocery_list column will only be used in the pancake row.
        // This was done to prevent another table for grocery list

        Uri path1 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description = "\nউপকরণ\n" +
                " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                " একটি বড় বাটির মধ্যে ময়দা, চিনি, বেকিং পাউডার, বেকিং সোডা একত্রিত করুন. দুধের মধ্যে ডিম এবং মাখন ফেটান.তার মধ্যে ময়দা মিশ্রণ ঢালুন  এবং ফেটান|" +
                "মাখন দিয়ে প্যান কোট  করুন| গরম প্যানে 1/4 কাপ মিশ্রণটি ঢালুন  এবং যখন বুদবুদ দেখা যায়,একটি খুন্তি দিয়ে উল্টান| যতক্ষণ না ওপর পিঠ খয়েরি হচ্ছে, " +
                "ততক্ষণ রান্না করুন| মধুর সাথে পরিবেশন করুন|";




        insertDrink(db, "প্যানকেক", recipe_description, path1);
    }
    public static void insertDrink(SQLiteDatabase db, String name, String description, Uri image){

        ContentValues drinkValues=new ContentValues();
        drinkValues.put("NAME", name);
        drinkValues.put("DESCRIPTION", description);
        drinkValues.put("IMAGE_RESOURCE_ID", image.toString());
        drinkValues.put("GROCERY_LIST","এখন কোনো বাজারের তালিকা নেই| নতুন তালিকা বানান|");
        drinkValues.put("চিনি","YES");
        drinkValues.put("ডিম","YES");
        drinkValues.put("ময়দা", "YES");
        drinkValues.put("মাখন","YES");
        drinkValues.put("বেকিং_পাউডার","YES");
        drinkValues.put("উৎসব","YES");

        drinkValues.put("দুধ", "YES");

        db.insert("RECIPE", null, drinkValues);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //  updatemyDatabase(db, oldVersion, newVersion);
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXxxxxxxxxxxxxxxxxxXXXXold version is "+oldVersion+"\n new versioln"+newVersion);

        if ( oldVersion<7) {
            db.execSQL("ALTER TABLE RECIPE ADD জলখাবার TEXT");
            db.execSQL("ALTER TABLE RECIPE ADD উৎসব TEXT");
            db.execSQL("ALTER TABLE RECIPE ADD নিরামিষ TEXT");
            db.execSQL("ALTER TABLE RECIPE ADD আমিষ TEXT");
            db.execSQL("ALTER TABLE RECIPE ADD মিষ্টান্ TEXT");
            db.execSQL("ALTER TABLE RECIPE ADD পানীয় TEXT");
            db.execSQL("ALTER TABLE RECIPE ADD অন্যান্য TEXT");
            db.execSQL("ALTER TABLE RECIPE ADD মসুর_ডাল TEXT" );
            db.execSQL("ALTER TABLE RECIPE ADD ধনেপাতা TEXT" );

          //  db.execSQL("ALTER TABLE RECIPE MODIFY COLUMN  জলখাবার TEXT");

            if ( oldVersion==7) {
                db.execSQL("ALTER TABLE RECIPE ADD পানীয় TEXT");
            }
            System.out.println("aleady exisitng db");
        }


    }
    /**
     * Get list of Users from SQLite DB as Array List
     * @return
     */
    public ArrayList<HashMap<String, String>> getAllUsers() {

        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT  * FROM RECIPE";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);
        String[] ingtext=getColNames();
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {



                 HashMap<String, String> map = new HashMap<String, String>();

                for (int i = 1; i <= j-1; i++) {

                  map.put(ingtext[i], cursor.getString(i));

                }

                wordList.add(map);
                 cursor.moveToNext();
        }
        database.close();
        System.out.println("RecipeDatabase: getAllUsers");

        return wordList;
    }


    /**
     * Get SQLite records that are yet to be Synced
     * @return
     */
    public int dbSyncCount(){

        int count = 0;

        String selectQuery = "SELECT  * FROM RECIPE where  updateStatus is null or updatestatus='no'";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(selectQuery, null);

        count = cursor.getCount();
       // System.out.println("unooooooooooooooooooooooooooUPDATE SYNC STATUSoooooooooooooooooooooooooo"+count);
        System.out.println("RecipeDatabase: dbSyncCount"+count);

        database.close();

        return count;
    }


    /**
     * Compose JSON out of SQLite records
     * @return
     */
    public String composeJSONfromSQLite(){
        ArrayList<HashMap<String, String>> wordList;
        wordList = new ArrayList<HashMap<String, String>>();
        String selectQuery = "SELECT  * FROM  RECIPE where  updateStatus is null or updatestatus ='no'";
        SQLiteDatabase database = this.getWritableDatabase();
        String[] ingtext=getColNames();
        Cursor cursor = database.rawQuery(selectQuery, null);
        cursor.moveToFirst();
        while (cursor.isAfterLast() == false) {
                HashMap<String, String> map = new HashMap<String, String>();
                for (int i = 1; i <= j-1; i++) {
                    map.put(ingtext[i], cursor.getString(i));
                }
                wordList.add(map);
                cursor.moveToNext();
        }

        database.close();
        Gson gson = new GsonBuilder().create();
        return gson.toJson(wordList);
    }

    /**
     * Update Sync status against each User ID
     * @param name
     * @param status
     */
    public void updateSyncStatus(String name, String status){
         System.out.println("RecipeDatabase:UPDATE SYNC STATUS");

        SQLiteDatabase database = this.getWritableDatabase();
        String updateQuery = "Update RECIPE  set updateStatus = '"+ status +"' where name ="+"'"+ name +"'";
        System.out.println(updateQuery);
        database.execSQL(updateQuery);
        database.close();
    }


    /**
     * Get Sync status of SQLite
     * @return
     */
    public String getSyncStatus(){
        String msg = null;
        if(this.dbSyncCount() == 0){
            msg = "SQLite and Remote MySQL DBs are in Sync!";
        }else{
            msg = "DB Sync neededn";
        }
        return msg;
    }





    public String[] getColNames(){
        String[] ingtext=new String[1000];
        j=0;
        String columnName="PRAGMA table_info(RECIPE)";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor_colname=database.rawQuery(columnName,null);
        cursor_colname.moveToFirst();
        while (cursor_colname.isAfterLast() == false) {
            ingtext[j] = cursor_colname.getString(1);
            j++;
            cursor_colname.moveToNext();
        }
        cursor_colname.close();
        return ingtext;
    }
}








