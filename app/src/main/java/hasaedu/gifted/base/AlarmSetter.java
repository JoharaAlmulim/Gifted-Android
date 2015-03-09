/*
 * Karasoft (c) 2015.
 *
 * Ashraf Ezzat
 */

package hasaedu.gifted.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import hasaedu.gifted.services.AlarmService;

/**
 * Created by Ashraf on Mar 09, 2015.
 */
public class AlarmSetter extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            // Set the alarm here.
        }
    }
}
