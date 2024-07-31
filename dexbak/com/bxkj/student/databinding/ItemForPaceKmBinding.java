package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.student.C4215R;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public abstract class ItemForPaceKmBinding extends ViewDataBinding {
    @NonNull
    public final ProgressBar pbDistance;
    @NonNull
    public final TextView tvAvgPaceHint;
    @NonNull
    public final TextView tvNumber;

    /* JADX INFO: Access modifiers changed from: protected */
    public ItemForPaceKmBinding(Object _bindingComponent, View _root, int _localFieldCount, ProgressBar pbDistance, TextView tvAvgPaceHint, TextView tvNumber) {
        super(_bindingComponent, _root, _localFieldCount);
        this.pbDistance = pbDistance;
        this.tvAvgPaceHint = tvAvgPaceHint;
        this.tvNumber = tvNumber;
    }

    public static ItemForPaceKmBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static ItemForPaceKmBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ItemForPaceKmBinding bind(@NonNull View view, @Nullable Object component) {
        return (ItemForPaceKmBinding) ViewDataBinding.bind(component, view, C4215R.C4221layout.item_for_pace_km);
    }

    @NonNull
    @Deprecated
    public static ItemForPaceKmBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (ItemForPaceKmBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.item_for_pace_km, root, attachToRoot, component);
    }

    @NonNull
    public static ItemForPaceKmBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static ItemForPaceKmBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (ItemForPaceKmBinding) ViewDataBinding.inflateInternal(inflater, C4215R.C4221layout.item_for_pace_km, null, false, component);
    }
}
