package net.vsona.common.utils;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

/**
 * 文件操作工具类
 *
 */
public class FileUtils {

    /**
     * 根据传入的path返回一个用于通过外部程序打开它的Intent
     *
     * @param uri
     * @return 如果不识别，则返回null
     */
    public static Intent buildOpenIntent(Uri uri) {
        if (uri == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        if (path.endsWith(".pdf")) {
            intent.setDataAndType(uri, "application/pdf");
        } else {
            return null;
        }
        return intent;
    }

}
