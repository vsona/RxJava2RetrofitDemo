package net.vsona.projecta.net;

import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import net.vsona.projecta.constants.Constants;
import net.vsona.projecta.net.http.NullOnEmptyConverterFactory;
import net.vsona.projecta.net.http.OkHttpHelper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Author   : roy
 * Data     : 2016-12-16  17:16
 * Describe :
 */

public class RetrofitHelper {

    private static class Holder {
        private static RetrofitHelper sRetrofitHelper = new RetrofitHelper();
    }

    private RetrofitHelper() {
    }

    public static RetrofitHelper getInstance() {
        return Holder.sRetrofitHelper;
    }

    public static Retrofit getJokeRetrofit() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constants.Url.JOKE)
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(OkHttpHelper.getOkClient())
                .build();
        return retrofit;
    }


}
