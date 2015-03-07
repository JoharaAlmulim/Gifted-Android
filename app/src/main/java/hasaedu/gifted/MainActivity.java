package hasaedu.gifted;

import android.content.Intent;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import hasaedu.gifted.base.BaseActionBarActivity;


public class MainActivity extends BaseActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_login = (Button) findViewById(R.id.btn_login);

        // Listening to register new account link
        btn_login.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // Switching to Register screen
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
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
