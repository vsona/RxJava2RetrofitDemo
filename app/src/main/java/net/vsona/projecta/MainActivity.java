package net.vsona.projecta;

import android.os.Bundle;

import net.vsona.projecta.ui.page.BaseActivity;
import net.vsona.projecta.ui.page.home.HomeActivity;

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
    }

    @Override
    public void enterHomeActivity() {
        HomeActivity.startUp();
        finish();
    }
}
