package com.habijabi.ranna;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


/**
 * Created by susanhita on 08-02-2016.
 */


public class SplashScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);

                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);


        Activity activity = this;
        //activity.overridePendingTransition(R.anim.flip,R.anim.move);
      //  activity.finish();
        activity.overridePendingTransition(R.anim.flip,R.anim.move);
        activity.startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

}


