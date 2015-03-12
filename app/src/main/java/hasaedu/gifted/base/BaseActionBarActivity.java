package hasaedu.gifted.base;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;

import android.view.Menu;
import android.view.MenuItem;


import hasaedu.gifted.AboutUsActivity;
import hasaedu.gifted.ArchiveListActivity;
import hasaedu.gifted.ArchiveYearActivity;
import hasaedu.gifted.CalendarActivity;
import hasaedu.gifted.ContactUsActivity;
import hasaedu.gifted.MainActivity;
import hasaedu.gifted.Models.CalendarEvent;
import hasaedu.gifted.ProgramsActivity;
import hasaedu.gifted.R;

/**
 * Created by Ashraf on Mar 06, 2015.
 */
public class BaseActionBarActivity extends ActionBarActivity {

    protected String BASEURL;
    protected PreferencesManager session;

    public boolean isUserSignedIn() {
        return session.isLoggedIn();
    }

    protected void setAlarm(Context context, CalendarEvent targetCal) {


        Intent intent = new Intent(getApplicationContext(), AlarmReceiver.class);

        intent.putExtra("CALENDAR_EVENT_TITLE", targetCal.eventTitle);
        intent.putExtra("CALENDAR_EVENT_DESC", targetCal.eventDesc);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        am.set(AlarmManager.RTC_WAKEUP,/*targetCal.getAsCalendar().getTimeInMillis()*/ SystemClock.elapsedRealtime() + 60 * 1000, pendingIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        session = new PreferencesManager(getApplicationContext());
        BASEURL = getString(R.string.BASEURL);
        try {


            if (this instanceof MainActivity) {
                // getActionBar().setDisplayHomeAsUpEnabled(false);
            } else if (this instanceof CalendarActivity) {
                // getActionBar().setDisplayHomeAsUpEnabled(false);
            } else if (this instanceof ArchiveListActivity) {
            } else {
                getActionBar().setDisplayHomeAsUpEnabled(true);
            }
        } catch (Exception ex) {

        }
        //NavUtils.navigateUpFromSameTask(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            // Respond to the action bar's Up/Home button
            case R.id.action_Home:
                // NavUtils.navigateUpFromSameTask(this);

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                return true;

            case R.id.action_programs:
                // NavUtils.navigateUpFromSameTask(this);

                Intent i1 = new Intent(getApplicationContext(), ProgramsActivity.class);
                startActivity(i1);
                return true;
            case R.id.action_archive:
                // NavUtils.navigateUpFromSameTask(this);

                Intent i2 = new Intent(getApplicationContext(), ArchiveYearActivity.class);
                startActivity(i2);
                return true;
            case R.id.action_Calendar:
                // NavUtils.navigateUpFromSameTask(this);

                Intent i3 = new Intent(getApplicationContext(), CalendarActivity.class);
                startActivity(i3);
                return true;
            case R.id.action_aboutus:
                // NavUtils.navigateUpFromSameTask(this);

                Intent i4 = new Intent(getApplicationContext(), AboutUsActivity.class);
                startActivity(i4);
                return true;
            case R.id.action_contactus:
                // NavUtils.navigateUpFromSameTask(this);

                Intent i5 = new Intent(getApplicationContext(), ContactUsActivity.class);
                startActivity(i5);
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
