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
import com.bxkj.student.C4215R;
import com.bxkj.student.p094v2.p098ui.dialog.NoticeDialog;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class DialogTipsBinding extends ViewDataBinding {
    @NonNull

    /* renamed from: bt */
    public final AppCompatButton f16281bt;
    @NonNull

    /* renamed from: iv */
    public final ImageView f16282iv;
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
        this.f16281bt = bt;
        this.f16282iv = iv;
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
        return (DialogTipsBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.dialog_tips);
    }

    @NonNull
    @Deprecated
    public static DialogTipsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (DialogTipsBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.dialog_tips, root, attachToRoot, component);
    }

    @NonNull
    public static DialogTipsBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static DialogTipsBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (DialogTipsBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.dialog_tips, null, false, component);
    }
}
