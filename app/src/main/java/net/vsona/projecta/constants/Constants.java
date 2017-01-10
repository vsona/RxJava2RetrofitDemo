package net.vsona.projecta.constants;

import android.support.annotation.StringDef;

import net.vsona.projecta.BuildConfig;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Author   : roy
 * Data     : 2017-01-10  15:43
 * Describe :
 */

public class Constants {

    public @interface Common {
        boolean debug = BuildConfig.DEBUG;
        boolean isShowLog = BuildConfig.IS_SHOW_LOG;
    }

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({Url.JOKE})
    public @interface Url {
        String JOKE = "http://apis.baidu.com/showapi_open_bus/";
    }

}
