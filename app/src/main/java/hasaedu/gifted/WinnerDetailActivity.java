package hasaedu.gifted;

import android.os.Bundle;
import android.widget.TextView;

import hasaedu.gifted.base.BaseActionBarActivity;


public class WinnerDetailActivity extends BaseActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner_detail);

        Bundle extras = getIntent().getExtras();

        String EXTRA_WINNER_ID = extras.getString("EXTRA_WINNER_ID");
        String EXTRA_WINNER_NAME = extras.getString("EXTRA_WINNER_NAME");
        String EXTRA_WINNER_INFO = extras.getString("EXTRA_WINNER_INFO");
        String EXTRA_PROJECT_TITLE = extras.getString("EXTRA_PROJECT_TITLE");
        String EXTRA_PROJECT_DESC = extras.getString("EXTRA_PROJECT_DESC");
        String EXTRA_WINNER_EMAIL = extras.getString("EXTRA_WINNER_EMAIL");

        String EXTRA_ITEM_POSITION = extras.getString("EXTRA_ITEM_POSITION");
        String EXTRA_YEAR_ID = extras.getString("EXTRA_YEAR_ID");


        TextView txtWinnerName = (TextView) findViewById(R.id.txtWinnerName);
        TextView txtWinnerInfo = (TextView) findViewById(R.id.txtWinnerInfo);
        TextView txtProjectTitle = (TextView) findViewById(R.id.txtProjectTitle);
        TextView txtProjectDesc = (TextView) findViewById(R.id.txtProjectDesc);
        TextView txtContactInfo = (TextView) findViewById(R.id.txtContactInfo);
        TextView txtContactEmail = (TextView) findViewById(R.id.txtContactEmail);


        txtWinnerName.setText("Winner Name : " + EXTRA_WINNER_NAME);
        txtWinnerInfo.setText(EXTRA_WINNER_INFO);
        txtProjectTitle.setText("Project Title : " + EXTRA_PROJECT_TITLE);
        txtProjectDesc.setText(EXTRA_PROJECT_DESC);
        txtContactEmail.setText("Email : " + EXTRA_WINNER_EMAIL);


    }


}
