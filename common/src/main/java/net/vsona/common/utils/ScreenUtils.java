package net.vsona.common.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;


import net.vsona.common.app.CommonApp;

import java.lang.reflect.Field;
import java.math.BigDecimal;

/**
 * Author   : roy
 * Data     : 2016-08-29  16:07
 * Describe :
 */

public class ScreenUtils {

    public static int getStatusBarHeight() {
        Class<?> c;
        Object obj;
        Field field;
        int x, statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = CommonApp.getInstance().getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return statusBarHeight;
    }

    /**
     * Get ActionBar size.
     *
     * @return
     */
    public static int getActionBarSize() {
        int actionBarSize = 0;
        TypedValue tv = new TypedValue();
        if (CommonApp.getInstance().getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            actionBarSize = TypedValue.complexToDimensionPixelSize(tv.data,
                    CommonApp.getInstance().getResources().getDisplayMetrics());
        }
        return actionBarSize;
    }
    /**
     * @return return screen width px unit.
     */
    public static int getScreenWidth() {
        WindowManager wm = (WindowManager) CommonApp.getInstance().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x;
    }

    /**
     * @return return screen height px unit.
     */
    public static int getScreenHeigth() {
        WindowManager wm = (WindowManager) CommonApp.getInstance().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.y;
    }

    public static int getScreenMinWidth() {
        WindowManager wm = (WindowManager) CommonApp.getInstance().getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return Math.min(size.x, size.y);
    }
    /**
     * Determine if the device is a tablet (i.e. it has a large screen).
     *
     * @return
     */
    public static boolean isTablet() {
        return (CommonApp.getInstance().getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public static float dpToPx(float dp) {
        return dp * CommonApp.getInstance().getResources().getDisplayMetrics().density;
    }

    public static float pxToDp(float px) {
        return px / CommonApp.getInstance().getResources().getDisplayMetrics().density;
    }

    public static int transformPx2Current(int px, int templatePx) {
        return (int) (getScreenWidth() * round((double) px / templatePx, 3));
    }

    public static float dpToPxInt( float dp) {
        return (int)(dpToPx(dp) + 0.5f);
    }

    public static float pxToDpCeilInt(Context context, float px) {
        return (int)(pxToDp( px) + 0.5f);
    }

    /**
     * 提供精确的小数位四舍五入处理。
     *
     * @param number 需要四舍五入的数字
     * @param scale  小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(Double number, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = null == number ? new BigDecimal("0.0") : new BigDecimal(
                Double.toString(number));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }
}
