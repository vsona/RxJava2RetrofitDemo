package net.vsona.projecta.ui.holder;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import java.util.HashSet;

import butterknife.ButterKnife;

public class MartianAdapterViewHolder<T> extends BaseViewHolder<T> implements IViewHolder {

    private T mData;
    private MartianViewHolder mMartianViewHolder;

    protected MartianAdapterViewHolder(ViewGroup parent) {
        super(parent);
        mMartianViewHolder = new MartianViewHolder(itemView);
        ButterKnife.bind(this, itemView);
    }

    protected MartianAdapterViewHolder(ViewGroup parent, @LayoutRes int res) {
        super(parent, res);
        mMartianViewHolder = new MartianViewHolder(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(T data) {
        this.mData = data;
    }

    public T getData() {
        return mData;
    }

    @Override
    public IViewHolder setText(int viewId, CharSequence value) {
        mMartianViewHolder.setText(viewId, value);
        return this;
    }

    @Override
    public IViewHolder setText(int viewId, @StringRes int strId) {
        mMartianViewHolder.setText(viewId, strId);
        return this;
    }

    @Override
    public IViewHolder setImageResource(int viewId, @DrawableRes int imageResId) {
        mMartianViewHolder.setImageResource(viewId, imageResId);
        return this;
    }

    @Override
    public IViewHolder setBackgroundColor(int viewId, int color) {
        mMartianViewHolder.setBackgroundColor(viewId, color);
        return this;
    }

    @Override
    public IViewHolder setBackgroundRes(int viewId, @DrawableRes int backgroundRes) {
        mMartianViewHolder.setBackgroundRes(viewId, backgroundRes);
        return this;
    }

    @Override
    public IViewHolder setTextColor(int viewId, int textColor) {
        mMartianViewHolder.setTextColor(viewId, textColor);
        return this;
    }

    @Override
    public IViewHolder setImageDrawable(int viewId, Drawable drawable) {
        mMartianViewHolder.setImageDrawable(viewId, drawable);
        return this;
    }

    @Override
    public IViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        mMartianViewHolder.setImageBitmap(viewId, bitmap);
        return this;
    }

    @Override
    public IViewHolder setAlpha(int viewId, float value) {
        mMartianViewHolder.setAlpha(viewId, value);
        return this;
    }

    @Override
    public IViewHolder setVisible(int viewId, boolean visible) {
        mMartianViewHolder.setVisible(viewId, visible);
        return this;
    }

    @Override
    public IViewHolder linkify(int viewId) {
        mMartianViewHolder.linkify(viewId);
        return this;
    }

    @Override
    public IViewHolder setTypeface(int viewId, Typeface typeface) {
        mMartianViewHolder.setTypeface(viewId, typeface);
        return this;
    }

    @Override
    public IViewHolder setTypeface(Typeface typeface, int... viewIds) {
        mMartianViewHolder.setTypeface(typeface, viewIds);
        return this;
    }

    @Override
    public IViewHolder setProgress(int viewId, int progress) {
        mMartianViewHolder.setProgress(viewId, progress);
        return this;
    }

    @Override
    public IViewHolder setProgress(int viewId, int progress, int max) {
        mMartianViewHolder.setProgress(viewId, progress, max);
        return this;
    }

    @Override
    public IViewHolder setMax(int viewId, int max) {
        mMartianViewHolder.setMax(viewId, max);
        return this;
    }

    @Override
    public IViewHolder setRating(int viewId, float rating) {
        mMartianViewHolder.setRating(viewId, rating);
        return this;
    }

    @Override
    public IViewHolder setRating(int viewId, float rating, int max) {
        mMartianViewHolder.setRating(viewId, rating, max);
        return this;
    }

    @Override
    public IViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        mMartianViewHolder.setOnClickListener(viewId, listener);
        return this;
    }

    @Override
    public IViewHolder setOnTouchListener(int viewId, View.OnTouchListener listener) {
        return this;
    }

    @Override
    public IViewHolder setOnLongClickListener(int viewId, View.OnLongClickListener listener) {
        mMartianViewHolder.setOnLongClickListener(viewId, listener);
        return this;
    }

    @Override
    public IViewHolder setOnCheckedChangeListener(int viewId, CompoundButton.OnCheckedChangeListener listener) {
        mMartianViewHolder.setOnCheckedChangeListener(viewId, listener);
        return this;
    }

    @Override
    public IViewHolder setTag(int viewId, Object tag) {
        mMartianViewHolder.setTag(viewId, tag);
        return this;
    }

    @Override
    public IViewHolder setTag(int viewId, int key, Object tag) {
        mMartianViewHolder.setTag(viewId, tag);
        return this;
    }

    @Override
    public IViewHolder setChecked(int viewId, boolean checked) {
        mMartianViewHolder.setChecked(viewId, checked);
        return null;
    }

    @Override
    public IViewHolder addOnClickListener(int viewId) {
        mMartianViewHolder.addOnClickListener(viewId);
        return this;
    }

    @Override
    public IViewHolder addOnLongClickListener(int viewId) {
        mMartianViewHolder.addOnLongClickListener(viewId);
        return this;
    }

    @Override
    public HashSet<Integer> getItemChildLongClickViewIds() {
        return mMartianViewHolder.getItemChildLongClickViewIds();
    }

    @Override
    public HashSet<Integer> getChildClickViewIds() {
        return mMartianViewHolder.getChildClickViewIds();
    }

    @Override
    public <TV extends View> TV getView(int viewId) {
        return mMartianViewHolder.getView(viewId);
    }
}
