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
import com.bxkj.base.p085v2.common.view.OnBackPress;
import com.bxkj.student.C4215R;
import com.bxkj.student.p094v2.p098ui.p101my.AboutUsActivity;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
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
    protected OnBackPress mBackEvent;
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
    public OnBackPress getBackEvent() {
        return this.mBackEvent;
    }

    @Nullable
    public String getTitle() {
        return this.mTitle;
    }

    public abstract void setActivity(@Nullable AboutUsActivity activity);

    public abstract void setBackEvent(@Nullable OnBackPress backEvent);

    public abstract void setTitle(@Nullable String title);

    @Deprecated
    public static V2AboutUsBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2AboutUsBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.v2_about_us);
    }

    @NonNull
    @Deprecated
    public static V2AboutUsBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2AboutUsBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v2_about_us, root, attachToRoot, component);
    }

    @NonNull
    public static V2AboutUsBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2AboutUsBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2AboutUsBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v2_about_us, null, false, component);
    }
}
