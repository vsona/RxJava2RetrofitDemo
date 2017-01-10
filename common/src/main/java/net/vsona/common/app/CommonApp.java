package net.vsona.common.app;

import android.app.Application;

/**
 * Author   : roy
 * Data     : 2017-01-09  17:32
 * Describe :
 */

public abstract class CommonApp extends Application {

    private static CommonApp sCommonApp;

    public static Application getInstance() {
        return sCommonApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sCommonApp = this;
        initData();
    }

    protected abstract void initData();
}
