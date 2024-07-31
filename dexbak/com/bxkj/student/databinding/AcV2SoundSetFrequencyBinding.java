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
import com.bxkj.student.C4215R;
import com.bxkj.student.p094v2.p098ui.sports.set.SoundFrequencyActivity;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class AcV2SoundSetFrequencyBinding extends ViewDataBinding {
    @NonNull
    public final Button btOk;
    @Bindable
    protected SoundFrequencyActivity mMActivity;
    @NonNull

    /* renamed from: rg */
    public final RadioGroup f16277rg;
    @NonNull
    public final V3PubTitleBinding titleLayout;

    /* JADX INFO: Access modifiers changed from: protected */
    public AcV2SoundSetFrequencyBinding(Object _bindingComponent, View _root, int _localFieldCount, Button btOk, RadioGroup rg, V3PubTitleBinding titleLayout) {
        super(_bindingComponent, _root, _localFieldCount);
        this.btOk = btOk;
        this.f16277rg = rg;
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
        return (AcV2SoundSetFrequencyBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.ac_v2_sound_set_frequency);
    }

    @NonNull
    @Deprecated
    public static AcV2SoundSetFrequencyBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (AcV2SoundSetFrequencyBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_v2_sound_set_frequency, root, attachToRoot, component);
    }

    @NonNull
    public static AcV2SoundSetFrequencyBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static AcV2SoundSetFrequencyBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (AcV2SoundSetFrequencyBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.ac_v2_sound_set_frequency, null, false, component);
    }
}
