package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bxkj.base.v2.data.a;
import com.bxkj.student.v2.ui.main.MyFragment;
import com.google.android.material.button.MaterialButton;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class V2MainTabMyFragmentBinding extends ViewDataBinding {
    @NonNull
    public final MaterialButton btLogout;
    @NonNull
    public final CardView cardHead;
    @NonNull
    public final ImageView ivHead;
    @Bindable
    protected a mLoggedInUser;
    @Bindable
    protected MyFragment mMyFragment;
    @NonNull
    public final NestedScrollView root;
    @NonNull
    public final RecyclerView rvMenu;
    @NonNull
    public final TextView tvName;
    @NonNull
    public final TextView tvTitle;
    @NonNull
    public final TextView tvUserNumber;

    /* JADX INFO: Access modifiers changed from: protected */
    public V2MainTabMyFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, MaterialButton btLogout, CardView cardHead, ImageView ivHead, NestedScrollView root, RecyclerView rvMenu, TextView tvName, TextView tvTitle, TextView tvUserNumber) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btLogout = btLogout;
        this.cardHead = cardHead;
        this.ivHead = ivHead;
        this.root = root;
        this.rvMenu = rvMenu;
        this.tvName = tvName;
        this.tvTitle = tvTitle;
        this.tvUserNumber = tvUserNumber;
    }

    public static V2MainTabMyFragmentBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2MainTabMyFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public a getLoggedInUser() {
        return this.mLoggedInUser;
    }

    @Nullable
    public MyFragment getMyFragment() {
        return this.mMyFragment;
    }

    public abstract void setLoggedInUser(@Nullable a loggedInUser);

    public abstract void setMyFragment(@Nullable MyFragment myFragment);

    @Deprecated
    public static V2MainTabMyFragmentBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2MainTabMyFragmentBinding) ViewDataBinding.bind(component, view, 2131428095);
    }

    @NonNull
    @Deprecated
    public static V2MainTabMyFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2MainTabMyFragmentBinding) ViewDataBinding.inflateInternal(inflater, 2131428095, root, attachToRoot, component);
    }

    @NonNull
    public static V2MainTabMyFragmentBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2MainTabMyFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2MainTabMyFragmentBinding) ViewDataBinding.inflateInternal(inflater, 2131428095, null, false, component);
    }
}
