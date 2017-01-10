package net.vsona.projecta;

import net.vsona.common.app.CommonApp;
import net.vsona.common.constants.CommonConstants;
import net.vsona.common.logger.LogLevel;
import net.vsona.common.logger.Logger;
import net.vsona.common.logger.Settings;
import net.vsona.projecta.constants.Constants;

/**
 * Author   : roy
 * Data     : 2017-01-09  17:38
 * Describe :
 */

public class ProjectApp extends CommonApp {

    @Override
    protected void initData() {
        initLogger();
    }

    private void initLogger() {
        CommonConstants.isShowLog = Constants.Common.isShowLog;
        Settings settings = Logger.init("projectA");// default PRETTYLOGGER or use just init()
        settings.methodCount(1);                 // default 2
        settings.hideThreadInfo();               // default shown
        settings.logLevel(LogLevel.FULL);        // default LogLevel.FULL
//        settings.methodOffset(2);               // default 0
        settings.logAdapter(new ProjectLogAdapter());
    }

}
