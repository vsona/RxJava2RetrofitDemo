package net.vsona.projecta.ui.page.joke;

import android.content.Context;
import android.text.Html;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import net.vsona.projecta.R;
import net.vsona.projecta.domain.JockDo;
import net.vsona.projecta.ui.page.holder.MartianAdapterViewHolder;

/**
 * Author   : roy
 * Data     : 2017-01-10  17:11
 * Describe :
 */

public class JokeAdapter extends RecyclerArrayAdapter<JockDo> {

    public JokeAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MartianAdapterViewHolder<JockDo>(parent, R.layout.item_joke) {
            @Override
            public void setData(JockDo data) {
                super.setData(data);
                setText(R.id.title, "#" + data.getTitle() + "#");
                setText(R.id.time, getDateBySplit(data.getCt()));
                /*使html中<标签>得以转化*/
                setText(R.id.content, Html.fromHtml(data.getText().toString()));
            }
        };
    }

    public static String getDateBySplit(String str) {
        String[] strings = str.split(" ");
        return strings[0];
    }
}
