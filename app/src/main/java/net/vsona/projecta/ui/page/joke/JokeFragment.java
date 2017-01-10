package net.vsona.projecta.ui.page.joke;

import android.support.v7.widget.LinearLayoutManager;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import net.vsona.common.widget.LoadMoreView;
import net.vsona.projecta.BaseFragment;
import net.vsona.projecta.R;
import net.vsona.projecta.domain.JockDo;

import java.util.List;

import butterknife.BindView;

/**
 * Author   : roy
 * Data     : 2017-01-10  12:09
 * Describe :
 */

public class JokeFragment extends BaseFragment<JokePresenter> implements JokeContract.View {

    @BindView(R.id.vs_recycler)
    EasyRecyclerView mRecyclerView;
    private JokeAdapter mJokeAdapter;
    private LoadMoreView mLoadMoreView;

    @Override
    protected void init() {
        mLoadMoreView = new LoadMoreView(mActivity);
        mJokeAdapter = new JokeAdapter(mActivity);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRecyclerView.setAdapter(mJokeAdapter);
        mRecyclerView.setRefreshListener(() -> {
            mLoadMoreView.setLoading();
            mPresenter.getData();
        });
        mJokeAdapter.setMore(mLoadMoreView, new RecyclerArrayAdapter.OnMoreListener() {
            @Override
            public void onMoreShow() {
                mPresenter.getMoreData();
            }

            @Override
            public void onMoreClick() {

            }
        });
        mJokeAdapter.setNoMore(mLoadMoreView);
    }

    @Override
    public JokePresenter createPresenter() {
        return new JokePresenter(this);
    }

    @Override
    protected int getRootLayoutResource() {
        return R.layout.fragment_joke;
    }

    public static JokeFragment newtInstance() {
        return new JokeFragment();
    }

    @Override
    public void showJokes(List<JockDo> contentlist) {
        mJokeAdapter.addAll(contentlist);
        mJokeAdapter.notifyDataSetChanged();
    }

    @Override
    public void clearData() {
        mJokeAdapter.clear();
    }

    @Override
    public void showEmpty() {
        mRecyclerView.showEmpty();
    }

    @Override
    public void setLoadFinish() {
        mJokeAdapter.stopMore();
        mLoadMoreView.setLoadFinish();
    }

    @Override
    public void setRefreshing(boolean b) {
        mRecyclerView.setRefreshing(b);
    }
}
