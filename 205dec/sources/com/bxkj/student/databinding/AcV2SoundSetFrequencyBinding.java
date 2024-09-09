package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.v2.ui.sports.set.SoundFrequencyActivity;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class AcV2SoundSetFrequencyBinding extends ViewDataBinding {
    @NonNull
    public final Button btOk;
    @Bindable
    protected SoundFrequencyActivity mMActivity;
    @NonNull
    public final RadioGroup rg;
    @NonNull
    public final V3PubTitleBinding titleLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcV2SoundSetFrequencyBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btOk, RadioGroup rg, V3PubTitleBinding titleLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btOk = btOk;
        this.rg = rg;
        this.titleLayout = titleLayout;
    }

    public static AcV2SoundSetFrequencyBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static AcV2SoundSetFrequencyBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public SoundFrequencyActivity getMActivity() {
        return this.mMActivity;
    }

    public abstract void setMActivity(@Nullable SoundFrequencyActivity mActivity);

    @Deprecated
    public static AcV2SoundSetFrequencyBinding bind(@NonNull View view, @Nullable Object component) {
        return (AcV2SoundSetFrequencyBinding) ViewDataBinding.bind(component, view, 2131427508);
    }

    @NonNull
    @Deprecated
    public static AcV2SoundSetFrequencyBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV2SoundSetFrequencyBinding) ViewDataBinding.inflateInternal(inflater, 2131427508, root, attachToRoot, component);
    }

    @NonNull
    public static AcV2SoundSetFrequencyBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV2SoundSetFrequencyBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV2SoundSetFrequencyBinding) ViewDataBinding.inflateInternal(inflater, 2131427508, null, false, component);
    }
}
