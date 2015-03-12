package hasaedu.gifted;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import hasaedu.gifted.base.BaseActionBarActivity;


public class Program_DetailActivity extends BaseActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program__detail);

        Bundle extras = getIntent().getExtras();

        String EXTRA_PROGRAM_ID = extras.getString("EXTRA_PROGRAM_ID");
        String EXTRA_PROGRAM_NAME = extras.getString("EXTRA_PROGRAM_NAME");
        String EXTRA_ITEM_POSITION = extras.getString("EXTRA_ITEM_POSITION");
        String EXTRA_PROGRAM_DESC = extras.getString("EXTRA_PROGRAM_DESC");
        String EXTRA_PROGRAM_ICON = extras.getString("EXTRA_PROGRAM_ICON");
        String EXTRA_CAT_ID = extras.getString("EXTRA_CAT_ID");

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        TextView txtProgramName = (TextView) findViewById(R.id.txtProgramName);
        TextView txtDesc = (TextView) findViewById(R.id.txtDesc);

        txtProgramName.setText(EXTRA_PROGRAM_NAME);
        txtDesc.setText(EXTRA_PROGRAM_DESC);

        Picasso.with(this).load(R.drawable.headerlogo).into(imageView);

    }


}
