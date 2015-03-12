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
import hasaedu.gifted.base.BaseActionBarActivity;


public class ProgramsActivity extends BaseActionBarActivity {

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


}


