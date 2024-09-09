package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.v2.common.view.a;
import com.bxkj.student.v2.ui.my.AboutUsActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class V2AboutUsBinding extends ViewDataBinding {
    @NonNull
    public final FrameLayout flTop;
    @NonNull
    public final V2PubTitleBinding includeTitle;
    @NonNull
    public final ImageView ivIcon;
    @NonNull
    public final ImageView ivLogo;
    @Bindable
    protected AboutUsActivity mActivity;
    @Bindable
    protected a mBackEvent;
    @Bindable
    protected String mTitle;
    @NonNull
    public final TextView tvName;
    @NonNull
    public final TextView tvVersion;

    /* JADX INFO: Access modifiers changed from: protected */
    public V2AboutUsBinding(Object _bindingComponent, View _root, int _localFieldCount, FrameLayout flTop, V2PubTitleBinding includeTitle, ImageView ivIcon, ImageView ivLogo, TextView tvName, TextView tvVersion) {
        super(_bindingComponent, _root, _localFieldCount);
        this.flTop = flTop;
        this.includeTitle = includeTitle;
        this.ivIcon = ivIcon;
        this.ivLogo = ivLogo;
        this.tvName = tvName;
        this.tvVersion = tvVersion;
    }

    public static V2AboutUsBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2AboutUsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public AboutUsActivity getActivity() {
        return this.mActivity;
    }

    @Nullable
    public a getBackEvent() {
        return this.mBackEvent;
    }

    @Nullable
    public String getTitle() {
        return this.mTitle;
    }

    public abstract void setActivity(@Nullable AboutUsActivity activity);

    public abstract void setBackEvent(@Nullable a backEvent);

    public abstract void setTitle(@Nullable String title);

    @Deprecated
    public static V2AboutUsBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2AboutUsBinding) ViewDataBinding.bind(component, view, 2131428081);
    }

    @NonNull
    @Deprecated
    public static V2AboutUsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2AboutUsBinding) ViewDataBinding.inflateInternal(inflater, 2131428081, root, attachToRoot, component);
    }

    @NonNull
    public static V2AboutUsBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2AboutUsBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2AboutUsBinding) ViewDataBinding.inflateInternal(inflater, 2131428081, null, false, component);
    }
}
