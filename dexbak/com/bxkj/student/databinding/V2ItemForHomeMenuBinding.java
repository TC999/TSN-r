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
import com.bxkj.base.p085v2.data.LoggedInUser;
import com.bxkj.student.C4215R;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class V2ItemForHomeMenuBinding extends ViewDataBinding {
    @NonNull
    public final ImageView ivIcon;
    @NonNull
    public final ImageView ivOp;
    @Bindable
    protected LoggedInUser mLoggedInUser;
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
    public LoggedInUser getLoggedInUser() {
        return this.mLoggedInUser;
    }

    @Nullable
    public Map<String, Object> getMap() {
        return this.mMap;
    }

    public abstract void setLoggedInUser(@Nullable LoggedInUser loggedInUser);

    public abstract void setMap(@Nullable Map<String, Object> map);

    @Deprecated
    public static V2ItemForHomeMenuBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2ItemForHomeMenuBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.v2_item_for_home_menu);
    }

    @NonNull
    @Deprecated
    public static V2ItemForHomeMenuBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2ItemForHomeMenuBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v2_item_for_home_menu, root, attachToRoot, component);
    }

    @NonNull
    public static V2ItemForHomeMenuBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2ItemForHomeMenuBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2ItemForHomeMenuBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v2_item_for_home_menu, null, false, component);
    }
}
