package hasaedu.gifted;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import hasaedu.gifted.DAL.CalendarEventContent;
import hasaedu.gifted.Models.ArchiveWinner;
import hasaedu.gifted.Models.CalendarEvent;
import hasaedu.gifted.base.BaseActionBarActivity;

@SuppressLint("SimpleDateFormat")
public class CalendarActivity extends BaseActionBarActivity {
    private CaldroidFragment caldroidFragment;

    private void setCustomResourceForDates() {

        for (CalendarEvent a : CalendarEventContent.CalendarEvents) {

            if (caldroidFragment != null) {
                caldroidFragment.setBackgroundResourceForDate(R.color.Pink, a.eventDate);
                caldroidFragment.setTextColorForDate(R.color.white, a.eventDate);
            }
        }
        caldroidFragment.refreshView();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);


        // Setup caldroid fragment
        // **** If you want normal CaldroidFragment, use below line ****
        caldroidFragment = new CaldroidFragment();

        // //////////////////////////////////////////////////////////////////////
        // **** This is to show customized fragment. If you want customized
        // version, uncomment below line ****
//		 caldroidFragment = new CaldroidSampleCustomFragment();

        // Setup arguments

        // If Activity is created after rotation
        if (savedInstanceState != null) {
            caldroidFragment.restoreStatesFromKey(savedInstanceState,
                    "CALDROID_SAVED_STATE");
        }
        // If activity is created from fresh
        else {
            Bundle args = new Bundle();
            Calendar cal = Calendar.getInstance();
            args.putInt(CaldroidFragment.MONTH, cal.get(Calendar.MONTH) + 1);
            args.putInt(CaldroidFragment.YEAR, cal.get(Calendar.YEAR));
            args.putBoolean(CaldroidFragment.ENABLE_SWIPE, true);
            args.putBoolean(CaldroidFragment.SIX_WEEKS_IN_CALENDAR, false);

            // Uncomment this to customize startDayOfWeek
            // args.putInt(CaldroidFragment.START_DAY_OF_WEEK,
            // CaldroidFragment.TUESDAY); // Tuesday

            // Uncomment this line to use Caldroid in compact mode
            // args.putBoolean(CaldroidFragment.SQUARE_TEXT_VIEW_CELL, false);

            caldroidFragment.setArguments(args);
        }

        setCustomResourceForDates();

        // Attach to the activity
        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.calendar1, caldroidFragment);
        t.commit();
        Button btn_Add_Event = (Button) findViewById(R.id.btn_Add_Event);
        if (isUserSignedIn()) {
            if (session.getUserDetails().userRole.equals("admin")) {

                btn_Add_Event.setVisibility(View.VISIBLE);
            }
        }

        btn_Add_Event.setOnClickListener
                (new View.OnClickListener() {

                    public void onClick(View v) {

                        openAddEvent(v);

                    }
                });

        // Setup listener
        final CaldroidListener listener = new CaldroidListener() {

            @Override
            public void onSelectDate(Date date, View view) {
/*
                Toast.makeText(getApplicationContext(), formatter.format(date),
                        Toast.LENGTH_SHORT).show();
*/
                ArrayList<CalendarEvent> celist = CalendarEventContent.getEventByDate(date);
                LinearLayout userpanel = (LinearLayout) findViewById(R.id.userpanel);
                if (celist.size() > 0) {
                    userpanel.setVisibility(View.VISIBLE);
                    final CalendarEvent ce = celist.get(0);

                    TextView txtEvenTitle = (TextView) findViewById(R.id.txtEvenTitle);
                    TextView txtEventDesc = (TextView) findViewById(R.id.txtEventDesc);
                    txtEvenTitle.setText(ce.toString());
                    txtEventDesc.setText(ce.eventDesc);

                    Button btn_Set_Reminder = (Button) findViewById(R.id.btn_Set_Reminder);

                    btn_Set_Reminder.setOnClickListener(new View.OnClickListener() {

                        public void onClick(View v) {

                            open(v, ce);

                        }
                    });

                } else {
                    userpanel.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onChangeMonth(int month, int year) {
                String text = "month: " + month + " year: " + year;
                /*
                Toast.makeText(getApplicationContext(), text,
                        Toast.LENGTH_SHORT).show();
                */
            }

            @Override
            public void onLongClickDate(Date date, View view) {
                /*
                Toast.makeText(getApplicationContext(),
                        "Long click " + formatter.format(date),
                        Toast.LENGTH_SHORT).show();
                */
            }

            @Override
            public void onCaldroidViewCreated() {
                if (caldroidFragment.getLeftArrowButton() != null) {
                    /*
                    Toast.makeText(getApplicationContext(),
                            "Caldroid view is created", Toast.LENGTH_SHORT)
                            .show();
                    */
                }
            }

        };

        // Setup Caldroid
        caldroidFragment.setCaldroidListener(listener);


    }

    private void openAddEvent(final View v) {
        LayoutInflater li = LayoutInflater.from(v.getContext());
        View promptsView = li.inflate(R.layout.addcalendarevent, null);

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                v.getContext());

        // set prompts.xml to alertdialog builder
        alertDialogBuilder.setView(promptsView);

        final EditText txtEventName = (EditText) promptsView
                .findViewById(R.id.txtEventName);

        final EditText txtEventDesc = (EditText) promptsView
                .findViewById(R.id.txtEventDesc);

        final DatePicker datePicker = (DatePicker) promptsView
                .findViewById(R.id.datePicker);

        // set dialog message
        alertDialogBuilder
                .setCancelable(false)
                .setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // get user input and set it to result
                                // edit text
                                //  result.setText(userInput.getText());
                                int day = datePicker.getDayOfMonth();
                                int month = datePicker.getMonth();
                                int year = datePicker.getYear();

                                Calendar calendar = Calendar.getInstance();
                                calendar.set(year, month, day);

                                Date dd = calendar.getTime();
                                int ceid = CalendarEventContent.CalendarEvents.size() + 1;
                                String eventName = txtEventName.getText().toString();
                                String eventDesc = txtEventDesc.getText().toString();
                                CalendarEvent oce = new CalendarEvent(String.valueOf(ceid), eventName, eventDesc, dd);
                                CalendarEventContent.CalendarEvents.add(oce);
                                setCustomResourceForDates();

                            }
                        })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

    public void open(View view, final CalendarEvent decision) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle(decision.toString());
        alertDialogBuilder.setMessage(R.string.decision);
        alertDialogBuilder.setPositiveButton(R.string.positive_button,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        /*
                        Toast.makeText(getApplicationContext(), R.string.positive_button,
                                Toast.LENGTH_SHORT).show();
                                */
                        setAlarm(getApplicationContext(), decision);

                    }
                });
        alertDialogBuilder.setNegativeButton(R.string.negative_button,
                new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        /*
                        Toast.makeText(getApplicationContext(), R.string.negative_button,
                                Toast.LENGTH_SHORT).show();
                                */
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }

}
