package com.habijabi.ranna;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ShareActionProvider;

public class RecipeActivity extends Activity {
    public static final String EXTRA_RECIPENO = "drinkNo";
    public static  String name="";
    public static  String desc="";
    CountDownTimer cTimer = null;
    private  ShareActionProvider shareActionProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ActionBar actionBar=getActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        Intent intent = getIntent();
        int drinkNo = (Integer) getIntent().getExtras().get(EXTRA_RECIPENO);
        new UpdateRecipeClass().execute(drinkNo);

    }
@Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        MenuItem menuItem=menu.findItem(R.id.action_share);
        shareActionProvider =(ShareActionProvider)menuItem.getActionProvider();
        setIntent(name+desc);
        return super.onCreateOptionsMenu(menu);
    }

    private void  setIntent(String text)
    {
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,text);
        shareActionProvider.setShareIntent(intent);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        if(cTimer!=null)
        {
            cTimer.cancel();
        }
        System.gc();
    }

    void timer(View view)
    {
        TextView editTime = (TextView) findViewById(R.id.edittTime);
        editTime.setVisibility(View.VISIBLE);
        Button timer = (Button) findViewById(R.id.timer);
        timer.setVisibility(View.VISIBLE);
        Button reset = (Button) findViewById(R.id.reset);
        reset.setVisibility(View.VISIBLE);


        Button time = (Button) findViewById(R.id.time);
        time.setVisibility(View.INVISIBLE);
    }

    void resetTimer(View view){
        reset();

    }

        void reset(){
            cTimer.cancel();
            TextView editTime = (TextView) findViewById(R.id.edittTime);
            editTime.setVisibility(View.INVISIBLE);
            editTime.setEnabled(true);
            editTime.setText("");
            Button timer = (Button) findViewById(R.id.timer);
            timer.setVisibility(View.INVISIBLE);
            timer.setText("Start");
            timer.setClickable(true);
            Button time = (Button) findViewById(R.id.time);
            time.setVisibility(View.VISIBLE);
            Button reset = (Button) findViewById(R.id.reset);
            reset.setVisibility(View.INVISIBLE);
        }
    void startTimer(View view) {
        TextView editTime = (TextView) findViewById(R.id.edittTime);
        String time_str= editTime.getText().toString().replaceAll("-","");
        editTime.setEnabled(false);
        Button timer = (Button) findViewById(R.id.timer);
        timer.setClickable(false);
        cTimer = new CountDownTimer(Integer.parseInt(time_str)*1000, 1000) {
            Button timer = (Button) findViewById(R.id.timer);
            public void onTick(long millisUntilFinished) {
                timer.setText("" + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timer.setText("Done!");
                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                r.play();
                reset();


            }


        }.start();


    }



private class UpdateRecipeClass extends AsyncTask<Integer,Void,Boolean> {
        public String desctext,nametext,resourceid;
        protected void onPreExecute(){}
        protected Boolean doInBackground(Integer...drinks) {
            int drinkNo=drinks[0];
            SQLiteOpenHelper starbuzzdb = new RecipeDatabase(RecipeActivity.this);
            try {
                SQLiteDatabase db = starbuzzdb.getWritableDatabase();

                Cursor cursor = db.query("RECIPE", new String[]{"NAME", "DESCRIPTION", "IMAGE_RESOURCE_ID"}, "_id = ?", new String[]{Integer.toString(drinkNo)}, null, null, null);
                if (cursor.moveToFirst()) {
                    nametext = cursor.getString(0);
                    desctext = cursor.getString(1);
                    resourceid = cursor.getString(2);
                }
                cursor.close();
                db.close();
                return true;
            }
            catch (SQLiteException e) {
                return false;
            }




        }
        protected void onPostExecute(Boolean success){
            if (!success){
                Toast toast = Toast.makeText(RecipeActivity.this,"ডেটাবেসের গন্ডগোল", Toast.LENGTH_SHORT);
                toast.show();
            }
            //render
            ActionBar actionBar=getActionBar();
            actionBar.setTitle(nametext);
            actionBar.setDisplayHomeAsUpEnabled(true);

            TextView name = (TextView) findViewById(R.id.name);
            name.setText(nametext+"\n");

            TextView description = (TextView) findViewById(R.id.description);
            description.setText(desctext+"\n");

//            description.setText(Uri.parse(resourceid).toString());
            if (resourceid!="") {
                ImageView photo = (ImageView) findViewById(R.id.photo);
                photo.setImageURI(Uri.parse(resourceid));
                photo.setContentDescription(nametext);
            }
            RecipeActivity.name=nametext+"\n";
            RecipeActivity.desc=desctext;

        }

    }



}
