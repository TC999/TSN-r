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
import com.bxkj.student.C4215R;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.record.V3RecordListActivity;
import com.google.android.material.tabs.TabLayout;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
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

    /* renamed from: tb */
    public final TabLayout f16279tb;
    @NonNull
    public final MarqueeTextView tvTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcV3RecordListBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatImageButton ibBack, AppCompatImageView ivSet, LinearLayout llContent, TabLayout tb, MarqueeTextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ibBack = ibBack;
        this.ivSet = ivSet;
        this.llContent = llContent;
        this.f16279tb = tb;
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
        return (AcV3RecordListBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.ac_v3_record_list);
    }

    @NonNull
    @Deprecated
    public static AcV3RecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV3RecordListBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_v3_record_list, root, attachToRoot, component);
    }

    @NonNull
    public static AcV3RecordListBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV3RecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV3RecordListBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_v3_record_list, null, false, component);
    }
}
