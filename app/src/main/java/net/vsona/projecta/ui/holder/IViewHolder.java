package net.vsona.projecta.ui.holder;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.CompoundButton;

import java.util.HashSet;

public interface IViewHolder {

    /**
     * Will set the text of a TextView.
     */
    IViewHolder setText(int viewId, CharSequence value);

    IViewHolder setText(int viewId, @StringRes int strId);

    /**
     * Will set the image of an ImageView from a resource id.
     */
    IViewHolder setImageResource(int viewId, @DrawableRes int imageResId);

    /**
     * Will set background color of a iView.
     */
    IViewHolder setBackgroundColor(int viewId, int color);

    /**
     * Will set background of a iView.
     */
    IViewHolder setBackgroundRes(int viewId, @DrawableRes int backgroundRes);

    /**
     * Will set text color of a TextView.
     */
    IViewHolder setTextColor(int viewId, int textColor);

    /**
     * Will set the image of an ImageView from a drawable.
     */
    IViewHolder setImageDrawable(int viewId, Drawable drawable);

    /**
     * Add an action to set the image of an image iView. Can be called multiple times.
     */
    IViewHolder setImageBitmap(int viewId, Bitmap bitmap);

    /**
     * Add an action to set the alpha of a iView. Can be called multiple times.
     * Alpha between 0-1.
     */
    IViewHolder setAlpha(int viewId, float value);

    /**
     * Set a iView visibility to VISIBLE (true) or GONE (false).
     */
    IViewHolder setVisible(int viewId, boolean visible);

    /**
     * Add links into a TextView.
     */
    IViewHolder linkify(int viewId);

    /**
     * Apply the typeface to the given viewId, and enable subpixel rendering.
     */
    IViewHolder setTypeface(int viewId, Typeface typeface);

    /**
     * Apply the typeface to all the given viewIds, and enable subpixel rendering.
     */
    IViewHolder setTypeface(Typeface typeface, int... viewIds);

    /**
     * Sets the progress of a ProgressBar.
     */
    IViewHolder setProgress(int viewId, int progress);

    /**
     * Sets the progress and max of a ProgressBar.
     */
    IViewHolder setProgress(int viewId, int progress, int max);

    /**
     * Sets the range of a ProgressBar to 0...max.
     */
    IViewHolder setMax(int viewId, int max);

    /**
     * Sets the rating (the number of stars filled) of a RatingBar.
     */
    IViewHolder setRating(int viewId, float rating);

    /**
     * Sets the rating (the number of stars filled) and max of a RatingBar.
     */
    IViewHolder setRating(int viewId, float rating, int max);

    /**
     * Sets the on click listener of the iView.
     */
    IViewHolder setOnClickListener(int viewId, View.OnClickListener listener);

    /**
     * Sets the on touch listener of the iView.
     */
    IViewHolder setOnTouchListener(int viewId, View.OnTouchListener listener);

    /**
     * Sets the on long click listener of the iView.
     */
    IViewHolder setOnLongClickListener(int viewId, View.OnLongClickListener listener);

    /**
     * Sets the on checked change listener of the iView.
     */
    IViewHolder setOnCheckedChangeListener(int viewId, CompoundButton.OnCheckedChangeListener listener);

    /**
     * Sets the tag of the iView.
     */
    IViewHolder setTag(int viewId, Object tag);

    /**
     * Sets the tag of the iView.
     */
    IViewHolder setTag(int viewId, int key, Object tag);

    /**
     * Sets the checked status of a checkable.
     */
    IViewHolder setChecked(int viewId, boolean checked);

    // TODO 子控件事件组 satrt
    // add childView id
    IViewHolder addOnClickListener(int viewId);

    // add long click iView id
    IViewHolder addOnLongClickListener(int viewId);

    HashSet<Integer> getItemChildLongClickViewIds();

    HashSet<Integer> getChildClickViewIds();
    // 子控件点击事件 end

    <TV extends View> TV getView(int viewId);

}
