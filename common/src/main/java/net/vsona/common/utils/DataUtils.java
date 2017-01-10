package net.vsona.common.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import net.vsona.common.app.CommonApp;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 数据操作工具类
 */
public class DataUtils {

    public static <T> boolean isEmpty(List<T> list) {
        return list == null || list.size() == 0;
    }

    public static <T> boolean isEmpty(T[] ts) {
        return ts == null || ts.length == 0;
    }

    public static String filterPoint(double number) {
        if (number % 1.0 == 0) {
            return Double.valueOf(number).intValue() + "";
        }
        return String.valueOf(number);
    }

    /**
     * 数组转成用逗号连接
     */
    @NonNull
    public static String genStringArray2StringWithComma(String[] arr) {
        if (ArrayUtils.isEmpty(arr)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (String id : arr) {
            sb.append(id).append(",");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public static boolean isEmailLegal(String email) {
        if (TextUtils.isEmpty(email)) return false;

        final String REGEXP = "^([a-z0-9\\-_.+]+)@([a-z0-9\\-]+[.][a-z0-9\\-.]+)$";
        Pattern p = Pattern.compile(REGEXP);
        Matcher m = p.matcher(email.toLowerCase());
        return m.matches();
    }

    // 获取application中指定的meta-data
    public static String getChannel() {
        return getMetaData("APP_CHANNEL");
    }

    // 获取application中指定的meta-data
    public static String getMetaData(String key) {
        if (TextUtils.isEmpty(key)) {
            throw new NullPointerException("key == null!!!");
        }
        String resultData = null;
        Context context = CommonApp.getInstance();
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        resultData = applicationInfo.metaData.getString(key);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return resultData;
    }
    /**
     * Get channel from META-INF directory.
     *
     * @return the channel name if success,otherwise return "none"
    public static String getChannel() {
        ApplicationInfo appinfo = CommonApp.newInstance().getApplicationInfo();
        String sourceDir = appinfo.sourceDir;
        String ret = "";
        ZipFile zipfile = null;
        try {
            zipfile = new ZipFile(sourceDir);
            Enumeration<?> entries = zipfile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = ((ZipEntry) entries.nextElement());
                String entryName = entry.getName();
                if (entryName.startsWith("META-INF/channel")) {
                    ret = entryName;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (zipfile != null) {
                try {
                    zipfile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        String[] split = ret.split("_");
        if (split != null && split.length >= 2) {
            return ret.substring(split[0].length() + 1);

        } else {
            return "none";
        }
    }
     */
}
