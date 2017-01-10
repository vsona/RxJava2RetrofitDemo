package net.vsona.projecta.net.http.interceptor;

import android.text.TextUtils;

import net.vsona.common.utils.MapUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * Author   : roy
 * Data     : 2016-08-18  15:59
 * Describe :
 */
public class ParamsInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        //添加服务器端需要的请求头部
        Request newRequest = getNewRequestBuilder(request).build();
        return chain.proceed(newRequest);
    }

    private Request.Builder getNewRequestBuilder(Request request) {

        Request.Builder builder = request.newBuilder();

        Map<String, String> params = null;
        Map<String, String> headerParams = null;

        if (!MapUtils.isEmpty(headerParams)) {
            for (Map.Entry<String, String> entry : headerParams.entrySet()) {
                builder.addHeader(entry.getKey(), entry.getValue());
            }
        }

        if (!MapUtils.isEmpty(params)) {
            //接口参数
            if (canSpliceBody(request)) {
                FormBody.Builder formBodyBuilder = new FormBody.Builder();
                if (params.size() > 0) {
                    for (Map.Entry<String, String> entry : params.entrySet()) {
                        formBodyBuilder.add(entry.getKey(), entry.getValue());
                    }
                }
                RequestBody formBody = formBodyBuilder.build();
                String postBodyString = convertOkHttpBodyToString(formBody);
                builder.post(RequestBody.create(MediaType.parse("application/x-www-form-urlencoded;charset=UTF-8"), postBodyString));
            } else {
                spliceRockParams2Url(request, builder, params);
            }
        }

        return builder;
    }

    private Map<String, String> parseResourceRequest2Params(Request request) {
        HashMap<String, String> params = new HashMap<>();
        params.putAll(parseGetParamsWithRequest(request));
        params.putAll(parsePostParamsWithRequest(request));
        return params;
    }

    private boolean canSpliceBody(Request request) {
        if (request == null) {
            return false;
        }
        if (!TextUtils.equals(request.method(), "POST")) {
            return false;
        }
        RequestBody body = request.body();
        if (body == null) {
            return true;
        }
        MediaType mediaType = body.contentType();
        if (mediaType == null) {
            return true;
        }
        if (TextUtils.equals(mediaType.subtype(), "multi-part")) {
            return false;
        }
        return true;
    }

    // func to inject params into url
    private void spliceRockParams2Url(Request request, Request.Builder requestBuilder, Map<String, String> paramsMap) {
        HttpUrl.Builder httpUrlBuilder = request.url().newBuilder();
        if (!MapUtils.isEmpty(paramsMap)) {
            for (Map.Entry<String, String> entry : paramsMap.entrySet()) {
                httpUrlBuilder.addQueryParameter(entry.getKey(), entry.getValue());
            }
        }
        requestBuilder.url(httpUrlBuilder.build());
    }

    private static String convertOkHttpBodyToString(final RequestBody requestBody) {
        if (requestBody == null) {
            return "";
        }
        try {
            final Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }

    private static Map<String, String> parsePostParamsWithRequest(final Request request) {
        RequestBody requestBody = request.body();
        Map<String, String> params = new HashMap<>();
        String str = convertOkHttpBodyToString(requestBody);
        if (!TextUtils.isEmpty(str)) {
            String[] items = str.split("&");
            if (items.length > 0) {
                for (String item : items) {
                    if (!TextUtils.isEmpty(item)) {
                        String[] kv = item.split("=");
                        if (kv.length == 2) {
                            try {
                                String value = (kv[1] == null ? "" : URLDecoder.decode(kv[1], "UTF-8"));
                                params.put(kv[0], value);
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return params;
    }

    private Map<String, String> parseGetParamsWithRequest(Request request) {
        String query = request.url().encodedQuery();
        Map<String, String> params = new HashMap<>();
        if (!TextUtils.isEmpty(query)) {
            String[] items = query.split("&");
            if (items != null && items.length > 0) {
                for (String item : items) {
                    if (!TextUtils.isEmpty(item)) {
                        String[] kv = item.split("=");
                        if (kv.length == 2) {
                            try {
                                String value = (kv[1] == null ? "" : URLDecoder.decode(kv[1], "UTF-8"));
                                params.put(kv[0], value);
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
        return params;
    }
}
