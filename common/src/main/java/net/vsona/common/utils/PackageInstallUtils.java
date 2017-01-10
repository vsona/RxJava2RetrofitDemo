package net.vsona.common.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;


import net.vsona.common.app.CommonApp;

import java.util.List;

/**
 * Author   : roy
 * Data     : 2017-01-09  18:32
 * Describe :
 */

public class PackageInstallUtils {

    public static boolean isWeiXinInstall() {
        return isAppInstall(CommonApp.getInstance(), "com.tencent.mm");
    }

    public static boolean isSinaInstall() {
        return isAppInstall(CommonApp.getInstance(), "com.sina.weibo");
    }

    private static boolean isAppInstall(Context context, String packageName) {
        final PackageManager packageManager = context.getPackageManager();
        // 获取所有已安装程序的包信息
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);
        for (int i = 0; i < pinfo.size(); i++) {
            if (pinfo.get(i).packageName.equalsIgnoreCase(packageName))
                return true;
        }
        return false;
    }
}
