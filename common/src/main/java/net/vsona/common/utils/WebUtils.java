package net.vsona.common.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;


import net.vsona.common.ActivityUtils;
import net.vsona.common.app.CommonApp;

import java.util.List;

/**
 * Author   : roy
 * Data     : 2016-12-28  14:33
 * Describe :
 */

public class WebUtils {

    public static final String W_SCHEME_PHONE = "tel";

    private static void jumpActivity(Intent intent){
        ActivityUtils.jump(intent);
    }
    private static Context getContext(){
        return CommonApp.getInstance();
    }

    public static boolean startWithNoWebUrl(Uri uri) {
        String path = uri.getPath();
        if (!TextUtils.isEmpty(path)) {
            Intent intent = FileUtils.buildOpenIntent(uri);
            if (intent != null) { //优先通过外部程序打开
                PackageManager packageManager = getContext().getPackageManager();
                List<ResolveInfo> activityInfoList = packageManager.queryIntentActivities(intent, PackageManager.MATCH_ALL);
                if (activityInfoList != null && activityInfoList.size() > 0) {
                    jumpActivity(intent);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean startWithPhone(Uri uri) {
        String scheme = uri.getScheme();
        if (TextUtils.equals(W_SCHEME_PHONE, scheme)) { //检查是否是电话uri
            String s = uri.toString();
            int minLength;
            if (s.startsWith("tel")) {
                minLength = 14;
            } else {
                minLength = 10;
            }
            //若低于长度不视作电话uri
            if (s.length() < minLength) {
                return true;
            }
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            jumpActivity(intent);
            return true;
        }
        return false;
    }
}
