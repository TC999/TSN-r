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
import com.bxkj.base.p085v2.common.view.OnBackPress;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class V2AcScanQrcodeBinding extends ViewDataBinding {
    @NonNull
    public final V2PubTitleBinding includeTitle;
    @Bindable
    protected OnBackPress mBackEvent;
    @NonNull
    public final ZBarView zbarview;

    /* JADX INFO: Access modifiers changed from: protected */
    public V2AcScanQrcodeBinding(Object _bindingComponent, View _root, int _localFieldCount, V2PubTitleBinding includeTitle, ZBarView zbarview) {
        super(_bindingComponent, _root, _localFieldCount);
        this.includeTitle = includeTitle;
        this.zbarview = zbarview;
    }

    public static V2AcScanQrcodeBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V2AcScanQrcodeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public OnBackPress getBackEvent() {
        return this.mBackEvent;
    }

    public abstract void setBackEvent(@Nullable OnBackPress backEvent);

    @Deprecated
    public static V2AcScanQrcodeBinding bind(@NonNull View view, @Nullable Object component) {
        return (V2AcScanQrcodeBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.v2_ac_scan_qrcode);
    }

    @NonNull
    @Deprecated
    public static V2AcScanQrcodeBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V2AcScanQrcodeBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v2_ac_scan_qrcode, root, attachToRoot, component);
    }

    @NonNull
    public static V2AcScanQrcodeBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V2AcScanQrcodeBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V2AcScanQrcodeBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v2_ac_scan_qrcode, null, false, component);
    }
}
