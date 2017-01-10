package net.vsona.projecta;

import android.util.Log;

import net.vsona.common.logger.LogAdapter;

import static net.vsona.common.logger.Logger.isShowLog;

/**
 * Author   : roy
 * Data     : 2016-10-19  17:33
 * Describe :
 */

public class ProjectLogAdapter implements LogAdapter {

    @Override
    public void d(String tag, String message) {
        if (isShowLog) {
            Log.d(tag, message);
        }
    }

    @Override
    public void e(String tag, String message) {
        if (isShowLog) {
            Log.e(tag, message);
        }
    }

    @Override
    public void w(String tag, String message) {
        if (isShowLog) {
            Log.w(tag, message);
        }
    }

    @Override
    public void i(String tag, String message) {
        if (isShowLog) {
            Log.i(tag, message);
        }
    }

    @Override
    public void v(String tag, String message) {
        if (isShowLog) {
            Log.v(tag, message);
        }
    }

    @Override
    public void wtf(String tag, String message) {
        if (isShowLog) {
            Log.wtf(tag, message);
        }
    }

    @Override
    public void net(String tag, String message) {
        if (isShowLog) {
            Log.d(tag, message);
        }
    }

}
