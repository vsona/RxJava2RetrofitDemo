package net.vsona.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import net.vsona.common.R;

public class LoadMoreView extends FrameLayout {

    TextView mTvText;

    public LoadMoreView(Context context) {
        this(context, null);
    }

    public LoadMoreView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.widget_load_more, this);
        mTvText = (TextView) view.findViewById(R.id.vs_text);
        setLoading();
    }

    public void setLoading() {
        mTvText.setText("加载中...");
    }

    public void setLoadFinish() {
        mTvText.setText("加载完毕");
    }

}
