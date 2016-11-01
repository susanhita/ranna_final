
package com.habijabi.ranna;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.provider.Settings;
import android.util.Log;

/**
 * Created by susanhita on 17-01-2016.
 */

public class RecipeDatabase  extends SQLiteOpenHelper {
    private static final int DB_VERSION=7;
    private static final String DB_NAME="RecipeDatabase";

    RecipeDatabase(Context context){
        super(context,DB_NAME,null,DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE RECIPE(_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "NAME TEXT, "
                + "DESCRIPTION TEXT,"
                + "IMAGE_RESOURCE_ID TEXT,"
                + "GROCERY_LIST TEXT,"
                + "চিনি TEXT,"
                + "দুধ TEXT,"
                + "ডিম TEXT,"
                + "মাখন TEXT,"
                + "বেকিং_পাউডার TEXT,"
                + "লবণ TEXT,"
                + "আদা TEXT,"
                + "রসুন TEXT,"
                + "পেঁয়াজ TEXT,"
                + "আলু TEXT,"
                + "টমেটো TEXT,"
                + "লঙ্কা TEXT,"
                + "হলুদ TEXT,"
                + "গোটা_জিরা TEXT,"
                + "ধনে_গুঁড়া TEXT,"
                + "জিরা_গুঁড়া TEXT,"
                + "লাল_মরিচ_গুঁড়া TEXT,"
                + "লাল_মরিচ TEXT,"
                + "কালো_জিরে  TEXT,"
                + "৫_ফোড়ন TEXT,"
                + "ঘি TEXT,"
                + "পোস্ত TEXT,"
                + "নারকেল TEXT,"
                + "কাসুন্দি TEXT,"
                + "ফুলকপি  TEXT,"
                + "বাঁধাকপি  TEXT,"
                + "পটল TEXT,"
                + "শর্ষে  TEXT,"
                + "শর্ষের_তেল TEXT,"
                + "রীফাইন্ড_তেল TEXT,"
                + "মেথি  TEXT,"
                + "মৌব়ি  TEXT,"
                + "পালং_শাক TEXT,"
                + "পুইঁশাক TEXT,"
                + "গোলমরিচ TEXT,"
                + "ময়দা TEXT,"
                + "আটা TEXT,"
                + "চাল TEXT,"
                + "মুগ_ডাল TEXT,"
                + "লাউ TEXT,"
                + "শসা  TEXT,"

                + "করলা TEXT,"
                + "আখের_গুড় TEXT,"
                + "খেজুরের_গুড় TEXT,"
                + "এঁচোড় TEXT,"
                + "বেগুন TEXT,"
                + "কুমড়া  TEXT,"
                + "রুই_মাছ TEXT,"
                + "ইলিশ_মাছ TEXT,"
                + "চিংড়ি TEXT,"
                + "তেজপাতা TEXT,"
                + "এলাচ TEXT,"
                + "লবঙ্গ TEXT,"
                +"জলখাবার TEXT,"
                +"নিরামিষ TEXT,"
                +"উৎসব TEXT,"
                +"আমিষ TEXT,"
                +"মিষ্টান্ TEXT,"
                +"অন্যান্য TEXT,"
                +"পানীয TEXT,"
                +"মসুর_ডাল TEXT,"
                +"ধনেপাতা TEXT"

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

            System.out.println("aleady exisitng db");
        }


    }




}




