package com.habijabi.ranna;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


/**
 * Created by susanhita on 23-02-2016.
 */
public class NotificationGrocery extends BroadcastReceiver {
        NotificationManager nm;
        public void onReceive(Context context, Intent intent) {
                nm = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
                Notification.Builder mBuilder = new Notification.Builder(context)
                        .setSmallIcon(R.drawable.icon)
                        .setContentTitle("দ্রব্যসামগ্রী কিনতে দোকানে যেতে হবে!")
                        .setPriority(Notification.PRIORITY_MAX)
                        .setDefaults(Notification.DEFAULT_VIBRATE)
                        .setContentText("ভুলবেন না !");
                Intent intent1 = new Intent(context, ViewGroceryList.class);
                TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
                stackBuilder.addParentStack(ViewGroceryList.class);
                stackBuilder.addNextIntent(intent1);
                PendingIntent pendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
                mBuilder.setContentIntent(pendingIntent);
                nm.notify(0,mBuilder.build());

        }
        }


