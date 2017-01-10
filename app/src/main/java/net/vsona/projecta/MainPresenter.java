package net.vsona.projecta;

import android.os.Bundle;
import android.os.SystemClock;

import net.vsona.common.logger.Logger;
import net.vsona.common.utils.WeakHandler;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Author   : roy
 * Data     : 2017-01-09  20:04
 * Describe :
 */

public class MainPresenter extends BasePresenter<MainContract.View> {

    public MainPresenter(MainContract.View view) {
        super(view);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Observable<Integer> zip = Observable
                .zip(getDemoObservable(), getDemoObservable(), (i, i2) -> 0)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io());
        final long startTime = System.currentTimeMillis();
        zip.subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                bindDisposable(d);
            }

            @Override
            public void onNext(Integer value) {
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                Logger.d("--->> onCompleted bind time " + (System.currentTimeMillis() - startTime));
                long delayTime = BuildConfig.SPLASH_TIME - (System.currentTimeMillis() - startTime);
                if (delayTime < 0) {
                    delayTime = 0;
                }
                new WeakHandler(message -> {//TODO refactor
                    mView.enterHomeActivity();
                    return true;
                }).sendEmptyMessageDelayed(0, delayTime);
            }
        });
    }

    private Observable<Integer> getDemoObservable() {
        return Observable.create(e -> {
            SystemClock.sleep(1000);
            e.onNext(0);
            e.onComplete();
        });
    }
}
