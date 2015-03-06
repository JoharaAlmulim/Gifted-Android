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

import hasaedu.gifted.dal.ProgramCategoryContent;
import hasaedu.gifted.models.ProgramCategory;


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
/*
            ViewGroup.LayoutParams params = btnWord.getLayoutParams();
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
            params.width = ViewGroup.LayoutParams.WRAP_CONTENT;
            btnWord.setLayoutParams(params);
*/
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
            ProgramCategory tag =(ProgramCategory) v.getTag();
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
}
