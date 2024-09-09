package com.bxkj.student.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bxkj.base.v2.common.view.EmptyRecyclerView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public abstract class V3FmValidRecordListBinding extends ViewDataBinding {
    @NonNull
    public final EmptyRecyclerView recyclerView;
    @NonNull
    public final SmartRefreshLayout refresh;

    /* JADX INFO: Access modifiers changed from: protected */
    public V3FmValidRecordListBinding(Object _bindingComponent, View _root, int _localFieldCount, EmptyRecyclerView recyclerView, SmartRefreshLayout refresh) {
        super(_bindingComponent, _root, _localFieldCount);
        this.recyclerView = recyclerView;
        this.refresh = refresh;
    }

    public static V3FmValidRecordListBinding bind(@NonNull View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    public static V3FmValidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static V3FmValidRecordListBinding bind(@NonNull View view, @Nullable Object component) {
        return (V3FmValidRecordListBinding) ViewDataBinding.bind(component, view, 2131428108);
    }

    @NonNull
    @Deprecated
    public static V3FmValidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
        return (V3FmValidRecordListBinding) ViewDataBinding.inflateInternal(inflater, 2131428108, root, attachToRoot, component);
    }

    @NonNull
    public static V3FmValidRecordListBinding inflate(@NonNull LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @NonNull
    @Deprecated
    public static V3FmValidRecordListBinding inflate(@NonNull LayoutInflater inflater, @Nullable Object component) {
        return (V3FmValidRecordListBinding) ViewDataBinding.inflateInternal(inflater, 2131428108, null, false, component);
    }
}
