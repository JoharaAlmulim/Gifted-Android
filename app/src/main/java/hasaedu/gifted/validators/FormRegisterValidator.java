package hasaedu.gifted.validators;

import android.text.TextUtils;

/**
 * Created by Ashraf on Mar 03, 2015.
 */
public class FormRegisterValidator {

    public boolean isPasswordValid(String password) {
        boolean toreturn = true;
        if(!TextUtils.isEmpty(password)) {
            //TODO: Replace this with your own logic
            if (password.length() < 4) {
                toreturn = false;
            }
        }else
        {
            toreturn = false;
        }
        return toreturn;
    }

}
