package net.vsona.projecta.net.http;

import net.vsona.projecta.constants.Constants;
import net.vsona.projecta.net.http.interceptor.ParamsInterceptor;
import net.vsona.projecta.net.http.interceptor.RockBaseLogInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Author   : roy
 * Data     : 2016-12-22  12:16
 * Describe :
 */

public class OkHttpHelper {

    private OkHttpClient sOkHttpClient;

    private static class Holder {
        private static OkHttpHelper sInstance = new OkHttpHelper();
    }

    public static OkHttpClient getOkClient() {
        return getInstance().sOkHttpClient;
    }

    public static OkHttpHelper getInstance() {
        return Holder.sInstance;
    }

    public OkHttpHelper() {
        sOkHttpClient = newOkClient();
    }

    private static OkHttpClient newOkClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        // 设置超时
        int connectTimeoutSeconds = 10;
        if (connectTimeoutSeconds > 0) {
            builder.connectTimeout(connectTimeoutSeconds, TimeUnit.SECONDS);
        }

        int readTimeoutSeconds = 10;
        if (readTimeoutSeconds > 0) {
            builder.readTimeout(readTimeoutSeconds, TimeUnit.SECONDS);
        }

        int writeTimeoutSeconds = 10;
        if (writeTimeoutSeconds > 0) {
            builder.writeTimeout(writeTimeoutSeconds, TimeUnit.SECONDS);
        }

        builder.addInterceptor(new ParamsInterceptor());
        if (Constants.Common.isShowLog) {
            // Log信息拦截器
            RockBaseLogInterceptor rockBaseLogInterceptor = new RockBaseLogInterceptor();
            rockBaseLogInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(rockBaseLogInterceptor);
        }
//        interceptors.add(new GzipRequestInterceptor());

        return builder.build();
    }
}
