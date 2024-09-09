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
import com.bxkj.student.v2.ui.sports.v3.detail.V3ExceptionDialog;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class V3ExceptionDialogBinding extends ViewDataBinding {
    @Bindable
    protected V3ExceptionDialog mDialog;
    @NonNull
    public final CardView rlThreetwoone;
    @NonNull
    public final TextView tvMsg;
    @NonNull
    public final TextView tvTitleHint;

    /* JADX INFO: Access modifiers changed from: protected */
    public V3ExceptionDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView rlThreetwoone, TextView tvMsg, TextView tvTitleHint) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rlThreetwoone = rlThreetwoone;
        this.tvMsg = tvMsg;
        this.tvTitleHint = tvTitleHint;
    }

    public static V3ExceptionDialogBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3ExceptionDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public V3ExceptionDialog getDialog() {
        return this.mDialog;
    }

    public abstract void setDialog(@Nullable V3ExceptionDialog dialog);

    @Deprecated
    public static V3ExceptionDialogBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3ExceptionDialogBinding) ViewDataBinding.bind(component, view, 2131428103);
    }

    @NonNull
    @Deprecated
    public static V3ExceptionDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3ExceptionDialogBinding) ViewDataBinding.inflateInternal(inflater, 2131428103, root, attachToRoot, component);
    }

    @NonNull
    public static V3ExceptionDialogBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3ExceptionDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3ExceptionDialogBinding) ViewDataBinding.inflateInternal(inflater, 2131428103, null, false, component);
    }
}
