package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.p085v2.common.view.OnBackPress;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class V2MyQrcodeBinding extends ViewDataBinding {
    @NonNull
    public final V2PubTitleBinding includeTitle;
    @NonNull
    public final ImageView ivBar;
    @NonNull
    public final ImageView ivCode;
    @Bindable
    protected OnBackPress mBackEvent;
    @Bindable
    protected String mTitle;
    @NonNull
    public final TextView tvName;
    @NonNull
    public final TextView tvQrcodeTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public V2MyQrcodeBinding(Object _bindingComponent, View _root, int _localFieldCount, V2PubTitleBinding includeTitle, ImageView ivBar, ImageView ivCode, TextView tvName, TextView tvQrcodeTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.includeTitle = includeTitle;
        this.ivBar = ivBar;
        this.ivCode = ivCode;
        this.tvName = tvName;
        this.tvQrcodeTitle = tvQrcodeTitle;
    }

    public static V2MyQrcodeBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2MyQrcodeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public OnBackPress getBackEvent() {
        return this.mBackEvent;
    }

    @Nullable
    public String getTitle() {
        return this.mTitle;
    }

    public abstract void setBackEvent(@Nullable OnBackPress backEvent);

    public abstract void setTitle(@Nullable String title);

    @Deprecated
    public static V2MyQrcodeBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2MyQrcodeBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.v2_my_qrcode);
    }

    @NonNull
    @Deprecated
    public static V2MyQrcodeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2MyQrcodeBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v2_my_qrcode, root, attachToRoot, component);
    }

    @NonNull
    public static V2MyQrcodeBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2MyQrcodeBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2MyQrcodeBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v2_my_qrcode, null, false, component);
    }
}
