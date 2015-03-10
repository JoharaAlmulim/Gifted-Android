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

import hasaedu.gifted.Models.Register;
import hasaedu.gifted.base.BaseActionBarActivity;
import hasaedu.gifted.validators.FormRegisterValidator;


public class RegisterActivity extends BaseActionBarActivity {
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
        Button btn_login = (Button) findViewById(R.id.btn_login);

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

                String email = txtemail.getText().toString();
                String password = txtpassword.getText().toString();
                String name = txtname.getText().toString();
                String renterPassword = txtrenterpassword.getText().toString();
                String mobile = txtmobile.getText().toString();
                boolean sms_notify = sch_sms_notify.isChecked();
                Register oreg = new Register("0", name, email, password, renterPassword, mobile, sms_notify);

                attemptRegister(oreg);
            }
        });

    }

    boolean validateData(Register oreg) {
        txtname.setError(null);
        txtemail.setError(null);
        txtpassword.setError(null);
        txtrenterpassword.setError(null);
        txtmobile.setError(null);
        sch_sms_notify.setError(null);

        boolean cancel = false;
        View focusView = null;

        FormRegisterValidator fv = new FormRegisterValidator();

        String mobileError = fv.ValidateMobile(oreg.mobile);
        if (mobileError.isEmpty() == false) {
            txtmobile.setError(mobileError);
            focusView = txtmobile;
            cancel = true;
        }

        String passAgainError = fv.ValidatePasswordAgain(oreg.password, oreg.passwordAgain);
        if (passAgainError.isEmpty() == false) {
            txtrenterpassword.setError(passAgainError);
            focusView = txtrenterpassword;
            cancel = true;
        }

        String passError = fv.ValidatePassword(oreg.password);
        if (passError.isEmpty() == false) {
            txtpassword.setError(passError);
            focusView = txtpassword;
            cancel = true;
        }

        String emailError = fv.ValidateEmail(oreg.email);
        if (emailError.isEmpty() == false) {
            txtemail.setError(emailError);
            focusView = txtemail;
            cancel = true;
        }

        String nameError = fv.ValidateName(oreg.name);
        if (nameError.isEmpty() == false) {
            txtname.setError(nameError);
            focusView = txtname;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        }

        return cancel;
    }

    private void attemptRegister(Register oreg) {


        if (!validateData(oreg)) {

        }
    }
}
