package hasaedu.gifted.validators;


import android.text.TextUtils;
import android.util.Patterns;

/**
 * Created by Ashraf on Mar 03, 2015.
 */


public class FormRegisterValidator {


    public String ValidatePassword(String password) {
        String toReturn = "";
        if(!TextUtils.isEmpty(password)) {
            //TODO: Replace this with your own logic
            if (password.length() < 4) {
                toReturn = "error invalid password";
            }

        }else
        {
            toReturn = "password is required";
        }
        return toReturn;
    }

    public String ValidatePasswordAgain(String password, String passwordAgain) {
        String toReturn = "";
        if (!password.equals(passwordAgain)) {

            toReturn = "enter the same password twice";
        }


        return toReturn;
    }

    public String ValidateName(String name) {
        String toReturn = "";
        if (!TextUtils.isEmpty(name)) {
            //TODO: Replace this with your own logic
            if (name.length() < 4) {
                toReturn = "Name is to short";
            }

        } else {
            toReturn = "Name is required";
        }
        return toReturn;
    }

    public String ValidateEmail(String email) {
        String toReturn = "";
        if (!TextUtils.isEmpty(email)) {
            //TODO: Replace this with your own logic

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                toReturn = "Enter a valid email address";
            }
        } else {
            toReturn = "Email is required";
        }
        return toReturn;
    }

    public String ValidateMobile(String mobile) {
        String toReturn = "";
        if (!TextUtils.isEmpty(mobile)) {
            //TODO: Replace this with your own logic

            if (!Patterns.PHONE.matcher(mobile).matches()) {
                toReturn = "Enter a valid Mobile";
            }
        } else {
            toReturn = "Mobile is required";
        }
        return toReturn;
    }

}
