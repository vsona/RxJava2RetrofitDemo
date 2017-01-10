package net.vsona.common.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import net.vsona.common.app.CommonApp;


/**
 * Author   : roy
 * Data     : 2016-08-29  16:03
 * Describe :
 */

public class NetUtils {
    /**
     * Checked the network connect status.
     */
    public static boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) CommonApp.getInstance()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    /**
     * Check WIFI connection.
     *
     * @return
     */
    public static boolean isWifiConnected() {
        ConnectivityManager cm = (ConnectivityManager) CommonApp.getInstance()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return (info != null && ConnectivityManager.TYPE_WIFI == info.getType());
    }

    /**
     *
     * Get Current Network Type
     *
     * @return
     */
    public static String getNetworkType() {
        ConnectivityManager cm = (ConnectivityManager) CommonApp.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return (info == null ? "None" : (ConnectivityManager.TYPE_WIFI == info.getType() ?
            "Wifi" : "Mobile"));
    }
}
