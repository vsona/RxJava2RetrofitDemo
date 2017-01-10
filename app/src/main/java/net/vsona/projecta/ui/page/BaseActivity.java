package net.vsona.projecta.ui.page;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import net.vsona.projecta.BasePresenter;
import net.vsona.projecta.ProjectDialog;

import butterknife.ButterKnife;

/**
 * Author   : roy
 * Data     : 2017-01-09  17:55
 * Describe :
 */

public abstract class BaseActivity<Presenter extends BasePresenter> extends AppCompatActivity {

    protected ProjectDialog mDialog = new ProjectDialog();
    protected Presenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        init(savedInstanceState);
        mPresenter.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
//        TitleBar toolbar = (TitleBar) findViewById(R.id.vs_toolbar);
//        setSupportActionBar(null);
//        if (toolbar != null) {
//            toolbar.setTitle(getTitle().toString());
//            toolbar.setShowBack(true);
//            toolbar.setTitleBarBackClickEvent(() -> finish());
//        }
        ButterKnife.bind(this);
    }

    public abstract Presenter createPresenter();

    protected abstract void init(Bundle savedInstanceState);
}
