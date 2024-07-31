package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.bxkj.student.C4215R;
import com.bxkj.student.p094v2.p098ui.sports.p102v3.V3PassPointDialog;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class V3PassPointDialogBinding extends ViewDataBinding {
    @Bindable
    protected V3PassPointDialog mDialog;
    @NonNull
    public final CardView rlThreetwoone;
    @NonNull

    /* renamed from: rv */
    public final RecyclerView f16287rv;
    @NonNull
    public final TextView tvTitleHint;

    /* JADX INFO: Access modifiers changed from: protected */
    public V3PassPointDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView rlThreetwoone, RecyclerView rv, TextView tvTitleHint) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rlThreetwoone = rlThreetwoone;
        this.f16287rv = rv;
        this.tvTitleHint = tvTitleHint;
    }

    public static V3PassPointDialogBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3PassPointDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public V3PassPointDialog getDialog() {
        return this.mDialog;
    }

    public abstract void setDialog(@Nullable V3PassPointDialog dialog);

    @Deprecated
    public static V3PassPointDialogBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3PassPointDialogBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.v3_pass_point_dialog);
    }

    @NonNull
    @Deprecated
    public static V3PassPointDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3PassPointDialogBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v3_pass_point_dialog, root, attachToRoot, component);
    }

    @NonNull
    public static V3PassPointDialogBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3PassPointDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3PassPointDialogBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.v3_pass_point_dialog, null, false, component);
    }
}
