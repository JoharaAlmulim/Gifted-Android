/*
 * Karasoft (c) 2015.
 *
 * Ashraf Ezzat
 */

package hasaedu.gifted;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import hasaedu.gifted.Adapters.ProgramAdapter;
import hasaedu.gifted.DAL.ProgramContent;
import hasaedu.gifted.Models.Program;
import hasaedu.gifted.base.BaseActionBarActivity;

/**
 * Created by Ashraf on Mar 11, 2015.
 */
public class Programs_List_Activity extends BaseActionBarActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs__list);

        Bundle extras = getIntent().getExtras();
        String catid = "1";
        String catname = "Student";
        if (extras != null) {
            catid = extras.getString("EXTRA_CAT_ID");
            catname = extras.getString("EXTRA_CAT_NAME");
        }
        // Get ListView object from xml
        listView = (ListView) findViewById(R.id.list);
        TextView txtTitle = (TextView) findViewById(R.id.txtTitle);

        txtTitle.setText("Program For : " + catname);
        // Construct the data source
        ArrayList<Program> arrayOfUsers = ProgramContent.getProgramByCatId(catid);
        // Create the adapter to convert the array to views
        ProgramAdapter adapter = new ProgramAdapter(this, arrayOfUsers);
        // Attach the adapter to a ListView

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                Program itemValue = (Program) parent.getItemAtPosition(position);
                //  Bundle bundle = new Bundle();
                //  bundle.putSerializable();

                Intent intent = new Intent(getBaseContext(), Program_DetailActivity.class);
                intent.putExtra("EXTRA_PROGRAM_ID", itemValue.id);
                intent.putExtra("EXTRA_PROGRAM_NAME", itemValue.ProgramName);
                intent.putExtra("EXTRA_ITEM_POSITION", itemPosition);
                intent.putExtra("EXTRA_PROGRAM_DESC", itemValue.ProgramDesc);
                intent.putExtra("EXTRA_PROGRAM_ICON", itemValue.ProgramIcon);
                intent.putExtra("EXTRA_CAT_ID", itemValue.ProgramCatId);


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
