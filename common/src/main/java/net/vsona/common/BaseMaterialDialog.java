package net.vsona.common;

import android.content.Context;
import android.support.annotation.StringRes;
import android.text.TextUtils;

import com.afollestad.materialdialogs.MaterialDialog;

public class BaseMaterialDialog {

    private MaterialDialog dialog;

    protected void dismiss() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
    }
    public MaterialDialog getDialog(){
        return this.dialog;
    }

    protected void showWithBuilder(MaterialDialog.Builder builder) {
        dismiss();
        if (builder == null) return ;
        this.dialog = builder.build();
        this.dialog.show();
    }

    protected void showLoading(Context context) {
        dismiss();
        if (context == null) return;
        MaterialDialog.Builder builder = newSimpleProgressLoadingBuilder(context);
        this.dialog = builder.build();
        this.dialog.show();
    }

    protected static MaterialDialog.Builder newBuilder(Context context) {
        return new MaterialDialog.Builder(context);
    }

    protected static MaterialDialog.Builder newSimpleProgressLoadingBuilder(Context context, CharSequence cs) {
        CharSequence message = "加载中...";
        if (!TextUtils.isEmpty(cs)) {
            message = cs;
        }
        return newBuilder(context).title(message).progress(true, 0);
    }

    protected static MaterialDialog.Builder newSimpleProgressLoadingBuilder(Context context, @StringRes int StrRes) {
        String message = context.getString(StrRes);
        return newSimpleProgressLoadingBuilder(context, message);
    }

    protected static MaterialDialog.Builder newSimpleProgressLoadingBuilder(Context context) {
        return newSimpleProgressLoadingBuilder(context, null);
    }

    protected static MaterialDialog.Builder newSimpleTitleContentBuilder(Context context, CharSequence title, CharSequence content) {
        return newBuilder(context).title(title).content(content);
    }

    protected static MaterialDialog.Builder newSimpleTitleContentPositiveBuilder(Context context, CharSequence title, CharSequence content) {
        return newSimpleTitleContentBuilder(context, title, content).positiveText("确定");
    }

}
