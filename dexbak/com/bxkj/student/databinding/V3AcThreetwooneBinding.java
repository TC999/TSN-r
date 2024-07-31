package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class V3AcThreetwooneBinding extends ViewDataBinding {
    @NonNull
    public final RelativeLayout rlThreetwoone;
    @NonNull
    public final TextView tvNumber;

    /* JADX INFO: Access modifiers changed from: protected */
    public V3AcThreetwooneBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout rlThreetwoone, TextView tvNumber) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rlThreetwoone = rlThreetwoone;
        this.tvNumber = tvNumber;
    }

    public static V3AcThreetwooneBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3AcThreetwooneBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static V3AcThreetwooneBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3AcThreetwooneBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.v3_ac_threetwoone);
    }

    @NonNull
    @Deprecated
    public static V3AcThreetwooneBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3AcThreetwooneBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v3_ac_threetwoone, root, attachToRoot, component);
    }

    @NonNull
    public static V3AcThreetwooneBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3AcThreetwooneBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3AcThreetwooneBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v3_ac_threetwoone, null, false, component);
    }
}
