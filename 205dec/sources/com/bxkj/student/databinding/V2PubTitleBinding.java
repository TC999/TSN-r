package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.v2.common.view.a;
import com.bxkj.base.view.MarqueeTextView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class V2PubTitleBinding extends ViewDataBinding {
    @NonNull
    public final AppCompatImageButton ibBack;
    @NonNull
    public final ConstraintLayout llTitle;
    @Bindable
    protected a mActivity;
    @Bindable
    protected Boolean mIsHideBack;
    @Bindable
    protected String mTitle;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final MarqueeTextView tvTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public V2PubTitleBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatImageButton ibBack, ConstraintLayout llTitle, Toolbar toolbar, MarqueeTextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ibBack = ibBack;
        this.llTitle = llTitle;
        this.toolbar = toolbar;
        this.tvTitle = tvTitle;
    }

    public static V2PubTitleBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2PubTitleBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public a getActivity() {
        return this.mActivity;
    }

    @Nullable
    public Boolean getIsHideBack() {
        return this.mIsHideBack;
    }

    @Nullable
    public String getTitle() {
        return this.mTitle;
    }

    public abstract void setActivity(@Nullable a activity);

    public abstract void setIsHideBack(@Nullable Boolean isHideBack);

    public abstract void setTitle(@Nullable String title);

    @Deprecated
    public static V2PubTitleBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2PubTitleBinding) ViewDataBinding.bind(component, view, 2131428100);
    }

    @NonNull
    @Deprecated
    public static V2PubTitleBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2PubTitleBinding) ViewDataBinding.inflateInternal(inflater, 2131428100, root, attachToRoot, component);
    }

    @NonNull
    public static V2PubTitleBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2PubTitleBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2PubTitleBinding) ViewDataBinding.inflateInternal(inflater, 2131428100, null, false, component);
    }
}
