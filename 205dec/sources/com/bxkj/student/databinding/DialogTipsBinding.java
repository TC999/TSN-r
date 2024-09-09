package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.v2.ui.dialog.NoticeDialog;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class DialogTipsBinding extends ViewDataBinding {
    @NonNull
    public final AppCompatButton bt;
    @NonNull
    public final ImageView iv;
    @NonNull
    public final LinearLayout llMsg;
    @Bindable
    protected NoticeDialog mDialog;
    @NonNull
    public final TextView tvContent;
    @NonNull
    public final TextView tvTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public DialogTipsBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatButton bt, ImageView iv, LinearLayout llMsg, TextView tvContent, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.bt = bt;
        this.iv = iv;
        this.llMsg = llMsg;
        this.tvContent = tvContent;
        this.tvTitle = tvTitle;
    }

    public static DialogTipsBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static DialogTipsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public NoticeDialog getDialog() {
        return this.mDialog;
    }

    public abstract void setDialog(@Nullable NoticeDialog dialog);

    @Deprecated
    public static DialogTipsBinding bind(@NonNull View view, @Nullable Object component) {
        return (DialogTipsBinding) ViewDataBinding.bind(component, view, 2131427609);
    }

    @NonNull
    @Deprecated
    public static DialogTipsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (DialogTipsBinding) ViewDataBinding.inflateInternal(inflater, 2131427609, root, attachToRoot, component);
    }

    @NonNull
    public static DialogTipsBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogTipsBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (DialogTipsBinding) ViewDataBinding.inflateInternal(inflater, 2131427609, null, false, component);
    }
}
