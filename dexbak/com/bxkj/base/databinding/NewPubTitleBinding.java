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
import com.bxkj.base.C3801R;
import com.bxkj.base.p085v2.common.view.OnBackPress;
import com.bxkj.base.view.MarqueeTextView;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public abstract class NewPubTitleBinding extends ViewDataBinding {
    @NonNull
    public final AppCompatImageButton ibBack;
    @NonNull
    public final ConstraintLayout llTitle;
    @Bindable
    protected OnBackPress mActivity;
    @Bindable
    protected Boolean mIsHideBack;
    @Bindable
    protected String mTitle;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final MarqueeTextView tvTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public NewPubTitleBinding(Object obj, View view, int i, AppCompatImageButton appCompatImageButton, ConstraintLayout constraintLayout, Toolbar toolbar, MarqueeTextView marqueeTextView) {
        super(obj, view, i);
        this.ibBack = appCompatImageButton;
        this.llTitle = constraintLayout;
        this.toolbar = toolbar;
        this.tvTitle = marqueeTextView;
    }

    public static NewPubTitleBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static NewPubTitleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public OnBackPress getActivity() {
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

    public abstract void setActivity(@Nullable OnBackPress onBackPress);

    public abstract void setIsHideBack(@Nullable Boolean bool);

    public abstract void setTitle(@Nullable String str);

    @Deprecated
    public static NewPubTitleBinding bind(@NonNull View view, @Nullable Object obj) {
        return (NewPubTitleBinding) ViewDataBinding.bind(obj, view, C3801R.C3807layout.new_pub_title);
    }

    @NonNull
    @Deprecated
    public static NewPubTitleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z, @Nullable Object obj) {
        return (NewPubTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, C3801R.C3807layout.new_pub_title, viewGroup, z, obj);
    }

    @NonNull
    public static NewPubTitleBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static NewPubTitleBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable Object obj) {
        return (NewPubTitleBinding) ViewDataBinding.inflateInternal(layoutInflater, C3801R.C3807layout.new_pub_title, null, false, obj);
    }
}
