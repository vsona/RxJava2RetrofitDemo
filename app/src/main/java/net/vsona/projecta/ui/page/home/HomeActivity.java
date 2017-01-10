package net.vsona.projecta.ui.page.home;

import android.os.Bundle;

import net.vsona.common.ActivityUtils;
import net.vsona.projecta.R;
import net.vsona.projecta.ui.page.BaseActivity;
import net.vsona.projecta.ui.page.joke.JokeFragment;

/**
 * Author   : roy
 * Data     : 2017-01-09  18:58
 * Describe :
 */

public class HomeActivity extends BaseActivity<HomePresenter> implements HomeContract.View {

    private JokeFragment mFragment;

    public static void startUp() {
        ActivityUtils.jump(HomeActivity.class);
    }

    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter(this);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setContentView(R.layout.activity_home);
        mFragment = JokeFragment.newtInstance();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.vs_content_frame_fragment, mFragment, "joke")
                .commit();
    }

}
