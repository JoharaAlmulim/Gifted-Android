package hasaedu.gifted;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import hasaedu.gifted.base.BaseActionBarActivity;


public class MainActivity extends BaseActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (session.getUserDetails().userRole == null) {
            session.logoutUser();
        }

        Button btn_login = (Button) findViewById(R.id.btn_login);
        Button btn_LogOut = (Button) findViewById(R.id.btn_LogOut);
        Button btn_SendSMS = (Button) findViewById(R.id.btn_SendSMS);
        TextView lblWelcomeBack = (TextView) findViewById(R.id.lblWelcomeBack);
        if (isUserSignedIn()) {
            btn_login.setVisibility(View.INVISIBLE);

            btn_LogOut.setVisibility(View.VISIBLE);
            lblWelcomeBack.setVisibility(View.VISIBLE);
            lblWelcomeBack.setText("Welcome Back: " + session.getUserDetails().name);
            if (session.getUserDetails().userRole.equals("admin")) {
                btn_SendSMS.setVisibility(View.VISIBLE);
            }


        } else {
            btn_LogOut.setVisibility(View.INVISIBLE);
            lblWelcomeBack.setVisibility(View.INVISIBLE);
            btn_SendSMS.setVisibility(View.INVISIBLE);


            btn_login.setVisibility(View.VISIBLE);
        }

        btn_SendSMS.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                final EditText input = new EditText(v.getContext());
                // Switching to Register screen
                new AlertDialog.Builder(v.getContext())
                        .setTitle("NEW SMS")
                        .setMessage("Write SMS Message")
                        .setView(input)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                                Editable value = input.getText();
                                Toast.makeText(getApplicationContext(), value,
                                        Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Do nothing.
                    }
                }).show();
            }
        });

        btn_LogOut.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                session.logoutUser();

                // Switching to Register screen
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
        // Listening to register new account link
        btn_login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent(getApplicationContext(), NewLoginActivity.class);
                startActivity(i);
            }
        });

        Button btn_program = (Button) findViewById(R.id.btn_program);

        // Listening to register new account link
        btn_program.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent(getApplicationContext(), ProgramsActivity.class);
                startActivity(i);
            }
        });

        Button btn_archive = (Button) findViewById(R.id.btn_archive);

        // Listening to register new account link
        btn_archive.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent(getApplicationContext(), ArchiveYearActivity.class);
                startActivity(i);
            }
        });

        Button btn_calendar = (Button) findViewById(R.id.btn_calendar);

        // Listening to register new account link
        btn_calendar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent(getApplicationContext(), CalendarActivity.class);
                startActivity(i);
            }
        });

    }


}
