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
import com.bxkj.student.v2.ui.sports.v3.detail.V3RankTipsDialog;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class V3RankDialogBinding extends ViewDataBinding {
    @Bindable
    protected V3RankTipsDialog mDialog;
    @NonNull
    public final CardView rlThreetwoone;
    @NonNull
    public final TextView tvMsg;

    /* JADX INFO: Access modifiers changed from: protected */
    public V3RankDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView rlThreetwoone, TextView tvMsg) {
        super(_bindingComponent, _root, _localFieldCount);
        this.rlThreetwoone = rlThreetwoone;
        this.tvMsg = tvMsg;
    }

    public static V3RankDialogBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3RankDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Nullable
    public V3RankTipsDialog getDialog() {
        return this.mDialog;
    }

    public abstract void setDialog(@Nullable V3RankTipsDialog dialog);

    @Deprecated
    public static V3RankDialogBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3RankDialogBinding) ViewDataBinding.bind(component, view, 2131428116);
    }

    @NonNull
    @Deprecated
    public static V3RankDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3RankDialogBinding) ViewDataBinding.inflateInternal(inflater, 2131428116, root, attachToRoot, component);
    }

    @NonNull
    public static V3RankDialogBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3RankDialogBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3RankDialogBinding) ViewDataBinding.inflateInternal(inflater, 2131428116, null, false, component);
    }
}
