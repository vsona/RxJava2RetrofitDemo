package net.vsona.projecta;

import android.os.Bundle;

import java.util.LinkedList;
import java.util.List;

import io.reactivex.disposables.Disposable;

/**
 * Author   : roy
 * Data     : 2017-01-09  19:05
 * Describe :
 */

public class BasePresenter<View extends IBaseView> implements IBasePresenter, ICanUnSubscribe {

    protected View mView;
    private List<Disposable> disposables = new LinkedList<>();

    public BasePresenter(View view) {
        mView = view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void bindDisposable(Disposable d) {
        disposables.add(d);
    }

    @Override
    public void detachView() {
        for (Disposable disposable : disposables) {
            if (!disposable.isDisposed()) disposable.dispose();
        }
        mView = null;
    }
}
