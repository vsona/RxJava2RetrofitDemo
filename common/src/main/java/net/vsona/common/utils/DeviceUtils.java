package net.vsona.common.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by wangsf on 16/9/22.
 */

public final class DeviceUtils {

    public static String getModel() {
        return Build.MODEL;
    }

    public static String getIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String imei = (telephonyManager == null ? null : telephonyManager.getDeviceId());
        return imei == null ? "" : imei;
    }

    public static String getIMSI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String imsi = (telephonyManager == null ? null : telephonyManager.getSubscriberId());
        return imsi == null ? "" : imsi;
    }

    public static String getMac(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = (wifiManager == null ? null : wifiManager.getConnectionInfo());
        String mac = (wifiInfo == null ? null : wifiInfo.getMacAddress());
        return mac;
    }

    public static String getUniqueId(Context context) {
        final String defaultMac = "02:00:00:00:00:00";
        try {
            String interfaceName = "wlan0";
            Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaceEnumeration != null) {
                List<NetworkInterface> interfaces = Collections.list(networkInterfaceEnumeration);
                for (NetworkInterface intf : interfaces) {
                    if (!intf.getName().equalsIgnoreCase(interfaceName)) {
                        continue;
                    }
                    byte[] mac = intf.getHardwareAddress();
                    if (mac == null) {
                        return defaultMac;
                    }
                    StringBuilder buf = new StringBuilder();
                    for (byte aMac : mac) {
                        buf.append(String.format("%02X:", aMac));
                    }
                    if (buf.length() > 0) {
                        buf.deleteCharAt(buf.length() - 1);
                    }
                    return buf.toString();
                }
            }
        } catch (Exception ex) {
            // for now eat exceptions
        }

        return defaultMac;
    }

    public static String getDeviceId(Context context) {
        String deviceId = "android";
        String uniqueId = getUniqueId(context);
        if(!TextUtils.isEmpty(uniqueId)) {
            return deviceId + uniqueId;
        }

        String imei = getIMEI(context);
        if (!TextUtils.isEmpty(imei)) {
            return deviceId + imei;
        }

        String imsi = getIMSI(context);
        if (!TextUtils.isEmpty(imsi)) {
            return deviceId + imsi;
        }

        String mac = getMac(context);
        if (!TextUtils.isEmpty(mac)) {
            return deviceId + mac;
        }

        return deviceId;
    }

    /**
     * return screenWidth * screenHeight * screenDensityDpi
     *
     * @param context
     * @return
     */
    public static String getScreenString(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels + "*" + dm.heightPixels + "*" + dm.densityDpi;
    }

    public static int getOSVersion() {
        return Build.VERSION.SDK_INT;
    }

    public static String getLanguage(Context context) {
        Configuration config = context.getResources().getConfiguration();
        if (config != null && config.locale != null) {
            return config.locale.getLanguage();
        }
        return "";
    }
}
