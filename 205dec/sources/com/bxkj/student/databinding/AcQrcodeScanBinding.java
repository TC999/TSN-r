package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import cn.bingoogolapple.qrcode.zbar.ZBarView;
import com.bxkj.base.databinding.NewPubTitleBinding;
import com.bxkj.student.run.extraclass.QrScanSignActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class AcQrcodeScanBinding extends ViewDataBinding {
    @Bindable
    protected QrScanSignActivity mQrScanActivity;
    @NonNull
    public final NewPubTitleBinding toolbar;
    @NonNull
    public final ZBarView zbarview;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcQrcodeScanBinding(Object _bindingComponent, View _root, int _localFieldCount, NewPubTitleBinding toolbar, ZBarView zbarview) {
        super(_bindingComponent, _root, _localFieldCount);
        this.toolbar = toolbar;
        this.zbarview = zbarview;
    }

    public static AcQrcodeScanBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcQrcodeScanBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public QrScanSignActivity getQrScanActivity() {
        return this.mQrScanActivity;
    }

    public abstract void setQrScanActivity(@Nullable QrScanSignActivity qrScanActivity);

    @Deprecated
    public static AcQrcodeScanBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcQrcodeScanBinding) ViewDataBinding.bind(component, view, 2131427466);
    }

    @NonNull
    @Deprecated
    public static AcQrcodeScanBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcQrcodeScanBinding) ViewDataBinding.inflateInternal(inflater, 2131427466, root, attachToRoot, component);
    }

    @NonNull
    public static AcQrcodeScanBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcQrcodeScanBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcQrcodeScanBinding) ViewDataBinding.inflateInternal(inflater, 2131427466, null, false, component);
    }
}
