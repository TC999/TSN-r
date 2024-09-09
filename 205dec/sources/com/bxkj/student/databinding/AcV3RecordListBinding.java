package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.view.MarqueeTextView;
import com.bxkj.student.v2.ui.sports.v3.record.V3RecordListActivity;
import com.google.android.material.tabs.TabLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class AcV3RecordListBinding extends ViewDataBinding {
    @NonNull
    public final AppCompatImageButton ibBack;
    @NonNull
    public final AppCompatImageView ivSet;
    @NonNull
    public final LinearLayout llContent;
    @Bindable
    protected V3RecordListActivity mMActivity;
    @NonNull
    public final TabLayout tb;
    @NonNull
    public final MarqueeTextView tvTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcV3RecordListBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatImageButton ibBack, AppCompatImageView ivSet, LinearLayout llContent, TabLayout tb, MarqueeTextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ibBack = ibBack;
        this.ivSet = ivSet;
        this.llContent = llContent;
        this.tb = tb;
        this.tvTitle = tvTitle;
    }

    public static AcV3RecordListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV3RecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public V3RecordListActivity getMActivity() {
        return this.mMActivity;
    }

    public abstract void setMActivity(@Nullable V3RecordListActivity mActivity);

    @Deprecated
    public static AcV3RecordListBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV3RecordListBinding) ViewDataBinding.bind(component, view, 2131427513);
    }

    @NonNull
    @Deprecated
    public static AcV3RecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV3RecordListBinding) ViewDataBinding.inflateInternal(inflater, 2131427513, root, attachToRoot, component);
    }

    @NonNull
    public static AcV3RecordListBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV3RecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV3RecordListBinding) ViewDataBinding.inflateInternal(inflater, 2131427513, null, false, component);
    }
}
