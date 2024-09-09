package com.bxkj.base.databinding;

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
import com.bxkj.base.R;
import com.bxkj.base.v2.common.view.a;
import com.bxkj.base.view.MarqueeTextView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public abstract class NewPubTitleBinding extends ViewDataBinding {
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
    public NewPubTitleBinding(Object obj, View view, int i4, AppCompatImageButton appCompatImageButton, ConstraintLayout constraintLayout, Toolbar toolbar, MarqueeTextView marqueeTextView) {
        super(obj, view, i4);
        this.ibBack = appCompatImageButton;
        this.llTitle = constraintLayout;
        this.toolbar = toolbar;
        this.tvTitle = marqueeTextView;
    }

    public static NewPubTitleBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static NewPubTitleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        return inflate(layoutInflater, viewGroup, z3, DataBindingUtil.getDefaultComponent());
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

    public abstract void setActivity(@Nullable a aVar);

    public abstract void setIsHideBack(@Nullable Boolean bool);

    public abstract void setTitle(@Nullable String str);

    @Deprecated
    public static NewPubTitleBinding bind(@NonNull View view, @Nullable Object obj) {
        return (NewPubTitleBinding) ViewDataBinding.bind(obj, view, R.layout.new_pub_title);
    }

    @NonNull
    @Deprecated
    public static NewPubTitleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3, @Nullable Object obj) {
        return (NewPubTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.new_pub_title, viewGroup, z3, obj);
    }

    @NonNull
    public static NewPubTitleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static NewPubTitleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (NewPubTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.new_pub_title, null, false, obj);
    }
}
