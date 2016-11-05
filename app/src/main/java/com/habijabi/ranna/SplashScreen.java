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
        overridePendingTransition(R.anim.flip,R.anim.flip);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep(2000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(SplashScreen.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();


    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override public void finish()
    {
        super.finish();
        overridePendingTransition(R.anim.flip, R.anim.flip);
    }

}































