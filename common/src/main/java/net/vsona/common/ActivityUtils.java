package net.vsona.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import net.vsona.common.app.CommonApp;


/**
 * Author: roy
 * Date ： 2016/4/28 16:05
 */
public class ActivityUtils {

    public interface IBuilder {
        void with(Intent intent);
    }

    public static void jump(Intent intent) {
        Context context = CommonApp.getInstance();
        context.startActivity(intent);
    }

    public static void jump(Class<?> targetActivity) {
        jump(targetActivity, null);
    }

    public static void jump(Class<?> targetActivity, IBuilder iBuilder) {
        Context context = CommonApp.getInstance();
        Intent intent = new Intent(context, targetActivity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (iBuilder != null) {
            iBuilder.with(intent);
        }
        context.startActivity(intent);
    }

    public static void jumpForResult(Activity sourceActivity, Class<?> targetActivity, int requestCode) {
        jumpForResult(sourceActivity, targetActivity, requestCode, null);
    }

    public static void jumpForResult(Activity sourceActivity, Class<?> targetActivity, int requestCode, Bundle bdl) {
        Intent intent = new Intent(sourceActivity, targetActivity);
        if (bdl != null) {
            intent.putExtras(bdl);
        }
        sourceActivity.startActivityForResult(intent, requestCode);
    }

    public static void backResult(Activity sourceActivity, int resultCode) {
        backResult(sourceActivity, resultCode, null);
    }

    public static void backResult(Activity sourceActivity, int resultCode, Bundle bdl) {
        Intent intent = new Intent();
        if (bdl != null) {
            intent.putExtras(bdl);
        }
        sourceActivity.setResult(resultCode, intent);
    }

}
