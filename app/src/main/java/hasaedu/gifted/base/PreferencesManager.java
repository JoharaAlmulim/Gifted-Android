/*
 * Karasoft (c) 2015.
 *
 * Ashraf Ezzat
 */

package hasaedu.gifted.base;


import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

import hasaedu.gifted.Models.CurrentUser;

/**
 * Created by Ashraf on Mar 11, 2015.
 */
public class PreferencesManager {

    SharedPreferences pref;
    // Editor for Shared preferences
    SharedPreferences.Editor editor;
    Context _context;
    private static final String PREF_NAME = "AndroidGiftedPref";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String KEY_NAME = "name";

    // Email address (make variable public to access from outside)
    public static final String KEY_EMAIL = "email";
    public static final String API_KEY = "apiKey";
    public static final String KEY_ROLE = "userRole";
    public static final String KEY_MOBILE = "userMobile";

    public PreferencesManager(Context context) {
        _context = context;
        pref = _context.getSharedPreferences(PREF_NAME, _context.MODE_PRIVATE);
        editor = pref.edit();
    }


    public void createLoginSession(String name, String email, String apiKey) {
        // Storing login value as TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_NAME, name);

        // Storing email in pref
        editor.putString(KEY_EMAIL, email);
        editor.putString(API_KEY, apiKey);
        // commit changes
        editor.commit();
    }

    /*
        public HashMap<String, String> getUserDetails(){
            HashMap<String, String> user = new HashMap<>();
            // user name
            user.put(KEY_NAME, pref.getString(KEY_NAME, null));

            // user email id
            user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));

            user.put(API_KEY, pref.getString(API_KEY,null));

            user.put(KEY_ROLE, pref.getString(KEY_ROLE,null));

            user.put(KEY_MOBILE, pref.getString(KEY_MOBILE,null));

            // return user
            return user;
        }
    */
    public CurrentUser getUserDetails() {
        String name = pref.getString(KEY_NAME, null);
        String email = pref.getString(KEY_EMAIL, null);
        String apiKey = pref.getString(API_KEY, null);
        String role = pref.getString(KEY_ROLE, null);
        String mobile = pref.getString(KEY_MOBILE, null);
        CurrentUser oUser = new CurrentUser(name, email, apiKey, role, mobile);
        return oUser;
    }

    public void logoutUser() {
        // Clearing all data from Shared Preferences
        editor.clear();
        editor.commit();
    }

    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }

    public String getApiKey() {
        return pref.getString(API_KEY, null);
    }

    public void createLoginSession(CurrentUser oUser) {
        editor.putBoolean(IS_LOGIN, true);

        // Storing name in pref
        editor.putString(KEY_NAME, oUser.name);

        // Storing email in pref
        editor.putString(KEY_EMAIL, oUser.email);
        editor.putString(API_KEY, oUser.apiKey);
        editor.putString(KEY_ROLE, oUser.userRole);
        editor.putString(KEY_MOBILE, oUser.userMobile);
        // commit changes
        editor.commit();
    }
}