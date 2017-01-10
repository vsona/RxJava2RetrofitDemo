package net.vsona.projecta.net.api;


import net.vsona.projecta.domain.JokeResult;
import net.vsona.projecta.net.ApiUtils;
import net.vsona.projecta.net.RetrofitHelper;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

/**
 * Author   : roy
 * Data     : 2017-01-10  14:53
 * Describe :
 */
public class JokeService {

    private static IJokeApi API_JOKE = RetrofitHelper.getJokeRetrofit().create(IJokeApi.class);

    public static Observable<JokeResult> getJokes(int page) {
        return ApiUtils.callJoke(API_JOKE.getJoke(page));
    }

    interface IJokeApi {
        @Headers("apikey:83ec99fff780989a5376a1bc595ed5ff")
        @GET("showapi_joke/joke_text")
        Observable<JokeResult> getJoke(@Query("page") int page);

        @GET("showapi_joke/joke_text")
        Call<JokeResult> callJoke(@Header("apikey") String apikey, @Query("page") int page);
    }
}
