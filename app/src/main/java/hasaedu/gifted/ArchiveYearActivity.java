package hasaedu.gifted;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import hasaedu.gifted.DAL.ArchiveYearContent;
import hasaedu.gifted.Models.ArchiveYears;


public class ArchiveYearActivity extends ActionBarActivity {

   // Button[] btnWord = new Button[ArchiveYearContent.ITEMS.size()];
  //  LinearLayout linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_archive_year);
CreateButtons();
    }

    private void CreateButtons() {
        LinearLayout   linear = (LinearLayout) findViewById(R.id.buttonslinearlayout);
        for (int i = 0; i <ArchiveYearContent.ITEMS.size(); i++) {
            Button  btnWord = new Button(this);
            btnWord.setGravity(Gravity.CENTER_HORIZONTAL);
            btnWord.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
            btnWord.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
            btnWord.setText(ArchiveYearContent.ITEMS.get(i).YearName);
            btnWord.setTag(ArchiveYearContent.ITEMS.get(i));
            btnWord.setOnClickListener(btnClicked);
            linear.addView(btnWord);
        }
    }
    View.OnClickListener btnClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ArchiveYears tag =(ArchiveYears) v.getTag();
            Intent intent = new Intent(getBaseContext(), ArchiveListActivity.class);
            intent.putExtra("EXTRA_YEAR_ID", tag.id);
            intent.putExtra("EXTRA_YEAR_NAME", tag.YearName);
            startActivity(intent);

            //Toast.makeText(getApplicationContext(), "clicked button", Toast.LENGTH_SHORT).show();
        }
    };
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
