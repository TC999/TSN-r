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
import com.bxkj.base.v2.data.a;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class V2ItemForHomeMenuBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivIcon;
    @NonNull
    public final ImageView ivOp;
    @Bindable
    protected a mLoggedInUser;
    @Bindable
    protected Map<String, Object> mMap;
    @NonNull
    public final TextView tvName;

    /* JADX INFO: Access modifiers changed from: protected */
    public V2ItemForHomeMenuBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView ivIcon, ImageView ivOp, TextView tvName) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ivIcon = ivIcon;
        this.ivOp = ivOp;
        this.tvName = tvName;
    }

    public static V2ItemForHomeMenuBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2ItemForHomeMenuBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public a getLoggedInUser() {
        return this.mLoggedInUser;
    }

    @Nullable
    public Map<String, Object> getMap() {
        return this.mMap;
    }

    public abstract void setLoggedInUser(@Nullable a loggedInUser);

    public abstract void setMap(@Nullable Map<String, Object> map);

    @Deprecated
    public static V2ItemForHomeMenuBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2ItemForHomeMenuBinding) ViewDataBinding.bind(component, view, 2131428088);
    }

    @NonNull
    @Deprecated
    public static V2ItemForHomeMenuBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2ItemForHomeMenuBinding) ViewDataBinding.inflateInternal(inflater, 2131428088, root, attachToRoot, component);
    }

    @NonNull
    public static V2ItemForHomeMenuBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2ItemForHomeMenuBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2ItemForHomeMenuBinding) ViewDataBinding.inflateInternal(inflater, 2131428088, null, false, component);
    }
}
