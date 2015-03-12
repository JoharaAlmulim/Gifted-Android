/*
 * Karasoft (c) 2015.
 *
 * Ashraf Ezzat
 */

package hasaedu.gifted.util;

import android.app.Activity;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Ashraf on Mar 12, 2015.
 */
public class Common {

    public static String readFromAsset(Activity act, String fileName) {
        String text = "";
        try {
            InputStream is = act.getAssets().open(fileName);

            int size = is.available();

            // Read the entire asset into a local byte buffer.
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }

}
