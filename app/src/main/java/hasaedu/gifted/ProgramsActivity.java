package hasaedu.gifted;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import hasaedu.gifted.Adapters.ProgramAdapter;
import hasaedu.gifted.DAL.ProgramCategoryContent;
import hasaedu.gifted.DAL.ProgramContent;
import hasaedu.gifted.Models.Program;
import hasaedu.gifted.Models.ProgramCategory;


public class ProgramsActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs);
        CreateButtons();
    }

    private void CreateButtons() {
        LinearLayout linear = (LinearLayout) findViewById(R.id.programbuttonslinearlayout);
        for (int i = 0; i < ProgramCategoryContent.ProgramCategories.size(); i++) {
            Button btnWord = new Button(this);

            btnWord.setGravity(Gravity.CENTER_HORIZONTAL);
            btnWord.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            btnWord.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            btnWord.setText(ProgramCategoryContent.ProgramCategories.get(i).CatName);
            btnWord.setTag(ProgramCategoryContent.ProgramCategories.get(i));
            btnWord.setOnClickListener(btnClicked);
            linear.addView(btnWord);
        }
    }

    View.OnClickListener btnClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ProgramCategory tag = (ProgramCategory) v.getTag();
            Intent intent = new Intent(getBaseContext(), Programs_List_Activity.class);
            intent.putExtra("EXTRA_CAT_ID", tag.id);
            intent.putExtra("EXTRA_CAT_NAME", tag.CatName);
            startActivity(intent);
            //Toast.makeText(getApplicationContext(), "clicked button", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_programs, menu);
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

    public static class Programs_List_Activity extends ActionBarActivity {
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


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_programs__list, menu);
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
}
