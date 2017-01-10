package net.vsona.projecta.ui.page.joke;

import android.os.Bundle;

import net.vsona.common.utils.DataUtils;
import net.vsona.projecta.BasePresenter;
import net.vsona.projecta.domain.JockDo;
import net.vsona.projecta.domain.JokeResult;
import net.vsona.projecta.net.api.JokeService;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Author   : roy
 * Data     : 2017-01-10  12:20
 * Describe :
 */

public class JokePresenter extends BasePresenter<JokeContract.View> {

    int pageNum = 1;

    public JokePresenter(JokeContract.View view) {
        super(view);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
    }

    public void getData() {
        loadDataWithLoadMore(false);
    }

    public void getMoreData() {
        loadDataWithLoadMore(true);
    }

    private void loadDataWithLoadMore(boolean isLoadMore) {
        if (!isLoadMore) {
            pageNum = 1;
            mView.clearData();
        }
        JokeService.getJokes(pageNum).subscribe(new Observer<JokeResult>() {
            @Override
            public void onSubscribe(Disposable d) {
                bindDisposable(d);
            }

            @Override
            public void onNext(JokeResult value) {
                List<JockDo> contentlist = value.getShowapi_res_body().getContentlist();
                if (DataUtils.isEmpty(contentlist)) {
                    if (pageNum == 1) {
                        mView.showEmpty();
                    }
                    mView.setLoadFinish();
                } else {
                    pageNum++;
                }
                mView.showJokes(contentlist);
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onComplete() {
                mView.setRefreshing(false);
            }
        });
    }
}
