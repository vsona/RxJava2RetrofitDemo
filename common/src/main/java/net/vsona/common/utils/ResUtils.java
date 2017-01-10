package net.vsona.common.utils;

import android.support.annotation.ColorRes;
import android.support.annotation.StringRes;

import net.vsona.common.app.CommonApp;


public class ResUtils {

    public static String getString(@StringRes int res) {
        return CommonApp.getInstance().getResources().getString(res);
    }

    public static int getColorOfRes(@ColorRes int res) {
        return CommonApp.getInstance().getResources().getColor(res);
    }

}
