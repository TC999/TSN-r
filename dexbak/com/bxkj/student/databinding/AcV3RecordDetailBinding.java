package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import cn.bluemobi.dylan.base.view.NoSlidingViewPager;
import com.bxkj.base.view.MarqueeTextView;
import com.bxkj.student.C4215R;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.detail.V3RecordDetailActivity;
import com.google.android.material.tabs.TabLayout;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class AcV3RecordDetailBinding extends ViewDataBinding {
    @NonNull
    public final AppCompatImageButton ibBack;
    @Bindable
    protected V3RecordDetailActivity mMActivity;
    @NonNull

    /* renamed from: tb */
    public final TabLayout f16278tb;
    @NonNull
    public final TextView toolbar;
    @NonNull
    public final MarqueeTextView tvTitle;
    @NonNull
    public final NoSlidingViewPager viewPager;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcV3RecordDetailBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatImageButton ibBack, TabLayout tb, TextView toolbar, MarqueeTextView tvTitle, NoSlidingViewPager viewPager) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ibBack = ibBack;
        this.f16278tb = tb;
        this.toolbar = toolbar;
        this.tvTitle = tvTitle;
        this.viewPager = viewPager;
    }

    public static AcV3RecordDetailBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV3RecordDetailBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public V3RecordDetailActivity getMActivity() {
        return this.mMActivity;
    }

    public abstract void setMActivity(@Nullable V3RecordDetailActivity mActivity);

    @Deprecated
    public static AcV3RecordDetailBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV3RecordDetailBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.ac_v3_record_detail);
    }

    @NonNull
    @Deprecated
    public static AcV3RecordDetailBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV3RecordDetailBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_v3_record_detail, root, attachToRoot, component);
    }

    @NonNull
    public static AcV3RecordDetailBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV3RecordDetailBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV3RecordDetailBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_v3_record_detail, null, false, component);
    }
}
