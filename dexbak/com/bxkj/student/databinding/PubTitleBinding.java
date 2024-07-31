package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.view.MarqueeTextView;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class PubTitleBinding extends ViewDataBinding {
    @NonNull
    public final AppCompatImageButton ibBack;
    @NonNull
    public final AppCompatImageButton ibRight;
    @NonNull
    public final ConstraintLayout llTitle;
    @Bindable
    protected AppCompatActivity mActivity;
    @Bindable
    protected Boolean mIsHideBack;
    @Bindable
    protected String mTitle;
    @NonNull
    public final MarqueeTextView tvTitle;

    /* JADX INFO: Access modifiers changed from: protected */
    public PubTitleBinding(Object _bindingComponent, View _root, int _localFieldCount, AppCompatImageButton ibBack, AppCompatImageButton ibRight, ConstraintLayout llTitle, MarqueeTextView tvTitle) {
        super(_bindingComponent, _root, _localFieldCount);
        this.ibBack = ibBack;
        this.ibRight = ibRight;
        this.llTitle = llTitle;
        this.tvTitle = tvTitle;
    }

    public static PubTitleBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static PubTitleBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public AppCompatActivity getActivity() {
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

    public abstract void setActivity(@Nullable AppCompatActivity activity);

    public abstract void setIsHideBack(@Nullable Boolean isHideBack);

    public abstract void setTitle(@Nullable String title);

    @Deprecated
    public static PubTitleBinding bind(@NonNull View view, @Nullable Object component) {
        return (PubTitleBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.pub_title);
    }

    @NonNull
    @Deprecated
    public static PubTitleBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (PubTitleBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.pub_title, root, attachToRoot, component);
    }

    @NonNull
    public static PubTitleBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static PubTitleBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (PubTitleBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.pub_title, null, false, component);
    }
}
