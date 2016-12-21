
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
    private static final int DB_VERSION=9;//released with 7
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
                +"updateStatus TEXT," //65
                +"syncsts TEXT,"//66
                /////////////////////
                +"মসুর_ডাল TEXT,"                                                                                                                           //67
                + "মুগ_ডাল TEXT"                                                                                                                            //68


                + ");");

        //The grocery_list column will only be used in the pancake row.
        // This was done to prevent another table for grocery list





        insertDrink(db);
    }
    public static void insertDrink(SQLiteDatabase db){

        Uri path1 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description = "\nউপকরণ\n" +
                " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                " একটি বড় বাটির মধ্যে ময়দা, চিনি, বেকিং পাউডার, বেকিং সোডা একত্রিত করুন. দুধের মধ্যে ডিম এবং মাখন ফেটান.তার মধ্যে ময়দা মিশ্রণ ঢালুন  এবং ফেটান|" +
                "মাখন দিয়ে প্যান কোট  করুন| গরম প্যানে 1/4 কাপ মিশ্রণটি ঢালুন  এবং যখন বুদবুদ দেখা যায়,একটি খুন্তি দিয়ে উল্টান| যতক্ষণ না ওপর পিঠ খয়েরি হচ্ছে, " +
                "ততক্ষণ রান্না করুন| মধুর সাথে পরিবেশন করুন|";

        ContentValues drinkValues=new ContentValues();
        drinkValues.put("NAME", "প্যানকেক");
        drinkValues.put("DESCRIPTION", recipe_description);
        drinkValues.put("IMAGE_RESOURCE_ID", path1.toString());
        drinkValues.put("GROCERY_LIST","এখন কোনো বাজারের তালিকা নেই| নতুন তালিকা বানান|");
        drinkValues.put("চিনি","YES");
        drinkValues.put("ডিম","YES");
        drinkValues.put("ময়দা", "YES");
        drinkValues.put("মাখন","YES");
        drinkValues.put("বেকিং_পাউডার","YES");
        drinkValues.put("উৎসব","YES");

        drinkValues.put("দুধ", "YES");

        db.insert("RECIPE", null, drinkValues);
        /***************/

        Uri path2 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description2 = "\nউপকরণ\n" +
                " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                "•  এক ইঞ্চি মাপের আলু টুকরো টুকরো  কেটে রাখুন\n" +
                "•  পনেরো থেকে বিশ মিনিটের জন্য এক কাপ গরম জলে পোস্ত ভিজিয়ে রাখুন.\n" +
                "• এবার পোস্টটি এবং একটি লংকা একসাথে বাটুন\n" +
                "•  সর্ষের তেল গরম করুন এবং এতে কালোজিরে দিয়ে দিন\n" +
                "• এতে আলু দিয়ে ৫ মিনিট ভাজুন\n" +
                "• এতে পোস্তর মিশ্রণটি দিয়ে দিন, এবং কম আঁচে কিছুক্ষণ ভেজে ঢেকে রাখুন,যতক্ষণ না আলুগুলো মোটামুটি সেদ্ধ হচ্ছে\n" +
                "•  ঢাকনা খুলে ফেলুন, এবং এতে লবণ, চিনি আর চেরা কাঁচালঙ্কা দিয়ে দিন.\n" +
                "• আলু সম্পূর্ণরূপে সিদ্ধ করার জন্য আরো এক মিনিট  ধরে নাড়তে থাকুন\n" +
                "•  আলু পোস্ত রেডি";

        ContentValues drinkValues2=new ContentValues();
        drinkValues2.put("NAME", "আলু পোস্ত ");
        drinkValues2.put("DESCRIPTION", recipe_description2);
        drinkValues2.put("IMAGE_RESOURCE_ID", path2.toString());
        drinkValues2.put("কালো_জিরে","YES");
        drinkValues2.put("লঙ্কা","YES");
        drinkValues2.put("আলু", "YES");
        drinkValues2.put("শর্ষের_তেল","YES");
        drinkValues2.put("লবণ","YES");
        drinkValues2.put("নিরামিষ","YES");
        drinkValues2.put("পোস্ত", "YES");
        db.insert("RECIPE", null, drinkValues2);
        /************************/



        Uri path3 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description3 = "\nউপকরণ\n" +
                " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                "\n" +
                "করাই এ ১/২ কাপ তেল গরম করুন\n" +
                "এদিকে পেঁয়াজ,নুন,বেসন,হলুদ,লঙ্কা ফেটান\n" +
                "এক এক চামচ মিশ্রণ তুলে গরম তেলে ছেড়ে দিন \n" +
                "মাঝারি আঁচে ভাজুন |একদিকে খয়েরি হলে চপ গুলি উল্টে দিন |\n" +
                "দুদিক খয়েরি হলে, ছেঁকে তুলে নিন\n" +
                "এক কাপ চা দিয়ে পরিবেশন করুন";

        ContentValues drinkValues3=new ContentValues();
        drinkValues3.put("NAME", "পেঁয়াজি");
        drinkValues3.put("DESCRIPTION", recipe_description3);
        drinkValues3.put("IMAGE_RESOURCE_ID", path3.toString());
        drinkValues3.put("হলুদ","YES");
        drinkValues3.put("লঙ্কা","YES");
        drinkValues3.put("রীফাইন্ড_তেল", "YES");
        drinkValues3.put("পেঁয়াজ","YES");
        drinkValues3.put("লবণ","YES");
        drinkValues3.put("জলখাবার","YES");
        db.insert("RECIPE", null, drinkValues3);
        /****************/

        Uri path4 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description4 = "\nউপকরণ\n" +
                " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                "\n" +
                "১ কাপ চিনি আর তার তিন ভাগ জল দিয়ে ফোটান (রয়ে যাওয়া রসগোল্লার রস দিয়েও চলবে )\n" +
                "৩ টি শুকনো লঙ্কা আর ৩ কোয়া রসুন বাটুন এবং কাটা কাঁচা আম ও নুন  দিয়ে মাখুন\n" +
                "এগুলি চিনির  রসে দিয়ে ফোটান\n" +
                "নাড়তে নাড়তে চেখে দেখুন এবং ত্বক ঝাল মিষ্টি এডজাস্ট করুন ";

        ContentValues drinkValues4=new ContentValues();
        drinkValues4.put("NAME", "কাঁচা আমের চাটনি");
        drinkValues4.put("DESCRIPTION", recipe_description4);
        drinkValues4.put("IMAGE_RESOURCE_ID", path4.toString());
        drinkValues4.put("লাল_মরিচ","YES");
        drinkValues4.put("চিনি", "YES");
        drinkValues4.put("লবণ","YES");
        drinkValues4.put("রসুন","YES");
        drinkValues4.put("মিষ্টান্","YES");
        db.insert("RECIPE", null, drinkValues4);
        /***************/

        Uri path5 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description5 = "\nউপকরণ\n" +
                " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                "\n" +
                "বেগুন গুলি প্রেসার কুকারে সেদ্ধ করুন  এবং চটকে নিন ভালোভাবে| \n" +
                "তেল গরম করুন,তাতে ২-৩ মিনিট ধরে তেজপাতা আর পেঁয়াজ ভাজুন কম আঁচে||\n" +
                "তারপর আদা,জীরে,জীরে পাউডার,লঙ্কা গুঁড়ো দিয়ে ১ মিনিট ধরে ভাজুন|\n" +
                " এতে বেগুনগুলি দিয়ে ৩-৪ মিনিট ভেজে তাতে নারকেলকোরা, চিনি,নুন মেশান|\n" +
                "৮-১০ মিনিট কম আঁচে রান্না করুন যতক্ষণ রান্নাটি শুকনো না হয়| \n" +
                "এরপর ওপরে নারকেলকোরা দিয়ে পরিবেশন করুন|\n" +
                "পদটি মিষ্টি মিষ্টি খেতে| চেখে নুন চিনি এডজাস্ট করবেন|";

        ContentValues drinkValues5=new ContentValues();
        drinkValues5.put("NAME", "বেগুনের ঘন্টো ");
        drinkValues5.put("DESCRIPTION", recipe_description5);
        drinkValues5.put("IMAGE_RESOURCE_ID", path5.toString());
        drinkValues5.put("শর্ষের_তেল","YES");
        drinkValues5.put("চিনি", "YES");
        drinkValues5.put("লবণ","YES");
        drinkValues5.put("গোটা_জিরা","YES");
        drinkValues5.put("আদা","YES");
        drinkValues5.put("পেঁয়াজ","YES");
        drinkValues5.put("বেগুন","YES");
        drinkValues5.put("নারকেল","YES");
        drinkValues5.put("তেজপাতা","YES");
        drinkValues5.put("জিরা_গুঁড়া","YES");
        drinkValues5.put("লাল_মরিচ_গুঁড়া","YES");
        drinkValues5.put("নিরামিষ","YES");
        db.insert("RECIPE", null, drinkValues5);
        /***************/

        Uri path6 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description6 = "\nউপকরণ\n" +
                " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                "\n" +
                "ডিম সেদ্ধ করে রাখুন।তেল গরম করে সেদ্ধ ডিমগুলি  সাবধানে লাল করে ভেজে নিন \n" +
                "পেঁয়াজ ভেজে লাল করুন।এতে একটু চিনি দিতে পারেন ।\n" +
                " তাতে  আদা, রসুন,কাঁচা লঙ্কা বাটা দিন ।\n" +
                "২-৩ মিনিট ভেজে তাতে হলুদ,ধনে,লঙ্কা গুঁড়ো দিন ।\n" +
                "মসলাগুলো খয়েরি খয়েরি হয়ে গেলে, এবং তেল ছাড়লে তাতে টমেটো দিন।\n" +
                "এক কাপ জল দিয়ে রান্না করুন যতক্ষন না আবার শুকনো হচ্ছে |\n" +
                "এতে এবার মটরশুঁটি ,গরম মশলা এবং ১ চামচ চিনি দিতে পারেন  |\n" +
                "এবার ১ কাপ জল দিয়ে ফোটান।ঝোল কতটা লাগবে বুঝে গ্যাস অফ করুন ";

        ContentValues drinkValues6=new ContentValues();
        drinkValues6.put("NAME", "ডিমের ঝোল");
        drinkValues6.put("DESCRIPTION", recipe_description6);
        drinkValues6.put("IMAGE_RESOURCE_ID", path6.toString());
        drinkValues6.put("রীফাইন্ড_তেল","YES");
        drinkValues6.put("চিনি", "YES");
        drinkValues6.put("লবণ","YES");
        drinkValues6.put("আলু","YES");
        drinkValues6.put("আদা","YES");
        drinkValues6.put("পেঁয়াজ","YES");
        drinkValues6.put("রসুন","YES");
        drinkValues6.put("টমেটো","YES");
        drinkValues6.put("ডিম","YES");
        drinkValues6.put("হলুদ","YES");
        drinkValues6.put("লাল_মরিচ_গুঁড়া","YES");
        drinkValues6.put("ধনে_গুঁড়া","YES");
        drinkValues6.put("আমিষ","YES");

        db.insert("RECIPE", null, drinkValues6);
        /***************/

        Uri path7 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description7 = "\nউপকরণ\n" +
                " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                "\n" +
                "\n" +
                "কুমরো চৌকো চৌকো করে কেটে রাখুন ।\n" +
                "কড়াইতে তেল গরম করুন এবং ওতে হিং, মেথি দিন (৫ ফোড়ন দিলেও চলবে), শুকনো লঙ্কা দিন।\n" +
                " এবার ওতে কুমড়োগুলি দিয়ে হলুদ,নুন,লঙ্কা গুঁড়ো দিন।\n" +
                "ভালো করে মিশিয়ে আঁচ কমিয়ে নাড়তে থাকুন।\n" +
                "কুমড়ো গুলি রান্না হয়ে গেলে নামিয়ে দিন ।";

        ContentValues drinkValues7=new ContentValues();
        drinkValues7.put("NAME", "কুমড়োর তরকারি ");
        drinkValues6.put("DESCRIPTION", recipe_description7);
        drinkValues6.put("IMAGE_RESOURCE_ID", path6.toString());

        drinkValues7.put("কুমড়া", "YES");
        drinkValues7.put("লবণ","YES");
        drinkValues7.put("লাল_মরিচ","YES");
        drinkValues7.put("৫_ফোড়ন","YES");
        drinkValues7.put("নিরামিষ","YES");
        drinkValues7.put("হলুদ","YES");
        drinkValues7.put("লাল_মরিচ_গুঁড়া","YES");


        db.insert("RECIPE", null, drinkValues7);
        /***************/

        Uri path8 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description8 = "\nউপকরণ\n" +
                " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                "\n" +
                "\n" +
                "বেগুনগুলি গোল গোল করে কাটুন।\n" +
                "ওতে নুন হলুদ মাখন।\n" +
                "করে এ তেল গরম করুন।\n" +
                "মাঝারি আঁচে এপিঠ ওপিঠ ভেজে নিন।\n" +
                "খেয়াল থাকে, বেগুন ভাজতে বেশ অনেকটা তেল লাগে ।";

        ContentValues drinkValues8=new ContentValues();
        drinkValues8.put("NAME", "বেগুন ভাজা  ");
        drinkValues8.put("DESCRIPTION", recipe_description8);
        drinkValues8.put("IMAGE_RESOURCE_ID", path8.toString());

        drinkValues8.put("বেগুন", "YES");
        drinkValues8.put("লবণ","YES");
        drinkValues8.put("নিরামিষ","YES");
        drinkValues8.put("হলুদ","YES");


        db.insert("RECIPE", null, drinkValues8);
        /***************/

        Uri path9 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description9 = "\nউপকরণ\n" +
                " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                "\n" +
                "\n" +
                "আলু, ফুলকপি এক সাইজ এ কেটে রাখুন ।\n" +
                "এবার আলু, ফুলকপি, সর্ষে বাটা, লঙ্কা কুচি, নুন -হলুদ দিয়ে প্রেসার কুকারে ২ টি সিটি দিন।\n" +
                "ব্যাস";

        ContentValues drinkValues9=new ContentValues();
        drinkValues9.put("NAME", "ফুলকপির বাটিঝাল ");
        drinkValues9.put("DESCRIPTION", recipe_description9);
        drinkValues9.put("IMAGE_RESOURCE_ID", path9.toString());
        drinkValues9.put("শর্ষে", "YES");
        drinkValues9.put("আলু", "YES");
        drinkValues9.put("ফুলকপি", "YES");
        drinkValues9.put("লবণ","YES");
        drinkValues9.put("নিরামিষ","YES");
        drinkValues9.put("হলুদ","YES");

        db.insert("RECIPE", null, drinkValues9);
       /***************/

        Uri path10 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description10 = "\nউপকরণ\n" +
                "এক চামচ সর্ষের তেলে, ১/২ চামচ ৫ ফোড়ন দিন।\n" +
                "ফোড়ন এর মৌরি জীরে গুলো একটু ভাজা ভাজ হলেই, ওতে আদা কুচি ও শুকনো লঙ্কা কুচি  দিন। \n" +
                "এবার টমেটো  গুলি দিয়ে দিন।\n" +
                "এবং নুন ছিটিয়ে কড়াইটি ঢাকা দিয়ে আঁচ কমিয়ে দিন।\n" +
                "৫ মিনিট অন্তর অন্তর টমেটোগুলি নাড়িয়ে ঢাকা দিন যতক্ষণ না  শুকিয়ে আসছে।\n" +
                "এরপর এতে চিনি দিয়ে দিন। (রসগোল্লার পরে থাকা রস দিতেও পারেন)\n" +
                "চাটনি শুকিয়ে আসলে, ওতে চাইলে ১/৪ কোয়া  লেবু চিপে নামিয়ে দিন।";

        ContentValues drinkValues10=new ContentValues();
        drinkValues10.put("NAME", "টমেটোর চাটনি ");
        drinkValues10.put("DESCRIPTION", recipe_description10);
        drinkValues10.put("IMAGE_RESOURCE_ID", path10.toString());
        drinkValues10.put("চিনি", "YES");
        drinkValues10.put("টমেটো", "YES");
        drinkValues10.put("৫_ফোড়ন", "YES");
        drinkValues10.put("আদা","YES");
        drinkValues10.put("মিষ্টান্","YES");
        drinkValues10.put("লাল_মরিচ","YES");
        drinkValues10.put("লবণ","YES");
        drinkValues10.put("শর্ষের_তেল","YES");


        db.insert("RECIPE", null, drinkValues10);
        /***************/

        Uri path11 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description11 = "\nউপকরণ\n" +
                " বড়ি গুলো ভেজে রাখুন।\n" +
                "লাউ চৌকো করে কেটে রাখুন। টমেটো কেটে রাখুন।\n" +
                "তেল গরম  করে  জীরে আর তেজ পাতা দিন। জীরে একটু ভাজা হলেই, এতে টমেটো আর কাঁচা লঙ্কা দিয়ে দিন। টমেটো থেকে বেরুনো জল শুকিয়ে আসলে পরে লাউগুলি  দিয়ে দিন।\n" +
                "এতে আদা কুচি,নুন-হলুদ, জীরে গুঁড়ো, লঙ্কা গুঁড়ো দিয়ে কষতে থাখুন।\n" +
                "সব মসলা মিশে গেলে ঢাকা দিয়ে দিন।(জল একদম দেবেন না, লাউ থেকে প্রচুর জল বেরোয়)।\n" +
                "মোটামুটি শুকিয়ে আসলে ওতে চিনি দিন।\n" +
                "এবার বড়ি গুলি গুঁড়িয়ে ছড়িয়ে দিয়ে পরিবেশন করুন ।";

        ContentValues drinkValues11=new ContentValues();
        drinkValues11.put("NAME", "লাউ বড়ি ");
        drinkValues11.put("DESCRIPTION", recipe_description11);
        drinkValues11.put("IMAGE_RESOURCE_ID", path11.toString());
        drinkValues11.put("চিনি", "YES");
        drinkValues11.put("লাউ", "YES");
        drinkValues11.put("গোটা_জিরা", "YES");
        drinkValues11.put("লবণ","YES");
        drinkValues11.put("নিরামিষ","YES");
        drinkValues11.put("হলুদ","YES");
        drinkValues11.put("টমেটো", "YES");
        drinkValues11.put("লঙ্কা", "YES");
        drinkValues11.put("আদা","YES");
        drinkValues11.put("লাল_মরিচ_গুঁড়া","YES");
        drinkValues11.put("জিরা_গুঁড়া","YES");




        db.insert("RECIPE", null, drinkValues11);
        /***************/

        Uri path12 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description12 = "\nউপকরণ\n" +
                "২ জনের মতো নুডলস \n" +
                "১ টি ক্যাপসিকাম\n" +
                "২ টি লঙ্কা\n" +
                "৪ কোয়া রসুন\n" +
                "২-৩ বিনস\n" +
                "১/৪ বাঁধাকপি\n" +
                "১ টি ডিম\n" +
                "২ টি সসেজ\n" +
                "২ টি পেঁয়াজ\n" +
                "১ চামচ সোয়া সস\n" +
                "১ চামচ ভিনিগার \n" +
                "১ চামচ গোলমরিচ\n" +
                "১/২ চামচ গরম মসলা(চিনেরা গরম মসলাকে বলে ফাইভ -স্পাইস  পাউডার  五香粉)\n" +
                "\n" +
                "নুডল  সেদ্ধ  করে রাখুন । এক্কেবারে নরম হওয়ার আগেই জল থেকে ছেঁকে নেবেন। .তেল দিয়ে একটি পাত্রে রাখুন। এতে নুডল গুলি ছাড়া ছাড়া থাকবে ।\n" +
                "\n" +
                "কড়াইয়ে একটু তেল নিন । গরম হলে তার  ওপর ডিম ভাগুন। খুন্তি দিয়ে ঘেঁটে দিন। ভাজা হয়ে গেলে খুন্তি দিয়ে কুচি কুচি করে দিন ।\n" +
                "\n" +
                "মাংস সেদ্ধ লম্বা লম্বা করে ছিঁড়ে নিন। অথবা সসেজ থাকলে ছোট ছোট করে কেটে কেটে ভেজে নিন । \n" +
                " \n" +
                "ক্যাপসিকাম, বাঁধাকপি, বিনস, পেয়াঁজ,  লঙ্কা  লম্বা লম্বা করে কেটে রাখুন ।\n" +
                "সব সবজি এবং রসুন  একটু তেলে ভেজে  নিন ২ মিনিট.  বেশিক্ষন ভাজবেন না ।\n" +
                " এবার এতে ডিম্, মাংস দিয়ে সোয়া সস, নুন, ১/২ চামচ চিনি, ভিনেগার, গোলমরিচ,  দিয়ে ২-৩ মিনিট ভাজুন । ১/২ চামচ গরম মসলা দিয়ে দিন।\n" +
                "\n" +
                "তারপর নুডলস  দিয়ে দিন।১ মিনিট সাবধানে ভাজুন। কড়াই ভারী হয়ে যাবে । দুটি খুঁটি ব্যবহার করতে পারেন ।\n" +
                "\n" +
                "পরিবেশন করুন।";

        ContentValues drinkValues12=new ContentValues();
        drinkValues12.put("NAME", "হাক্কা নুডল ");
        drinkValues12.put("DESCRIPTION", recipe_description12);
        drinkValues12.put("IMAGE_RESOURCE_ID", path12.toString());
        drinkValues12.put("চিনি", "YES");
        drinkValues12.put("রীফাইন্ড_তেল", "YES");
        drinkValues12.put("রসুন","YES");
        drinkValues12.put("পেঁয়াজ","YES");
        drinkValues12.put("বাঁধাকপি","YES");
        drinkValues12.put("ডিম","YES");
        drinkValues12.put("লঙ্কা","YES");
        drinkValues12.put("গোলমরিচ","YES");
        drinkValues12.put("উৎসব","YES");
        drinkValues12.put("লবণ","YES");


        db.insert("RECIPE", null, drinkValues12);

        /***************/

        Uri path13 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description13 = "\nউপকরণ\n" +
                " ৫০০গ্রা চিংড়ি\n" +
                "দেড় কাপ বাসমতী চাল\n" +
                "১ দারুচিনি, ৩-৪  লবঙ্গ ও এলাচ ও গোটা গোলমরিচ\n" +
                "২ মুঠো কাজুবাদাম \n"+
                "১ চামচ আদা\n" +
                "৪ কাঁচালঙ্কা \n" +
                "১  চামচ জিরা গুঁড়া \n" +
                "১ চা  লাল মরিচ গুঁড়া\n" +
                "৩ পাকা টমেটো \n" +
                "এক বড় পেঁয়াজ \n ১  কাপ নারকেলকোরা\n ১ কপি দই \n" +
                "৪ চামচ তেল" +
                "জলে দারচিনি, এলাচ, লবঙ্গ দিয়ে চাল সেদ্ধ করুন।\n" +
                "ভাত একটু কাঁচা থাকলেই নামিয়ে নিন ।\n" +
                "\n" +
                "আদা আর লঙ্কা বেটে রাখুন।টমেটো কেটে রাখুন\n" +
                "কাজু বাদাম ভেজে রাখুন । পেঁয়াজ গোল গোল করে কেটে  ভেজে আলাদা রাখুন  ।\n" +
                "এবার কড়াইয়ে   আদা লঙ্কা  দিয়ে ভাজুন ২ মিনিট।\n" +
                "ওতে টমেটো, লঙ্কা গুঁড়ো  ও জীরে গুঁড়ো দিয়ে আরও ভাজুন যতক্ষণ না টমেটো গুলো পেস্ট হয়ে যাচ্ছে ।\n" +
                "\n" +
                "দই ফেটিয়ে নিন। এবার নারকেলকোরা ও দই মিশিয়ে দিন কড়াইয়ে ।\n" +
                "করাইনাড়তে থাকতে খাকুন যতক্ষণ না মিশ্রণটি   শুকিয়ে আসছে ।\n" +
                "\n" +
                "এবার চিংড়ি গুলি দিয়ে দিন এবং জল ও নুন  দিয়ে ৫ মিনিট কম আঁচে ফোটান।\n" +
                "এবার একটি চিংড়ি  খুঁটি দিয়ে কেটে দেখুন সেদ্ধ হয়েছে কিনা ।\n" +
                "\n" +
                "এর  পর ভাত , কাজ, ভাজা পেঁয়াজ, ও চিংড়ি   মসলা মিশিয়ে নিন । একটু ঘি দিতে পারেন।\n" +
                "\n" +
                "ব্যাস চিংড়ি  বিরিয়ানি তৈরী!\n";

        ContentValues drinkValues13=new ContentValues();
        drinkValues13.put("NAME", "চিংড়ি বিরিয়ানি ");
        drinkValues13.put("DESCRIPTION", recipe_description13);
        drinkValues13.put("IMAGE_RESOURCE_ID", path13.toString());
        drinkValues13.put("রীফাইন্ড_তেল", "YES");
        drinkValues13.put("চাল", "YES");
        drinkValues13.put("আদা", "YES");
        drinkValues13.put("পেঁয়াজ", "YES");
        drinkValues13.put("টমেটো", "YES");
        drinkValues13.put("নারকেল", "YES");
        drinkValues13.put("চিংড়ি", "YES");
        drinkValues13.put("এলাচ", "YES");
        drinkValues13.put("লবঙ্গ", "YES");
        drinkValues13.put("লঙ্কা", "YES");
        drinkValues13.put("জিরা_গুঁড়া","YES");
        drinkValues13.put("লাল_মরিচ_গুঁড়া","YES");
        drinkValues13.put("আমিষ","YES");

        db.insert("RECIPE", null, drinkValues13);

        /***************/

        Uri path14 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description14 = "\nউপকরণ\n" +
                " 250g পটল  \n2 লঙ্কা \n 3-4 এলাচ,লবঙ্গ\n  1 চামচ আদা\n \n" +
                "\n" +
                "\n" +
                "পটলের খোসা ছাড়িয়ে দুদিকে চিঁড়ে দিন। ওগুলো ভেজে তুলে নিন।\n" +
                "\n" +
                "\n" +
                "এবার 1 চামচ তেলে জিড়ে, গোটা গরম মশলা , হিং, তেজপাতা ফোড়ন দিন।\n" +
                "\n" +
                "\n" +
                " এবার আদা বাটা, লঙ্কা দিয়ে ভাজুন। তারপর দই দিয়ে দিন।\n" +
                "এবার নুন ,চিনি, কিসমিস দেবেন \n" +
                "শেষে পটলগুলো দিয়ে সব মিলিয়ে নামিয়ে নিন।\n";

        ContentValues drinkValues14=new ContentValues();
        drinkValues14.put("NAME", "দই পটল");
        drinkValues14.put("DESCRIPTION", recipe_description14);
        drinkValues14.put("IMAGE_RESOURCE_ID", path14.toString());
        drinkValues14.put("লঙ্কা", "YES");
        drinkValues14.put("এলাচ", "YES");
        drinkValues14.put("লবঙ্গ", "YES");
        drinkValues14.put("লঙ্কা", "YES");
        drinkValues14.put("লবণ","YES");
        drinkValues14.put("নিরামিষ","YES");
        drinkValues14.put("গোটা_জিরা", "YES");
        drinkValues14.put("পটল", "YES");
        drinkValues14.put("তেজপাতা", "YES");
        drinkValues14.put("চিনি", "YES");
        drinkValues14.put("রীফাইন্ড_তেল", "YES");
        db.insert("RECIPE", null, drinkValues14);
        /***************/

        Uri path15 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description15 = "\nউপকরণ\n" +
                " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                "\n" +
                "\n" +
                "আলু হালকা ভেজে তুলে নিন।\n" +
                "অল্প তেলে পেঁয়াজ ভেজে লাল করুন। এর পর ওতে আদা-রসুন বাটা দিন।\n" +
                "ভাজুন যতক্ষণ না সমস্ত মিশ্রণটি ভাজা হচ্ছে।এতে টমেটো দিয়ে দিন ।\n" +
                "এবার এতে হলুদ, নুন, কাশ্মীরি মির্চ  ও দম মসলা বা চিকেন মসলা দিয়ে ভাজুন ।\n" +
                "জলে তেজপাতা ও চিনি  দিয়ে সেদ্ধ করুন যতক্ষণ না আলুগুলো সেদ্ধ হচ্ছে।\n" +
                "যদি তলায় মসলা আটকিয়ে যে, তাহলে একটু খুঁটি চালিয়ে দিন।\n" +
                "মাখা মাখা হয়ে এলে করাই নামিয়ে নিন ।";

        ContentValues drinkValues15=new ContentValues();
        drinkValues15.put("NAME", "আলুর দম");
        drinkValues15.put("DESCRIPTION", recipe_description15);
        drinkValues15.put("IMAGE_RESOURCE_ID", path15.toString());
        drinkValues15.put("আলু", "YES");
        drinkValues15.put("তেজপাতা", "YES");
        drinkValues15.put("লঙ্কা", "YES");
        drinkValues15.put("চিনি", "YES");
        drinkValues15.put("রীফাইন্ড_তেল", "YES");
        drinkValues15.put("পেঁয়াজ", "YES");
        drinkValues15.put("টমেটো", "YES");
        drinkValues15.put("লবণ","YES");
        drinkValues15.put("নিরামিষ","YES");
        drinkValues15.put("হলুদ","YES");

        db.insert("RECIPE", null, drinkValues15);
        //TODO

        /********/

        Uri path16 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description16 = "\nউপকরণ\n৩ আলু \n" +
                "১ বাঁধাকপি কুচি করে কাটা\n" +
                "তেজপাতা, ৫ ফোড়ন\n" +
                "নুন ১ চা \n" +
                "হলুদ ১ চা \n" +
                "মটরশুঁটি ১ কাপ \n" +
                "আদাবাটা ১ চা \n" +
                "রসুনবাটা ১/২ চা \n" +
                " আলু ভেজে তুলে রাখুন।\n" +
                "অল্প তেলে তেজপাতা,৫ ফোড়ন  আদা,রসুন,লঙ্কা  বাটা ভাজুন।\n" +
                "সম্পূর্ণ ভাজা হয়ে গেলে বাঁধাকপি কুচি দিয়ে দিন।\n" +
                "এর পরে আলু,মটর,জীরে গুঁড়ো, ধোনে , লঙ্কাগুঁড়ো, নুন-হলুদ দিয়ে দিন।\n" +
                "সবকিছু কষতে থাকুন যতক্ষণ না জল বেরিয়ে অর্ধেক হয়ে যাচ্ছে।\n" +
                "আলু সম্পূর্ণ সেদ্ধ হলে নামিয়ে নিন।";

        ContentValues drinkValues16=new ContentValues();
        drinkValues16.put("NAME", "বাঁধাকপির ঘন্ট");
        drinkValues16.put("DESCRIPTION", recipe_description16);
        drinkValues16.put("IMAGE_RESOURCE_ID", path16.toString());
        drinkValues16.put("রসুন","YES");
        drinkValues16.put("আলু", "YES");
        drinkValues16.put("আদা","YES");
        drinkValues16.put("লবণ","YES");
        drinkValues16.put("নিরামিষ","YES");
        drinkValues16.put("হলুদ","YES");
        drinkValues16.put("তেজপাতা", "YES");
        drinkValues16.put("জিরা_গুঁড়া","YES");
        drinkValues16.put("লাল_মরিচ_গুঁড়া","YES");
        drinkValues16.put("৫_ফোড়ন", "YES");
        drinkValues16.put("ধনে_গুঁড়া","YES");



        db.insert("RECIPE", null, drinkValues16);

        /***************/

        Uri path17 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description17 = "\nউপকরণ\n" +
                " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                "\n" +
                "\n" +
                "মুরগির মাংস নুন-হলুদ মাখিয়ে (১/২  থেকে ২ ঘন্টা) মেরিনেট করুন।\n" +
                "আলু ভেজে আলাদা রাখুন।\n" +
                "পেয়াঁজ ভেজে আলাদা রাখুন\n" +
                "প্রেসার কুকারে/কড়াইয়ে অল্প তেলে টমেটো ভাজুন যতক্ষণ না সম্পূর্ণ ভাজা হচ্ছে (মোটামুটি ৫ মিন)।\n" +
                "এবার এতে আদাবাটা,রসুনবাটা,লঙ্কা বাটা  ও একটি তেজপাতা দিয়ে দিন।\n" +
                "এর পর চিকেন মসলা (না থাকলে জীরে গুঁড়ো ,ধোনে গুঁড়ো,নুন-হলুদ, লঙ্কাগুঁড়ো ও গরম মসলা দিতে পারেন) দিয়ে দিন।\n" +
                "মসলা ভাজা হয়ে গেলে আলু দিয়ে কিছুক্ষন কোষে , মুরগি পিসগুলি  দিয়ে দিন।\n" +
                "মুরগি থেকে জল বেরুবে সেই জল শুকিয়ে গেলে, ২ কাপ জল দিয়ে সেদ্ধ করুন বা প্রেসার কুকারে ২ টি সিটি দিন।";

        ContentValues drinkValues17=new ContentValues();
        drinkValues17.put("NAME", "চিকেন কশা ");
        drinkValues17.put("DESCRIPTION", recipe_description17);
        drinkValues17.put("IMAGE_RESOURCE_ID", path17.toString());
        drinkValues17.put("টমেটো", "YES");
        drinkValues17.put("আলু", "YES");
        drinkValues17.put("রসুন","YES");
        drinkValues17.put("লবণ","YES");
        drinkValues17.put("আদা","YES");
        drinkValues17.put("হলুদ","YES");
        drinkValues17.put("ধনে_গুঁড়া","YES");
        drinkValues17.put("লাল_মরিচ_গুঁড়া","YES");
        drinkValues17.put("তেজপাতা", "YES");
        drinkValues17.put("জিরা_গুঁড়া","YES");
        drinkValues17.put("আমিষ","YES");
        drinkValues17.put("পেঁয়াজ", "YES");
        drinkValues17.put("লঙ্কা", "YES");







        db.insert("RECIPE", null, drinkValues17);
        /***************/

        Uri path18 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description18 = "\nউপকরণ\n" +
                " মাছগুলি ধুয়ে নুন হলুদ দিয়ে ভেজে নিন।\n" +
                "আলু  নুন হলুদ দিয়ে  ভেজে আলাদা রাখুন।\n" +
                "পেয়াঁজ লাল হওয়া অব্দি ভাজুন। তারপর ওতে চিনি  চামচ দিয়ে দিন । চিনি গলে  লেগে গেলে নামিয়ে নিন । আলাদা রাখুন।\n" +
                " প্রেসার কুকারে/কড়াইয়ে অল্প তেলে টমেটো ভাজুন যতক্ষণ না সম্পূর্ণ ভাজা হচ্ছে (মোটামুটি ৫ মিন)।\n" +
                "এবার এতে আদাবাটা,লঙ্কা বাটা  ও একটি তেজপাতা দিয়ে দিন।\n" +
                "তারপর দিন নুন-হলুদ, জীরে গুঁড়ো ও একটু গরম মসলা আর আলু দিয়ে কষতে থাকুন ।\n" +
                "মসলা ভাজা হয়ে গেলে মাছ দিয়ে দিন। ১/২ চামচ চিনি দেবেন। জল দিয়ে ফুটিয়ে নিন।\n" +
                "আলু সেদ্ধ হয়ে এলে নামিয়ে নিন।\n";

        ContentValues drinkValues18=new ContentValues();
        drinkValues18.put("NAME", "রুই মাছের কালিয়া");
        drinkValues18.put("DESCRIPTION", recipe_description18);
        drinkValues18.put("IMAGE_RESOURCE_ID", path18.toString());
        drinkValues18.put("রুই_মাছ ", "YES");
        drinkValues18.put("আলু", "YES");
        drinkValues18.put("পেঁয়াজ", "YES");
        drinkValues18.put("লবণ","YES");
        drinkValues18.put("আমিষ","YES");
        drinkValues18.put("হলুদ","YES");
        drinkValues18.put("জিরা_গুঁড়া","YES");
        drinkValues18.put("তেজপাতা", "YES");
        drinkValues18.put("আদা","YES");
        drinkValues18.put("টমেটো", "YES");
        drinkValues18.put("চিনি", "YES");
        drinkValues18.put("লঙ্কা", "YES");



        db.insert("RECIPE", null, drinkValues18);
        /***************/

        Uri path19 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description19 = "\nউপকরণ\n৭০০G -১KG ইলিশ মাছ\n" +
                "১/২ কাপ সর্ষে\n" +
                "১ চামচ নুন\n" +
                "১/২ চামচ হলুদ\n" +
                "৪ টি  লঙ্কা" +
                "কলাপাতা চার ইঞ্চি বাই চার ইঞ্চি  (অথবা মাছের সাইজ  অনুযায়ী) কেটে  রাখুন।  \n" +
                "হলুদ,নুন,লঙ্কা   ও শর্ষে  একসাথে পিষে রাখুন।\n" +
                "ইলিশ মাছ ধুয়ে ওতে নুন-হলুদ-সর্ষে-লঙ্কা  বাটা মাখান।\n" +
                "এর পর প্রতিটি মাছ কলাপাতা তে রেখে সুতো দিয়ে বেঁধে দিন।\n" +
                "প্রেসার কোকের এ এককাপ জল দিন। \n" +
                "এবার একটি সেপারেটর  বা ইডলি  মেকার বা স্টীমার এ  এক এক করে সব মাছ গুলি দিয়ে দিন।\n" +
                "২ টি সিটি দিয়ে নামিয়ে নিন।\n";

        ContentValues drinkValues19=new ContentValues();
        drinkValues19.put("NAME", "ইলিশ পাতুরি");
        drinkValues19.put("DESCRIPTION", recipe_description19);
        drinkValues19.put("IMAGE_RESOURCE_ID", path19.toString());
        drinkValues19.put("শর্ষে", "YES");
        drinkValues19.put("লঙ্কা", "YES");
        drinkValues19.put("লবণ","YES");
        drinkValues19.put("আমিষ","YES");
        drinkValues19.put("হলুদ","YES");

        db.insert("RECIPE", null, drinkValues19);
        /***************/

        Uri path20 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description20 = "\nউপকরণ\n" +
                " ১ টি নারকেল কোরানো\n" +
                "১/২ কাপ গুড়\n" +
                "২ কাপ চালের  গুঁড়ো\n" +
                "৫০০ লি দুধ \n" +
                "\n" +
                "কড়াই তে  গুড় ওর সামান্য জল দিয়ে ১ মিন ফোটান ।\n" +
                "এবার এতে নারকেলকোরা  দিয়ে দিন।\n" +
                "নাড়তে থাকুন যতক্ষণ না মিশ্রণটি সম্পূর্ণ খয়েরি হচ্ছে ।\n" +
                "চালের গুঁড়ো মেচে ছোট ছোট লেচি তৈরী করুন।\n" +
                "লুচির সাইজে বেলে , এতে নারকেলের পুর দিয়ে , ধারগুলো এঁটে দিন।\n" +
                "\n" +
                "দুধ এ ৫ চামচ চিনি দিয়ে , পীঠে গুলি দিয়ে দিন।\n" +
                "১৫-২০ মিন কম আঁচে ফোটান ।\n" +
                "নামিয়ে নিন ";

        ContentValues drinkValues20=new ContentValues();
        drinkValues20.put("NAME", "দুধ পুলি পীঠে");
        drinkValues20.put("DESCRIPTION", recipe_description20);
        drinkValues20.put("IMAGE_RESOURCE_ID", path20.toString());
        drinkValues20.put("দুধ", "YES");
        drinkValues20.put("চিনি","YES");
        drinkValues20.put("মিষ্টান্","YES");
        drinkValues20.put("নারকেল", "YES");
        drinkValues20.put("আখের_গুড় ","YES");

        db.insert("RECIPE", null, drinkValues20);
        /***************/

        Uri path21 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
        String recipe_description21 = "\nউপকরণ\nকাঁচা আম\n" +
                "৪ চামচ চিনি\n" +
                "বিট নুন\n" +
                "জীরে গুঁড়ো " +
                "কাঁচা আমে কয়েকটা ফুটো করুন\n" +
                "এবার আগুনে ঝলসে নিন(১০ মিন)\nজীরে ভেজে গুড়িয়ে নিন \n" +
                "আমটি ঠান্ডা হলে, পড়া খোসাটি ছাড়িয়ে নিন।\n" +
                "এবার আমটি চটকে আঁটি টি বাদ দিন।\n" +
                "ওতে বিট নুন, জীরে ভাজা গুঁড়ো দিন। চিনি দিন পরিমান মতো( বেশি টক হলে বেশি চিনি বাড়বে)\n" +
                " ঘটনি দিয়ে কিংবা  মিক্সিতে  জল দিয়ে মিশ্রণটি মিশিয়ে মোলায়েম করে নিন।\n" +
                "পরিবেশন করুন(বরফ দিতে পারেন)";

        ContentValues drinkValues21=new ContentValues();
        drinkValues21.put("NAME", "আম পোড়া শরবত");
        drinkValues21.put("DESCRIPTION", recipe_description21);
        drinkValues21.put("IMAGE_RESOURCE_ID", path21.toString());
        drinkValues21.put("চিনি","YES");
        drinkValues21.put("পানীয় ","YES");
        drinkValues21.put("গোটা_জিরা ","YES");

        db.insert("RECIPE", null, drinkValues20);
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


            if ( oldVersion<10) {
                db.execSQL("ALTER TABLE RECIPE ADD syncsts TEXT");
                db.execSQL("ALTER TABLE RECIPE ADD updateStatus TEXT");
                Uri path2 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
                String recipe_description2 = "\nউপকরণ\n" +
                        " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                        "•  এক ইঞ্চি মাপের আলু টুকরো টুকরো  কেটে রাখুন\n" +
                        "•  পনেরো থেকে বিশ মিনিটের জন্য এক কাপ গরম জলে পোস্ত ভিজিয়ে রাখুন.\n" +
                        "• এবার পোস্টটি এবং একটি লংকা একসাথে বাটুন\n" +
                        "•  সর্ষের তেল গরম করুন এবং এতে কালোজিরে দিয়ে দিন\n" +
                        "• এতে আলু দিয়ে ৫ মিনিট ভাজুন\n" +
                        "• এতে পোস্তর মিশ্রণটি দিয়ে দিন, এবং কম আঁচে কিছুক্ষণ ভেজে ঢেকে রাখুন,যতক্ষণ না আলুগুলো মোটামুটি সেদ্ধ হচ্ছে\n" +
                        "•  ঢাকনা খুলে ফেলুন, এবং এতে লবণ, চিনি আর চেরা কাঁচালঙ্কা দিয়ে দিন.\n" +
                        "• আলু সম্পূর্ণরূপে সিদ্ধ করার জন্য আরো এক মিনিট  ধরে নাড়তে থাকুন\n" +
                        "•  আলু পোস্ত রেডি";

                ContentValues drinkValues2=new ContentValues();
                drinkValues2.put("NAME", "আলু পোস্ত ");
                drinkValues2.put("DESCRIPTION", recipe_description2);
                drinkValues2.put("IMAGE_RESOURCE_ID", path2.toString());
                drinkValues2.put("কালো_জিরে","YES");
                drinkValues2.put("লঙ্কা","YES");
                drinkValues2.put("আলু", "YES");
                drinkValues2.put("শর্ষের_তেল","YES");
                drinkValues2.put("লবণ","YES");
                drinkValues2.put("নিরামিষ","YES");
                drinkValues2.put("পোস্ত", "YES");
                db.insert("RECIPE", null, drinkValues2);
                /************************/



                Uri path3 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
                String recipe_description3 = "\nউপকরণ\n" +
                        " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                        "\n" +
                        "করাই এ ১/২ কাপ তেল গরম করুন\n" +
                        "এদিকে পেঁয়াজ,নুন,বেসন,হলুদ,লঙ্কা ফেটান\n" +
                        "এক এক চামচ মিশ্রণ তুলে গরম তেলে ছেড়ে দিন \n" +
                        "মাঝারি আঁচে ভাজুন |একদিকে খয়েরি হলে চপ গুলি উল্টে দিন |\n" +
                        "দুদিক খয়েরি হলে, ছেঁকে তুলে নিন\n" +
                        "এক কাপ চা দিয়ে পরিবেশন করুন";

                ContentValues drinkValues3=new ContentValues();
                drinkValues3.put("NAME", "পেঁয়াজি");
                drinkValues3.put("DESCRIPTION", recipe_description3);
                drinkValues3.put("IMAGE_RESOURCE_ID", path3.toString());
                drinkValues3.put("হলুদ","YES");
                drinkValues3.put("লঙ্কা","YES");
                drinkValues3.put("রীফাইন্ড_তেল", "YES");
                drinkValues3.put("পেঁয়াজ","YES");
                drinkValues3.put("লবণ","YES");
                drinkValues3.put("জলখাবার","YES");
                db.insert("RECIPE", null, drinkValues3);
                /****************/

                Uri path4 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
                String recipe_description4 = "\nউপকরণ\n" +
                        " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                        "\n" +
                        "১ কাপ চিনি আর তার তিন ভাগ জল দিয়ে ফোটান (রয়ে যাওয়া রসগোল্লার রস দিয়েও চলবে )\n" +
                        "৩ টি শুকনো লঙ্কা আর ৩ কোয়া রসুন বাটুন এবং কাটা কাঁচা আম ও নুন  দিয়ে মাখুন\n" +
                        "এগুলি চিনির  রসে দিয়ে ফোটান\n" +
                        "নাড়তে নাড়তে চেখে দেখুন এবং ত্বক ঝাল মিষ্টি এডজাস্ট করুন ";

                ContentValues drinkValues4=new ContentValues();
                drinkValues4.put("NAME", "কাঁচা আমের চাটনি");
                drinkValues4.put("DESCRIPTION", recipe_description4);
                drinkValues4.put("IMAGE_RESOURCE_ID", path4.toString());
                drinkValues4.put("লাল_মরিচ","YES");
                drinkValues4.put("চিনি", "YES");
                drinkValues4.put("লবণ","YES");
                drinkValues4.put("রসুন","YES");
                drinkValues4.put("মিষ্টান্","YES");
                db.insert("RECIPE", null, drinkValues4);
                /***************/

                Uri path5 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
                String recipe_description5 = "\nউপকরণ\n" +
                        " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                        "\n" +
                        "বেগুন গুলি প্রেসার কুকারে সেদ্ধ করুন  এবং চটকে নিন ভালোভাবে| \n" +
                        "তেল গরম করুন,তাতে ২-৩ মিনিট ধরে তেজপাতা আর পেঁয়াজ ভাজুন কম আঁচে||\n" +
                        "তারপর আদা,জীরে,জীরে পাউডার,লঙ্কা গুঁড়ো দিয়ে ১ মিনিট ধরে ভাজুন|\n" +
                        " এতে বেগুনগুলি দিয়ে ৩-৪ মিনিট ভেজে তাতে নারকেলকোরা, চিনি,নুন মেশান|\n" +
                        "৮-১০ মিনিট কম আঁচে রান্না করুন যতক্ষণ রান্নাটি শুকনো না হয়| \n" +
                        "এরপর ওপরে নারকেলকোরা দিয়ে পরিবেশন করুন|\n" +
                        "পদটি মিষ্টি মিষ্টি খেতে| চেখে নুন চিনি এডজাস্ট করবেন|";

                ContentValues drinkValues5=new ContentValues();
                drinkValues5.put("NAME", "বেগুনের ঘন্টো ");
                drinkValues5.put("DESCRIPTION", recipe_description5);
                drinkValues5.put("IMAGE_RESOURCE_ID", path5.toString());
                drinkValues5.put("শর্ষের_তেল","YES");
                drinkValues5.put("চিনি", "YES");
                drinkValues5.put("লবণ","YES");
                drinkValues5.put("গোটা_জিরা","YES");
                drinkValues5.put("আদা","YES");
                drinkValues5.put("পেঁয়াজ","YES");
                drinkValues5.put("বেগুন","YES");
                drinkValues5.put("নারকেল","YES");
                drinkValues5.put("তেজপাতা","YES");
                drinkValues5.put("জিরা_গুঁড়া","YES");
                drinkValues5.put("লাল_মরিচ_গুঁড়া","YES");
                drinkValues5.put("নিরামিষ","YES");
                db.insert("RECIPE", null, drinkValues5);
                /***************/

                Uri path6 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
                String recipe_description6 = "\nউপকরণ\n" +
                        " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                        "\n" +
                        "ডিম সেদ্ধ করে রাখুন।তেল গরম করে সেদ্ধ ডিমগুলি  সাবধানে লাল করে ভেজে নিন \n" +
                        "পেঁয়াজ ভেজে লাল করুন।এতে একটু চিনি দিতে পারেন ।\n" +
                        " তাতে  আদা, রসুন,কাঁচা লঙ্কা বাটা দিন ।\n" +
                        "২-৩ মিনিট ভেজে তাতে হলুদ,ধনে,লঙ্কা গুঁড়ো দিন ।\n" +
                        "মসলাগুলো খয়েরি খয়েরি হয়ে গেলে, এবং তেল ছাড়লে তাতে টমেটো দিন।\n" +
                        "এক কাপ জল দিয়ে রান্না করুন যতক্ষন না আবার শুকনো হচ্ছে |\n" +
                        "এতে এবার মটরশুঁটি ,গরম মশলা এবং ১ চামচ চিনি দিতে পারেন  |\n" +
                        "এবার ১ কাপ জল দিয়ে ফোটান।ঝোল কতটা লাগবে বুঝে গ্যাস অফ করুন ";

                ContentValues drinkValues6=new ContentValues();
                drinkValues6.put("NAME", "ডিমের ঝোল");
                drinkValues6.put("DESCRIPTION", recipe_description6);
                drinkValues6.put("IMAGE_RESOURCE_ID", path6.toString());
                drinkValues6.put("রীফাইন্ড_তেল","YES");
                drinkValues6.put("চিনি", "YES");
                drinkValues6.put("লবণ","YES");
                drinkValues6.put("আলু","YES");
                drinkValues6.put("আদা","YES");
                drinkValues6.put("পেঁয়াজ","YES");
                drinkValues6.put("রসুন","YES");
                drinkValues6.put("টমেটো","YES");
                drinkValues6.put("ডিম","YES");
                drinkValues6.put("হলুদ","YES");
                drinkValues6.put("লাল_মরিচ_গুঁড়া","YES");
                drinkValues6.put("ধনে_গুঁড়া","YES");
                drinkValues6.put("আমিষ","YES");

                db.insert("RECIPE", null, drinkValues6);
                /***************/

                Uri path7 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
                String recipe_description7 = "\nউপকরণ\n" +
                        " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                        "\n" +
                        "\n" +
                        "কুমরো চৌকো চৌকো করে কেটে রাখুন ।\n" +
                        "কড়াইতে তেল গরম করুন এবং ওতে হিং, মেথি দিন (৫ ফোড়ন দিলেও চলবে), শুকনো লঙ্কা দিন।\n" +
                        " এবার ওতে কুমড়োগুলি দিয়ে হলুদ,নুন,লঙ্কা গুঁড়ো দিন।\n" +
                        "ভালো করে মিশিয়ে আঁচ কমিয়ে নাড়তে থাকুন।\n" +
                        "কুমড়ো গুলি রান্না হয়ে গেলে নামিয়ে দিন ।";

                ContentValues drinkValues7=new ContentValues();
                drinkValues7.put("NAME", "কুমড়োর তরকারি ");
                drinkValues6.put("DESCRIPTION", recipe_description7);
                drinkValues6.put("IMAGE_RESOURCE_ID", path6.toString());

                drinkValues7.put("কুমড়া", "YES");
                drinkValues7.put("লবণ","YES");
                drinkValues7.put("লাল_মরিচ","YES");
                drinkValues7.put("৫_ফোড়ন","YES");
                drinkValues7.put("নিরামিষ","YES");
                drinkValues7.put("হলুদ","YES");
                drinkValues7.put("লাল_মরিচ_গুঁড়া","YES");


                db.insert("RECIPE", null, drinkValues7);
                /***************/

                Uri path8 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
                String recipe_description8 = "\nউপকরণ\n" +
                        " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                        "\n" +
                        "\n" +
                        "বেগুনগুলি গোল গোল করে কাটুন।\n" +
                        "ওতে নুন হলুদ মাখন।\n" +
                        "করে এ তেল গরম করুন।\n" +
                        "মাঝারি আঁচে এপিঠ ওপিঠ ভেজে নিন।\n" +
                        "খেয়াল থাকে, বেগুন ভাজতে বেশ অনেকটা তেল লাগে ।";

                ContentValues drinkValues8=new ContentValues();
                drinkValues8.put("NAME", "বেগুন ভাজা  ");
                drinkValues8.put("DESCRIPTION", recipe_description8);
                drinkValues8.put("IMAGE_RESOURCE_ID", path8.toString());

                drinkValues8.put("বেগুন", "YES");
                drinkValues8.put("লবণ","YES");
                drinkValues8.put("নিরামিষ","YES");
                drinkValues8.put("হলুদ","YES");


                db.insert("RECIPE", null, drinkValues8);
                /***************/

                Uri path9 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
                String recipe_description9 = "\nউপকরণ\n" +
                        " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                        "\n" +
                        "\n" +
                        "আলু, ফুলকপি এক সাইজ এ কেটে রাখুন ।\n" +
                        "এবার আলু, ফুলকপি, সর্ষে বাটা, লঙ্কা কুচি, নুন -হলুদ দিয়ে প্রেসার কুকারে ২ টি সিটি দিন।\n" +
                        "ব্যাস";

                ContentValues drinkValues9=new ContentValues();
                drinkValues9.put("NAME", "ফুলকপির বাটিঝাল ");
                drinkValues9.put("DESCRIPTION", recipe_description9);
                drinkValues9.put("IMAGE_RESOURCE_ID", path9.toString());
                drinkValues9.put("শর্ষে", "YES");
                drinkValues9.put("আলু", "YES");
                drinkValues9.put("ফুলকপি", "YES");
                drinkValues9.put("লবণ","YES");
                drinkValues9.put("নিরামিষ","YES");
                drinkValues9.put("হলুদ","YES");

                db.insert("RECIPE", null, drinkValues9);
                /***************/

                Uri path10 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
                String recipe_description10 = "\nউপকরণ\n" +
                        "এক চামচ সর্ষের তেলে, ১/২ চামচ ৫ ফোড়ন দিন।\n" +
                        "ফোড়ন এর মৌরি জীরে গুলো একটু ভাজা ভাজ হলেই, ওতে আদা কুচি ও শুকনো লঙ্কা কুচি  দিন। \n" +
                        "এবার টমেটো  গুলি দিয়ে দিন।\n" +
                        "এবং নুন ছিটিয়ে কড়াইটি ঢাকা দিয়ে আঁচ কমিয়ে দিন।\n" +
                        "৫ মিনিট অন্তর অন্তর টমেটোগুলি নাড়িয়ে ঢাকা দিন যতক্ষণ না  শুকিয়ে আসছে।\n" +
                        "এরপর এতে চিনি দিয়ে দিন। (রসগোল্লার পরে থাকা রস দিতেও পারেন)\n" +
                        "চাটনি শুকিয়ে আসলে, ওতে চাইলে ১/৪ কোয়া  লেবু চিপে নামিয়ে দিন।";

                ContentValues drinkValues10=new ContentValues();
                drinkValues10.put("NAME", "টমেটোর চাটনি ");
                drinkValues10.put("DESCRIPTION", recipe_description10);
                drinkValues10.put("IMAGE_RESOURCE_ID", path10.toString());
                drinkValues10.put("চিনি", "YES");
                drinkValues10.put("টমেটো", "YES");
                drinkValues10.put("৫_ফোড়ন", "YES");
                drinkValues10.put("আদা","YES");
                drinkValues10.put("মিষ্টান্","YES");
                drinkValues10.put("লাল_মরিচ","YES");
                drinkValues10.put("লবণ","YES");
                drinkValues10.put("শর্ষের_তেল","YES");


                db.insert("RECIPE", null, drinkValues10);
                /***************/

                Uri path11 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
                String recipe_description11 = "\nউপকরণ\n" +
                        " বড়ি গুলো ভেজে রাখুন।\n" +
                        "লাউ চৌকো করে কেটে রাখুন। টমেটো কেটে রাখুন।\n" +
                        "তেল গরম  করে  জীরে আর তেজ পাতা দিন। জীরে একটু ভাজা হলেই, এতে টমেটো আর কাঁচা লঙ্কা দিয়ে দিন। টমেটো থেকে বেরুনো জল শুকিয়ে আসলে পরে লাউগুলি  দিয়ে দিন।\n" +
                        "এতে আদা কুচি,নুন-হলুদ, জীরে গুঁড়ো, লঙ্কা গুঁড়ো দিয়ে কষতে থাখুন।\n" +
                        "সব মসলা মিশে গেলে ঢাকা দিয়ে দিন।(জল একদম দেবেন না, লাউ থেকে প্রচুর জল বেরোয়)।\n" +
                        "মোটামুটি শুকিয়ে আসলে ওতে চিনি দিন।\n" +
                        "এবার বড়ি গুলি গুঁড়িয়ে ছড়িয়ে দিয়ে পরিবেশন করুন ।";

                ContentValues drinkValues11=new ContentValues();
                drinkValues11.put("NAME", "লাউ বড়ি ");
                drinkValues11.put("DESCRIPTION", recipe_description11);
                drinkValues11.put("IMAGE_RESOURCE_ID", path11.toString());
                drinkValues11.put("চিনি", "YES");
                drinkValues11.put("লাউ", "YES");
                drinkValues11.put("গোটা_জিরা", "YES");
                drinkValues11.put("লবণ","YES");
                drinkValues11.put("নিরামিষ","YES");
                drinkValues11.put("হলুদ","YES");
                drinkValues11.put("টমেটো", "YES");
                drinkValues11.put("লঙ্কা", "YES");
                drinkValues11.put("আদা","YES");
                drinkValues11.put("লাল_মরিচ_গুঁড়া","YES");
                drinkValues11.put("জিরা_গুঁড়া","YES");




                db.insert("RECIPE", null, drinkValues11);
                /***************/

                Uri path12 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
                String recipe_description12 = "\nউপকরণ\n" +
                        "২ জনের মতো নুডলস \n" +
                        "১ টি ক্যাপসিকাম\n" +
                        "২ টি লঙ্কা\n" +
                        "৪ কোয়া রসুন\n" +
                        "২-৩ বিনস\n" +
                        "১/৪ বাঁধাকপি\n" +
                        "১ টি ডিম\n" +
                        "২ টি সসেজ\n" +
                        "২ টি পেঁয়াজ\n" +
                        "১ চামচ সোয়া সস\n" +
                        "১ চামচ ভিনিগার \n" +
                        "১ চামচ গোলমরিচ\n" +
                        "১/২ চামচ গরম মসলা(চিনেরা গরম মসলাকে বলে ফাইভ -স্পাইস  পাউডার  五香粉)\n" +
                        "\n" +
                        "নুডল  সেদ্ধ  করে রাখুন । এক্কেবারে নরম হওয়ার আগেই জল থেকে ছেঁকে নেবেন। .তেল দিয়ে একটি পাত্রে রাখুন। এতে নুডল গুলি ছাড়া ছাড়া থাকবে ।\n" +
                        "\n" +
                        "কড়াইয়ে একটু তেল নিন । গরম হলে তার  ওপর ডিম ভাগুন। খুন্তি দিয়ে ঘেঁটে দিন। ভাজা হয়ে গেলে খুন্তি দিয়ে কুচি কুচি করে দিন ।\n" +
                        "\n" +
                        "মাংস সেদ্ধ লম্বা লম্বা করে ছিঁড়ে নিন। অথবা সসেজ থাকলে ছোট ছোট করে কেটে কেটে ভেজে নিন । \n" +
                        " \n" +
                        "ক্যাপসিকাম, বাঁধাকপি, বিনস, পেয়াঁজ,  লঙ্কা  লম্বা লম্বা করে কেটে রাখুন ।\n" +
                        "সব সবজি এবং রসুন  একটু তেলে ভেজে  নিন ২ মিনিট.  বেশিক্ষন ভাজবেন না ।\n" +
                        " এবার এতে ডিম্, মাংস দিয়ে সোয়া সস, নুন, ১/২ চামচ চিনি, ভিনেগার, গোলমরিচ,  দিয়ে ২-৩ মিনিট ভাজুন । ১/২ চামচ গরম মসলা দিয়ে দিন।\n" +
                        "\n" +
                        "তারপর নুডলস  দিয়ে দিন।১ মিনিট সাবধানে ভাজুন। কড়াই ভারী হয়ে যাবে । দুটি খুঁটি ব্যবহার করতে পারেন ।\n" +
                        "\n" +
                        "পরিবেশন করুন।";

                ContentValues drinkValues12=new ContentValues();
                drinkValues12.put("NAME", "হাক্কা নুডল ");
                drinkValues12.put("DESCRIPTION", recipe_description12);
                drinkValues12.put("IMAGE_RESOURCE_ID", path12.toString());
                drinkValues12.put("চিনি", "YES");
                drinkValues12.put("রীফাইন্ড_তেল", "YES");
                drinkValues12.put("রসুন","YES");
                drinkValues12.put("পেঁয়াজ","YES");
                drinkValues12.put("বাঁধাকপি","YES");
                drinkValues12.put("ডিম","YES");
                drinkValues12.put("লঙ্কা","YES");
                drinkValues12.put("গোলমরিচ","YES");
                drinkValues12.put("উৎসব","YES");
                drinkValues12.put("লবণ","YES");


                db.insert("RECIPE", null, drinkValues12);

                /***************/

                Uri path13 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
                String recipe_description13 = "\nউপকরণ\n" +
                        " ৫০০গ্রা চিংড়ি\n" +
                        "দেড় কাপ বাসমতী চাল\n" +
                        "১ দারুচিনি, ৩-৪  লবঙ্গ ও এলাচ ও গোটা গোলমরিচ\n" +
                        "২ মুঠো কাজুবাদাম \n"+
                        "১ চামচ আদা\n" +
                        "৪ কাঁচালঙ্কা \n" +
                        "১  চামচ জিরা গুঁড়া \n" +
                        "১ চা  লাল মরিচ গুঁড়া\n" +
                        "৩ পাকা টমেটো \n" +
                        "এক বড় পেঁয়াজ \n ১  কাপ নারকেলকোরা\n ১ কপি দই \n" +
                        "৪ চামচ তেল" +
                        "জলে দারচিনি, এলাচ, লবঙ্গ দিয়ে চাল সেদ্ধ করুন।\n" +
                        "ভাত একটু কাঁচা থাকলেই নামিয়ে নিন ।\n" +
                        "\n" +
                        "আদা আর লঙ্কা বেটে রাখুন।টমেটো কেটে রাখুন\n" +
                        "কাজু বাদাম ভেজে রাখুন । পেঁয়াজ গোল গোল করে কেটে  ভেজে আলাদা রাখুন  ।\n" +
                        "এবার কড়াইয়ে   আদা লঙ্কা  দিয়ে ভাজুন ২ মিনিট।\n" +
                        "ওতে টমেটো, লঙ্কা গুঁড়ো  ও জীরে গুঁড়ো দিয়ে আরও ভাজুন যতক্ষণ না টমেটো গুলো পেস্ট হয়ে যাচ্ছে ।\n" +
                        "\n" +
                        "দই ফেটিয়ে নিন। এবার নারকেলকোরা ও দই মিশিয়ে দিন কড়াইয়ে ।\n" +
                        "করাইনাড়তে থাকতে খাকুন যতক্ষণ না মিশ্রণটি   শুকিয়ে আসছে ।\n" +
                        "\n" +
                        "এবার চিংড়ি গুলি দিয়ে দিন এবং জল ও নুন  দিয়ে ৫ মিনিট কম আঁচে ফোটান।\n" +
                        "এবার একটি চিংড়ি  খুঁটি দিয়ে কেটে দেখুন সেদ্ধ হয়েছে কিনা ।\n" +
                        "\n" +
                        "এর  পর ভাত , কাজ, ভাজা পেঁয়াজ, ও চিংড়ি   মসলা মিশিয়ে নিন । একটু ঘি দিতে পারেন।\n" +
                        "\n" +
                        "ব্যাস চিংড়ি  বিরিয়ানি তৈরী!\n";

                ContentValues drinkValues13=new ContentValues();
                drinkValues13.put("NAME", "চিংড়ি বিরিয়ানি ");
                drinkValues13.put("DESCRIPTION", recipe_description13);
                drinkValues13.put("IMAGE_RESOURCE_ID", path13.toString());
                drinkValues13.put("রীফাইন্ড_তেল", "YES");
                drinkValues13.put("চাল", "YES");
                drinkValues13.put("আদা", "YES");
                drinkValues13.put("পেঁয়াজ", "YES");
                drinkValues13.put("টমেটো", "YES");
                drinkValues13.put("নারকেল", "YES");
                drinkValues13.put("চিংড়ি", "YES");
                drinkValues13.put("এলাচ", "YES");
                drinkValues13.put("লবঙ্গ", "YES");
                drinkValues13.put("লঙ্কা", "YES");
                drinkValues13.put("জিরা_গুঁড়া","YES");
                drinkValues13.put("লাল_মরিচ_গুঁড়া","YES");
                drinkValues13.put("আমিষ","YES");

                db.insert("RECIPE", null, drinkValues13);

                /***************/

                Uri path14 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
                String recipe_description14 = "\nউপকরণ\n" +
                        " 250g পটল  \n2 লঙ্কা \n 3-4 এলাচ,লবঙ্গ\n  1 চামচ আদা\n \n" +
                        "\n" +
                        "\n" +
                        "পটলের খোসা ছাড়িয়ে দুদিকে চিঁড়ে দিন। ওগুলো ভেজে তুলে নিন।\n" +
                        "\n" +
                        "\n" +
                        "এবার 1 চামচ তেলে জিড়ে, গোটা গরম মশলা , হিং, তেজপাতা ফোড়ন দিন।\n" +
                        "\n" +
                        "\n" +
                        " এবার আদা বাটা, লঙ্কা দিয়ে ভাজুন। তারপর দই দিয়ে দিন।\n" +
                        "এবার নুন ,চিনি, কিসমিস দেবেন \n" +
                        "শেষে পটলগুলো দিয়ে সব মিলিয়ে নামিয়ে নিন।\n";

                ContentValues drinkValues14=new ContentValues();
                drinkValues14.put("NAME", "দই পটল");
                drinkValues14.put("DESCRIPTION", recipe_description14);
                drinkValues14.put("IMAGE_RESOURCE_ID", path14.toString());
                drinkValues14.put("লঙ্কা", "YES");
                drinkValues14.put("এলাচ", "YES");
                drinkValues14.put("লবঙ্গ", "YES");
                drinkValues14.put("লঙ্কা", "YES");
                drinkValues14.put("লবণ","YES");
                drinkValues14.put("নিরামিষ","YES");
                drinkValues14.put("গোটা_জিরা", "YES");
                drinkValues14.put("পটল", "YES");
                drinkValues14.put("তেজপাতা", "YES");
                drinkValues14.put("চিনি", "YES");
                drinkValues14.put("রীফাইন্ড_তেল", "YES");
                db.insert("RECIPE", null, drinkValues14);
                /***************/

                Uri path15 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
                String recipe_description15 = "\nউপকরণ\n" +
                        " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                        "\n" +
                        "\n" +
                        "আলু হালকা ভেজে তুলে নিন।\n" +
                        "অল্প তেলে পেঁয়াজ ভেজে লাল করুন। এর পর ওতে আদা-রসুন বাটা দিন।\n" +
                        "ভাজুন যতক্ষণ না সমস্ত মিশ্রণটি ভাজা হচ্ছে।এতে টমেটো দিয়ে দিন ।\n" +
                        "এবার এতে হলুদ, নুন, কাশ্মীরি মির্চ  ও দম মসলা বা চিকেন মসলা দিয়ে ভাজুন ।\n" +
                        "জলে তেজপাতা ও চিনি  দিয়ে সেদ্ধ করুন যতক্ষণ না আলুগুলো সেদ্ধ হচ্ছে।\n" +
                        "যদি তলায় মসলা আটকিয়ে যে, তাহলে একটু খুঁটি চালিয়ে দিন।\n" +
                        "মাখা মাখা হয়ে এলে করাই নামিয়ে নিন ।";

                ContentValues drinkValues15=new ContentValues();
                drinkValues15.put("NAME", "আলুর দম");
                drinkValues15.put("DESCRIPTION", recipe_description15);
                drinkValues15.put("IMAGE_RESOURCE_ID", path15.toString());
                drinkValues15.put("আলু", "YES");
                drinkValues15.put("তেজপাতা", "YES");
                drinkValues15.put("লঙ্কা", "YES");
                drinkValues15.put("চিনি", "YES");
                drinkValues15.put("রীফাইন্ড_তেল", "YES");
                drinkValues15.put("পেঁয়াজ", "YES");
                drinkValues15.put("টমেটো", "YES");
                drinkValues15.put("লবণ","YES");
                drinkValues15.put("নিরামিষ","YES");
                drinkValues15.put("হলুদ","YES");

                db.insert("RECIPE", null, drinkValues15);
                //TODO

                /********/

                Uri path16 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
                String recipe_description16 = "\nউপকরণ\n৩ আলু \n" +
                        "১ বাঁধাকপি কুচি করে কাটা\n" +
                        "তেজপাতা, ৫ ফোড়ন\n" +
                        "নুন ১ চা \n" +
                        "হলুদ ১ চা \n" +
                        "মটরশুঁটি ১ কাপ \n" +
                        "আদাবাটা ১ চা \n" +
                        "রসুনবাটা ১/২ চা \n" +
                        " আলু ভেজে তুলে রাখুন।\n" +
                        "অল্প তেলে তেজপাতা,৫ ফোড়ন  আদা,রসুন,লঙ্কা  বাটা ভাজুন।\n" +
                        "সম্পূর্ণ ভাজা হয়ে গেলে বাঁধাকপি কুচি দিয়ে দিন।\n" +
                        "এর পরে আলু,মটর,জীরে গুঁড়ো, ধোনে , লঙ্কাগুঁড়ো, নুন-হলুদ দিয়ে দিন।\n" +
                        "সবকিছু কষতে থাকুন যতক্ষণ না জল বেরিয়ে অর্ধেক হয়ে যাচ্ছে।\n" +
                        "আলু সম্পূর্ণ সেদ্ধ হলে নামিয়ে নিন।";

                ContentValues drinkValues16=new ContentValues();
                drinkValues16.put("NAME", "বাঁধাকপির ঘন্ট");
                drinkValues16.put("DESCRIPTION", recipe_description16);
                drinkValues16.put("IMAGE_RESOURCE_ID", path16.toString());
                drinkValues16.put("রসুন","YES");
                drinkValues16.put("আলু", "YES");
                drinkValues16.put("আদা","YES");
                drinkValues16.put("লবণ","YES");
                drinkValues16.put("নিরামিষ","YES");
                drinkValues16.put("হলুদ","YES");
                drinkValues16.put("তেজপাতা", "YES");
                drinkValues16.put("জিরা_গুঁড়া","YES");
                drinkValues16.put("লাল_মরিচ_গুঁড়া","YES");
                drinkValues16.put("৫_ফোড়ন", "YES");
                drinkValues16.put("ধনে_গুঁড়া","YES");



                db.insert("RECIPE", null, drinkValues16);

                /***************/

                Uri path17 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
                String recipe_description17 = "\nউপকরণ\n" +
                        " 2 ডিম  \n 1 কাপ ময়দা \n 1/2 কাপ চিনি \n 1/2 কাপ মাখন \n 1/2 চামচ বেকিং পাউডার\n 1/2 কাপ দুধ\n\n" +
                        "\n" +
                        "\n" +
                        "মুরগির মাংস নুন-হলুদ মাখিয়ে (১/২  থেকে ২ ঘন্টা) মেরিনেট করুন।\n" +
                        "আলু ভেজে আলাদা রাখুন।\n" +
                        "পেয়াঁজ ভেজে আলাদা রাখুন\n" +
                        "প্রেসার কুকারে/কড়াইয়ে অল্প তেলে টমেটো ভাজুন যতক্ষণ না সম্পূর্ণ ভাজা হচ্ছে (মোটামুটি ৫ মিন)।\n" +
                        "এবার এতে আদাবাটা,রসুনবাটা,লঙ্কা বাটা  ও একটি তেজপাতা দিয়ে দিন।\n" +
                        "এর পর চিকেন মসলা (না থাকলে জীরে গুঁড়ো ,ধোনে গুঁড়ো,নুন-হলুদ, লঙ্কাগুঁড়ো ও গরম মসলা দিতে পারেন) দিয়ে দিন।\n" +
                        "মসলা ভাজা হয়ে গেলে আলু দিয়ে কিছুক্ষন কোষে , মুরগি পিসগুলি  দিয়ে দিন।\n" +
                        "মুরগি থেকে জল বেরুবে সেই জল শুকিয়ে গেলে, ২ কাপ জল দিয়ে সেদ্ধ করুন বা প্রেসার কুকারে ২ টি সিটি দিন।";

                ContentValues drinkValues17=new ContentValues();
                drinkValues17.put("NAME", "চিকেন কশা ");
                drinkValues17.put("DESCRIPTION", recipe_description17);
                drinkValues17.put("IMAGE_RESOURCE_ID", path17.toString());
                drinkValues17.put("টমেটো", "YES");
                drinkValues17.put("আলু", "YES");
                drinkValues17.put("রসুন","YES");
                drinkValues17.put("লবণ","YES");
                drinkValues17.put("আদা","YES");
                drinkValues17.put("হলুদ","YES");
                drinkValues17.put("ধনে_গুঁড়া","YES");
                drinkValues17.put("লাল_মরিচ_গুঁড়া","YES");
                drinkValues17.put("তেজপাতা", "YES");
                drinkValues17.put("জিরা_গুঁড়া","YES");
                drinkValues17.put("আমিষ","YES");
                drinkValues17.put("পেঁয়াজ", "YES");
                drinkValues17.put("লঙ্কা", "YES");







                db.insert("RECIPE", null, drinkValues17);
                /***************/

                Uri path18 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
                String recipe_description18 = "\nউপকরণ\n" +
                        " মাছগুলি ধুয়ে নুন হলুদ দিয়ে ভেজে নিন।\n" +
                        "আলু  নুন হলুদ দিয়ে  ভেজে আলাদা রাখুন।\n" +
                        "পেয়াঁজ লাল হওয়া অব্দি ভাজুন। তারপর ওতে চিনি  চামচ দিয়ে দিন । চিনি গলে  লেগে গেলে নামিয়ে নিন । আলাদা রাখুন।\n" +
                        " প্রেসার কুকারে/কড়াইয়ে অল্প তেলে টমেটো ভাজুন যতক্ষণ না সম্পূর্ণ ভাজা হচ্ছে (মোটামুটি ৫ মিন)।\n" +
                        "এবার এতে আদাবাটা,লঙ্কা বাটা  ও একটি তেজপাতা দিয়ে দিন।\n" +
                        "তারপর দিন নুন-হলুদ, জীরে গুঁড়ো ও একটু গরম মসলা আর আলু দিয়ে কষতে থাকুন ।\n" +
                        "মসলা ভাজা হয়ে গেলে মাছ দিয়ে দিন। ১/২ চামচ চিনি দেবেন। জল দিয়ে ফুটিয়ে নিন।\n" +
                        "আলু সেদ্ধ হয়ে এলে নামিয়ে নিন।\n";

                ContentValues drinkValues18=new ContentValues();
                drinkValues18.put("NAME", "রুই মাছের কালিয়া");
                drinkValues18.put("DESCRIPTION", recipe_description18);
                drinkValues18.put("IMAGE_RESOURCE_ID", path18.toString());
                drinkValues18.put("রুই_মাছ ", "YES");
                drinkValues18.put("আলু", "YES");
                drinkValues18.put("পেঁয়াজ", "YES");
                drinkValues18.put("লবণ","YES");
                drinkValues18.put("আমিষ","YES");
                drinkValues18.put("হলুদ","YES");
                drinkValues18.put("জিরা_গুঁড়া","YES");
                drinkValues18.put("তেজপাতা", "YES");
                drinkValues18.put("আদা","YES");
                drinkValues18.put("টমেটো", "YES");
                drinkValues18.put("চিনি", "YES");
                drinkValues18.put("লঙ্কা", "YES");



                db.insert("RECIPE", null, drinkValues18);
                /***************/

                Uri path19 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
                String recipe_description19 = "\nউপকরণ\n৭০০G -১KG ইলিশ মাছ\n" +
                        "১/২ কাপ সর্ষে\n" +
                        "১ চামচ নুন\n" +
                        "১/২ চামচ হলুদ\n" +
                        "৪ টি  লঙ্কা" +
                        "কলাপাতা চার ইঞ্চি বাই চার ইঞ্চি  (অথবা মাছের সাইজ  অনুযায়ী) কেটে  রাখুন।  \n" +
                        "হলুদ,নুন,লঙ্কা   ও শর্ষে  একসাথে পিষে রাখুন।\n" +
                        "ইলিশ মাছ ধুয়ে ওতে নুন-হলুদ-সর্ষে-লঙ্কা  বাটা মাখান।\n" +
                        "এর পর প্রতিটি মাছ কলাপাতা তে রেখে সুতো দিয়ে বেঁধে দিন।\n" +
                        "প্রেসার কোকের এ এককাপ জল দিন। \n" +
                        "এবার একটি সেপারেটর  বা ইডলি  মেকার বা স্টীমার এ  এক এক করে সব মাছ গুলি দিয়ে দিন।\n" +
                        "২ টি সিটি দিয়ে নামিয়ে নিন।\n";

                ContentValues drinkValues19=new ContentValues();
                drinkValues19.put("NAME", "ইলিশ পাতুরি");
                drinkValues19.put("DESCRIPTION", recipe_description19);
                drinkValues19.put("IMAGE_RESOURCE_ID", path19.toString());
                drinkValues19.put("শর্ষে", "YES");
                drinkValues19.put("লঙ্কা", "YES");
                drinkValues19.put("লবণ","YES");
                drinkValues19.put("আমিষ","YES");
                drinkValues19.put("হলুদ","YES");

                db.insert("RECIPE", null, drinkValues19);
                /***************/

                Uri path20 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
                String recipe_description20 = "\nউপকরণ\n" +
                        " ১ টি নারকেল কোরানো\n" +
                        "১/২ কাপ গুড়\n" +
                        "২ কাপ চালের  গুঁড়ো\n" +
                        "৫০০ লি দুধ \n" +
                        "\n" +
                        "কড়াই তে  গুড় ওর সামান্য জল দিয়ে ১ মিন ফোটান ।\n" +
                        "এবার এতে নারকেলকোরা  দিয়ে দিন।\n" +
                        "নাড়তে থাকুন যতক্ষণ না মিশ্রণটি সম্পূর্ণ খয়েরি হচ্ছে ।\n" +
                        "চালের গুঁড়ো মেচে ছোট ছোট লেচি তৈরী করুন।\n" +
                        "লুচির সাইজে বেলে , এতে নারকেলের পুর দিয়ে , ধারগুলো এঁটে দিন।\n" +
                        "\n" +
                        "দুধ এ ৫ চামচ চিনি দিয়ে , পীঠে গুলি দিয়ে দিন।\n" +
                        "১৫-২০ মিন কম আঁচে ফোটান ।\n" +
                        "নামিয়ে নিন ";

                ContentValues drinkValues20=new ContentValues();
                drinkValues20.put("NAME", "দুধ পুলি পীঠে");
                drinkValues20.put("DESCRIPTION", recipe_description20);
                drinkValues20.put("IMAGE_RESOURCE_ID", path20.toString());
                drinkValues20.put("দুধ", "YES");
                drinkValues20.put("চিনি","YES");
                drinkValues20.put("মিষ্টান্","YES");
                drinkValues20.put("নারকেল", "YES");
                drinkValues20.put("আখের_গুড় ","YES");

                db.insert("RECIPE", null, drinkValues20);
                /***************/

                Uri path21 = Uri.parse("android.resource://com.habijabi.ranna/" + R.drawable.pancake);
                String recipe_description21 = "\nউপকরণ\nকাঁচা আম\n" +
                        "৪ চামচ চিনি\n" +
                        "বিট নুন\n" +
                        "জীরে গুঁড়ো " +
                        "কাঁচা আমে কয়েকটা ফুটো করুন\n" +
                        "এবার আগুনে ঝলসে নিন(১০ মিন)\nজীরে ভেজে গুড়িয়ে নিন \n" +
                        "আমটি ঠান্ডা হলে, পড়া খোসাটি ছাড়িয়ে নিন।\n" +
                        "এবার আমটি চটকে আঁটি টি বাদ দিন।\n" +
                        "ওতে বিট নুন, জীরে ভাজা গুঁড়ো দিন। চিনি দিন পরিমান মতো( বেশি টক হলে বেশি চিনি বাড়বে)\n" +
                        " ঘটনি দিয়ে কিংবা  মিক্সিতে  জল দিয়ে মিশ্রণটি মিশিয়ে মোলায়েম করে নিন।\n" +
                        "পরিবেশন করুন(বরফ দিতে পারেন)";

                ContentValues drinkValues21=new ContentValues();
                drinkValues21.put("NAME", "আম পোড়া শরবত");
                drinkValues21.put("DESCRIPTION", recipe_description21);
                drinkValues21.put("IMAGE_RESOURCE_ID", path21.toString());
                drinkValues21.put("চিনি","YES");
                drinkValues21.put("পানীয় ","YES");
                drinkValues21.put("গোটা_জিরা ","YES");

                db.insert("RECIPE", null, drinkValues21);
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

    /**
     * Inserts User into SQLite DB queryValuesxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
     * @param  */

    public void insertUser(HashMap<String, String> queryValues) {





            SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        for ( String key : queryValues.keySet() ) {
            System.out.println( key );

            values.put(key,queryValues.get(key));
        }



       database.insert("RECIPE", null, values);
        database.close();

    }

}








