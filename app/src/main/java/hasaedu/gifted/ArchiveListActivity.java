package hasaedu.gifted;


import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import hasaedu.gifted.Adapters.WinnerAdapter;
import hasaedu.gifted.DAL.ArchiveWinnerContent;

import hasaedu.gifted.Models.ArchiveWinner;

import hasaedu.gifted.base.BaseActionBarActivity;


public class ArchiveListActivity extends BaseActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive_list);

        Bundle extras = getIntent().getExtras();
        String year_id = "1";
        String year_name = "2010";
        if (extras != null) {
            year_id = extras.getString("EXTRA_YEAR_ID");
            year_name = extras.getString("EXTRA_YEAR_NAME");
        }
        // Get ListView object from xml
        ListView listView = (ListView) findViewById(R.id.list);
        TextView txtTitle = (TextView) findViewById(R.id.txtTitle);

        txtTitle.setText("Archive of Year : " + year_name);

        ArrayList<ArchiveWinner> arrayOfWinners = ArchiveWinnerContent.getWinnerByYearId(year_id);
        // Create the adapter to convert the array to views
        WinnerAdapter adapter = new WinnerAdapter(this, arrayOfWinners);
// Attach the adapter to a ListView

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                ArchiveWinner itemValue = (ArchiveWinner) parent.getItemAtPosition(position);
                //  Bundle bundle = new Bundle();
                //  bundle.putSerializable();

                Intent intent = new Intent(getBaseContext(), WinnerDetailActivity.class);
                intent.putExtra("EXTRA_WINNER_ID", itemValue.id);
                intent.putExtra("EXTRA_WINNER_NAME", itemValue.WinnerName);
                intent.putExtra("EXTRA_WINNER_INFO", itemValue.WinnerInfo);
                intent.putExtra("EXTRA_PROJECT_TITLE", itemValue.ProjectTitle);
                intent.putExtra("EXTRA_PROJECT_DESC", itemValue.ProjectDesc);
                intent.putExtra("EXTRA_WINNER_EMAIL", itemValue.WinnerEmail);

                intent.putExtra("EXTRA_ITEM_POSITION", itemPosition);
                intent.putExtra("EXTRA_YEAR_ID", itemValue.ArchiveYearId);


                startActivity(intent);

                    /*
                    Show Alert

                    Toast.makeText(getApplicationContext(),
                    "Position :" + itemPosition + "  ListItem : " + itemValue.ProgramName, Toast.LENGTH_LONG)
                    .show();

                    */
            }
        });

    }

}
