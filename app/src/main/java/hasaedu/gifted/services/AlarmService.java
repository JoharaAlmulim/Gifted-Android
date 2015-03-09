/*
 * Karasoft (c) 2015.
 *
 * Ashraf Ezzat
 */

package hasaedu.gifted.services;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by Ashraf on Mar 09, 2015.
 */
public class AlarmService extends IntentService {
    private static final String TAG = "AlarmService";

    public AlarmService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }

}
