package net.vsona.projecta.net;

import net.vsona.projecta.domain.JokeResult;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * Author   : roy
 * Data     : 2017-01-10  16:08
 * Describe :
 */

public class ApiUtils {

    public static Observable<JokeResult> callJoke(Observable<JokeResult> joke) {
        return joke
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .filter(jokeResult -> jokeResult.getShowapi_res_code() == 0)
                //some thing convert eg .map(result -> { convert(result) })
                .observeOn(AndroidSchedulers.mainThread());
    }

}
