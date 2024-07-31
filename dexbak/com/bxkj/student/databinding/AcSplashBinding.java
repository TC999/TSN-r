package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class AcSplashBinding extends ViewDataBinding {
    @NonNull
    public final FrameLayout adsFl;
    @NonNull

    /* renamed from: iv */
    public final ImageView f16275iv;
    @NonNull
    public final TextView tvTime;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcSplashBinding(Object _bindingComponent, View _root, int _localFieldCount, FrameLayout adsFl, ImageView iv, TextView tvTime) {
        super(_bindingComponent, _root, _localFieldCount);
        this.adsFl = adsFl;
        this.f16275iv = iv;
        this.tvTime = tvTime;
    }

    public static AcSplashBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcSplashBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AcSplashBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcSplashBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.ac_splash);
    }

    @NonNull
    @Deprecated
    public static AcSplashBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcSplashBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_splash, root, attachToRoot, component);
    }

    @NonNull
    public static AcSplashBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcSplashBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcSplashBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_splash, null, false, component);
    }
}
