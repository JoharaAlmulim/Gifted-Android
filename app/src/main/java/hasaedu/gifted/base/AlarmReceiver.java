/*
 * Karasoft (c) 2015.
 *
 * Ashraf Ezzat
 */

package hasaedu.gifted.base;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


import hasaedu.gifted.CalendarActivity;
import hasaedu.gifted.R;

/**
 * Created by Ashraf on Mar 09, 2015.
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        showNotification(context, intent);
    }

    private void showNotification(Context context, Intent intent) {

        String eventTitle = intent.getStringExtra("CALENDAR_EVENT_TITLE");
        String eventDesc = intent.getStringExtra("CALENDAR_EVENT_DESC");


        PendingIntent contentIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, CalendarActivity.class), 0);
        Notification n = new Notification.Builder(context)
                .setContentTitle("Gifted Reminder  : " + eventTitle)
                .setContentText(eventDesc)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentIntent(contentIntent)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setAutoCancel(true).build();


        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, n);
    }
}
