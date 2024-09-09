package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.v2.common.view.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class AcFacePrivacyAgreementBinding extends ViewDataBinding {
    @NonNull
    public final Button btAgree;
    @NonNull
    public final Button btRefuse;
    @NonNull
    public final LinearLayout llBottom;
    @Bindable
    protected a mMActivity;
    @NonNull
    public final V2PubTitleBinding titleLayout;
    @NonNull
    public final TextView tvUserAgree;
    @NonNull
    public final TextView tvUserPrivate;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcFacePrivacyAgreementBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btAgree, Button btRefuse, LinearLayout llBottom, V2PubTitleBinding titleLayout, TextView tvUserAgree, TextView tvUserPrivate) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btAgree = btAgree;
        this.btRefuse = btRefuse;
        this.llBottom = llBottom;
        this.titleLayout = titleLayout;
        this.tvUserAgree = tvUserAgree;
        this.tvUserPrivate = tvUserPrivate;
    }

    public static AcFacePrivacyAgreementBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcFacePrivacyAgreementBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public a getMActivity() {
        return this.mMActivity;
    }

    public abstract void setMActivity(@Nullable a mActivity);

    @Deprecated
    public static AcFacePrivacyAgreementBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcFacePrivacyAgreementBinding) ViewDataBinding.bind(component, view, 2131427399);
    }

    @NonNull
    @Deprecated
    public static AcFacePrivacyAgreementBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcFacePrivacyAgreementBinding) ViewDataBinding.inflateInternal(inflater, 2131427399, root, attachToRoot, component);
    }

    @NonNull
    public static AcFacePrivacyAgreementBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcFacePrivacyAgreementBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcFacePrivacyAgreementBinding) ViewDataBinding.inflateInternal(inflater, 2131427399, null, false, component);
    }
}
