package net.vsona.common.utils;

import android.content.Context;

import java.lang.ref.WeakReference;

/**
 * Author   : roy
 * Data     : 2016-08-31  15:44
 * Describe :
 */

public class ContextUtils {

    private static WeakReference<Context> contextWeakReference;

    public static void init(Context context) {
        contextWeakReference = new WeakReference<>(context);
    }

    public static Context get() {
        if (contextWeakReference == null) {
            throw new RuntimeException("ContextUtils's contextWeakReference is null , not call init");
        }
        return contextWeakReference.get();
    }
}
