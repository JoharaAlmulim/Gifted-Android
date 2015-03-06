package hasaedu.gifted;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import hasaedu.gifted.validators.FormRegisterValidator;


public class Register extends ActionBarActivity {
   // private UserLoginTask mAuthTask = null;

    // UI references.
    private EditText txtname;
    private EditText txtemail;
    private EditText txtpassword;
    private EditText txtrenterpassword;
    private EditText txtmobile;
    private Switch sch_sms_notify;

    private View mProgressView;
    private View mregister_FormView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //set login action
        Button btn_login = (Button)findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });

        // get data

        txtname = (EditText) findViewById(R.id.txtname);
        txtemail = (EditText) findViewById(R.id.txtemail);
        txtpassword = (EditText) findViewById(R.id.txtpassword);
        txtrenterpassword = (EditText) findViewById(R.id.txtrenterpassword);
        txtmobile = (EditText) findViewById(R.id.txtmobile);
        sch_sms_notify = (Switch) findViewById(R.id.sch_sms_notify);

        mregister_FormView = findViewById(R.id.register_form);
        mProgressView = findViewById(R.id.register_progress);

        Button btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptRegister();
            }
        });

    }

    private void attemptRegister() {

        txtname.setError(null);
        txtemail.setError(null);
        txtpassword.setError(null);
        txtrenterpassword.setError(null);
        txtmobile.setError(null);
        sch_sms_notify.setError(null);

        String email = txtemail.getText().toString();
        String password = txtpassword.getText().toString();
        String name = txtname.getText().toString();
        String renterpassword = txtrenterpassword.getText().toString();
        String mobile = txtmobile.getText().toString();
        boolean sms_notify = sch_sms_notify.isChecked();

        boolean cancel = false;
        View focusView = null;

        FormRegisterValidator fv = new FormRegisterValidator();
        // validate user input data

        if (!fv.isPasswordValid(password)) {
            txtpassword.setError(getString(R.string.error_invalid_password));
            focusView = txtpassword;
            cancel = true;
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
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
