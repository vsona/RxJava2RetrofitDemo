package net.vsona.projecta;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

/**
 * Author   : roy
 * Data     : 2017-01-10  12:09
 * Describe :
 */

public abstract class BaseFragment<Presenter extends BasePresenter> extends Fragment {

    protected Presenter mPresenter;
    protected View mRootView;
    protected FragmentActivity mActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        if (mRootView == null) {
            int rootLayoutResource = getRootLayoutResource();
            if (rootLayoutResource != 0) {
                mRootView = inflater.inflate(rootLayoutResource, container, false);
                ButterKnife.bind(this, mRootView);
            }
        }
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mActivity = getActivity();
        init();
        mPresenter.onCreate(savedInstanceState);
    }

    protected abstract void init();

    public abstract Presenter createPresenter();

    @LayoutRes
    protected abstract int getRootLayoutResource();

}
