/*
 * Karasoft (c) 2015.
 *
 * Ashraf Ezzat
 */

package hasaedu.gifted;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import hasaedu.gifted.Models.CurrentUser;
import hasaedu.gifted.Models.LoginUser;
import hasaedu.gifted.app.AppController;
import hasaedu.gifted.base.BaseActionBarActivity;
import hasaedu.gifted.validators.FormRegisterValidator;


public class NewLoginActivity extends BaseActionBarActivity {
    private EditText txtemail;
    private EditText txtpassword;
    private TextView lblRegisterError;

    private ProgressDialog pDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_login);

        txtemail = (EditText) findViewById(R.id.txtemail);
        txtpassword = (EditText) findViewById(R.id.txtpassword);
        lblRegisterError = (TextView) findViewById(R.id.lblRegisterError);

        Button btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = txtemail.getText().toString();
                String password = txtpassword.getText().toString();

                LoginUser oLogin = new LoginUser(email, password);

                attemptLogin(oLogin);
            }
        });
        session.createLoginSession("Android Hive", "anroidhive@gmail.com", "");
    }

    private void attemptLogin(final LoginUser oLogin) {

        lblRegisterError.setVisibility(View.INVISIBLE);
        pDialog = new ProgressDialog(this);
        // Showing progress dialog before making http request
        pDialog.setMessage("Loading...");
        pDialog.show();
        String url = BASEURL + "/login";
        // final String TAG = "LoginData";
        String tag_json_obj = "LoginDataJson";
        if (!validateData(oLogin)) {

            StringRequest sr = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    pDialog.hide();
                    try {

                        JSONObject jObject = new JSONObject(response);
                        boolean aJsonError = jObject.getBoolean("error");

                        if (!aJsonError) {

                            String name = jObject.getString("name");
                            String email = jObject.getString("email");
                            String apiKey = jObject.getString("apiKey");
                            String userRole = jObject.getString("UserRole");
                            String userMobile = jObject.getString("MobileNumber");

                            CurrentUser ouser = new CurrentUser(name, email, apiKey, userRole, userMobile);
                            session.createLoginSession(ouser);

                            Intent i = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i);
                        } else {
                            String aJsonMessage = jObject.getString("message");
                            lblRegisterError.setText(aJsonMessage);
                            lblRegisterError.setVisibility(View.VISIBLE);
                        }
                    } catch (JSONException ex) {
                        lblRegisterError.setText("Parse Error Try Again");
                        lblRegisterError.setVisibility(View.VISIBLE);
                    }
                    // mPostCommentResponse.requestCompleted();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    pDialog.hide();
                    lblRegisterError.setText("NET Error Try Again");
                    lblRegisterError.setVisibility(View.VISIBLE);
                    // mPostCommentResponse.requestEndedWithError(error);
                }
            }) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();

                    params.put("email", oLogin.email);
                    params.put("password", oLogin.password);


                    return params;
                }

                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("Content-Type", "application/x-www-form-urlencoded");
                    return params;
                }
            };

            AppController.getInstance().addToRequestQueue(sr, tag_json_obj);
        } else {
            pDialog.hide();
        }
    }

    boolean validateData(LoginUser oreg) {

        txtemail.setError(null);
        txtpassword.setError(null);


        boolean cancel = false;
        View focusView = null;

        FormRegisterValidator fv = new FormRegisterValidator();


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


        if (cancel) {
            focusView.requestFocus();
        }

        return cancel;
    }


}
