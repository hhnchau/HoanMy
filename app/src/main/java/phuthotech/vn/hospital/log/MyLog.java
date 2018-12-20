package phuthotech.vn.hospital.log;

import android.util.Log;

/**
 * Created by kingpes on 8/18/18.
 */

public class MyLog {
    private static final String TAG = "LOG --> ";

    public static void print(String s) {
        boolean log = true;
        if (log) {
            Log.d(TAG, s);
        }
    }
}


