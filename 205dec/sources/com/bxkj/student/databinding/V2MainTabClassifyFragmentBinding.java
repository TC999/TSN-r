package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bxkj.student.v2.ui.main.ClassifyFragment;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class V2MainTabClassifyFragmentBinding extends ViewDataBinding {
    @NonNull
    public final CardView cardHome;
    @Bindable
    protected ClassifyFragment mClassifyFragment;
    @NonNull
    public final RecyclerView rvHomeMenu;
    @NonNull
    public final RecyclerView rvMenu;
    @NonNull
    public final ImageView tvHomeMenuArrow;
    @NonNull
    public final TextView tvHomeMenuCount;
    @NonNull
    public final TextView tvHomeMenuHint;
    @NonNull
    public final TextView tvTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public V2MainTabClassifyFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView cardHome, RecyclerView rvHomeMenu, RecyclerView rvMenu, ImageView tvHomeMenuArrow, TextView tvHomeMenuCount, TextView tvHomeMenuHint, TextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.cardHome = cardHome;
        this.rvHomeMenu = rvHomeMenu;
        this.rvMenu = rvMenu;
        this.tvHomeMenuArrow = tvHomeMenuArrow;
        this.tvHomeMenuCount = tvHomeMenuCount;
        this.tvHomeMenuHint = tvHomeMenuHint;
        this.tvTitle = tvTitle;
    }

    public static V2MainTabClassifyFragmentBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2MainTabClassifyFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public ClassifyFragment getClassifyFragment() {
        return this.mClassifyFragment;
    }

    public abstract void setClassifyFragment(@Nullable ClassifyFragment classifyFragment);

    @Deprecated
    public static V2MainTabClassifyFragmentBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2MainTabClassifyFragmentBinding) ViewDataBinding.bind(component, view, 2131428091);
    }

    @NonNull
    @Deprecated
    public static V2MainTabClassifyFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2MainTabClassifyFragmentBinding) ViewDataBinding.inflateInternal(inflater, 2131428091, root, attachToRoot, component);
    }

    @NonNull
    public static V2MainTabClassifyFragmentBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2MainTabClassifyFragmentBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2MainTabClassifyFragmentBinding) ViewDataBinding.inflateInternal(inflater, 2131428091, null, false, component);
    }
}
