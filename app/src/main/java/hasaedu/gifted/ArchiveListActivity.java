package hasaedu.gifted;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import hasaedu.gifted.Adapters.WinnerAdapter;
import hasaedu.gifted.DAL.ArchiveWinnerContent;

import hasaedu.gifted.Models.ArchiveWinner;



public class ArchiveListActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive_list);

    Bundle extras = getIntent().getExtras();

    String year_id = extras.getString("EXTRA_YEAR_ID");
    String year_name = extras.getString("EXTRA_YEAR_NAME");

    // Get ListView object from xml
    ListView  listView = (ListView) findViewById(R.id.list);
    TextView txtTitle = (TextView) findViewById(R.id.txtTitle);

        txtTitle.setText("Archive of Year : "+year_name);

    ArrayList<ArchiveWinner> arrayOfWinners = ArchiveWinnerContent.getWinnerByYearId(year_id);
    // Create the adapter to convert the array to views
        WinnerAdapter adapter = new WinnerAdapter(this, arrayOfWinners);
// Attach the adapter to a ListView

    listView.setAdapter(adapter);
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_archive_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
